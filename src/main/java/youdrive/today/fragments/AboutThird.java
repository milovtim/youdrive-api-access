package youdrive.today.fragments;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder;
import com.yandex.metrica.YandexMetrica;
import youdrive.today.App;
import youdrive.today.C1733R;
import youdrive.today.databinding.FragmentAboutThirdBinding;

public class AboutThird extends BaseFragment {
    private FragmentAboutThirdBinding f803b;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.f803b = (FragmentAboutThirdBinding) DataBindingUtil.inflate(inflater, C1733R.layout.fragment_about_third, container, false);
        this.f803b.setListener(this);
        setData();
        return this.f803b.getRoot();
    }

    private void setData() {
        this.f803b.tvMinuteTarification.setText(Html.fromHtml(getString(C1733R.string.minute_tarrif_text)));
        this.f803b.tvFreeParking.setText(Html.fromHtml(getString(C1733R.string.free_parking_text)));
        this.f803b.tvFreeFuel.setText(Html.fromHtml(getString(C1733R.string.free_fuel_text)));
        this.f803b.tvFreeNight.setText(Html.fromHtml(getString(C1733R.string.free_night_text)));
        this.f803b.tvFarRides.setText(Html.fromHtml(getString(C1733R.string.far_rides_text)));
    }

    private void showTextDialog(String _message) {
        new Builder(this.mActivity).setMessage(_message).setPositiveButton("OK", AboutThird$$Lambda$1.lambdaFactory$()).create().show();
    }

    private static /* synthetic */ void lambda$showTextDialog$26(DialogInterface num, int window) {
    }

    public void onStart() {
        super.onStart();
        YandexMetrica.reportEvent("registration_0_2");
        App.tracker().setScreenName("registration_0_2");
        App.tracker().send(new ScreenViewBuilder().build());
    }

    public void onMinuteTarrification(View view) {
        showTextDialog(getString(C1733R.string.minute_tarification));
    }

    public void onFreeParking(View view) {
        showTextDialog(getString(C1733R.string.free_parking));
    }

    public void onFuelIsPayed(View view) {
        showTextDialog(getString(C1733R.string.fuelIsPayed));
    }

    public void onFreeNightParking(View view) {
        showTextDialog(getString(C1733R.string.free_night_parking));
    }

    public void onFarRides(View view) {
        showTextDialog(getString(C1733R.string.far_rides));
    }
}
