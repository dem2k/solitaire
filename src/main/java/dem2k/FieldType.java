package dem2k;

public enum FieldType {

    EMPTY(0), BORDER(-1), STONE(1), MOVEMENT(9), ERASED(7), ERASED2(8);

    private final int type;

    FieldType(int type) {
        this.type = type;
    }

    public int type() {
        return type;
    }

    public static FieldType ofType(int type) {
        for (FieldType value : values()) {
            if (value.type == type) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown type: " + type);
    }

}
