package youdrive.today.fragments;

import java.lang.invoke.LambdaForm.Hidden;
import rx.android.widget.OnTextChangeEvent;
import rx.functions.Func1;

final /* synthetic */ class RegisterProfileFragment$$Lambda$17 implements Func1 {
    private static final RegisterProfileFragment$$Lambda$17 instance;

    static {
        instance = new RegisterProfileFragment$$Lambda$17();
    }

    private RegisterProfileFragment$$Lambda$17() {
    }

    public static Func1 lambdaFactory$() {
        return instance;
    }

    @Hidden
    public Object call(Object obj) {
        return ((OnTextChangeEvent) obj).text();
    }
}
