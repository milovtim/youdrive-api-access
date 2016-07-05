package youdrive.today.fragments;

import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Action1;

final /* synthetic */ class RegisterProfileFragment$$Lambda$25 implements Action1 {
    private final RegisterProfileFragment arg$1;

    private RegisterProfileFragment$$Lambda$25(RegisterProfileFragment registerProfileFragment) {
        this.arg$1 = registerProfileFragment;
    }

    private static Action1 get$Lambda(RegisterProfileFragment registerProfileFragment) {
        return new RegisterProfileFragment$$Lambda$25(registerProfileFragment);
    }

    public static Action1 lambdaFactory$(RegisterProfileFragment registerProfileFragment) {
        return new RegisterProfileFragment$$Lambda$25(registerProfileFragment);
    }

    @Hidden
    public void call(Object obj) {
        this.arg$1.lambda$checkFields$52((Boolean) obj);
    }
}
