package youdrive.today.fragments;

import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Action1;
import youdrive.today.activities.RegistrationActivity;

final /* synthetic */ class RegisterDocumentsFragment$$Lambda$4 implements Action1 {
    private final RegistrationActivity arg$1;

    private RegisterDocumentsFragment$$Lambda$4(RegistrationActivity registrationActivity) {
        this.arg$1 = registrationActivity;
    }

    private static Action1 get$Lambda(RegistrationActivity registrationActivity) {
        return new RegisterDocumentsFragment$$Lambda$4(registrationActivity);
    }

    public static Action1 lambdaFactory$(RegistrationActivity registrationActivity) {
        return new RegisterDocumentsFragment$$Lambda$4(registrationActivity);
    }

    @Hidden
    public void call(Object obj) {
        this.arg$1.onCreateFailure((Throwable) obj);
    }
}
