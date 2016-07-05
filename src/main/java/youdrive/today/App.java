package youdrive.today;

import android.app.Application;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.yandex.metrica.YandexMetrica;
import youdrive.today.helpers.PreferenceHelper;
import youdrive.today.network.ApiClient;

public class App extends Application {
    private static GoogleAnalytics analytics;
    private static Tracker mTracker;
    private static App sInstance;
    private final String YANDEX_API_KEY;
    private ApiClient mApiClient;
    private PreferenceHelper mPreference;

    public App() {
        this.YANDEX_API_KEY = "14cbd311-8785-44c6-97e5-4622679719f5";
        sInstance = this;
    }

    public void onCreate() {
        super.onCreate();
        this.mPreference = new PreferenceHelper(getApplicationContext());
        this.mApiClient = new ApiClient();
        YandexMetrica.activate(getApplicationContext(), "14cbd311-8785-44c6-97e5-4622679719f5");
        analytics = GoogleAnalytics.getInstance(this);
        mTracker = analytics.newTracker("UA-64074244-1");
        mTracker.enableExceptionReporting(true);
        mTracker.enableAdvertisingIdCollection(true);
        mTracker.enableAutoActivityTracking(true);
        YandexMetrica.enableActivityAutoTracking(this);
    }

    public PreferenceHelper getPreference() {
        return this.mPreference;
    }

    public static Tracker tracker() {
        return mTracker;
    }

    public static GoogleAnalytics analytics() {
        return analytics;
    }

    public ApiClient getApiClient() {
        return this.mApiClient;
    }

    public static App getInstance() {
        return sInstance;
    }
}
