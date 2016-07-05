package youdrive.today.activities;

import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Func1;

final /* synthetic */ class LoginActivity$$Lambda$5 implements Func1 {
    private static final LoginActivity$$Lambda$5 instance;

    static {
        instance = new LoginActivity$$Lambda$5();
    }

    private LoginActivity$$Lambda$5() {
    }

    public static Func1 lambdaFactory$() {
        return instance;
    }

    @Hidden
    public Object call(Object obj) {
        return LoginActivity.lambda$checkFields$3((CharSequence) obj);
    }
}
