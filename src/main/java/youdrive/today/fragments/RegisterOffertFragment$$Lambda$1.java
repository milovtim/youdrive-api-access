package youdrive.today.fragments;

import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Action1;
import youdrive.today.response.RegistrationModel;

final /* synthetic */ class RegisterOffertFragment$$Lambda$1 implements Action1 {
    private final RegisterOffertFragment arg$1;

    private RegisterOffertFragment$$Lambda$1(RegisterOffertFragment registerOffertFragment) {
        this.arg$1 = registerOffertFragment;
    }

    private static Action1 get$Lambda(RegisterOffertFragment registerOffertFragment) {
        return new RegisterOffertFragment$$Lambda$1(registerOffertFragment);
    }

    public static Action1 lambdaFactory$(RegisterOffertFragment registerOffertFragment) {
        return new RegisterOffertFragment$$Lambda$1(registerOffertFragment);
    }

    @Hidden
    public void call(Object obj) {
        this.arg$1.onCreateSucccess((RegistrationModel) obj);
    }
}
