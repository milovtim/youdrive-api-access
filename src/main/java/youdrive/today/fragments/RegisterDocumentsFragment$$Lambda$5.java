package youdrive.today.fragments;

import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Action1;
import youdrive.today.response.UploadGroupResponse;

final /* synthetic */ class RegisterDocumentsFragment$$Lambda$5 implements Action1 {
    private final RegisterDocumentsFragment arg$1;

    private RegisterDocumentsFragment$$Lambda$5(RegisterDocumentsFragment registerDocumentsFragment) {
        this.arg$1 = registerDocumentsFragment;
    }

    private static Action1 get$Lambda(RegisterDocumentsFragment registerDocumentsFragment) {
        return new RegisterDocumentsFragment$$Lambda$5(registerDocumentsFragment);
    }

    public static Action1 lambdaFactory$(RegisterDocumentsFragment registerDocumentsFragment) {
        return new RegisterDocumentsFragment$$Lambda$5(registerDocumentsFragment);
    }

    @Hidden
    public void call(Object obj) {
        this.arg$1.onUploadGroupSuccess((UploadGroupResponse) obj);
    }
}
