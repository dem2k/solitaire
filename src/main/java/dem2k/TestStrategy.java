package dem2k;

import static dem2k.MoveDirection.DOWN;
import static dem2k.MoveDirection.LEFT;
import static dem2k.MoveDirection.NOPE;
import static dem2k.MoveDirection.RIGHT;
import static dem2k.MoveDirection.UP;

public class TestStrategy implements Strategy {

    private final GameField field;
    private final AppConfig config;

    public TestStrategy(GameField field, AppConfig config) {
        this.field = field;
        this.config = config;
    }

    @Override
    public Move getNextMove() {
        for (int x = 1; x < field.rows(); x++) {
            for (int y = 1; y < field.cols(); y++) {
                if (field.canMove(x, y, LEFT)) {
                    return new Move(x, y, LEFT);
                }
                if (field.canMove(x, y, RIGHT)) {
                    return new Move(x, y, RIGHT);
                }
                if (field.canMove(x, y, UP)) {
                    return new Move(x, y, UP);
                }
                if (field.canMove(x, y, DOWN)) {
                    return new Move(x, y, DOWN);
                }
            }
        }
        return new Move(0, 0, NOPE);
    }

    @Override
    public boolean hasNextMove() {
        for (int x = 1; x < field.rows(); x++) {
            for (int y = 1; y < field.cols(); y++) {
                if (field.canMove(x, y, LEFT) || field.canMove(x, y, RIGHT)
                        || field.canMove(x, y, DOWN) || field.canMove(x, y, UP)) {
                    return true;
                }
            }
        }
        return false;
    }
}
