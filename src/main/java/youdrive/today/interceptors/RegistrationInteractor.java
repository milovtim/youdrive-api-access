package youdrive.today.interceptors;

import youdrive.today.listeners.RegistrationActionListener;

public interface RegistrationInteractor {
    void getInvite(String str, Long l, String str2, boolean z, RegistrationActionListener registrationActionListener);

    void getRegions(RegistrationActionListener registrationActionListener);
}
