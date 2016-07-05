package youdrive.today.network;

import com.squareup.okhttp.OkHttpClient;
import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import retrofit.RestAdapter.Builder;
import retrofit.RestAdapter.LogLevel;
import retrofit.client.OkClient;
import retrofit.mime.TypedFile;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import youdrive.today.models.ApiCommand;
import youdrive.today.models.Car;
import youdrive.today.models.Command;
import youdrive.today.models.CreditCardModel;
import youdrive.today.models.CreditCardResponse;
import youdrive.today.models.InviteUser;
import youdrive.today.models.LoginUser;
import youdrive.today.models.RegistrationUser;
import youdrive.today.response.BaseResponse;
import youdrive.today.response.CarResponse;
import youdrive.today.response.CommandResponse;
import youdrive.today.response.LoginResponse;
import youdrive.today.response.PolygonResponse;
import youdrive.today.response.RegionsResponse;
import youdrive.today.response.RegistrationModel;
import youdrive.today.response.UploadCareResponse;
import youdrive.today.response.UploadGroupResponse;

public class ApiClient {
    private static String HOST;
    private static String UPLOADCARE_KEY;
    private static final boolean enableLog = false;
    private CarsharingService mService;
    private UploadService mUploadService;

    static {
        HOST = "https://youdrive.today";
        UPLOADCARE_KEY = "507278759b3577e5f137";
    }

    public ApiClient() {
        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(5, TimeUnit.SECONDS);
        client.interceptors().add(new AddCookiesInterceptor());
        client.interceptors().add(new ReceivedCookiesInterceptor());
        this.mService = new Builder().setEndpoint(HOST).setClient(new CustomClient(client)).setLogLevel(LogLevel.NONE).build().create(CarsharingService.class);
        this.mUploadService = (UploadService) new Builder().setEndpoint("https://upload.uploadcare.com").setClient(new OkClient(new OkHttpClient())).setLogLevel(LogLevel.FULL).build().create(UploadService.class);
    }

    public Observable<LoginResponse> login(String email, String password) {
        return this.mService.login(new LoginUser(email, password));
    }

    public Observable<BaseResponse> logout() {
        return this.mService.logout();
    }

    public Observable<CarResponse> getStatusCars(double lat, double lon) {
        return this.mService.getStatusCars(lat, lon);
    }

    public Observable<CarResponse> getStatusCars() {
        return this.mService.getStatusCars();
    }

    public Observable<PolygonResponse> getPolygon() {
        return this.mService.getPolygon();
    }

    public Observable<RegionsResponse> getRegions() {
        return this.mService.getRegions();
    }

    public Observable<BaseResponse> invite(String email, Long phone, String region, boolean readyToUse) {
        return this.mService.invite(new InviteUser(email, phone.longValue(), region, readyToUse));
    }

    public Observable<CarResponse> booking(String id, double lat, double lon) {
        return this.mService.booking(new Car(id, (float) lat, (float) lon));
    }

    public Observable<CommandResponse> command(Command command) {
        return this.mService.command(new ApiCommand(command.toString()));
    }

    public Observable<CommandResponse> complete() {
        return this.mService.complete();
    }

    public Observable<CommandResponse> result(String token) {
        return this.mService.result(token);
    }

//    public Observable<RegistrationModel> createUser() {
//        return this.mService.createAccount(new RegistrationModel()).retry(3).timeout(5, TimeUnit.SECONDS).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
//    }

//    public Observable<RegistrationModel> updateUser(String userId, RegistrationUser user) {
//        return this.mService.updateAccount(userId, user).retry(3).timeout(5, TimeUnit.SECONDS).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
//    }

//    public Observable<RegistrationModel> createUser(String userId) {
//        return this.mService.createAccount(userId).retry(3).timeout(5, TimeUnit.SECONDS).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
//    }

//    public Observable<CreditCardResponse> initCard(CreditCardModel model) {
//        return this.mService.initCreditCard(model).timeout(5, TimeUnit.SECONDS).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
//    }

    public Observable<UploadCareResponse> uploadFile(File file) {
        return this.mUploadService.uploadFile(UPLOADCARE_KEY, 1, new TypedFile("multipart/form-data", file));
    }

    public Observable<UploadGroupResponse> uploadGroup(Map<String, String> params) {
        return this.mUploadService.uploadGroup(UPLOADCARE_KEY, params);
    }
}
