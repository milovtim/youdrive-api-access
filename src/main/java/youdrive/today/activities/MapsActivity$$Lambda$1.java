package youdrive.today.activities;

import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Action1;

final /* synthetic */ class MapsActivity$$Lambda$1 implements Action1 {
    private final MapsActivity arg$1;

    private MapsActivity$$Lambda$1(MapsActivity mapsActivity) {
        this.arg$1 = mapsActivity;
    }

    private static Action1 get$Lambda(MapsActivity mapsActivity) {
        return new MapsActivity$$Lambda$1(mapsActivity);
    }

    public static Action1 lambdaFactory$(MapsActivity mapsActivity) {
        return new MapsActivity$$Lambda$1(mapsActivity);
    }

    @Hidden
    public void call(Object obj) {
        this.arg$1.loadCars(((Long) obj).longValue());
    }
}
