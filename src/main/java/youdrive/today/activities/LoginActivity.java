package youdrive.today.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.util.Patterns;
import android.view.View;
import com.dd.CircularProgressButton;
import com.google.gson.Gson;
import rx.Observable;
import rx.android.widget.WidgetObservable;
import timber.log.Timber;
import youdrive.today.App;
import youdrive.today.BaseActivity;
import youdrive.today.C1733R;
import youdrive.today.databinding.ActivityLoginBinding;
import youdrive.today.helpers.AppUtils;
import youdrive.today.interceptors.LoginInteractorImpl;
import youdrive.today.listeners.LoginActionListener;
import youdrive.today.models.User;

public class LoginActivity extends BaseActivity implements LoginActionListener {
    private ActivityLoginBinding f795b;
    private LoginInteractorImpl mInteractor;

    public void bindActivity() {
        this.f795b = (ActivityLoginBinding) DataBindingUtil.setContentView(this, C1733R.layout.activity_login);
        this.f795b.setListener(this);
        this.mInteractor = new LoginInteractorImpl();
        this.f795b.btnLogin.setIndeterminateProgressMode(true);
        this.f795b.btnLogin.setEnabled(false);
        checkFields();
    }

    public void onLogin(View view) {
        if (this.f795b.btnLogin.getProgress() == 0 && isConnected()) {
            setEnabled(false);
            this.f795b.btnLogin.setProgress(50);
            this.mInteractor.login(this.f795b.etLogin.getText().toString(), this.f795b.etPassword.getText().toString(), this);
        }
    }

    public void onRestore(View view) {
        AppUtils.restore(this);
    }

    public void onAbout(View view) {
        AppUtils.about(this);
    }

    public void onRegistration(View view) {
        startActivity(new Intent(this, RegistrationActivity.class));
        finish();
    }

    private void setEnabled(boolean value) {
        this.f795b.etLogin.setEnabled(value);
        this.f795b.etPassword.setEnabled(value);
        this.f795b.txtRestore.setEnabled(value);
        this.f795b.txtAbout.setEnabled(value);
        this.f795b.txtRegistration.setEnabled(value);
    }

    private boolean isConnected() {
        boolean isConnected = isNetworkConnected();
        if (!isConnected) {
            showToast(getString(C1733R.string.no_internet));
        }
        return isConnected;
    }

    private boolean validateEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public void onSuccess(User user) {
        Timber.tag("Login").m1337d("User " + user.toString(), new Object[0]);
        if (App.getInstance().getPreference() != null) {
            App.getInstance().getPreference().putUser(new Gson().toJson((Object) user));
        }
        AppUtils.success(this.f795b.btnLogin, getString(C1733R.string.open_car));
        startActivity(new Intent(this, MapsActivity.class));
        finish();
    }

    public void checkFields() {
        Observable distinctUntilChanged = Observable.combineLatest(WidgetObservable.text(this.f795b.etLogin).distinctUntilChanged().map(LoginActivity$$Lambda$1.lambdaFactory$()).map(LoginActivity$$Lambda$2.lambdaFactory$(this)).doOnNext(LoginActivity$$Lambda$3.lambdaFactory$(this)), WidgetObservable.text(this.f795b.etPassword).distinctUntilChanged().map(LoginActivity$$Lambda$4.lambdaFactory$()).map(LoginActivity$$Lambda$5.lambdaFactory$()).doOnNext(LoginActivity$$Lambda$6.lambdaFactory$(this)), LoginActivity$$Lambda$7.lambdaFactory$()).distinctUntilChanged();
        CircularProgressButton circularProgressButton = this.f795b.btnLogin;
        circularProgressButton.getClass();
        distinctUntilChanged.subscribe(LoginActivity$$Lambda$8.lambdaFactory$(circularProgressButton));
    }

    private /* synthetic */ Boolean lambda$checkFields$1(CharSequence t) {
        return Boolean.valueOf(validateEmail(t.toString()));
    }

    private /* synthetic */ void lambda$checkFields$2(Boolean bool) {
        if (!bool.booleanValue()) {
            this.f795b.etLogin.setError(getString(C1733R.string.email_not_valid));
        }
    }

    private static /* synthetic */ Boolean lambda$checkFields$3(CharSequence t) {
        return Boolean.valueOf(t.length() != 0);
    }

    private /* synthetic */ void lambda$checkFields$4(Boolean bool) {
        if (!bool.booleanValue()) {
            this.f795b.etPassword.setError(getString(C1733R.string.empty));
        }
    }

    private static /* synthetic */ Boolean lambda$checkFields$5(Boolean a, Boolean b) {
        boolean z = a.booleanValue() && b.booleanValue();
        return Boolean.valueOf(z);
    }

    public void onError() {
        error(getString(C1733R.string.internal_error));
    }

    public void onErrorUserNotFound(String message) {
        error(message);
    }

    public void onErrorFieldEmpty(String message) {
        error(message);
    }

    public void onUnknownError(String text) {
        error(text);
    }

    private void error(String text) {
        setEnabled(true);
        AppUtils.error(text, this.f795b.btnLogin);
    }

    protected void onDestroy() {
        this.mInteractor.getSubscription().unsubscribe();
        super.onDestroy();
    }
}
