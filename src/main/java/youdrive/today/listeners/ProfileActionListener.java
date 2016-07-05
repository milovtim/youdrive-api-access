package youdrive.today.listeners;

public interface ProfileActionListener {
    void onError();

    void onInvalidRequest();

    void onLogout();

    void onSessionNotFound();

    void onUnknownError(String str);
}
