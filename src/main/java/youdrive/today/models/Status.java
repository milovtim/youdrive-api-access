package youdrive.today.models;

public enum Status {
    NORMAL("normal"),
    BOOKING("booking"),
    USAGE("usage"),
    PARKING("parking");
    
    private final String text;

    private Status(String text) {
        this.text = text;
    }

    public String toString() {
        return this.text;
    }

    public static Status fromString(String text) {
        if (text != null) {
            for (Status status : values()) {
                if (text.equalsIgnoreCase(status.text)) {
                    return status;
                }
            }
        }
        return null;
    }
}
