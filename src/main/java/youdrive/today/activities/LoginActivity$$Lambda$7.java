package youdrive.today.activities;

import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Func2;

final /* synthetic */ class LoginActivity$$Lambda$7 implements Func2 {
    private static final LoginActivity$$Lambda$7 instance;

    static {
        instance = new LoginActivity$$Lambda$7();
    }

    private LoginActivity$$Lambda$7() {
    }

    public static Func2 lambdaFactory$() {
        return instance;
    }

    @Hidden
    public Object call(Object obj, Object obj2) {
        return LoginActivity.lambda$checkFields$5((Boolean) obj, (Boolean) obj2);
    }
}
