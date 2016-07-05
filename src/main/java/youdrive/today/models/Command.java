package youdrive.today.models;

public enum Command {
    OPEN("open"),
    CLOSE("close"),
    COMPLETE("complete"),
    TRANSFER("transfer");
    
    private final String text;

    private Command(String text) {
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
