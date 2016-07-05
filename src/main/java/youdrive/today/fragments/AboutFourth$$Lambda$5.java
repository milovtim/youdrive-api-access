package youdrive.today.fragments;

import java.lang.invoke.LambdaForm.Hidden;
import java.util.Comparator;
import youdrive.today.models.SimpleCar;

final /* synthetic */ class AboutFourth$$Lambda$5 implements Comparator {
    private static final AboutFourth$$Lambda$5 instance;

    static {
        instance = new AboutFourth$$Lambda$5();
    }

    private AboutFourth$$Lambda$5() {
    }

    public static Comparator lambdaFactory$() {
        return instance;
    }

    @Hidden
    public int compare(Object obj, Object obj2) {
        return Double.compare(((SimpleCar) obj).getLatitude(), ((SimpleCar) obj2).getLatitude());
    }
}
