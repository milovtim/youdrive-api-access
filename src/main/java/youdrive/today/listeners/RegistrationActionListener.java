package youdrive.today.listeners;

import java.util.List;
import youdrive.today.models.Region;

public interface RegistrationActionListener {
    void onError();

    void onInvite();

    void onRegionNotFound(String str);

    void onRegions(List<Region> list);

    void onUnknownError(String str);

    void onUserAlreadyExist(String str);
}
