package youdrive.today.interceptors;

import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Action1;

final /* synthetic */ class CarInteractorImpl$$Lambda$8 implements Action1 {
    private final CarInteractorImpl arg$1;

    private CarInteractorImpl$$Lambda$8(CarInteractorImpl carInteractorImpl) {
        this.arg$1 = carInteractorImpl;
    }

    private static Action1 get$Lambda(CarInteractorImpl carInteractorImpl) {
        return new CarInteractorImpl$$Lambda$8(carInteractorImpl);
    }

    public static Action1 lambdaFactory$(CarInteractorImpl carInteractorImpl) {
        return new CarInteractorImpl$$Lambda$8(carInteractorImpl);
    }

    @Hidden
    public void call(Object obj) {
        this.arg$1.handleNetworkError((Throwable) obj);
    }
}
