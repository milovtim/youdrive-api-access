package youdrive.today.activities;

import java.lang.invoke.LambdaForm.Hidden;

final /* synthetic */ class MapsActivity$$Lambda$4 implements Runnable {
    private final MapsActivity arg$1;

    private MapsActivity$$Lambda$4(MapsActivity mapsActivity) {
        this.arg$1 = mapsActivity;
    }

    private static Runnable get$Lambda(MapsActivity mapsActivity) {
        return new MapsActivity$$Lambda$4(mapsActivity);
    }

    public static Runnable lambdaFactory$(MapsActivity mapsActivity) {
        return new MapsActivity$$Lambda$4(mapsActivity);
    }

    @Hidden
    public void run() {
        this.arg$1.lambda$onPleaseWait$8();
    }
}
