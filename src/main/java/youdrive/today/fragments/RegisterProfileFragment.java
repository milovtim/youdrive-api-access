package youdrive.today.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.Selection;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder;
import com.yandex.metrica.YandexMetrica;
import rx.Observable;
import rx.Subscription;
import rx.android.widget.WidgetObservable;
import rx.functions.Action1;
import youdrive.today.App;
import youdrive.today.C1733R;
import youdrive.today.activities.RegistrationActivity;
import youdrive.today.databinding.FragmentRegisterProfileBinding;
import youdrive.today.databinding.ItemPopupBinding;
import youdrive.today.models.RegistrationUser;
import youdrive.today.response.RegistrationModel;

public class RegisterProfileFragment extends BaseFragment<RegistrationActivity> {
    private FragmentRegisterProfileBinding f808b;
    private ItemPopupBinding bPopup;
    private PopupWindow mPopupWindow;
    private Subscription mSubscription;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.f808b = (FragmentRegisterProfileBinding) DataBindingUtil.inflate(inflater, C1733R.layout.fragment_register_profile, container, false);
        this.bPopup = (ItemPopupBinding) DataBindingUtil.inflate(inflater, C1733R.layout.item_popup, null, false);
        this.mPopupWindow = new PopupWindow(-2, -2);
        this.mPopupWindow.setContentView(this.bPopup.getRoot());
        this.mPopupWindow.setBackgroundDrawable(getResources().getDrawable(C1733R.drawable.popup_background));
        this.mPopupWindow.setOutsideTouchable(true);
        this.f808b.setListener(this);
        checkFields();
        this.f808b.tvForvard.setEnabled(false);
        return this.f808b.getRoot();
    }

    public void onStop() {
        if (this.mSubscription != null) {
            this.mSubscription.unsubscribe();
        }
        super.onStop();
    }

    public void updateUser(String userId, RegistrationUser user) {
        user.setOnline_contract_signed(true);
        ((RegistrationActivity) this.mActivity).showProgress();
        Observable updateUser = ((RegistrationActivity) this.mActivity).mClient.updateUser(userId, user);
        Action1 lambdaFactory$ = RegisterProfileFragment$$Lambda$1.lambdaFactory$(this);
        RegistrationActivity registrationActivity = (RegistrationActivity) this.mActivity;
        registrationActivity.getClass();
        this.mSubscription = updateUser.subscribe(lambdaFactory$, RegisterProfileFragment$$Lambda$2.lambdaFactory$(registrationActivity));
    }

    public void onUpdateSuccess(RegistrationModel model) {
        ((RegistrationActivity) this.mActivity).hideProgress();
        if (model.isSuccess()) {
            ((RegistrationActivity) this.mActivity).mUser = model.getData();
            ((RegistrationActivity) this.mActivity).startFragmentLeft(new RegisterDocumentsFragment());
            return;
        }
        Toast.makeText(this.mActivity, "\u041f\u0440\u043e\u0438\u0437\u043e\u0448\u043b\u0430 \u043d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u0430\u044f \u043e\u0448\u0438\u0431\u043a\u0430.", 0).show();
    }

    public void onStart() {
        super.onStart();
        YandexMetrica.reportEvent("registration_2_0");
        App.tracker().setScreenName("registration_2_0");
        App.tracker().send(new ScreenViewBuilder().build());
    }

    public void popupInit(View view, String message) {
        this.mPopupWindow.dismiss();
        this.bPopup.tvText.setText(message);
        this.mPopupWindow.showAsDropDown(view, 0, 0);
    }

    public void checkFields() {
        Observable<Boolean> email = WidgetObservable.text(this.f808b.etEmail).distinctUntilChanged().map(RegisterProfileFragment$$Lambda$3.lambdaFactory$()).map(RegisterProfileFragment$$Lambda$4.lambdaFactory$(this)).doOnNext(RegisterProfileFragment$$Lambda$5.lambdaFactory$(this));
        WidgetObservable.text(this.f808b.etPromo).distinctUntilChanged().map(RegisterProfileFragment$$Lambda$6.lambdaFactory$()).doOnNext(RegisterProfileFragment$$Lambda$7.lambdaFactory$(this)).subscribe();
        this.f808b.etPhone.setText("+7");
        Selection.setSelection(this.f808b.etPhone.getText(), this.f808b.etPhone.getText().length());
        Observable distinctUntilChanged = Observable.combineLatest(email, WidgetObservable.text(this.f808b.etPhone).distinctUntilChanged().map(RegisterProfileFragment$$Lambda$8.lambdaFactory$()).map(RegisterProfileFragment$$Lambda$9.lambdaFactory$(this)).doOnNext(RegisterProfileFragment$$Lambda$10.lambdaFactory$(this)), WidgetObservable.text(this.f808b.etPassword).distinctUntilChanged().map(RegisterProfileFragment$$Lambda$11.lambdaFactory$()).map(RegisterProfileFragment$$Lambda$12.lambdaFactory$()).doOnNext(RegisterProfileFragment$$Lambda$13.lambdaFactory$(this)), WidgetObservable.text(this.f808b.etPaswordAgain).distinctUntilChanged().map(RegisterProfileFragment$$Lambda$14.lambdaFactory$()).map(RegisterProfileFragment$$Lambda$15.lambdaFactory$(this)).doOnNext(RegisterProfileFragment$$Lambda$16.lambdaFactory$(this)), WidgetObservable.text(this.f808b.etName).distinctUntilChanged().map(RegisterProfileFragment$$Lambda$17.lambdaFactory$()).map(RegisterProfileFragment$$Lambda$18.lambdaFactory$()).doOnNext(RegisterProfileFragment$$Lambda$19.lambdaFactory$(this)), WidgetObservable.text(this.f808b.etSurname).distinctUntilChanged().map(RegisterProfileFragment$$Lambda$20.lambdaFactory$()).map(RegisterProfileFragment$$Lambda$21.lambdaFactory$()).doOnNext(RegisterProfileFragment$$Lambda$22.lambdaFactory$(this)), WidgetObservable.text(this.f808b.etMiddleName).distinctUntilChanged().map(RegisterProfileFragment$$Lambda$23.lambdaFactory$()).map(RegisterProfileFragment$$Lambda$24.lambdaFactory$()).doOnNext(RegisterProfileFragment$$Lambda$25.lambdaFactory$(this)), RegisterProfileFragment$$Lambda$26.lambdaFactory$()).distinctUntilChanged();
        TextView textView = this.f808b.tvForvard;
        textView.getClass();
        distinctUntilChanged.subscribe(RegisterProfileFragment$$Lambda$27.lambdaFactory$(textView));
    }

    private /* synthetic */ Boolean lambda$checkFields$38(CharSequence t) {
        return Boolean.valueOf(validateEmail(t.toString()));
    }

    private /* synthetic */ void lambda$checkFields$39(Boolean bool) {
        if (bool.booleanValue()) {
            ((RegistrationActivity) this.mActivity).mUser.setEmail(this.f808b.etEmail.getText().toString());
        } else {
            this.f808b.etEmail.setError(getString(C1733R.string.email_not_valid));
        }
    }

    private /* synthetic */ void lambda$checkFields$40(CharSequence text) {
        ((RegistrationActivity) this.mActivity).mUser.setPromocode(text.toString());
    }

    private /* synthetic */ Boolean lambda$checkFields$41(CharSequence t) {
        if (!t.toString().startsWith("+7")) {
            this.f808b.etPhone.setText("+7");
            Selection.setSelection(this.f808b.etPhone.getText(), this.f808b.etPhone.getText().length());
        }
        return Boolean.valueOf(t.length() == 12);
    }

    private /* synthetic */ void lambda$checkFields$42(Boolean bool) {
        if (bool.booleanValue()) {
            ((RegistrationActivity) this.mActivity).mUser.setPhone(this.f808b.etPhone.getText().toString().substring(2));
        } else {
            this.f808b.etPhone.setError(getString(C1733R.string.phone_error));
        }
    }

    private static /* synthetic */ Boolean lambda$checkFields$43(CharSequence t) {
        return Boolean.valueOf(t.length() >= 6);
    }

    private /* synthetic */ void lambda$checkFields$44(Boolean bool) {
        if (bool.booleanValue()) {
            ((RegistrationActivity) this.mActivity).mUser.setPassword(this.f808b.etPassword.getText().toString());
        } else {
            this.f808b.etPassword.setError(getString(C1733R.string.minimal_password_length));
        }
    }

    private /* synthetic */ Boolean lambda$checkFields$45(CharSequence t) {
        return Boolean.valueOf(t.toString().equals(this.f808b.etPassword.getText().toString()));
    }

    private /* synthetic */ void lambda$checkFields$46(Boolean bool) {
        if (bool.booleanValue()) {
            ((RegistrationActivity) this.mActivity).mUser.setPassword_confirm(this.f808b.etPaswordAgain.getText().toString());
        } else {
            this.f808b.etPaswordAgain.setError(getString(C1733R.string.password_dont_match));
        }
    }

    private static /* synthetic */ Boolean lambda$checkFields$47(CharSequence t) {
        return Boolean.valueOf(t.length() != 0);
    }

    private /* synthetic */ void lambda$checkFields$48(Boolean bool) {
        if (bool.booleanValue()) {
            ((RegistrationActivity) this.mActivity).mUser.setFirst_name(this.f808b.etName.getText().toString());
        } else {
            this.f808b.etName.setError(getString(C1733R.string.empty));
        }
    }

    private static /* synthetic */ Boolean lambda$checkFields$49(CharSequence t) {
        return Boolean.valueOf(t.length() != 0);
    }

    private /* synthetic */ void lambda$checkFields$50(Boolean bool) {
        if (bool.booleanValue()) {
            ((RegistrationActivity) this.mActivity).mUser.setLast_name(this.f808b.etSurname.getText().toString());
        } else {
            this.f808b.etSurname.setError(getString(C1733R.string.empty));
        }
    }

    private static /* synthetic */ Boolean lambda$checkFields$51(CharSequence t) {
        return Boolean.valueOf(t.length() != 0);
    }

    private /* synthetic */ void lambda$checkFields$52(Boolean bool) {
        if (bool.booleanValue()) {
            ((RegistrationActivity) this.mActivity).mUser.setMiddle_name(this.f808b.etMiddleName.getText().toString());
        } else {
            this.f808b.etMiddleName.setError(getString(C1733R.string.empty));
        }
    }

    private static /* synthetic */ Boolean lambda$checkFields$53(Boolean e, Boolean m, Boolean p, Boolean pa, Boolean n, Boolean s, Boolean mi) {
        boolean z = e.booleanValue() && m.booleanValue() && p.booleanValue() && pa.booleanValue() && n.booleanValue() && s.booleanValue() && mi.booleanValue();
        return Boolean.valueOf(z);
    }

    private boolean validateEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public void onForvard(View view) {
        updateUser(((RegistrationActivity) this.mActivity).userId, ((RegistrationActivity) this.mActivity).mUser);
    }

    public void onEmail(View view) {
        popupInit(view, getString(C1733R.string.email_hint));
    }

    public void onPhone(View view) {
        popupInit(view, getString(C1733R.string.phone_hint));
    }

    public void onName(View view) {
        popupInit(view, getString(C1733R.string.name_hint));
    }

    public void onSurName(View view) {
        popupInit(view, getString(C1733R.string.surname_hint));
    }

    public void onMiddleName(View view) {
        popupInit(view, getString(C1733R.string.middlename_hint));
    }

    public void onPromo(View view) {
        popupInit(view, getString(C1733R.string.promo_hint));
    }

    public void onPassword(View view) {
        popupInit(view, getString(C1733R.string.password_hint));
    }

    public void onBack(View view) {
        ((RegistrationActivity) this.mActivity).getFragmentManager().popBackStack();
    }
}
