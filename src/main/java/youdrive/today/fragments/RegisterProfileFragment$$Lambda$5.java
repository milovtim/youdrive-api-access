package youdrive.today.fragments;

import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Action1;

final /* synthetic */ class RegisterProfileFragment$$Lambda$5 implements Action1 {
    private final RegisterProfileFragment arg$1;

    private RegisterProfileFragment$$Lambda$5(RegisterProfileFragment registerProfileFragment) {
        this.arg$1 = registerProfileFragment;
    }

    private static Action1 get$Lambda(RegisterProfileFragment registerProfileFragment) {
        return new RegisterProfileFragment$$Lambda$5(registerProfileFragment);
    }

    public static Action1 lambdaFactory$(RegisterProfileFragment registerProfileFragment) {
        return new RegisterProfileFragment$$Lambda$5(registerProfileFragment);
    }

    @Hidden
    public void call(Object obj) {
        this.arg$1.lambda$checkFields$39((Boolean) obj);
    }
}
