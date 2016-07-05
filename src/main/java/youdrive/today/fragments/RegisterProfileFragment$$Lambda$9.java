package youdrive.today.fragments;

import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Func1;

final /* synthetic */ class RegisterProfileFragment$$Lambda$9 implements Func1 {
    private final RegisterProfileFragment arg$1;

    private RegisterProfileFragment$$Lambda$9(RegisterProfileFragment registerProfileFragment) {
        this.arg$1 = registerProfileFragment;
    }

    private static Func1 get$Lambda(RegisterProfileFragment registerProfileFragment) {
        return new RegisterProfileFragment$$Lambda$9(registerProfileFragment);
    }

    public static Func1 lambdaFactory$(RegisterProfileFragment registerProfileFragment) {
        return new RegisterProfileFragment$$Lambda$9(registerProfileFragment);
    }

    @Hidden
    public Object call(Object obj) {
        return this.arg$1.lambda$checkFields$41((CharSequence) obj);
    }
}
