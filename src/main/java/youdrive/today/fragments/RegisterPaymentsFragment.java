package youdrive.today.fragments;

import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder;
import com.google.gson.Gson;
import com.yandex.metrica.YandexMetrica;
import java.util.Set;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import youdrive.today.App;
import youdrive.today.C1733R;
import youdrive.today.activities.MapsActivity;
import youdrive.today.activities.RegistrationActivity;
import youdrive.today.databinding.FragmentRegisterPaymentsBinding;
import youdrive.today.models.RegistrationUser;
import youdrive.today.models.User;
import youdrive.today.response.RegistrationModel;

public class RegisterPaymentsFragment extends BaseFragment<RegistrationActivity> {
    private final String FINISH_URL;
    private FragmentRegisterPaymentsBinding f807b;
    private DialogFragment dialogFragment;
    private Subscription mSubscription;
    private Subscription mUserSubscription;

    /* renamed from: youdrive.today.fragments.RegisterPaymentsFragment.1 */
    class C17371 extends WebViewClient {
        C17371() {
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return false;
        }

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.v("Retrofit", url);
            if (url.equals("https://youdrive.today/create-mob-account-done.html")) {
                RegisterPaymentsFragment.this.f807b.wvPayment.setVisibility(8);
                RegisterPaymentsFragment.this.updateUser(((RegistrationActivity) RegisterPaymentsFragment.this.mActivity).userId, ((RegistrationActivity) RegisterPaymentsFragment.this.mActivity).mUser);
            }
        }
    }

    public RegisterPaymentsFragment() {
        this.FINISH_URL = "https://youdrive.today/create-mob-account-done.html";
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.f807b = (FragmentRegisterPaymentsBinding) DataBindingUtil.inflate(inflater, C1733R.layout.fragment_register_payments, container, false);
        this.f807b.setListener(this);
        initWebView();
        return this.f807b.getRoot();
    }

    public void onStart() {
        super.onStart();
        YandexMetrica.reportEvent("registration_4_0");
    }

    public void onStop() {
        super.onStop();
        if (this.mSubscription != null) {
            this.mSubscription.unsubscribe();
        }
    }

    public void updateUser(String userId, RegistrationUser user) {
        ((RegistrationActivity) this.mActivity).showProgress();
        Observable updateUser = ((RegistrationActivity) this.mActivity).mClient.updateUser(userId, user);
        Action1 lambdaFactory$ = RegisterPaymentsFragment$$Lambda$1.lambdaFactory$(this);
        RegistrationActivity registrationActivity = (RegistrationActivity) this.mActivity;
        registrationActivity.getClass();
        this.mSubscription = updateUser.subscribe(lambdaFactory$, RegisterPaymentsFragment$$Lambda$2.lambdaFactory$(registrationActivity));
    }

    public void onUpdateSuccess(RegistrationModel model) {
        createUser(((RegistrationActivity) this.mActivity).userId);
    }

    public void createUser(String userId) {
        ((RegistrationActivity) this.mActivity).showProgress();
        Observable createUser = ((RegistrationActivity) this.mActivity).mClient.createUser(userId);
        Action1 lambdaFactory$ = RegisterPaymentsFragment$$Lambda$3.lambdaFactory$(this);
        RegistrationActivity registrationActivity = (RegistrationActivity) this.mActivity;
        registrationActivity.getClass();
        this.mUserSubscription = createUser.subscribe(lambdaFactory$, RegisterPaymentsFragment$$Lambda$4.lambdaFactory$(registrationActivity));
    }

    private void onCreateUserSuccess(RegistrationModel model) {
        String sessionId = model.getSession_id();
        Object user = new User(sessionId, model.getData().getFirst_name() + " " + model.getData().getLast_name(), null);
        Log.v("retrofit", "************** session id = " + sessionId);
        if (App.getInstance().getPreference() != null) {
            String userString = new Gson().toJson(user);
            Log.v("SESSION_ID", "trying to save " + userString);
            App.getInstance().getPreference().putUser(userString);
        } else {
            YandexMetrica.reportEvent("SessionID777777 not saved");
        }
        YandexMetrica.reportEvent("registration_5_0");
        App.tracker().setScreenName("registration_5_0");
        App.tracker().send(new ScreenViewBuilder().build());
        Log.v("SESSION_ID", "trying to read saved session Id" + App.getInstance().getPreference().getSession());
        Log.v("SESSION_ID", "trying to read saved user object" + App.getInstance().getPreference().getUser());
        Set<String> set = App.getInstance().getPreference().getSession();
        set.clear();
        set.add("session_id=" + sessionId);
        App.getInstance().getPreference().putSession(set);
        startActivity(new Intent(this.mActivity, MapsActivity.class));
        ((RegistrationActivity) this.mActivity).finish();
    }

    private void initWebView() {
        this.f807b.wvPayment.getSettings().setJavaScriptEnabled(true);
        this.f807b.wvPayment.setWebViewClient(new C17371());
    }

    private void openUrl(String url) {
        this.dialogFragment.dismiss();
        this.f807b.wvPayment.setVisibility(0);
        this.f807b.wvPayment.loadUrl(url);
    }

    public void onCardLink(View view) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.addToBackStack(null);
        this.dialogFragment = PaymentDialogFragment.newInstance(((RegistrationActivity) this.mActivity).userId, getString(C1733R.string.minimal_price), RegisterPaymentsFragment$$Lambda$5.lambdaFactory$(this));
        this.dialogFragment.show(ft, "dialog");
    }

    public void onForvard(View view) {
        if (this.f807b.wvPayment.getVisibility() == 0) {
            this.f807b.wvPayment.setVisibility(8);
        } else {
            updateUser(((RegistrationActivity) this.mActivity).userId, ((RegistrationActivity) this.mActivity).mUser);
        }
    }

    public void onBack(View view) {
        if (this.f807b.wvPayment.getVisibility() == 0) {
            this.f807b.wvPayment.setVisibility(8);
        } else {
            ((RegistrationActivity) this.mActivity).getFragmentManager().popBackStack();
        }
    }
}
