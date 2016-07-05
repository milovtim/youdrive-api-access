package youdrive.today.activities;

import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Action1;

final /* synthetic */ class MapsActivity$$Lambda$2 implements Action1 {
    private static final MapsActivity$$Lambda$2 instance;

    static {
        instance = new MapsActivity$$Lambda$2();
    }

    private MapsActivity$$Lambda$2() {
    }

    public static Action1 lambdaFactory$() {
        return instance;
    }

    @Hidden
    public void call(Object obj) {
        MapsActivity.lambda$startUpdates$6((Throwable) obj);
    }
}
