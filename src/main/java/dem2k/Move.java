package dem2k;

public class Move {

    private final int x;
    private final int y;
    private final MoveDirection moveDirection;

    public Move(int x, int y, MoveDirection moveDirection) {
        this.x = x;
        this.y = y;
        this.moveDirection = moveDirection;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public MoveDirection direction() {
        return moveDirection;
    }
}
