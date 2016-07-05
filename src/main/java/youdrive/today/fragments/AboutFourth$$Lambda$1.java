package youdrive.today.fragments;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import java.lang.invoke.LambdaForm.Hidden;

final /* synthetic */ class AboutFourth$$Lambda$1 implements OnMapReadyCallback {
    private final AboutFourth arg$1;

    private AboutFourth$$Lambda$1(AboutFourth aboutFourth) {
        this.arg$1 = aboutFourth;
    }

    private static OnMapReadyCallback get$Lambda(AboutFourth aboutFourth) {
        return new AboutFourth$$Lambda$1(aboutFourth);
    }

    public static OnMapReadyCallback lambdaFactory$(AboutFourth aboutFourth) {
        return new AboutFourth$$Lambda$1(aboutFourth);
    }

    @Hidden
    public void onMapReady(GoogleMap googleMap) {
        this.arg$1.initMap(googleMap);
    }
}
