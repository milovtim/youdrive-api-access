package youdrive.today.interceptors;

import java.util.concurrent.TimeUnit;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import youdrive.today.App;
import youdrive.today.listeners.CarActionListener;
import youdrive.today.models.ApiError;
import youdrive.today.models.Command;
import youdrive.today.models.Result;
import youdrive.today.network.ApiClient;
import youdrive.today.response.CarResponse;
import youdrive.today.response.CommandResponse;

public class CarInteractorImpl implements CarInteractor {
    private final ApiClient mApiClient;
    private CarActionListener mListener;
    private CompositeSubscription subscriptions;

    public CarInteractorImpl() {
        this.subscriptions = new CompositeSubscription();
        this.mApiClient = App.getInstance().getApiClient();
    }

    public void booking(String id, double lat, double lon, CarActionListener listener) {
        this.mListener = listener;
        this.subscriptions.add(this.mApiClient.booking(id, lat, lon).retry(3).timeout(5, TimeUnit.SECONDS).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(CarInteractorImpl$$Lambda$1.lambdaFactory$(this), CarInteractorImpl$$Lambda$2.lambdaFactory$(this)));
    }

    public void onBookingSuccess(CarResponse response) {
        if (response.isSuccess()) {
            if (response.getCar() != null) {
                this.mListener.onBook(response.getCar());
            }
            this.mListener.onBookingTimeLeft(response.getBookingTimeLeft());
            return;
        }
        handlingError(new ApiError(response.getCode(), response.getText()), this.mListener);
    }

    public void command(Command command, CarActionListener listener) {
        this.mListener = listener;
        this.subscriptions.add(this.mApiClient.command(command).retry(3).timeout(5, TimeUnit.SECONDS).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(CarInteractorImpl$$Lambda$3.lambdaFactory$(this, command), CarInteractorImpl$$Lambda$4.lambdaFactory$(this)));
    }

    private /* synthetic */ void lambda$command$16(Command command, CommandResponse response) {
        onCommandSuccess(command, response);
    }

    private void onCommandSuccess(Command command, CommandResponse response) {
        if (response.isSuccess()) {
            this.mListener.onToken(command, response.getResultToken());
            result(command, response.getResultToken(), this.mListener);
            return;
        }
        handlingError(new ApiError(response.getCode(), response.getText()), this.mListener);
    }

    public void complete(Command command, CarActionListener listener) {
        this.mListener = listener;
        this.subscriptions.add(this.mApiClient.complete().retry(3).timeout(5, TimeUnit.SECONDS).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(CarInteractorImpl$$Lambda$5.lambdaFactory$(this, command), CarInteractorImpl$$Lambda$6.lambdaFactory$(this)));
    }

    private /* synthetic */ void lambda$complete$17(Command command, CommandResponse response) {
        onCompleteSuccess(command, response);
    }

    private void onCompleteSuccess(Command command, CommandResponse response) {
        if (response.isSuccess()) {
            this.mListener.onToken(command, response.getResultToken());
            result(command, response.getResultToken(), this.mListener);
            return;
        }
        handlingError(new ApiError(response.getCode(), response.getText()), this.mListener);
    }

    public void result(Command command, String token, CarActionListener listener) {
        this.mListener = listener;
        this.subscriptions.add(this.mApiClient.result(token).retry(3).timeout(5, TimeUnit.SECONDS).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(CarInteractorImpl$$Lambda$7.lambdaFactory$(this, command), CarInteractorImpl$$Lambda$8.lambdaFactory$(this)));
    }

    private /* synthetic */ void lambda$result$18(Command command, CommandResponse response) {
        onResultSuccess(command, response);
    }

    private void onResultSuccess(Command command, CommandResponse response) {
        if (response.isSuccess()) {
            Result result = Result.fromString(response.getStatus());
            if (result == null) {
                this.mListener.onError();
                return;
            } else if (result.equals(Result.NEW) || result.equals(Result.PROCESSING)) {
                this.mListener.onPleaseWait();
                return;
            } else if (result.equals(Result.ERROR)) {
                this.mListener.onCommandError();
                return;
            } else if (command.equals(Command.OPEN)) {
                this.mListener.onOpen();
                return;
            } else if (command.equals(Command.CLOSE)) {
                this.mListener.onClose();
                return;
            } else if (command == Command.TRANSFER) {
                this.mListener.onTransfer();
                return;
            } else {
                this.mListener.onComplete(response.getCheck());
                return;
            }
        }
        handlingError(new ApiError(response.getCode(), response.getText()), this.mListener);
    }

    public void handleNetworkError(Throwable t) {
        this.mListener.onError();
    }

    private void handlingError(ApiError error, CarActionListener listener) {
        if (error.getCode() == ApiError.CAR_NOT_FOUND) {
            listener.onCarNotFound(error.getText());
        } else if (error.getCode() == ApiError.NOT_INFO) {
            listener.onNotInfo(error.getText());
        } else if (error.getCode() == ApiError.NOT_ORDER) {
            listener.onNotOrder(error.getText());
        } else if (error.getCode() == ApiError.FORBIDDEN) {
            listener.onAccessDenied(error.getText());
        } else if (error.getCode() == ApiError.COMMAND_NOT_SUPPORTED) {
            listener.onCommandNotSupported(error.getText());
        } else if (error.getCode() == ApiError.SESSION_NOT_FOUND) {
            listener.onSessionNotFound(error.getText());
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
