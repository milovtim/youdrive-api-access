package ru.milovtim.youdrive;

import com.squareup.okhttp.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit.RestAdapter;
import ru.milovtim.youdrive.session.CookieStore;
import youdrive.today.models.LoginUser;
import youdrive.today.network.AddCookiesInterceptor;
import youdrive.today.network.CarsharingService;
import youdrive.today.network.CustomClient;
import youdrive.today.network.ReceivedCookiesInterceptor;

import java.util.concurrent.TimeUnit;

import static retrofit.RestAdapter.LogLevel.FULL;
import static retrofit.RestAdapter.LogLevel.NONE;

@Configuration
public class Beans {

    @Autowired
    AppProperties appProps;

    @Bean
    CarsharingService service(OkHttpClient client) {
        return new RestAdapter.Builder()
                .setEndpoint(appProps.getApiHost())
                .setClient(new CustomClient(client))
                .setLogLevel(appProps.isLogApiHttpRequests()? FULL: NONE)
                .build()
                .create(CarsharingService.class);
    }


    @Bean
    OkHttpClient httpClient(AddCookiesInterceptor cookie, ReceivedCookiesInterceptor setCookie) {
        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(5, TimeUnit.SECONDS);
        client.interceptors().add(cookie);
        client.interceptors().add(setCookie);
        return client;
    }

    @Bean
    AddCookiesInterceptor addStoredCookiesToRequests(CookieStore cookieStorage) {
        return new AddCookiesInterceptor(cookieStorage);
    }

    @Bean
    ReceivedCookiesInterceptor storeInputCookies(CookieStore cookieStorage) {
        return new ReceivedCookiesInterceptor(cookieStorage);
    }

    @Bean
    LoginUser loginUser() {
        final AppProperties.Account account = appProps.getAccount();
        return new LoginUser(account.getEmail(), account.getPassword());
    }

}
