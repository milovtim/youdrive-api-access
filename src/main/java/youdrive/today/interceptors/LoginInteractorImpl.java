package youdrive.today.interceptors;

import com.google.gson.Gson;
import java.util.concurrent.TimeUnit;
import retrofit.RetrofitError;
import retrofit.mime.TypedByteArray;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;
import youdrive.today.App;
import youdrive.today.listeners.LoginActionListener;
import youdrive.today.models.ApiError;
import youdrive.today.models.User;
import youdrive.today.network.ApiClient;
import youdrive.today.response.LoginResponse;

public class LoginInteractorImpl implements LoginInteractor, Observer<LoginResponse> {
    private final ApiClient mApiClient;
    private LoginActionListener mListener;
    private Subscription subscription;

    public LoginInteractorImpl() {
        this.subscription = Subscriptions.empty();
        this.mApiClient = App.getInstance().getApiClient();
    }

    public void login(String email, String password, LoginActionListener listener) {
        this.mListener = listener;
        this.subscription = this.mApiClient.login(email, password).retry(3).timeout(5, TimeUnit.SECONDS).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer) this);
    }

    public Subscription getSubscription() {
        return this.subscription;
    }

    public void onCompleted() {
        this.subscription.unsubscribe();
    }

    public void onError(Throwable e) {
        try {
            LoginResponse response = (LoginResponse) new Gson().fromJson(new String(((TypedByteArray) ((RetrofitError) e).getResponse().getBody()).getBytes()), LoginResponse.class);
            handlingError(new ApiError(response.getCode(), response.getText()), this.mListener);
        } catch (Exception e2) {
            this.mListener.onError();
        }
    }

    public void onNext(LoginResponse response) {
        if (response.isSuccess()) {
            this.mListener.onSuccess(new User(response.getSessionId(), response.getName(), response.getAvatar()));
        } else {
            handlingError(new ApiError(response.getCode(), response.getText()), this.mListener);
        }
    }

    private void handlingError(ApiError error, LoginActionListener listener) {
        switch (error.getCode()) {
            case ApiError.USER_NOT_FOUND /*113*/:
                listener.onErrorUserNotFound(error.getText());
            case ApiError.FIELD_IS_EMPTY /*114*/:
                listener.onErrorFieldEmpty(error.getText());
            default:
                if (error.getText() != null) {
                    listener.onUnknownError(error.getText());
                } else {
                    listener.onError();
                }
        }
    }
}
