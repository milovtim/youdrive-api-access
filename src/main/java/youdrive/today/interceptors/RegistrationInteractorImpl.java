package youdrive.today.interceptors;

import com.google.gson.Gson;
import java.util.concurrent.TimeUnit;
import retrofit.RetrofitError;
import retrofit.mime.TypedByteArray;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;
import youdrive.today.App;
import youdrive.today.listeners.RegistrationActionListener;
import youdrive.today.models.ApiError;
import youdrive.today.network.ApiClient;
import youdrive.today.response.BaseResponse;
import youdrive.today.response.RegionsResponse;

public class RegistrationInteractorImpl implements RegistrationInteractor {
    private final ApiClient mApiClient;
    private RegistrationActionListener mListener;
    private CompositeSubscription subscriptions;

    public RegistrationInteractorImpl() {
        this.subscriptions = new CompositeSubscription();
        this.mApiClient = App.getInstance().getApiClient();
    }

    public void getInvite(String email, Long phone, String region, boolean readyToUse, RegistrationActionListener listener) {
        this.mListener = listener;
        this.subscriptions.add(this.mApiClient.invite(email, phone, region, readyToUse).retry(3).timeout(5, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(RegistrationInteractorImpl$$Lambda$1.lambdaFactory$(this), RegistrationInteractorImpl$$Lambda$2.lambdaFactory$(this)));
    }

    private void onSuccessInvite(BaseResponse response) {
        this.mListener.onInvite();
    }

    private void onFailureInvite(Throwable throwable) {
        try {
            BaseResponse response = (BaseResponse) new Gson().fromJson(new String(((TypedByteArray) ((RetrofitError) throwable).getResponse().getBody()).getBytes()), BaseResponse.class);
            handlingError(new ApiError(response.getCode(), response.getText()), this.mListener);
        } catch (Exception e) {
            this.mListener.onError();
        }
    }

    public void getRegions(RegistrationActionListener listener) {
        this.mListener = listener;
        this.subscriptions.add(this.mApiClient.getRegions().retry(3).timeout(5, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(RegistrationInteractorImpl$$Lambda$3.lambdaFactory$(this), RegistrationInteractorImpl$$Lambda$4.lambdaFactory$(this)));
    }

    public void onRegionsRespnseSuccess(RegionsResponse response) {
        if (response.isSuccess()) {
            this.mListener.onRegions(response.getRegions());
        } else {
            handlingError(new ApiError(response.getCode(), response.getText()), this.mListener);
        }
    }

    public void onRegionsFailure(Throwable e) {
        try {
            RegionsResponse response = (RegionsResponse) new Gson().fromJson(new String(((TypedByteArray) ((RetrofitError) e).getResponse().getBody()).getBytes()), RegionsResponse.class);
            handlingError(new ApiError(response.getCode(), response.getText()), this.mListener);
        } catch (Exception e2) {
            this.mListener.onError();
        }
    }

    private void handlingError(ApiError error, RegistrationActionListener listener) {
        if (error.getCode() == ApiError.USER_ALREADY_EXISTS) {
            listener.onUserAlreadyExist(error.getText());
        } else if (error.getCode() == ApiError.REGION_NOT_FOUND) {
            listener.onRegionNotFound(error.getText());
        } else if (error.getText() != null) {
            listener.onUnknownError(error.getText());
        } else {
            listener.onError();
        }
    }

    public Subscription getSubscription() {
        return this.subscriptions;
    }
}
