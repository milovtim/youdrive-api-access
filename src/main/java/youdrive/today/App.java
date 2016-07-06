package youdrive.today;

import youdrive.today.helpers.PreferenceHelper;
import youdrive.today.network.ApiClient;

public class App {
    private static App sInstance;
    private final String YANDEX_API_KEY;
    private ApiClient mApiClient;
    private PreferenceHelper mPreference;

    public App() {
        this.YANDEX_API_KEY = "14cbd311-8785-44c6-97e5-4622679719f5";
        sInstance = this;
    }

    public void onCreate() {
//        this.mPreference = new PreferenceHelper(getApplicationContext());
        this.mApiClient = new ApiClient();
    }

    public PreferenceHelper getPreference() {
        return this.mPreference;
    }

//    public static Tracker tracker() {
//        return mTracker;
//    }
//    public static GoogleAnalytics analytics() {
//        return analytics;
//    }

    public ApiClient getApiClient() {
        return this.mApiClient;
    }

    public static App getInstance() {
        return sInstance;
    }
}
