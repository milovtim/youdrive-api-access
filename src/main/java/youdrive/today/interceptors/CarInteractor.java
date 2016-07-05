package youdrive.today.interceptors;

import youdrive.today.listeners.CarActionListener;
import youdrive.today.models.Command;

public interface CarInteractor {
    void booking(String str, double d, double d2, CarActionListener carActionListener);

    void command(Command command, CarActionListener carActionListener);

    void complete(Command command, CarActionListener carActionListener);

    void result(Command command, String str, CarActionListener carActionListener);
}
