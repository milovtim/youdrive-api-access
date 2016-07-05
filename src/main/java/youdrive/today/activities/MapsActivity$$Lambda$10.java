package youdrive.today.activities;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback;
import java.lang.invoke.LambdaForm.Hidden;

final /* synthetic */ class MapsActivity$$Lambda$10 implements SingleButtonCallback {
    private static final MapsActivity$$Lambda$10 instance;

    static {
        instance = new MapsActivity$$Lambda$10();
    }

    private MapsActivity$$Lambda$10() {
    }

    public static SingleButtonCallback lambdaFactory$() {
        return instance;
    }

    @Hidden
    public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
        MapsActivity.lambda$onCloseRent$14(materialDialog, dialogAction);
    }
}
