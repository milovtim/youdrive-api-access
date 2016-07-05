package youdrive.today.fragments;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder;
import com.yandex.metrica.YandexMetrica;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import youdrive.today.App;
import youdrive.today.C1733R;
import youdrive.today.activities.RegistrationActivity;
import youdrive.today.activities.WellcomeActivity;
import youdrive.today.databinding.FragmentRegisterOffertBinding;
import youdrive.today.response.RegistrationModel;

public class RegisterOffertFragment extends BaseFragment<RegistrationActivity> implements OnCheckedChangeListener {
    private FragmentRegisterOffertBinding f806b;
    private Subscription mSubscription;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.f806b = (FragmentRegisterOffertBinding) DataBindingUtil.inflate(inflater, C1733R.layout.fragment_register_offert, container, false);
        this.f806b.setListener(this);
        setData();
        return this.f806b.getRoot();
    }

    private void setData() {
        this.f806b.tvDogovor.setText(Html.fromHtml(getString(C1733R.string.dogovor)));
        this.f806b.checkbox.setOnCheckedChangeListener(this);
        this.f806b.tvForvard.setEnabled(false);
    }

    public void onBack(View view) {
        startActivity(new Intent(this.mActivity, WellcomeActivity.class));
        ((RegistrationActivity) this.mActivity).finish();
    }

    public void onForvard(View view) {
        createUser();
    }

    public void createUser() {
        ((RegistrationActivity) this.mActivity).showProgress();
        Observable createUser = ((RegistrationActivity) this.mActivity).mClient.createUser();
        Action1 lambdaFactory$ = RegisterOffertFragment$$Lambda$1.lambdaFactory$(this);
        RegistrationActivity registrationActivity = (RegistrationActivity) this.mActivity;
        registrationActivity.getClass();
        this.mSubscription = createUser.subscribe(lambdaFactory$, RegisterOffertFragment$$Lambda$2.lambdaFactory$(registrationActivity));
    }

    public void onStart() {
        super.onStart();
        YandexMetrica.reportEvent("registration_1_0");
        App.tracker().setScreenName("registration_1_0");
        App.tracker().send(new ScreenViewBuilder().build());
    }

    public void onCreateSucccess(RegistrationModel model) {
        ((RegistrationActivity) this.mActivity).hideProgress();
        ((RegistrationActivity) this.mActivity).userId = model.getId();
        ((RegistrationActivity) this.mActivity).mUser = model.getData();
        ((RegistrationActivity) this.mActivity).startFragmentLeft(new RegisterProfileFragment());
    }

    public void onStop() {
        if (this.mSubscription != null) {
            this.mSubscription.unsubscribe();
        }
        super.onStop();
    }

    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        this.f806b.tvForvard.setEnabled(isChecked);
    }
}
