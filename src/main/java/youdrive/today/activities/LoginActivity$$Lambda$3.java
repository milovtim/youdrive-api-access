package youdrive.today.activities;

import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Action1;

final /* synthetic */ class LoginActivity$$Lambda$3 implements Action1 {
    private final LoginActivity arg$1;

    private LoginActivity$$Lambda$3(LoginActivity loginActivity) {
        this.arg$1 = loginActivity;
    }

    private static Action1 get$Lambda(LoginActivity loginActivity) {
        return new LoginActivity$$Lambda$3(loginActivity);
    }

    public static Action1 lambdaFactory$(LoginActivity loginActivity) {
        return new LoginActivity$$Lambda$3(loginActivity);
    }

    @Hidden
    public void call(Object obj) {
        this.arg$1.lambda$checkFields$2((Boolean) obj);
    }
}
