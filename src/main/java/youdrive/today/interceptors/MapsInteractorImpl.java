package youdrive.today.interceptors;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import youdrive.today.App;
import youdrive.today.listeners.MapsActionListener;
import youdrive.today.listeners.PolygonListener;
import youdrive.today.listeners.ValueFunction;
import youdrive.today.models.ApiError;
import youdrive.today.models.Status;
import youdrive.today.network.ApiClient;
import youdrive.today.response.CarResponse;
import youdrive.today.response.PolygonResponse;

public class MapsInteractorImpl implements MapsInteractor {
    private final ApiClient mApiClient;
    CompositeSubscription subscriptions;

    public MapsInteractorImpl() {
        this.subscriptions = new CompositeSubscription();
        this.mApiClient = App.getInstance().getApiClient();
    }

    public void getStatusCar(MapsActionListener listener) {
        this.subscriptions.add(this.mApiClient.getStatusCars().retry(3).timeout(5, TimeUnit.SECONDS).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(MapsInteractorImpl$$Lambda$1.lambdaFactory$(this, listener), MapsInteractorImpl$$Lambda$2.lambdaFactory$(this, listener)));
    }

    private /* synthetic */ void lambda$getStatusCar$19(MapsActionListener listener, CarResponse response) {
        onStatusCarSuccess(response, listener);
    }

    private /* synthetic */ void lambda$getStatusCar$20(MapsActionListener listener, Throwable error) {
        handleNetworkError(error, listener);
    }

    private void onStatusCarSuccess(CarResponse response, MapsActionListener listener) {
        if (response.isSuccess()) {
            listener.onStatus(Status.fromString(response.getStatus()));
            if (response.getCars() != null) {
                listener.onCars(response.getCars());
            } else if (response.getCar() != null) {
                listener.onCar(response.getCar());
            }
            if (response.getCheck() != null) {
                listener.onCheck(response.getCheck());
                return;
            }
            return;
        }
        handlingError(new ApiError(response.getCode(), response.getText()), listener);
    }

    public void getInfo(PolygonListener listener) {
        this.subscriptions.add(this.mApiClient.getPolygon().retry(3).timeout(3, TimeUnit.SECONDS).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(MapsInteractorImpl$$Lambda$3.lambdaFactory$(this, listener), MapsInteractorImpl$$Lambda$4.lambdaFactory$(this, listener)));
    }

    private /* synthetic */ void lambda$getInfo$21(PolygonListener listener, PolygonResponse response) {
        onGetInfoSuccess(response, listener);
    }

    private /* synthetic */ void lambda$getInfo$22(PolygonListener listener, Throwable error) {
        handleNetworkError(error, listener);
    }

    private void onGetInfoSuccess(PolygonResponse response, PolygonListener listener) {
        if (response.isSuccess()) {
            listener.onPolygonSuccess(response);
        } else {
            listener.onPolygonFailed();
        }
    }

    public void getStatusCars(double lat, double lon, MapsActionListener listener) {
        this.subscriptions.add(this.mApiClient.getStatusCars(lat, lon).retry(3).timeout(5, TimeUnit.SECONDS).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(MapsInteractorImpl$$Lambda$5.lambdaFactory$(this, listener), MapsInteractorImpl$$Lambda$6.lambdaFactory$(this, listener)));
    }

    private /* synthetic */ void lambda$getStatusCars$23(MapsActionListener listener, CarResponse response) {
        onCarResponseSuccess(response, listener);
    }

    private /* synthetic */ void lambda$getStatusCars$24(MapsActionListener listener, Throwable error) {
        handleNetworkError(error, listener);
    }

    public void getInfo(ValueFunction<PolygonResponse> successFunc, ValueFunction<Throwable> errorFunc, CompositeSubscription subscriptions) {
        Observable observeOn = this.mApiClient.getPolygon().retry(3).timeout(5, TimeUnit.SECONDS).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        successFunc.getClass();
        Action1 lambdaFactory$ = MapsInteractorImpl$$Lambda$7.lambdaFactory$(successFunc);
        errorFunc.getClass();
        subscriptions.add(observeOn.subscribe(lambdaFactory$, MapsInteractorImpl$$Lambda$8.lambdaFactory$(errorFunc)));
    }

    private void onCarResponseSuccess(CarResponse response, MapsActionListener listener) {
        if (response.isSuccess()) {
            if (response.getCars() != null) {
                listener.onCars(response.getCars());
            } else if (response.getCar() != null) {
                listener.onCar(response.getCar());
            }
            listener.onStatus(Status.fromString(response.getStatus()));
            if (response.getCheck() != null) {
                listener.onCheck(response.getCheck());
                return;
            }
            return;
        }
        handlingError(new ApiError(response.getCode(), response.getText()), listener);
    }

    private void handleNetworkError(Throwable error, PolygonListener listener) {
        listener.onPolygonFailed();
    }

    private void handleNetworkError(Throwable error, MapsActionListener listener) {
        listener.onError();
    }

    private void handlingError(ApiError error, MapsActionListener listener) {
        if (error.getCode() == ApiError.FORBIDDEN) {
            listener.onForbidden();
        } else if (error.getCode() == ApiError.TARIFF_NOT_FOUND) {
            listener.onTariffNotFound();
        } else if (error.getText() != null) {
            listener.onUnknownError(error.getText());
        } else {
            listener.onError();
        }
    }

    public Subscription getSubscription() {
        return this.subscriptions;
    }

    public void clearSubscriptions() {
        this.subscriptions.unsubscribe();
        this.subscriptions = new CompositeSubscription();
    }
}
