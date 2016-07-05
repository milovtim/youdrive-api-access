package youdrive.today.activities;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback;
import java.lang.invoke.LambdaForm.Hidden;

final /* synthetic */ class MapsActivity$$Lambda$5 implements SingleButtonCallback {
    private final MapsActivity arg$1;

    private MapsActivity$$Lambda$5(MapsActivity mapsActivity) {
        this.arg$1 = mapsActivity;
    }

    private static SingleButtonCallback get$Lambda(MapsActivity mapsActivity) {
        return new MapsActivity$$Lambda$5(mapsActivity);
    }

    public static SingleButtonCallback lambdaFactory$(MapsActivity mapsActivity) {
        return new MapsActivity$$Lambda$5(mapsActivity);
    }

    @Hidden
    public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
        this.arg$1.lambda$onButtonCancel$9(materialDialog, dialogAction);
    }
}
