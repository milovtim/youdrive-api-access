package youdrive.today.interceptors;

import com.google.gson.Gson;
import retrofit.RetrofitError;
import retrofit.mime.TypedByteArray;
import rx.Observer;
import rx.Subscription;
import rx.subscriptions.Subscriptions;
import youdrive.today.listeners.ProfileActionListener;
import youdrive.today.models.ApiError;
import youdrive.today.network.ApiClient;
import youdrive.today.response.BaseResponse;

public class ProfileInteractorImpl implements ProfileInteractor, Observer<BaseResponse> {
    private final ApiClient mApiClient;
    private ProfileActionListener mListener;
    private Subscription subscription;

    public ProfileInteractorImpl() {
        this.subscription = Subscriptions.empty();
        this.mApiClient = new ApiClient();
    }

    public void logout(ProfileActionListener listener) {
        this.mListener = listener;
//        this.subscription = this.mApiClient.logout().retry(3).timeout(5, TimeUnit.SECONDS).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe((Observer) this);
    }

    public void onCompleted() {
        this.subscription.unsubscribe();
    }

    public void onError(Throwable e) {
        try {
            BaseResponse response = (BaseResponse) new Gson().fromJson(new String(((TypedByteArray) ((RetrofitError) e).getResponse().getBody()).getBytes()), BaseResponse.class);
            handlingError(new ApiError(response.getCode(), response.getText()), this.mListener);
        } catch (Exception e2) {
            this.mListener.onError();
        }
    }

    public void onNext(BaseResponse response) {
        if (response.isSuccess()) {
            this.mListener.onLogout();
        } else {
            handlingError(new ApiError(response.getCode(), response.getText()), this.mListener);
        }
    }

    private void handlingError(ApiError error, ProfileActionListener listener) {
        if (error.getCode() == ApiError.SESSION_NOT_FOUND) {
            listener.onSessionNotFound();
        } else if (error.getCode() == ApiError.INVALID_REQUEST) {
            listener.onInvalidRequest();
        } else if (error.getCode() == ApiError.FORBIDDEN) {
            listener.onLogout();
        } else {
            listener.onError();
        }
    }

    public Subscription getSubscription() {
        return this.subscription;
    }
}
