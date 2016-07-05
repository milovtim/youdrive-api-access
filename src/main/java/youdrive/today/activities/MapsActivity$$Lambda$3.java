package youdrive.today.activities;

import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.model.Marker;
import java.lang.invoke.LambdaForm.Hidden;

final /* synthetic */ class MapsActivity$$Lambda$3 implements OnMarkerClickListener {
    private final MapsActivity arg$1;

    private MapsActivity$$Lambda$3(MapsActivity mapsActivity) {
        this.arg$1 = mapsActivity;
    }

    private static OnMarkerClickListener get$Lambda(MapsActivity mapsActivity) {
        return new MapsActivity$$Lambda$3(mapsActivity);
    }

    public static OnMarkerClickListener lambdaFactory$(MapsActivity mapsActivity) {
        return new MapsActivity$$Lambda$3(mapsActivity);
    }

    @Hidden
    public boolean onMarkerClick(Marker marker) {
        return this.arg$1.lambda$onStatus$7(marker);
    }
}
