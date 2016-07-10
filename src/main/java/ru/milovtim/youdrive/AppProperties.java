package ru.milovtim.youdrive;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created on 07.07.16.
 */
@ConfigurationProperties(prefix = "youdrive")
@Component
public class AppProperties {

    private boolean logApiHttpRequests;

    private String apiHost;

    private Account account;

    public boolean isLogApiHttpRequests() {
        return logApiHttpRequests;
    }

    public void setLogApiHttpRequests(boolean logApiHttpRequests) {
        this.logApiHttpRequests = logApiHttpRequests;
    }

    public String getApiHost() {
        return apiHost;
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public static class Account {
        private String email;
        private String password;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
