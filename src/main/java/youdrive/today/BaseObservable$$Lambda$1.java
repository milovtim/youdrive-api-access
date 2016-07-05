package youdrive.today;

import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Func1;
import youdrive.today.listeners.RequestListener;

final /* synthetic */ class BaseObservable$$Lambda$1 implements Func1 {
    private final RequestListener arg$1;

    private BaseObservable$$Lambda$1(RequestListener requestListener) {
        this.arg$1 = requestListener;
    }

    private static Func1 get$Lambda(RequestListener requestListener) {
        return new BaseObservable$$Lambda$1(requestListener);
    }

    public static Func1 lambdaFactory$(RequestListener requestListener) {
        return new BaseObservable$$Lambda$1(requestListener);
    }

    @Hidden
    public Object call(Object obj) {
        return this.arg$1.onRequest();
    }
}
