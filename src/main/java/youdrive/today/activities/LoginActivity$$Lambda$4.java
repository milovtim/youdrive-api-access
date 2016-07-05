package youdrive.today.activities;

import java.lang.invoke.LambdaForm.Hidden;
import rx.android.widget.OnTextChangeEvent;
import rx.functions.Func1;

final /* synthetic */ class LoginActivity$$Lambda$4 implements Func1 {
    private static final LoginActivity$$Lambda$4 instance;

    static {
        instance = new LoginActivity$$Lambda$4();
    }

    private LoginActivity$$Lambda$4() {
    }

    public static Func1 lambdaFactory$() {
        return instance;
    }

    @Hidden
    public Object call(Object obj) {
        return ((OnTextChangeEvent) obj).text();
    }
}
