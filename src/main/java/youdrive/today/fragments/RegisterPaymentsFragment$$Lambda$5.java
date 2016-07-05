package youdrive.today.fragments;

import java.lang.invoke.LambdaForm.Hidden;
import youdrive.today.listeners.ValueFunction;

final /* synthetic */ class RegisterPaymentsFragment$$Lambda$5 implements ValueFunction {
    private final RegisterPaymentsFragment arg$1;

    private RegisterPaymentsFragment$$Lambda$5(RegisterPaymentsFragment registerPaymentsFragment) {
        this.arg$1 = registerPaymentsFragment;
    }

    private static ValueFunction get$Lambda(RegisterPaymentsFragment registerPaymentsFragment) {
        return new RegisterPaymentsFragment$$Lambda$5(registerPaymentsFragment);
    }

    public static ValueFunction lambdaFactory$(RegisterPaymentsFragment registerPaymentsFragment) {
        return new RegisterPaymentsFragment$$Lambda$5(registerPaymentsFragment);
    }

    @Hidden
    public void apply(Object obj) {
        this.arg$1.openUrl((String) obj);
    }
}
