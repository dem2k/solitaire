package dem2k;

import static dem2k.PegType.EMPTY;
import static dem2k.PegType.ERASED;
import static dem2k.PegType.MOVEMENT;
import static dem2k.PegType.STONE;

public class ConsoleVieweer implements Viewer {

    private static final String ERASE_LINE = "\033[K";
    private static final String HOME_POS00 = "\033[0;0H"; //POS 0,0
    private static final String CLEAR_SCRN = "\033[2J"; // CLS  Oder? "\033[H\033[2J";

    private GameField field;
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
    public void animate(Move move) {
        // view should not change model?
        //this.field = field.clone();
        
        switch (move.direction()) {
            case LEFT:
                moveLeft(move.x(), move.y());
                break;
            case RIGHT:
                moveRight(move.x(), move.y());
                break;
            case UP:
                moveUp(move.x(), move.y());
                break;
            case DOWN:
                moveDown(move.x(), move.y());
                break;
            case NOPE:
                break;
            default:
                throw new IllegalArgumentException("Unknown Move: " + move.direction());
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

    private char mapCell(PegType cell) {
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
        }
        return '?';
    }

    private void moveDown(int x, int y) {
        field.setFeld(x, y, MOVEMENT);
        show();
        field.setFeld(x, y, EMPTY);
        field.setFeld(x, y + 1, MOVEMENT);
        show();
        field.setFeld(x, y + 1, ERASED);
        field.setFeld(x, y + 2, MOVEMENT);
        show();
//        field.setFeld(x, y + 1, ERASED2);
//        show();
        field.setFeld(x, y + 1, EMPTY);
        field.setFeld(x, y + 2, MOVEMENT);
        show();
        field.setFeld(x, y + 2, STONE);
        show();
    }

    private void moveUp(int x, int y) {
        field.setFeld(x, y, MOVEMENT);
        show();
        field.setFeld(x, y, EMPTY);
        field.setFeld(x, y - 1, MOVEMENT);
        show();
        field.setFeld(x, y - 1, ERASED);
        field.setFeld(x, y - 2, MOVEMENT);
        show();
//        field.setFeld(x, y - 1, ERASED2);
//        show();
        field.setFeld(x, y - 1, EMPTY);
        field.setFeld(x, y - 2, MOVEMENT);
        show();
        field.setFeld(x, y - 2, STONE);
        show();
    }

    private void moveRight(int x, int y) {
        field.setFeld(x, y, MOVEMENT);
        show();
        field.setFeld(x, y, EMPTY);
        field.setFeld(x + 1, y, MOVEMENT);
        show();
        field.setFeld(x + 1, y, ERASED);
        field.setFeld(x + 2, y, MOVEMENT);
        show();
//        field.setFeld(x + 1, y, ERASED2);
//        show();
        field.setFeld(x + 1, y, EMPTY);
        field.setFeld(x + 2, y, MOVEMENT);
        show();
        field.setFeld(x + 2, y, STONE);
        show();
    }

    private void moveLeft(int x, int y) {
        field.setFeld(x, y, MOVEMENT);
        show();
        field.setFeld(x, y, EMPTY);
        field.setFeld(x - 1, y, MOVEMENT);
        show();
        field.setFeld(x - 1, y, ERASED);
        field.setFeld(x - 2, y, MOVEMENT);
        show();
//        field.setFeld(x - 1, y, ERASED2);
//        show();
        field.setFeld(x - 1, y, EMPTY);
        field.setFeld(x - 2, y, MOVEMENT);
        show();
        field.setFeld(x - 2, y, STONE);
        show();
    }

}
