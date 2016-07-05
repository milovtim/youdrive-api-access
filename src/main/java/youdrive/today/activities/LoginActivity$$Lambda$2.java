package youdrive.today.activities;

import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Func1;

final /* synthetic */ class LoginActivity$$Lambda$2 implements Func1 {
    private final LoginActivity arg$1;

    private LoginActivity$$Lambda$2(LoginActivity loginActivity) {
        this.arg$1 = loginActivity;
    }

    private static Func1 get$Lambda(LoginActivity loginActivity) {
        return new LoginActivity$$Lambda$2(loginActivity);
    }

    public static Func1 lambdaFactory$(LoginActivity loginActivity) {
        return new LoginActivity$$Lambda$2(loginActivity);
    }

    @Hidden
    public Object call(Object obj) {
        return this.arg$1.lambda$checkFields$1((CharSequence) obj);
    }
}
