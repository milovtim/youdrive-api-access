package youdrive.today.fragments;

import java.lang.invoke.LambdaForm.Hidden;
import youdrive.today.listeners.ValueFunction;
import youdrive.today.response.PolygonResponse;

final /* synthetic */ class AboutFourth$$Lambda$3 implements ValueFunction {
    private final AboutFourth arg$1;

    private AboutFourth$$Lambda$3(AboutFourth aboutFourth) {
        this.arg$1 = aboutFourth;
    }

    private static ValueFunction get$Lambda(AboutFourth aboutFourth) {
        return new AboutFourth$$Lambda$3(aboutFourth);
    }

    public static ValueFunction lambdaFactory$(AboutFourth aboutFourth) {
        return new AboutFourth$$Lambda$3(aboutFourth);
    }

    @Hidden
    public void apply(Object obj) {
        this.arg$1.onCarsSuccess((PolygonResponse) obj);
    }
}
