package youdrive.today.fragments;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.yandex.metrica.YandexMetrica;
import java.util.Collections;
import java.util.List;
import rx.subscriptions.CompositeSubscription;
import youdrive.today.App;
import youdrive.today.C1733R;
import youdrive.today.activities.LoginActivity;
import youdrive.today.activities.RegistrationActivity;
import youdrive.today.activities.WellcomeActivity;
import youdrive.today.databinding.FragmentAboutFourthBinding;
import youdrive.today.interceptors.MapsInteractorImpl;
import youdrive.today.models.Coord;
import youdrive.today.models.SimpleCar;
import youdrive.today.response.PolygonResponse;

public class AboutFourth extends BaseFragment<WellcomeActivity> {
    private FragmentAboutFourthBinding f801b;
    private GoogleMap mMap;
    private PolygonOptions mPolygon;
    private CompositeSubscription mSubscriptions;

    /* renamed from: youdrive.today.fragments.AboutFourth.1 */
    class C17361 extends SimpleTarget<Bitmap> {
        final /* synthetic */ SimpleCar val$car;

        C17361(int x0, int x1, SimpleCar simpleCar) {
            this.val$car = simpleCar;
            super(x0, x1);
        }

        public void onResourceReady(Bitmap resource, GlideAnimation glideAnimation) {
            AboutFourth.this.mMap.addMarker(new MarkerOptions().flat(true).position(new LatLng(this.val$car.getLatitude(), this.val$car.getLongitude())).icon(BitmapDescriptorFactory.fromBitmap(resource)));
        }

        public void onLoadFailed(Exception e, Drawable errorDrawable) {
            AboutFourth.this.mMap.addMarker(new MarkerOptions().flat(true).position(new LatLng(this.val$car.getLatitude(), this.val$car.getLongitude())).icon(BitmapDescriptorFactory.fromResource(C1733R.drawable.car_location)));
        }
    }

    public AboutFourth() {
        this.mSubscriptions = new CompositeSubscription();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.f801b = (FragmentAboutFourthBinding) DataBindingUtil.inflate(inflater, C1733R.layout.fragment_about_fourth, container, false);
        this.f801b.setListener(this);
        initTextView();
        this.f801b.map.onCreate(savedInstanceState);
        MapsInitializer.initialize(getActivity());
        this.f801b.map.getMapAsync(AboutFourth$$Lambda$1.lambdaFactory$(this));
        return this.f801b.getRoot();
    }

    private void initTextView() {
        this.f801b.tvFooter.setText(Html.fromHtml(getString(C1733R.string.have_questions)));
        this.f801b.tvFooter.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void initMap(GoogleMap map) {
        this.mMap = map;
        ((WellcomeActivity) this.mActivity).getLocationPermission(AboutFourth$$Lambda$2.lambdaFactory$(this));
    }

    private void setMyLocation() {
        this.mMap.getUiSettings().setMyLocationButtonEnabled(false);
        this.mMap.setMyLocationEnabled(true);
        this.mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(55.749792d, 37.632495d), 11.0f));
        getCars();
    }

    public void onRegister(View view) {
        startActivity(new Intent(getActivity(), RegistrationActivity.class));
        getActivity().finish();
    }

    public void onLogin(View view) {
        startActivity(new Intent(getActivity(), LoginActivity.class));
        getActivity().finish();
    }

    public void onResume() {
        this.f801b.map.onResume();
        this.mSubscriptions = new CompositeSubscription();
        super.onResume();
    }

    public void onPause() {
        this.mSubscriptions.unsubscribe();
        super.onPause();
        this.f801b.map.onPause();
    }

    public void onStart() {
        super.onStart();
        YandexMetrica.reportEvent("registration_0_3");
        App.tracker().setScreenName("registration_0_3");
        App.tracker().send(new ScreenViewBuilder().build());
    }

    public void onDestroy() {
        super.onDestroy();
        this.f801b.map.onDestroy();
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.f801b.map.onLowMemory();
    }

    private void getCars() {
        MapsInteractorImpl interactor = new MapsInteractorImpl();
        if (((WellcomeActivity) this.mActivity).isNetworkConnected()) {
            interactor.getInfo(AboutFourth$$Lambda$3.lambdaFactory$(this), AboutFourth$$Lambda$4.lambdaFactory$(this), this.mSubscriptions);
        } else {
            ((WellcomeActivity) this.mActivity).showMessage(getString(C1733R.string.no_internet));
        }
    }

    private void onCarsSuccess(PolygonResponse response) {
        List<SimpleCar> cars = response.getCars();
        Collections.sort(cars, AboutFourth$$Lambda$5.lambdaFactory$());
        for (SimpleCar c : cars) {
            addMarker(c);
        }
        for (List<Coord> coords : response.getArea()) {
            drawPolygon(coords);
        }
        if (cars.size() != 1) {
            CameraUpdateFactory.newLatLngZoom(new LatLng(((SimpleCar) cars.get(0)).getLatitude(), ((SimpleCar) cars.get(0)).getLongitude()), 14.0f);
        } else {
            CameraUpdateFactory.newLatLngZoom(new LatLng(((SimpleCar) cars.get(0)).getLatitude(), ((SimpleCar) cars.get(0)).getLongitude()), 14.0f);
        }
    }

    private void drawPolygon(List<Coord> coordList) {
        this.mPolygon = new PolygonOptions().fillColor(getResources().getColor(C1733R.color.polygonColor)).strokeColor(getResources().getColor(17170445)).geodesic(true);
        for (Coord coord : coordList) {
            this.mPolygon.add(coord.toLatLng());
        }
        this.mPolygon.add(((Coord) coordList.get(0)).toLatLng());
        this.mMap.addPolygon(this.mPolygon);
    }

    private void onCarsFailure(Throwable t) {
        ((WellcomeActivity) this.mActivity).showErrorMessage(getString(C1733R.string.error));
    }

    private int getPx(int dp) {
        return (int) TypedValue.applyDimension(1, (float) dp, getResources().getDisplayMetrics());
    }

    private void addMarker(SimpleCar car) {
        Glide.with((FragmentActivity) this.mActivity).load(car.getPin_img() + "_android.png").asBitmap().sizeMultiplier(0.5f).into(new C17361(100, 100, car));
    }
}
