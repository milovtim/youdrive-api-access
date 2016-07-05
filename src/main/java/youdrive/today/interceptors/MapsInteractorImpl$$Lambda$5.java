package youdrive.today.interceptors;

import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Action1;
import youdrive.today.listeners.MapsActionListener;
import youdrive.today.response.CarResponse;

final /* synthetic */ class MapsInteractorImpl$$Lambda$5 implements Action1 {
    private final MapsInteractorImpl arg$1;
    private final MapsActionListener arg$2;

    private MapsInteractorImpl$$Lambda$5(MapsInteractorImpl mapsInteractorImpl, MapsActionListener mapsActionListener) {
        this.arg$1 = mapsInteractorImpl;
        this.arg$2 = mapsActionListener;
    }

    private static Action1 get$Lambda(MapsInteractorImpl mapsInteractorImpl, MapsActionListener mapsActionListener) {
        return new MapsInteractorImpl$$Lambda$5(mapsInteractorImpl, mapsActionListener);
    }

    public static Action1 lambdaFactory$(MapsInteractorImpl mapsInteractorImpl, MapsActionListener mapsActionListener) {
        return new MapsInteractorImpl$$Lambda$5(mapsInteractorImpl, mapsActionListener);
    }

    @Hidden
    public void call(Object obj) {
        this.arg$1.lambda$getStatusCars$23(this.arg$2, (CarResponse) obj);
    }
}
