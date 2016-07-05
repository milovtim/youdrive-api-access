package youdrive.today.interceptors;

import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Action1;
import youdrive.today.listeners.ValueFunction;

final /* synthetic */ class MapsInteractorImpl$$Lambda$8 implements Action1 {
    private final ValueFunction arg$1;

    private MapsInteractorImpl$$Lambda$8(ValueFunction valueFunction) {
        this.arg$1 = valueFunction;
    }

    private static Action1 get$Lambda(ValueFunction valueFunction) {
        return new MapsInteractorImpl$$Lambda$8(valueFunction);
    }

    public static Action1 lambdaFactory$(ValueFunction valueFunction) {
        return new MapsInteractorImpl$$Lambda$8(valueFunction);
    }

    @Hidden
    public void call(Object obj) {
        this.arg$1.apply((Throwable) obj);
    }
}
