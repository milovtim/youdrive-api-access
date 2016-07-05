package youdrive.today.activities;

import java.lang.invoke.LambdaForm.Hidden;
import youdrive.today.listeners.Function;

final /* synthetic */ class MapsActivity$$Lambda$11 implements Function {
    private final MapsActivity arg$1;

    private MapsActivity$$Lambda$11(MapsActivity mapsActivity) {
        this.arg$1 = mapsActivity;
    }

    private static Function get$Lambda(MapsActivity mapsActivity) {
        return new MapsActivity$$Lambda$11(mapsActivity);
    }

    public static Function lambdaFactory$(MapsActivity mapsActivity) {
        return new MapsActivity$$Lambda$11(mapsActivity);
    }

    @Hidden
    public void apply() {
        this.arg$1.lambda$call$15();
    }
}
