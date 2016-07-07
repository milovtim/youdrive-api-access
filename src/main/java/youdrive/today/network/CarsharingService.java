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
    @POST("/session")
    LoginResponse login(@Body LoginUser loginUser);

    @DELETE("/session")
    BaseResponse logout();

    @POST("/order")
    CarResponse booking(@Body Car car);

    @DELETE("/order")
    CommandResponse complete();


    @POST("/action")
    CommandResponse command(@Body ApiCommand apiCommand);


    @GET("/action/{token}")
    CommandResponse result(@Path("token") String str);


    @GET("/status")
    CarResponse getStatusCars();

    @GET("/status")
    CarResponse getStatusCars(@Query("lat") double d, @Query("lon") double d2);

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GET("/create-account/{registrationId}")
    Observable<RegistrationModel> createAccount(@Path("registrationId") String str);

    @POST("/create-account")
    Observable<RegistrationModel> createAccount(@Body RegistrationModel registrationModel);

    @GET("/info")
    Observable<PolygonResponse> getPolygon();

    @GET("/regions")
    Observable<RegionsResponse> getRegions();

    @POST("/cards/init")
    Observable<CreditCardResponse> initCreditCard(@Body CreditCardModel creditCardModel);

    @POST("/invite")
    Observable<BaseResponse> invite(@Body InviteUser inviteUser);

    @PUT("/create-account/{registrationId}")
    Observable<RegistrationModel> updateAccount(@Path("registrationId") String str, @Body RegistrationUser registrationUser);
}
