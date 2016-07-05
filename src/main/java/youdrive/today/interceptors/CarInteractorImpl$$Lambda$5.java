package youdrive.today.interceptors;

import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Action1;
import youdrive.today.models.Command;
import youdrive.today.response.CommandResponse;

final /* synthetic */ class CarInteractorImpl$$Lambda$5 implements Action1 {
    private final CarInteractorImpl arg$1;
    private final Command arg$2;

    private CarInteractorImpl$$Lambda$5(CarInteractorImpl carInteractorImpl, Command command) {
        this.arg$1 = carInteractorImpl;
        this.arg$2 = command;
    }

    private static Action1 get$Lambda(CarInteractorImpl carInteractorImpl, Command command) {
        return new CarInteractorImpl$$Lambda$5(carInteractorImpl, command);
    }

    public static Action1 lambdaFactory$(CarInteractorImpl carInteractorImpl, Command command) {
        return new CarInteractorImpl$$Lambda$5(carInteractorImpl, command);
    }

    @Hidden
    public void call(Object obj) {
        this.arg$1.lambda$complete$17(this.arg$2, (CommandResponse) obj);
    }
}
