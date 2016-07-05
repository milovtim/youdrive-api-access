package youdrive.today.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder;
import com.yandex.metrica.YandexMetrica;
import youdrive.today.App;
import youdrive.today.C1733R;
import youdrive.today.databinding.FragmentAboutFirstBinding;

public class AboutFirst extends BaseFragment {
    private FragmentAboutFirstBinding f800b;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.f800b = (FragmentAboutFirstBinding) DataBindingUtil.inflate(inflater, C1733R.layout.fragment_about_first, container, false);
        return this.f800b.getRoot();
    }

    public void onStart() {
        super.onStart();
        YandexMetrica.reportEvent("registration_0_0");
        App.tracker().setScreenName("registration_0_0");
        App.tracker().send(new ScreenViewBuilder().build());
    }
}
