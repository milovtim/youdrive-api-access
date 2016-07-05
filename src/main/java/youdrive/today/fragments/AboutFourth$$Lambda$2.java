package youdrive.today.fragments;

import java.lang.invoke.LambdaForm.Hidden;
import youdrive.today.listeners.Function;

final /* synthetic */ class AboutFourth$$Lambda$2 implements Function {
    private final AboutFourth arg$1;

    private AboutFourth$$Lambda$2(AboutFourth aboutFourth) {
        this.arg$1 = aboutFourth;
    }

    private static Function get$Lambda(AboutFourth aboutFourth) {
        return new AboutFourth$$Lambda$2(aboutFourth);
    }

    public static Function lambdaFactory$(AboutFourth aboutFourth) {
        return new AboutFourth$$Lambda$2(aboutFourth);
    }

    @Hidden
    public void apply() {
        this.arg$1.setMyLocation();
    }
}
