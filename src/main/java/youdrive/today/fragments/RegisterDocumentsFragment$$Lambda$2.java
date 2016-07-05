package youdrive.today.fragments;

import android.widget.ProgressBar;
import java.lang.invoke.LambdaForm.Hidden;
import rx.functions.Action1;

final /* synthetic */ class RegisterDocumentsFragment$$Lambda$2 implements Action1 {
    private final RegisterDocumentsFragment arg$1;
    private final ProgressBar arg$2;

    private RegisterDocumentsFragment$$Lambda$2(RegisterDocumentsFragment registerDocumentsFragment, ProgressBar progressBar) {
        this.arg$1 = registerDocumentsFragment;
        this.arg$2 = progressBar;
    }

    private static Action1 get$Lambda(RegisterDocumentsFragment registerDocumentsFragment, ProgressBar progressBar) {
        return new RegisterDocumentsFragment$$Lambda$2(registerDocumentsFragment, progressBar);
    }

    public static Action1 lambdaFactory$(RegisterDocumentsFragment registerDocumentsFragment, ProgressBar progressBar) {
        return new RegisterDocumentsFragment$$Lambda$2(registerDocumentsFragment, progressBar);
    }

    @Hidden
    public void call(Object obj) {
        this.arg$1.lambda$uploadFile$37(this.arg$2, (Throwable) obj);
    }
}
