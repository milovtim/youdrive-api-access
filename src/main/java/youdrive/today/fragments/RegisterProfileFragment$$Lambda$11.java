package youdrive.today.fragments;

import java.lang.invoke.LambdaForm.Hidden;
import rx.android.widget.OnTextChangeEvent;
import rx.functions.Func1;

final /* synthetic */ class RegisterProfileFragment$$Lambda$11 implements Func1 {
    private static final RegisterProfileFragment$$Lambda$11 instance;

    static {
        instance = new RegisterProfileFragment$$Lambda$11();
    }

    private RegisterProfileFragment$$Lambda$11() {
    }

    public static Func1 lambdaFactory$() {
        return instance;
    }

    @Hidden
    public Object call(Object obj) {
        return ((OnTextChangeEvent) obj).text();
    }
}
