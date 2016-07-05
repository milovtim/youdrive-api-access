package youdrive.today.fragments;

import java.lang.invoke.LambdaForm.Hidden;
import rx.android.widget.OnTextChangeEvent;
import rx.functions.Func1;

final /* synthetic */ class RegisterProfileFragment$$Lambda$8 implements Func1 {
    private static final RegisterProfileFragment$$Lambda$8 instance;

    static {
        instance = new RegisterProfileFragment$$Lambda$8();
    }

    private RegisterProfileFragment$$Lambda$8() {
    }

    public static Func1 lambdaFactory$() {
        return instance;
    }

    @Hidden
    public Object call(Object obj) {
        return ((OnTextChangeEvent) obj).text();
    }
}
