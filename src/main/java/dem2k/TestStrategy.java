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
                if (field.canJumpLeft(x, y)) {
                    return new Move(x, y, LEFT);
                }
                if (field.canJumpRight(x, y)) {
                    return new Move(x, y, RIGHT);
                }
                if (field.canJumpUp(x, y)) {
                    return new Move(x, y, UP);
                }
                if (field.canJumpDown(x, y)) {
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
                if (field.canJumpLeft(x, y) || field.canJumpRight(x, y)
                        || field.canJumpDown(x, y) || field.canJumpUp(x, y)) {
                    return true;
                }
            }
        }
        return false;
    }
}
