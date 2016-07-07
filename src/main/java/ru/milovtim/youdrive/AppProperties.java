package ru.milovtim.youdrive;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created on 07.07.16.
 */
@ConfigurationProperties(prefix = "youdrive")
@Getter @Setter
@Component
public class AppProperties {

    private boolean logApiHttpRequests;

    private String apiHost;

    private Account account;

    @Getter @Setter
    public static class Account {
        private String email;
        private String password;
    }
}
