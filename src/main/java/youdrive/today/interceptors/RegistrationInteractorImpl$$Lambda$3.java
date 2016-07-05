package youdrive.today.interceptors;

import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Action1;
import youdrive.today.response.RegionsResponse;

final /* synthetic */ class RegistrationInteractorImpl$$Lambda$3 implements Action1 {
    private final RegistrationInteractorImpl arg$1;

    private RegistrationInteractorImpl$$Lambda$3(RegistrationInteractorImpl registrationInteractorImpl) {
        this.arg$1 = registrationInteractorImpl;
    }

    private static Action1 get$Lambda(RegistrationInteractorImpl registrationInteractorImpl) {
        return new RegistrationInteractorImpl$$Lambda$3(registrationInteractorImpl);
    }

    public static Action1 lambdaFactory$(RegistrationInteractorImpl registrationInteractorImpl) {
        return new RegistrationInteractorImpl$$Lambda$3(registrationInteractorImpl);
    }

    @Hidden
    public void call(Object obj) {
        this.arg$1.onRegionsRespnseSuccess((RegionsResponse) obj);
    }
}
