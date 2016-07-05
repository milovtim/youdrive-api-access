package youdrive.today.interceptors;

import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Action1;
import youdrive.today.listeners.PolygonListener;

final /* synthetic */ class MapsInteractorImpl$$Lambda$4 implements Action1 {
    private final MapsInteractorImpl arg$1;
    private final PolygonListener arg$2;

    private MapsInteractorImpl$$Lambda$4(MapsInteractorImpl mapsInteractorImpl, PolygonListener polygonListener) {
        this.arg$1 = mapsInteractorImpl;
        this.arg$2 = polygonListener;
    }

    private static Action1 get$Lambda(MapsInteractorImpl mapsInteractorImpl, PolygonListener polygonListener) {
        return new MapsInteractorImpl$$Lambda$4(mapsInteractorImpl, polygonListener);
    }

    public static Action1 lambdaFactory$(MapsInteractorImpl mapsInteractorImpl, PolygonListener polygonListener) {
        return new MapsInteractorImpl$$Lambda$4(mapsInteractorImpl, polygonListener);
    }

    @Hidden
    public void call(Object obj) {
        this.arg$1.lambda$getInfo$22(this.arg$2, (Throwable) obj);
    }
}
