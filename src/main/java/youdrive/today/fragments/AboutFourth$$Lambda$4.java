package youdrive.today.fragments;

import java.lang.invoke.LambdaForm.Hidden;
import youdrive.today.listeners.ValueFunction;

final /* synthetic */ class AboutFourth$$Lambda$4 implements ValueFunction {
    private final AboutFourth arg$1;

    private AboutFourth$$Lambda$4(AboutFourth aboutFourth) {
        this.arg$1 = aboutFourth;
    }

    private static ValueFunction get$Lambda(AboutFourth aboutFourth) {
        return new AboutFourth$$Lambda$4(aboutFourth);
    }

    public static ValueFunction lambdaFactory$(AboutFourth aboutFourth) {
        return new AboutFourth$$Lambda$4(aboutFourth);
    }

    @Hidden
    public void apply(Object obj) {
        this.arg$1.onCarsFailure((Throwable) obj);
    }
}
