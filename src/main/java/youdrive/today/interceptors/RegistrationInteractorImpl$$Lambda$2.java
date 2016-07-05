package youdrive.today.interceptors;

import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Action1;

final /* synthetic */ class RegistrationInteractorImpl$$Lambda$2 implements Action1 {
    private final RegistrationInteractorImpl arg$1;

    private RegistrationInteractorImpl$$Lambda$2(RegistrationInteractorImpl registrationInteractorImpl) {
        this.arg$1 = registrationInteractorImpl;
    }

    private static Action1 get$Lambda(RegistrationInteractorImpl registrationInteractorImpl) {
        return new RegistrationInteractorImpl$$Lambda$2(registrationInteractorImpl);
    }

    public static Action1 lambdaFactory$(RegistrationInteractorImpl registrationInteractorImpl) {
        return new RegistrationInteractorImpl$$Lambda$2(registrationInteractorImpl);
    }

    @Hidden
    public void call(Object obj) {
        this.arg$1.onFailureInvite((Throwable) obj);
    }
}
