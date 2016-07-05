package youdrive.today.fragments;

import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Action1;
import youdrive.today.activities.RegistrationActivity;

final /* synthetic */ class RegisterProfileFragment$$Lambda$2 implements Action1 {
    private final RegistrationActivity arg$1;

    private RegisterProfileFragment$$Lambda$2(RegistrationActivity registrationActivity) {
        this.arg$1 = registrationActivity;
    }

    private static Action1 get$Lambda(RegistrationActivity registrationActivity) {
        return new RegisterProfileFragment$$Lambda$2(registrationActivity);
    }

    public static Action1 lambdaFactory$(RegistrationActivity registrationActivity) {
        return new RegisterProfileFragment$$Lambda$2(registrationActivity);
    }

    @Hidden
    public void call(Object obj) {
        this.arg$1.onCreateFailure((Throwable) obj);
    }
}
