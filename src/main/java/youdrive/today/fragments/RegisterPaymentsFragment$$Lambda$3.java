package youdrive.today.fragments;

import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Action1;
import youdrive.today.response.RegistrationModel;

final /* synthetic */ class RegisterPaymentsFragment$$Lambda$3 implements Action1 {
    private final RegisterPaymentsFragment arg$1;

    private RegisterPaymentsFragment$$Lambda$3(RegisterPaymentsFragment registerPaymentsFragment) {
        this.arg$1 = registerPaymentsFragment;
    }

    private static Action1 get$Lambda(RegisterPaymentsFragment registerPaymentsFragment) {
        return new RegisterPaymentsFragment$$Lambda$3(registerPaymentsFragment);
    }

    public static Action1 lambdaFactory$(RegisterPaymentsFragment registerPaymentsFragment) {
        return new RegisterPaymentsFragment$$Lambda$3(registerPaymentsFragment);
    }

    @Hidden
    public void call(Object obj) {
        this.arg$1.onCreateUserSuccess((RegistrationModel) obj);
    }
}
