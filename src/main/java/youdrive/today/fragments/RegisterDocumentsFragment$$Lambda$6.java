package youdrive.today.fragments;

import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Action1;

final /* synthetic */ class RegisterDocumentsFragment$$Lambda$6 implements Action1 {
    private final RegisterDocumentsFragment arg$1;

    private RegisterDocumentsFragment$$Lambda$6(RegisterDocumentsFragment registerDocumentsFragment) {
        this.arg$1 = registerDocumentsFragment;
    }

    private static Action1 get$Lambda(RegisterDocumentsFragment registerDocumentsFragment) {
        return new RegisterDocumentsFragment$$Lambda$6(registerDocumentsFragment);
    }

    public static Action1 lambdaFactory$(RegisterDocumentsFragment registerDocumentsFragment) {
        return new RegisterDocumentsFragment$$Lambda$6(registerDocumentsFragment);
    }

    @Hidden
    public void call(Object obj) {
        this.arg$1.onUploadGroupsFailed((Throwable) obj);
    }
}
