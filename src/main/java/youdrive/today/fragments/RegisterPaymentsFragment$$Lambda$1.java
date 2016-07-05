package youdrive.today.fragments;

import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Action1;
import youdrive.today.response.RegistrationModel;

final /* synthetic */ class RegisterPaymentsFragment$$Lambda$1 implements Action1 {
    private final RegisterPaymentsFragment arg$1;

    private RegisterPaymentsFragment$$Lambda$1(RegisterPaymentsFragment registerPaymentsFragment) {
        this.arg$1 = registerPaymentsFragment;
    }

    private static Action1 get$Lambda(RegisterPaymentsFragment registerPaymentsFragment) {
        return new RegisterPaymentsFragment$$Lambda$1(registerPaymentsFragment);
    }

    public static Action1 lambdaFactory$(RegisterPaymentsFragment registerPaymentsFragment) {
        return new RegisterPaymentsFragment$$Lambda$1(registerPaymentsFragment);
    }

    @Hidden
    public void call(Object obj) {
        this.arg$1.onUpdateSuccess((RegistrationModel) obj);
    }
}
