package youdrive.today.network;

import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;
import youdrive.today.models.ApiCommand;
import youdrive.today.models.Car;
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

public interface CarsharingService {
    @POST("/order")
    Observable<CarResponse> booking(@Body Car car);

    @POST("/action")
    Observable<CommandResponse> command(@Body ApiCommand apiCommand);

    @DELETE("/order")
    Observable<CommandResponse> complete();

    @GET("/create-account/{registrationId}")
    Observable<RegistrationModel> createAccount(@Path("registrationId") String str);

    @POST("/create-account")
    Observable<RegistrationModel> createAccount(@Body RegistrationModel registrationModel);

    @GET("/info")
    Observable<PolygonResponse> getPolygon();

    @GET("/regions")
    Observable<RegionsResponse> getRegions();

    @GET("/status")
    Observable<CarResponse> getStatusCars();

    @GET("/status")
    Observable<CarResponse> getStatusCars(@Query("lat") double d, @Query("lon") double d2);

    @POST("/cards/init")
    Observable<CreditCardResponse> initCreditCard(@Body CreditCardModel creditCardModel);

    @POST("/invite")
    Observable<BaseResponse> invite(@Body InviteUser inviteUser);

    @POST("/session")
    Observable<LoginResponse> login(@Body LoginUser loginUser);

    @DELETE("/session")
    Observable<BaseResponse> logout();

    @GET("/action/{token}")
    Observable<CommandResponse> result(@Path("token") String str);

    @PUT("/create-account/{registrationId}")
    Observable<RegistrationModel> updateAccount(@Path("registrationId") String str, @Body RegistrationUser registrationUser);
}
