package youdrive.today.activities;

import android.view.View;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback;
import java.lang.invoke.LambdaForm.Hidden;

final /* synthetic */ class MapsActivity$$Lambda$7 implements SingleButtonCallback {
    private final MapsActivity arg$1;
    private final View arg$2;

    private MapsActivity$$Lambda$7(MapsActivity mapsActivity, View view) {
        this.arg$1 = mapsActivity;
        this.arg$2 = view;
    }

    private static SingleButtonCallback get$Lambda(MapsActivity mapsActivity, View view) {
        return new MapsActivity$$Lambda$7(mapsActivity, view);
    }

    public static SingleButtonCallback lambdaFactory$(MapsActivity mapsActivity, View view) {
        return new MapsActivity$$Lambda$7(mapsActivity, view);
    }

    @Hidden
    public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
        this.arg$1.lambda$onBookClicked$11(this.arg$2, materialDialog, dialogAction);
    }
}
