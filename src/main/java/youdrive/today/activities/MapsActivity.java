package youdrive.today.activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.TextView;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.dd.CircularProgressButton;
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.gson.Gson;
import com.yandex.metrica.YandexMetrica;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;
import youdrive.today.App;
import youdrive.today.BaseActivity;
import youdrive.today.C1733R;
import youdrive.today.adapters.ProfileAdapter;
import youdrive.today.databinding.ActivityMapsBinding;
import youdrive.today.databinding.DialogCloseCar;
import youdrive.today.databinding.DialogInfo;
import youdrive.today.databinding.HeaderProfileBinding;
import youdrive.today.databinding.MarkerInfo;
import youdrive.today.databinding.OpenCarDialog;
import youdrive.today.databinding.PopupDistance;
import youdrive.today.helpers.AppUtils;
import youdrive.today.helpers.PreferenceHelper;
import youdrive.today.interceptors.CarInteractorImpl;
import youdrive.today.interceptors.MapsInteractorImpl;
import youdrive.today.interceptors.ProfileInteractorImpl;
import youdrive.today.listeners.CarActionListener;
import youdrive.today.listeners.MapsActionListener;
import youdrive.today.listeners.PolygonListener;
import youdrive.today.listeners.ProfileActionListener;
import youdrive.today.models.Car;
import youdrive.today.models.Check;
import youdrive.today.models.Command;
import youdrive.today.models.Coord;
import youdrive.today.models.Menu;
import youdrive.today.models.Status;
import youdrive.today.models.User;
import youdrive.today.response.PolygonResponse;

public class MapsActivity extends BaseActivity implements MapsActionListener, ProfileActionListener, CarActionListener, ConnectionCallbacks, OnConnectionFailedListener, LocationListener, PolygonListener {
    private static final int RC_BOOK = 0;
    private static final int RC_CHECK = 1;
    private ActivityMapsBinding f796b;
    private DialogCloseCar bCloseCar;
    private DialogInfo bInfo;
    private OpenCarDialog bOpenCar;
    private boolean isFake;
    private boolean isInfoPopup;
    private boolean isMoveCamera;
    private boolean isMoveCameraWithMe;
    private boolean isShowClosePopup;
    private boolean isShowCommandPopup;
    private int mBookingTimeLeft;
    private Car mCar;
    private CarInteractorImpl mCarInteractor;
    private Check mCheck;
    private Command mCommand;
    private MaterialDialog mDialog;
    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;
    private LocationRequest mLocationRequest;
    private GoogleMap mMap;
    private MapsInteractorImpl mMapsInteractor;
    private Marker mMarker;
    HashMap<Marker, Car> mMarkerCar;
    private List<PolygonOptions> mPolygons;
    private ProfileInteractorImpl mProfileInteractor;
    private Status mStatus;
    private String mToken;
    private User mUser;
    private float mZoomLevel;
    private Subscription timerSubscription;

    /* renamed from: youdrive.today.activities.MapsActivity.1 */
    class C17341 extends SimpleTarget<Bitmap> {
        final /* synthetic */ Car val$car;

        C17341(int x0, int x1, Car car) {
            this.val$car = car;
            super(x0, x1);
        }

        public void onResourceReady(Bitmap resource, GlideAnimation glideAnimation) {
            MapsActivity.this.putMarker(this.val$car, BitmapDescriptorFactory.fromBitmap(resource));
        }

        public void onLoadFailed(Exception e, Drawable errorDrawable) {
            MapsActivity.this.putMarker(this.val$car, BitmapDescriptorFactory.fromResource(C1733R.drawable.car_location));
        }
    }

    /* renamed from: youdrive.today.activities.MapsActivity.2 */
    static /* synthetic */ class C17352 {
        static final /* synthetic */ int[] $SwitchMap$youdrive$today$models$Status;

        static {
            $SwitchMap$youdrive$today$models$Status = new int[Status.values().length];
            try {
                $SwitchMap$youdrive$today$models$Status[Status.BOOKING.ordinal()] = MapsActivity.RC_CHECK;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$youdrive$today$models$Status[Status.PARKING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$youdrive$today$models$Status[Status.USAGE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private class CustomWindowAdapter implements InfoWindowAdapter {
        private CustomWindowAdapter() {
        }

        public View getInfoWindow(Marker marker) {
            return null;
        }

        public View getInfoContents(Marker marker) {
            if (marker.equals(MapsActivity.this.mMarker)) {
                return null;
            }
            MarkerInfo bMarkerInfo = (MarkerInfo) DataBindingUtil.inflate(MapsActivity.this.getLayoutInflater(), C1733R.layout.marker_info, null, false);
            bMarkerInfo.rlDiscount.setVisibility(MapsActivity.this.mCar.getDiscount() > 0 ? MapsActivity.RC_BOOK : 8);
            bMarkerInfo.tvDiscount.setText("-" + MapsActivity.this.mCar.getDiscount() + "%");
            bMarkerInfo.txtColor.setText(MapsActivity.this.mCar.getColor());
            bMarkerInfo.txtModel.setText(MapsActivity.this.mCar.getModel());
            bMarkerInfo.txtNumber.setText(MapsActivity.this.mCar.getNumber());
            if (Status.BOOKING.equals(MapsActivity.this.mStatus)) {
                bMarkerInfo.txtStartUsage.setVisibility(MapsActivity.RC_BOOK);
                bMarkerInfo.txtStartUsage.setText("\u0414\u043e \u043d\u0430\u0447\u0430\u043b\u0430 \u0430\u0440\u0435\u043d\u0434\u044b " + (MapsActivity.this.mBookingTimeLeft / 60) + "\u043c\u0438\u043d");
            }
            return bMarkerInfo.getRoot();
        }
    }

    public MapsActivity() {
        this.isShowCommandPopup = false;
        this.isShowClosePopup = false;
        this.isInfoPopup = false;
        this.isMoveCamera = false;
        this.isMoveCameraWithMe = false;
        this.isFake = false;
        this.mMarkerCar = new HashMap();
    }

    private void startUpdates() {
        this.timerSubscription = Observable.interval(20, TimeUnit.SECONDS).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(MapsActivity$$Lambda$1.lambdaFactory$(this), MapsActivity$$Lambda$2.lambdaFactory$());
    }

    private static /* synthetic */ void lambda$startUpdates$6(Throwable error) {
    }

    private void loadCars(long seconds) {
        if (isProcessing()) {
            this.mMapsInteractor.clearSubscriptions();
        } else if (this.mStatus != null && this.mLastLocation != null) {
            if (Status.NORMAL.equals(this.mStatus) || Status.BOOKING.equals(this.mStatus)) {
                if (isNetworkConnected()) {
                    this.mMapsInteractor.getStatusCars(this.mLastLocation.getLatitude(), this.mLastLocation.getLongitude(), this);
                }
            } else if (isNetworkConnected()) {
                this.mMapsInteractor.getStatusCar(this);
            }
        }
    }

    public void bindActivity() {
        this.f796b = (ActivityMapsBinding) DataBindingUtil.setContentView(this, C1733R.layout.activity_maps);
        this.f796b.setListener(this);
        this.f796b.toolbar.setNavigationIcon((int) C1733R.drawable.ic_ab_drawer);
        setSupportActionBar(this.f796b.toolbar);
        setUpMapIfNeeded();
        createLocationRequest();
        this.mZoomLevel = this.mMap.getMinZoomLevel();
        if (!(App.getInstance().getPreference() == null || App.getInstance().getPreference().getUser() == null)) {
            this.mUser = (User) new Gson().fromJson(App.getInstance().getPreference().getUser(), User.class);
        }
        HeaderProfileBinding headerBinding = (HeaderProfileBinding) DataBindingUtil.inflate(getLayoutInflater(), C1733R.layout.header_profile, null, false);
        if (this.mUser != null) {
            headerBinding.txtName.setText(this.mUser.getName());
        }
        this.f796b.lvProfile.addHeaderView(headerBinding.getRoot());
        this.f796b.lvProfile.setAdapter(new ProfileAdapter(this, C1733R.layout.item_profile, getMenu()));
        this.f796b.drawer.setDrawerShadow((int) C1733R.drawable.drawer_shadow, 3);
        this.mProfileInteractor = new ProfileInteractorImpl();
        this.mCarInteractor = new CarInteractorImpl();
        this.mMapsInteractor = new MapsInteractorImpl();
        buildGoogleApiClient();
        checkInternet();
    }

    protected void onStart() {
        super.onStart();
        YandexMetrica.reportEvent("map_0_0");
        App.tracker().setScreenName("map_0_0");
        App.tracker().send(new ScreenViewBuilder().build());
        this.mGoogleApiClient.connect();
    }

    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
        if (this.mGoogleApiClient.isConnected()) {
            startLocationUpdates();
        }
        startUpdates();
    }

    protected void onPause() {
        super.onPause();
        if (this.mGoogleApiClient.isConnected()) {
            stopLocationUpdates();
        }
    }

    protected void onStop() {
        super.onStop();
        if (this.mGoogleApiClient.isConnected()) {
            this.mGoogleApiClient.disconnect();
        }
        if (this.timerSubscription != null) {
            this.timerSubscription.unsubscribe();
        }
    }

    private void checkInternet() {
        if (!isNetworkConnected()) {
            showToast("\u041d\u0435\u0442 \u043f\u043e\u0434\u043a\u043b\u044e\u0447\u0435\u043d\u0438\u044f \u043a \u0438\u043d\u0442\u0435\u0440\u043d\u0435\u0442\u0443");
            animateCamera(new LatLng(55.749792d, 37.632495d));
        }
    }

    private void animateCamera(LatLng position) {
        this.mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(position, 11.0f));
    }

    protected void buildGoogleApiClient() {
        this.mGoogleApiClient = new Builder(this).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(LocationServices.API).build();
    }

    private List<Menu> getMenu() {
        List<Menu> items = new ArrayList();
        items.add(new Menu(C1733R.drawable.icon_help, getString(C1733R.string.profile)));
        items.add(new Menu(C1733R.drawable.icon_tariff, getString(C1733R.string.tariff)));
        items.add(new Menu(C1733R.drawable.icon_help, getString(C1733R.string.help)));
        items.add(new Menu(C1733R.drawable.icon_call, getString(C1733R.string.call)));
        items.add(new Menu(C1733R.drawable.icon_exit, getString(C1733R.string.exit)));
        return items;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 16908332:
                this.f796b.drawer.openDrawer(3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setUpMapIfNeeded() {
        if (this.mMap == null) {
            this.mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(C1733R.id.map)).getMap();
        }
    }

    protected void createLocationRequest() {
        this.mLocationRequest = new LocationRequest();
        this.mLocationRequest.setInterval(10000);
        this.mLocationRequest.setFastestInterval(5000);
        this.mLocationRequest.setPriority(100);
    }

    protected void startLocationUpdates() {
        LocationServices.FusedLocationApi.requestLocationUpdates(this.mGoogleApiClient, this.mLocationRequest, (LocationListener) this);
    }

    protected void stopLocationUpdates() {
        LocationServices.FusedLocationApi.removeLocationUpdates(this.mGoogleApiClient, (LocationListener) this);
    }

    void updateLocation(Location location) {
        if (this.mMarker == null) {
            buildUserLocation(location);
        } else {
            this.mMarker.setPosition(new LatLng(location.getLatitude(), location.getLongitude()));
        }
    }

    private void showCarsDialog(Car car) {
        if (car != null && Status.NORMAL.equals(this.mStatus)) {
            this.bInfo = (DialogInfo) DataBindingUtil.inflate(getLayoutInflater(), C1733R.layout.dialog_info_contents, null, false);
            this.mCar = car;
            this.bInfo.setActivity(this);
            this.bInfo.setCar(car);
            this.bInfo.btnBook.setIndeterminateProgressMode(true);
            this.mDialog = new MaterialDialog.Builder(this).customView(this.bInfo.getRoot(), true).widgetColorRes(C1733R.color.white).show();
        }
    }

    private void addMarker(Car car) {
        Glide.with(getApplicationContext()).load(car.getPointer_resource() + "_android.png").asBitmap().sizeMultiplier(0.5f).into(new C17341(100, 100, car));
    }

    private void putMarker(Car car, BitmapDescriptor icon) {
        this.mMarkerCar.put(this.mMap.addMarker(new MarkerOptions().flat(true).position(new LatLng((double) car.getLat(), (double) car.getLon())).title(car.getModel()).icon(icon)), car);
        if (car.getDiscount() >= 15) {
            int resDiscount = C1733R.drawable.ic_percent_orange;
            if (car.getDiscount() >= 50) {
                resDiscount = C1733R.drawable.ic_percent_bordo;
            } else if (car.getDiscount() >= 25) {
                resDiscount = C1733R.drawable.ic_percent_red;
            } else if (car.getDiscount() >= 15) {
                resDiscount = C1733R.drawable.ic_percent_orange;
            }
            MarkerOptions markerOptionsPercent = new MarkerOptions().flat(true).position(new LatLng((double) car.getLat(), (double) car.getLon())).title(car.getModel()).anchor(0.5f, 0.5f).icon(BitmapDescriptorFactory.fromResource(resDiscount));
        }
    }

    public void onLogout() {
        Timber.tag("Action").m1337d("Logout", new Object[RC_BOOK]);
        startActivity(new Intent(this, LoginActivity.class));
        new PreferenceHelper(this).clear();
    }

    public void onError() {
        animateCamera(new LatLng(55.749792d, 37.632495d));
        Timber.tag("Error").m1337d("Internal Error", new Object[RC_BOOK]);
        String text = getString(C1733R.string.internal_error);
        if (this.bOpenCar != null && this.bOpenCar.btnCancel != null && this.bOpenCar.btnCancel.getProgress() == 50) {
            AppUtils.error(text, this.bOpenCar.btnCancel);
            this.bOpenCar.btnOpen.setEnabled(true);
        } else if (this.bCloseCar != null && this.bCloseCar.btnCloseRent != null && this.bCloseCar.btnCloseRent.getProgress() == 50) {
            AppUtils.error(text, this.bCloseCar.btnCloseRent);
            this.bCloseCar.btnCloseOrOpen.setEnabled(true);
        } else if (this.bOpenCar != null && this.bOpenCar.btnOpen != null && this.bOpenCar.btnOpen.getProgress() == 50) {
            AppUtils.error(text, this.bOpenCar.btnOpen);
            this.bOpenCar.btnCancel.setEnabled(true);
        } else if (this.bCloseCar != null && this.bCloseCar.btnCloseOrOpen != null && this.bCloseCar.btnCloseOrOpen.getProgress() == 50) {
            AppUtils.error(text, this.bCloseCar.btnCloseOrOpen);
            this.bCloseCar.btnCloseRent.setEnabled(true);
        } else if (this.bInfo != null && this.bInfo.btnBook != null && this.bInfo.btnBook.getProgress() == 50) {
            AppUtils.error(text, this.bInfo.btnBook);
        }
    }

    public void onAccessDenied(String text) {
        Timber.tag("Error").m1339e("onAccessDenied", new Object[RC_BOOK]);
        unlock(text);
    }

    private void unlock(String text) {
        if (this.bOpenCar.btnCancel != null && this.bOpenCar.btnCancel.getProgress() == 50) {
            AppUtils.error(text, this.bOpenCar.btnCancel);
            this.bOpenCar.btnOpen.setEnabled(true);
        } else if (this.bCloseCar.btnCloseRent != null && this.bCloseCar.btnCloseRent.getProgress() == 50) {
            AppUtils.error(text, this.bCloseCar.btnCloseRent);
            this.bCloseCar.btnCloseOrOpen.setEnabled(true);
        } else if (this.bOpenCar.btnOpen != null && this.bOpenCar.btnOpen.getProgress() == 50) {
            AppUtils.error(text, this.bOpenCar.btnOpen);
            this.bOpenCar.btnCancel.setEnabled(true);
        } else if (this.bCloseCar.btnCloseOrOpen != null && this.bCloseCar.btnCloseOrOpen.getProgress() == 50) {
            AppUtils.error(text, this.bCloseCar.btnCloseOrOpen);
            this.bCloseCar.btnCloseRent.setEnabled(true);
        }
    }

    public void onCommandNotSupported(String text) {
        Timber.tag("Error").m1339e("onCommandNotSupported", new Object[RC_BOOK]);
        unlock(text);
    }

    public void onClose() {
        this.mMapsInteractor.getStatusCar(this);
        onStatus(Status.PARKING);
        Timber.tag("Action").m1337d("onClose", new Object[RC_BOOK]);
        if (this.bCloseCar.btnCloseOrOpen != null) {
            this.bCloseCar.btnCloseRent.setEnabled(true);
            AppUtils.success(this.bCloseCar.btnCloseOrOpen, getString(C1733R.string.open_car));
        }
    }

    public void onComplete(Check check) {
        Timber.tag("Action").m1337d("onComplete " + check.toString(), new Object[RC_BOOK]);
        hideBottomWindow();
        startActivityForResult(new Intent(this, CompleteActivity.class).putExtra("check", check), RC_CHECK);
        this.mMapsInteractor.getStatusCar(this);
    }

    public void onTransfer() {
        Timber.tag("Action").m1337d("onTransfer ", new Object[RC_BOOK]);
        if (this.bCloseCar != null) {
            if (this.mStatus == Status.USAGE) {
                this.bCloseCar.btnCloseOrOpen.setEnabled(false);
                this.mCarInteractor.command(Command.CLOSE, this);
            } else {
                this.bCloseCar.btnCloseRent.setVisibility(8);
                this.mMapsInteractor.getStatusCar(this);
            }
        }
        if (this.bOpenCar != null) {
            this.bOpenCar.btnCancel.setEnabled(true);
            AppUtils.success(this.bOpenCar.btnCancel, getString(C1733R.string.transfer_car));
            this.bOpenCar.btnCancel.setVisibility(8);
        }
    }

    public void onBookingTimeLeft(int bookingTimeLeft) {
        Timber.tag("Action").m1337d("onBookingTimeLeft " + bookingTimeLeft, new Object[RC_BOOK]);
        this.mBookingTimeLeft = bookingTimeLeft;
        for (Entry<Marker, Car> entry : this.mMarkerCar.entrySet()) {
            if (((Car) entry.getValue()).equals(this.mCar)) {
                ((Marker) entry.getKey()).showInfoWindow();
            }
        }
    }

    public void onSessionNotFound(String text) {
        Timber.tag("Error").m1339e("onSessionNotFound", new Object[RC_BOOK]);
        unlock(text);
    }

    private void clear() {
        this.mMarkerCar.clear();
        this.mMap.clear();
        this.mMarker.remove();
    }

    public void onCars(List<Car> cars) {
        clear();
        if (this.mPolygons != null) {
            for (PolygonOptions polygon : this.mPolygons) {
                this.mMap.addPolygon(polygon);
            }
        } else {
            this.mMapsInteractor.getInfo(this);
        }
        Collections.sort(cars);
        if (!this.isMoveCameraWithMe) {
            this.isMoveCameraWithMe = true;
            onMoveCameraWithMe((Car) cars.get(RC_BOOK));
        }
        for (Car c : cars) {
            addMarker(c);
        }
        showDistancePopup(((Car) cars.get(RC_BOOK)).getWalktime());
    }

    private void onMoveCameraWithMe(Car car) {
        if (this.mMarker == null) {
            return;
        }
        if (this.isFake) {
            animateCamera(this.mMarker.getPosition());
        } else {
            onMoveCameraWithMe(this.mMarker.getPosition(), car);
        }
    }

    private void onMoveCameraWithMe(LatLng position, Car car) {
        this.mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(LatLngBounds.builder().include(position).include(new LatLng((double) car.getLat(), (double) car.getLon())).build(), getPx(20)));
    }

    private void onMoveCamera(Car car) {
        this.mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng((double) car.getLat(), (double) car.getLon()), 15.0f), ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED, null);
    }

    private int getPx(int dp) {
        return (int) TypedValue.applyDimension(RC_CHECK, (float) dp, getResources().getDisplayMetrics());
    }

    public void onForbidden() {
        this.mProfileInteractor.logout(this);
    }

    public void onTariffNotFound() {
        Timber.m1357d("onTariffNotFound", new Object[RC_BOOK]);
    }

    public void onBook(Car car) {
        Timber.tag("Action").m1337d("onBook " + car.toString(), new Object[RC_BOOK]);
        this.isInfoPopup = false;
        if (this.mDialog.isShowing()) {
            this.bInfo.btnBook.setProgress(100);
            this.mDialog.dismiss();
        }
        this.mCar = car;
        if (this.mCar.isInTransfer() && this.bCloseCar != null) {
            this.bCloseCar.btnCloseRent.setVisibility(8);
        }
        clear();
        if (this.mPolygons != null) {
            for (PolygonOptions polygon : this.mPolygons) {
                this.mMap.addPolygon(polygon);
            }
        } else {
            this.mMapsInteractor.getInfo(this);
        }
        onStatus(Status.BOOKING);
        addMarker(car);
        startActivityForResult(new Intent(this, BookCarActivity.class).putExtra("car", this.mCar), RC_BOOK);
    }

    public void onCar(Car car) {
        this.mCar = car;
        clear();
        if (this.mPolygons != null) {
            for (PolygonOptions polygon : this.mPolygons) {
                this.mMap.addPolygon(polygon);
            }
        } else {
            this.mMapsInteractor.getInfo(this);
        }
        addMarker(car);
        if (!this.isMoveCamera) {
            this.isMoveCamera = true;
            onMoveCamera(car);
        }
    }

    public void onStatus(Status status) {
        this.mStatus = status;
        if (!Status.USAGE.equals(this.mStatus)) {
            this.mMarker.setVisible(false);
            buildUserLocation(this.mLastLocation);
        }
        switch (C17352.$SwitchMap$youdrive$today$models$Status[status.ordinal()]) {
            case RC_CHECK /*1*/:
                if (!this.isInfoPopup) {
                    showDistancePopup(this.mCar.getWalktime());
                }
                if (!this.isShowCommandPopup) {
                    showCommandPopup();
                }
                this.mMap.setInfoWindowAdapter(new CustomWindowAdapter());
                this.mMap.getUiSettings().setMapToolbarEnabled(false);
            case C1733R.styleable.View_paddingStart /*2*/:
            case C1733R.styleable.View_paddingEnd /*3*/:
                hideTopWindow();
                showClosePopup();
                this.mMap.setInfoWindowAdapter(new CustomWindowAdapter());
            default:
                this.mMap.setInfoWindowAdapter(null);
                this.mMap.setOnMarkerClickListener(MapsActivity$$Lambda$3.lambdaFactory$(this));
                this.mMap.getUiSettings().setMapToolbarEnabled(true);
        }
    }

    private /* synthetic */ boolean lambda$onStatus$7(Marker marker) {
        showCarsDialog((Car) this.mMarkerCar.get(marker));
        return false;
    }

    private boolean isProcessing() {
        if (this.isShowClosePopup && this.bCloseCar != null) {
            if (this.bCloseCar.btnCloseOrOpen != null && this.bCloseCar.btnCloseOrOpen.getProgress() == 50) {
                return true;
            }
            if (this.bCloseCar.btnCloseRent != null && this.bCloseCar.btnCloseRent.getProgress() == 50) {
                return true;
            }
        }
        if (this.isShowCommandPopup && this.bOpenCar != null) {
            if (this.bOpenCar.btnOpen != null && this.bOpenCar.btnOpen.getProgress() == 50) {
                return true;
            }
            if (this.bOpenCar.btnCancel != null && this.bOpenCar.btnCancel.getProgress() == 50) {
                return true;
            }
        }
        return false;
    }

    private void buildUserLocation(Location location) {
        this.mMarker = this.mMap.addMarker(new MarkerOptions().position(new LatLng(location.getLatitude(), location.getLongitude())).title("\u042d\u0442\u043e \u0412\u044b!").flat(true).icon(BitmapDescriptorFactory.fromResource(C1733R.drawable.user_location)));
        if (this.isFake) {
            this.mMarker.setVisible(false);
        }
    }

    private void drawPolygon(PolygonResponse coordList) {
        if (this.mPolygons == null) {
            this.mPolygons = new ArrayList();
        }
        this.mPolygons.clear();
        List[] area = coordList.getArea();
        int length = area.length;
        for (int i = RC_BOOK; i < length; i += RC_CHECK) {
            List<Coord> coords = area[i];
            PolygonOptions polygon = new PolygonOptions().fillColor(getResources().getColor(C1733R.color.polygonColor)).strokeColor(getResources().getColor(17170445)).geodesic(true);
            for (Coord coord : coords) {
                polygon.add(coord.toLatLng());
            }
            this.mPolygons.add(polygon);
        }
        for (PolygonOptions _polygon : this.mPolygons) {
            this.mMap.addPolygon(_polygon);
        }
    }

    public void onCheck(Check check) {
        onBookingTimeLeft(check.getBookingTimeLeft());
        this.mCheck = check;
        if (this.isShowClosePopup) {
            showClosePopup();
        }
    }

    public void onUnknownError(String text) {
        unlock(text);
    }

    public void onCarNotFound(String text) {
        if (this.bInfo.btnBook != null) {
            AppUtils.error(text, this.bInfo.btnBook);
        }
    }

    public void onNotInfo(String text) {
        if (this.bInfo.btnBook != null) {
            AppUtils.error(text, this.bInfo.btnBook);
        }
    }

    public void onNotOrder(String text) {
        if (this.bInfo.btnBook != null) {
            AppUtils.error(text, this.bInfo.btnBook);
        }
    }

    public void onToken(Command command, String token) {
        this.mToken = token;
        this.mCommand = command;
    }

    public void onPleaseWait() {
        if (this.mToken != null && this.mCommand != null) {
            new Handler().postDelayed(MapsActivity$$Lambda$4.lambdaFactory$(this), 3000);
        }
    }

    private /* synthetic */ void lambda$onPleaseWait$8() {
        this.mCarInteractor.result(this.mCommand, this.mToken, this);
    }

    public void onCommandError() {
        unlock(getString(C1733R.string.command_error));
    }

    public void onOpen() {
        this.mMapsInteractor.getStatusCar(this);
        onStatus(Status.USAGE);
        if (!(this.bOpenCar == null || this.bOpenCar.btnOpen == null)) {
            AppUtils.success(this.bOpenCar.btnOpen);
        }
        if (this.bCloseCar != null && this.bCloseCar.btnCloseOrOpen != null) {
            this.bCloseCar.btnCloseRent.setEnabled(true);
            AppUtils.success(this.bCloseCar.btnCloseOrOpen, getString(C1733R.string.close_car));
        }
    }

    public void onSessionNotFound() {
        this.mProfileInteractor.logout(this);
    }

    public void onInvalidRequest() {
    }

    public void onConnected(Bundle bundle) {
        this.mLastLocation = LocationServices.FusedLocationApi.getLastLocation(this.mGoogleApiClient);
        startLocationUpdates();
        if (this.mLastLocation != null) {
            updateLocation(this.mLastLocation);
            if (this.mMarkerCar.isEmpty()) {
                this.mMapsInteractor.getStatusCars(this.mLastLocation.getLatitude(), this.mLastLocation.getLongitude(), this);
            }
            if (this.mPolygons == null) {
                this.mMapsInteractor.getInfo(this);
                return;
            }
            return;
        }
        this.mLastLocation = new Location(BuildConfig.FLAVOR);
        this.mLastLocation.setLatitude(55.749792d);
        this.mLastLocation.setLongitude(37.632495d);
        animateCamera(new LatLng(55.749792d, 37.632495d));
        this.isFake = true;
        updateLocation(this.mLastLocation);
        if (this.mMarkerCar.isEmpty()) {
            this.mMapsInteractor.getStatusCars(0.0d, 0.0d, this);
        }
        if (this.mPolygons == null) {
            this.mMapsInteractor.getInfo(this);
        }
        showToast("\u041d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u043e\u043f\u0440\u0435\u0434\u0435\u043b\u0438\u0442\u044c \u043c\u0435\u0441\u0442\u043e\u0440\u0430\u0441\u043f\u043e\u043b\u043e\u0436\u0435\u043d\u0438\u0435");
    }

    public void onConnectionSuspended(int i) {
        this.mGoogleApiClient.connect();
    }

    public void onConnectionFailed(ConnectionResult result) {
        Timber.m1359e("Connection failed: ConnectionResult.getErrorCode() = " + result.getErrorCode(), new Object[RC_BOOK]);
        animateCamera(new LatLng(55.749792d, 37.632495d));
    }

    public void onLocationChanged(Location location) {
        this.mLastLocation = location;
        updateLocation(location);
    }

    private void addBottomWindow(View view) {
        this.f796b.ltContainer.addView(view);
    }

    private void hideBottomWindow() {
        this.isShowCommandPopup = false;
        this.isShowClosePopup = false;
        this.f796b.ltContainer.removeAllViews();
    }

    private void addTopWindow(View view) {
        this.f796b.ltInfo.setAnimation(AnimationUtils.loadAnimation(this, C1733R.anim.top_down));
        this.f796b.ltInfo.addView(view);
    }

    private void hideTopWindow() {
        this.isInfoPopup = false;
        this.f796b.ltInfo.removeAllViews();
    }

    private void showDistancePopup(int walktime) {
        hideTopWindow();
        this.isInfoPopup = true;
        PopupDistance popupDistance = (PopupDistance) DataBindingUtil.inflate(getLayoutInflater(), C1733R.layout.popup_distance, null, false);
        addTopWindow(popupDistance.getRoot());
        if (Status.NORMAL.equals(this.mStatus)) {
            TextView textView = popupDistance.txtDistance;
            Object[] objArr = new Object[RC_CHECK];
            objArr[RC_BOOK] = AppUtils.toTime(walktime);
            textView.setText(getString(C1733R.string.distance_to_car, objArr));
            hideBottomWindow();
            return;
        }
        textView = popupDistance.txtDistance;
        objArr = new Object[RC_CHECK];
        objArr[RC_BOOK] = AppUtils.toTime(walktime);
        textView.setText(getString(C1733R.string.distance_to_book_car, objArr));
    }

    private void showCommandPopup() {
        int i;
        hideBottomWindow();
        this.isShowCommandPopup = true;
        this.bOpenCar = (OpenCarDialog) DataBindingUtil.inflate(getLayoutInflater(), C1733R.layout.popup_open_car, null, false);
        this.bOpenCar.btnNavigate.setProgress(100);
        addBottomWindow(this.bOpenCar.getRoot());
        this.bOpenCar.setListener(this);
        CircularProgressButton circularProgressButton = this.bOpenCar.btnCancel;
        if (this.mCar.isInTransfer()) {
            i = 8;
        } else {
            i = RC_BOOK;
        }
        circularProgressButton.setVisibility(i);
        this.bOpenCar.btnCancel.setText(getString(this.mCar.isTransferable() ? C1733R.string.transfer_car : C1733R.string.cancel_reserve));
        this.bOpenCar.btnOpen.setIndeterminateProgressMode(true);
        this.bOpenCar.btnCancel.setIndeterminateProgressMode(true);
    }

    public void onButtonOpen(View view) {
        this.mMapsInteractor.clearSubscriptions();
        this.bOpenCar.btnOpen.setProgress(50);
        this.bOpenCar.btnCancel.setEnabled(false);
        this.mCarInteractor.command(Command.OPEN, this);
    }

    public void onButtonCancel(View view) {
        if (this.mCar.isTransferable()) {
            new MaterialDialog.Builder(this).title((int) C1733R.string.transfer_finish_title).content((int) C1733R.string.transfer_finish_info).widgetColorRes(C1733R.color.white).positiveText((int) C1733R.string.ok_action).negativeText((int) C1733R.string.cancel_action).onPositive(MapsActivity$$Lambda$5.lambdaFactory$(this)).onNegative(MapsActivity$$Lambda$6.lambdaFactory$()).positiveColor(getResources().getColor(C1733R.color.main_dark)).negativeColor(getResources().getColor(C1733R.color.main_dark)).autoDismiss(true).show();
            return;
        }
        this.mMapsInteractor.clearSubscriptions();
        this.bOpenCar.btnCancel.setProgress(50);
        this.mCarInteractor.complete(Command.COMPLETE, this);
        this.bOpenCar.btnOpen.setEnabled(false);
    }

    private /* synthetic */ void lambda$onButtonCancel$9(MaterialDialog dialog, DialogAction which) {
        this.mMapsInteractor.clearSubscriptions();
        this.bOpenCar.btnCancel.setEnabled(false);
        this.bOpenCar.btnCancel.setProgress(50);
        this.mCarInteractor.command(Command.TRANSFER, this);
    }

    private static /* synthetic */ void lambda$onButtonCancel$10(MaterialDialog dialog, DialogAction which) {
    }

    public void onButtonNavigate(View view) {
        Intent mapIntent = new Intent("android.intent.action.VIEW", Uri.parse("google.navigation:q=" + this.mCar.getLat() + ", " + this.mCar.getLon() + "&mode=w"));
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
            return;
        }
        String appPackageName = "com.google.android.apps.maps";
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.android.apps.maps")));
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps")));
        }
    }

    public void onZoomIn(View v) {
        if (this.mMap != null) {
            this.mZoomLevel = this.mMap.getCameraPosition().zoom;
            if (this.mZoomLevel < this.mMap.getMaxZoomLevel()) {
                GoogleMap googleMap = this.mMap;
                float f = this.mZoomLevel + 1.0f;
                this.mZoomLevel = f;
                googleMap.animateCamera(CameraUpdateFactory.zoomTo(f));
            }
        }
    }

    public void onZoomOut(View v) {
        if (this.mMap != null) {
            this.mZoomLevel = this.mMap.getCameraPosition().zoom;
            if (this.mZoomLevel > this.mMap.getMinZoomLevel()) {
                GoogleMap googleMap = this.mMap;
                float f = this.mZoomLevel - 1.0f;
                this.mZoomLevel = f;
                googleMap.animateCamera(CameraUpdateFactory.zoomTo(f));
            }
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        switch (position) {
            case RC_CHECK /*1*/:
                openUrl("https://youdrive.today/profile.html");
            case C1733R.styleable.View_paddingStart /*2*/:
                openUrl("http://youdrive.today/tariffs-regulations.html");
            case C1733R.styleable.View_paddingEnd /*3*/:
                openUrl("http://youdrive.copiny.com/");
            case C1733R.styleable.View_theme /*4*/:
                call();
            case C1733R.styleable.ViewPagerIndicator_vpiUnderlinePageIndicatorStyle /*5*/:
                App.getInstance().getPreference().clear();
                this.mProfileInteractor.logout(this);
            default:
        }
    }

    public void onBookClicked(View view) {
        this.mDialog.getBuilder().autoDismiss(false);
        if (view.getTag() == null || this.mLastLocation.getLatitude() <= 0.0d || this.mLastLocation.getLongitude() <= 0.0d) {
            showToast("\u041d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u0438\u0442\u044c \u043c\u0435\u0441\u0442\u043e\u0440\u0430\u0441\u043f\u043e\u043b\u043e\u0436\u0435\u043d\u0438\u0435");
        } else if (this.mCar.isTransferable()) {
            new MaterialDialog.Builder(this).title((int) C1733R.string.transfer_book_title).content((int) C1733R.string.transfer_book_info).widgetColorRes(C1733R.color.white).positiveText((int) C1733R.string.ok_action).negativeText((int) C1733R.string.cancel_action).onPositive(MapsActivity$$Lambda$7.lambdaFactory$(this, view)).onNegative(MapsActivity$$Lambda$8.lambdaFactory$(this)).positiveColor(getResources().getColor(C1733R.color.main_dark)).negativeColor(getResources().getColor(C1733R.color.main_dark)).autoDismiss(true).show();
        } else {
            this.mMapsInteractor.clearSubscriptions();
            this.bInfo.btnBook.setProgress(50);
            this.mCarInteractor.booking((String) view.getTag(), this.mLastLocation.getLatitude(), this.mLastLocation.getLongitude(), this);
        }
    }

    private /* synthetic */ void lambda$onBookClicked$11(View view, MaterialDialog dialog, DialogAction which) {
        this.mMapsInteractor.clearSubscriptions();
        this.bInfo.btnBook.setProgress(50);
        this.mCarInteractor.booking((String) view.getTag(), this.mLastLocation.getLatitude(), this.mLastLocation.getLongitude(), this);
    }

    private /* synthetic */ void lambda$onBookClicked$12(MaterialDialog dialog, DialogAction which) {
        this.mDialog.dismiss();
    }

    private void showClosePopup() {
        hideBottomWindow();
        this.isShowClosePopup = true;
        this.bCloseCar = (DialogCloseCar) DataBindingUtil.inflate(getLayoutInflater(), C1733R.layout.popup_close_car, null, false);
        addBottomWindow(this.bCloseCar.getRoot());
        this.bCloseCar.setListener(this);
        this.bCloseCar.btnCloseRent.setVisibility(this.mCar.isInTransfer() ? 8 : RC_BOOK);
        CircularProgressButton circularProgressButton = this.bCloseCar.btnCloseRent;
        CharSequence string = (!this.mCar.isTransferable() || this.mCar.isInTransfer()) ? getString(C1733R.string.close_rent) : getString(C1733R.string.transfer_car);
        circularProgressButton.setText(string);
        circularProgressButton = this.bCloseCar.btnCloseRent;
        String string2 = (!this.mCar.isTransferable() || this.mCar.isInTransfer()) ? getString(C1733R.string.close_rent) : getString(C1733R.string.transfer_car);
        circularProgressButton.setIdleText(string2);
        this.bCloseCar.btnCloseOrOpen.setIndeterminateProgressMode(true);
        this.bCloseCar.btnCloseRent.setIndeterminateProgressMode(true);
        if (Status.PARKING.equals(this.mStatus) || Status.BOOKING.equals(this.mStatus)) {
            this.bCloseCar.btnNavigate.setVisibility(RC_BOOK);
            this.bCloseCar.btnCloseOrOpen.setText(getString(C1733R.string.open_car));
            this.bCloseCar.btnCloseOrOpen.setIdleText(getString(C1733R.string.open_car));
            this.bCloseCar.btnNavigate.setProgress(100);
        } else {
            this.bCloseCar.btnNavigate.setVisibility(8);
            this.bCloseCar.btnCloseOrOpen.setText(getString(C1733R.string.close_car));
            this.bCloseCar.btnCloseOrOpen.setIdleText(getString(C1733R.string.close_car));
        }
        if (Status.PARKING.equals(this.mStatus)) {
            this.bCloseCar.txtTariff.setText("\u041f\u0430\u0440\u043a\u043e\u0432\u043a\u0430");
            this.bCloseCar.txtPerMin.setText(convertRub((long) this.mCar.getTariff().getParking()));
        } else if (Status.USAGE.equals(this.mStatus)) {
            this.bCloseCar.txtTariff.setText("\u0418\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435");
            this.bCloseCar.txtPerMin.setText(convertRub((long) this.mCar.getTariff().getUsage()));
        }
        if (this.mCheck != null) {
            this.bCloseCar.txtTotalUsage.setText(convertRub(this.mCheck.getUsageWeekendCost() + this.mCheck.getUsageWorkdayCost()));
            this.bCloseCar.txtParking.setText(convertRub(this.mCheck.getParkingCost()));
            this.bCloseCar.txtTotal.setText(convertRub((this.mCheck.getParkingCost() + this.mCheck.getUsageWorkdayCost()) + this.mCheck.getUsageWeekendCost()));
        }
    }

    public void onCloseRent(View view) {
        if (this.mCar.isTransferable()) {
            new MaterialDialog.Builder(this).title((int) C1733R.string.transfer_finish_title).content((int) C1733R.string.transfer_finish_info).widgetColorRes(C1733R.color.white).positiveText((int) C1733R.string.ok_action).negativeText((int) C1733R.string.cancel_action).onPositive(MapsActivity$$Lambda$9.lambdaFactory$(this)).onNegative(MapsActivity$$Lambda$10.lambdaFactory$()).positiveColor(getResources().getColor(C1733R.color.main_dark)).negativeColor(getResources().getColor(C1733R.color.main_dark)).autoDismiss(true).show();
            return;
        }
        this.mMapsInteractor.clearSubscriptions();
        this.bCloseCar.btnCloseOrOpen.setEnabled(false);
        this.bCloseCar.btnCloseRent.setProgress(50);
        this.mCarInteractor.complete(Command.COMPLETE, this);
    }

    private /* synthetic */ void lambda$onCloseRent$13(MaterialDialog dialog, DialogAction which) {
        this.mMapsInteractor.clearSubscriptions();
        this.bCloseCar.btnCloseOrOpen.setEnabled(false);
        this.bCloseCar.btnCloseRent.setProgress(50);
        this.mCarInteractor.command(Command.TRANSFER, this);
    }

    private static /* synthetic */ void lambda$onCloseRent$14(MaterialDialog dialog, DialogAction which) {
    }

    public void onCloseOrOpen(View view) {
        this.mMapsInteractor.clearSubscriptions();
        this.bCloseCar.btnCloseRent.setEnabled(false);
        this.bCloseCar.btnCloseOrOpen.setProgress(50);
        if (Status.USAGE.equals(this.mStatus)) {
            this.mCarInteractor.command(Command.CLOSE, this);
        } else {
            this.mCarInteractor.command(Command.OPEN, this);
        }
    }

    public String convertRub(long kopeck) {
        StringBuilder stringBuilder = new StringBuilder();
        Object[] objArr = new Object[RC_CHECK];
        objArr[RC_BOOK] = Float.valueOf(((float) kopeck) / 100.0f);
        return stringBuilder.append(String.format("%.2f", objArr)).append(" \u0440\u0443\u0431.").toString();
    }

    public String convertRubPerMin(long kopeck) {
        StringBuilder stringBuilder = new StringBuilder();
        Object[] objArr = new Object[RC_CHECK];
        objArr[RC_BOOK] = Float.valueOf(((float) kopeck) / 100.0f);
        return stringBuilder.append(String.format("%.2f", objArr)).append(" \u0440\u0443\u0431./\u043c\u0438\u043d.").toString();
    }

    public void onPolygonSuccess(PolygonResponse response) {
        drawPolygon(response);
    }

    public void onPolygonFailed() {
        if (this.mPolygons == null) {
            this.mMapsInteractor.getInfo(this);
        }
    }

    protected void onDestroy() {
        this.mMapsInteractor.getSubscription().unsubscribe();
        this.mProfileInteractor.getSubscription().unsubscribe();
        this.mCarInteractor.getSubscription().unsubscribe();
        super.onDestroy();
    }

    private void call() {
        checkPhonePermission(MapsActivity$$Lambda$11.lambdaFactory$(this));
    }

    private /* synthetic */ void lambda$call$15() {
        startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:+74993223875")));
    }

    private void openUrl(String url) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            onMoveCamera(this.mCar);
        } else if (requestCode == RC_CHECK) {
            this.mMapsInteractor.getStatusCars(this.mLastLocation.getLatitude(), this.mLastLocation.getLongitude(), this);
        }
    }
}
