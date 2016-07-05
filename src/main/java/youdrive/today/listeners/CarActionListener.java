package youdrive.today.listeners;

import youdrive.today.models.Car;
import youdrive.today.models.Check;
import youdrive.today.models.Command;

public interface CarActionListener {
    void onAccessDenied(String str);

    void onBook(Car car);

    void onBookingTimeLeft(int i);

    void onCarNotFound(String str);

    void onClose();

    void onCommandError();

    void onCommandNotSupported(String str);

    void onComplete(Check check);

    void onError();

    void onNotInfo(String str);

    void onNotOrder(String str);

    void onOpen();

    void onPleaseWait();

    void onSessionNotFound(String str);

    void onToken(Command command, String str);

    void onTransfer();

    void onUnknownError(String str);
}
