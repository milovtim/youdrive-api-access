package youdrive.today.models;

public enum Command {
    OPEN("open"),//наверно открыть машину
    CLOSE("close"),//это -- закрыть
    COMPLETE("complete"),//завершить аренду
    TRANSFER("transfer");//передать машину другому вне домашней зоны
    
    private final String text;

    Command(String text) {
        this.text = text;
    }

    public String toString() {
        return this.text;
    }

    public static Command fromString(String text) {
        if (text != null) {
            for (Command command : values()) {
                if (text.equalsIgnoreCase(command.text)) {
                    return command;
                }
            }
        }
        return null;
    }
}
