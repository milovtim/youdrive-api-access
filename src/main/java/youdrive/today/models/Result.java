package youdrive.today.models;

public enum Result {
    NEW("new"),
    PROCESSING("processing"),
    DONE("done"),
    ERROR("error");
    
    private final String text;

    private Result(String text) {
        this.text = text;
    }

    public String toString() {
        return this.text;
    }

    public static Result fromString(String text) {
        if (text != null) {
            for (Result result : values()) {
                if (text.equalsIgnoreCase(result.text)) {
                    return result;
                }
            }
        }
        return null;
    }
}
