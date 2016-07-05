package youdrive.today.listeners;

import youdrive.today.models.User;

public interface LoginActionListener {
    void onError();

    void onErrorFieldEmpty(String str);

    void onErrorUserNotFound(String str);

    void onSuccess(User user);

    void onUnknownError(String str);
}
