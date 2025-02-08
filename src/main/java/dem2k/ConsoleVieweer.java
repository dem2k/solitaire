package dem2k;

public class ConsoleVieweer implements Viewer {

    private static final String ERASE_LINE = "\033[K";
    private static final String HOME_POS00 = "\033[0;0H"; //POS 0,0
    private static final String CLEAR_SCRN = "\033[2J"; // CLS  Oder? "\033[H\033[2J";

    private final GameField field;
    private final AppConfig config;

    public ConsoleVieweer(GameField field, AppConfig config) {
        this.field = field;
        this.config = config;
        System.out.println(CLEAR_SCRN);
    }

    @Override
    public void show() {
        StringBuilder result = new StringBuilder(" ");
        for (int y = 0; y < field.cols(); y++) {
            for (int x = 0; x < field.rows(); x++) {
                result.append(mapCell(field.getFeld(x, y)));
            }
            result.append("\n ");
        }
        System.out.println(HOME_POS00);
        sleep();
        System.out.println(result);
    }

    @Override
    public void move(Move move) {
        if (move.direction() == MoveDirection.LEFT) {
            moveLeft(move.x(), move.y());
        }
        if (move.direction() == MoveDirection.RIGHT) {
            moveRight(move.x(), move.y());
        }
        if (move.direction() == MoveDirection.UP) {
            moveUp(move.x(), move.y());
        }
        if (move.direction() == MoveDirection.DOWN) {
            moveDown(move.x(), move.y());
        }
    }

    private void sleep() {
        try {
            Thread.sleep(config.frameDelay());
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private char mapCell(FieldType cell) {
        switch (cell) {
            case EMPTY:
                return ' ';
            case STONE:
                return '@'; // '•' ''
            case BORDER:
                return ' ';
            case MOVEMENT:
                return '*';
            case ERASED:
                return 'x';
            case ERASED2:
                return '+';
        }
        return '?';
    }

    public void moveDown(int x, int y) {
        field.setFeld(x, y, FieldType.MOVEMENT);
        show();
        field.setFeld(x, y, FieldType.EMPTY);
        field.setFeld(x, y + 1, FieldType.MOVEMENT);
        show();
        field.setFeld(x, y + 1, FieldType.ERASED);
        field.setFeld(x, y + 2, FieldType.MOVEMENT);
        show();
        field.setFeld(x, y + 1, FieldType.ERASED2);
        show();
        field.setFeld(x, y + 1, FieldType.EMPTY);
        field.setFeld(x, y + 2, FieldType.MOVEMENT);
        show();
        field.setFeld(x, y + 2, FieldType.STONE);
        show();
    }

    public void moveUp(int x, int y) {
        field.setFeld(x, y, FieldType.MOVEMENT);
        show();
        field.setFeld(x, y, FieldType.EMPTY);
        field.setFeld(x, y - 1, FieldType.MOVEMENT);
        show();
        field.setFeld(x, y - 1, FieldType.ERASED);
        field.setFeld(x, y - 2, FieldType.MOVEMENT);
        show();
        field.setFeld(x, y - 1, FieldType.ERASED2);
        show();
        field.setFeld(x, y - 1, FieldType.EMPTY);
        field.setFeld(x, y - 2, FieldType.MOVEMENT);
        show();
        field.setFeld(x, y - 2, FieldType.STONE);
        show();
    }

    public void moveRight(int x, int y) {
        field.setFeld(x, y, FieldType.MOVEMENT);
        show();
        field.setFeld(x, y, FieldType.EMPTY);
        field.setFeld(x + 1, y, FieldType.MOVEMENT);
        show();
        field.setFeld(x + 1, y, FieldType.ERASED);
        field.setFeld(x + 2, y, FieldType.MOVEMENT);
        show();
        field.setFeld(x + 1, y, FieldType.ERASED2);
        show();
        field.setFeld(x + 1, y, FieldType.EMPTY);
        field.setFeld(x + 2, y, FieldType.MOVEMENT);
        show();
        field.setFeld(x + 2, y, FieldType.STONE);
        show();
    }

    public void moveLeft(int x, int y) {
        field.setFeld(x, y, FieldType.MOVEMENT);
        show();
        field.setFeld(x, y, FieldType.EMPTY);
        field.setFeld(x - 1, y, FieldType.MOVEMENT);
        show();
        field.setFeld(x - 1, y, FieldType.ERASED);
        field.setFeld(x - 2, y, FieldType.MOVEMENT);
        show();
        field.setFeld(x - 1, y, FieldType.ERASED2);
        show();
        field.setFeld(x - 1, y, FieldType.EMPTY);
        field.setFeld(x - 2, y, FieldType.MOVEMENT);
        show();
        field.setFeld(x - 2, y, FieldType.STONE);
        show();
    }

}
