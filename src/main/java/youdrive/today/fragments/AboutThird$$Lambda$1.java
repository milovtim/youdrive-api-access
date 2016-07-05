package youdrive.today.fragments;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.lang.invoke.LambdaForm.Hidden;

final /* synthetic */ class AboutThird$$Lambda$1 implements OnClickListener {
    private static final AboutThird$$Lambda$1 instance;

    static {
        instance = new AboutThird$$Lambda$1();
    }

    private AboutThird$$Lambda$1() {
    }

    public static OnClickListener lambdaFactory$() {
        return instance;
    }

    @Hidden
    public void onClick(DialogInterface dialogInterface, int i) {
        AboutThird.lambda$showTextDialog$26(dialogInterface, i);
    }
}
