package youdrive.today.fragments;

import android.widget.ProgressBar;
import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Action1;
import youdrive.today.response.UploadCareResponse;

final /* synthetic */ class RegisterDocumentsFragment$$Lambda$1 implements Action1 {
    private final RegisterDocumentsFragment arg$1;
    private final ProgressBar arg$2;

    private RegisterDocumentsFragment$$Lambda$1(RegisterDocumentsFragment registerDocumentsFragment, ProgressBar progressBar) {
        this.arg$1 = registerDocumentsFragment;
        this.arg$2 = progressBar;
    }

    private static Action1 get$Lambda(RegisterDocumentsFragment registerDocumentsFragment, ProgressBar progressBar) {
        return new RegisterDocumentsFragment$$Lambda$1(registerDocumentsFragment, progressBar);
    }

    public static Action1 lambdaFactory$(RegisterDocumentsFragment registerDocumentsFragment, ProgressBar progressBar) {
        return new RegisterDocumentsFragment$$Lambda$1(registerDocumentsFragment, progressBar);
    }

    @Hidden
    public void call(Object obj) {
        this.arg$1.lambda$uploadFile$36(this.arg$2, (UploadCareResponse) obj);
    }
}
