package dem2k;

public class GameField {

    private final int rows = 9;
    private final int cols = 9;
    private final int[] field;

    private GameField(int[] field) {
        this.field = field;
    }

    public static GameField english() {
        int[] initial = {
//               0   1   2   3   4   5   6   7   8                
/*       0  */  -1, -1, -1, -1, -1, -1, -1, -1, -1,
/*       1  */  -1, -1, -1, +1, +1, +1, -1, -1, -1,
/*       2  */  -1, -1, -1, +1, +1, +1, -1, -1, -1,
/*       3  */  -1, +1, +1, +1, +1, +1, +1, +1, -1,
/*       4  */  -1, +1, +1, +1,  0, +1, +1, +1, -1,
/*       5  */  -1, +1, +1, +1, +1, +1, +1, +1, -1,
/*       6  */  -1, -1, -1, +1, +1, +1, -1, -1, -1,
/*       7  */  -1, -1, -1, +1, +1, +1, -1, -1, -1,
/*       8  */  -1, -1, -1, -1, -1, -1, -1, -1, -1,
        };
        return new GameField(initial);
    }

    public static GameField european() {
        int[] initial = {
//               0   1   2   3   4   5   6   7   8                
/*       0  */  -1, -1, -1, -1, -1, -1, -1, -1, -1,
/*       1  */  -1, -1, -1, +1, +1, +1, -1, -1, -1,
/*       2  */  -1, -1, +1, +1, +1, +1, +1, -1, -1,
/*       3  */  -1, +1, +1, +1, +1, +1, +1, +1, -1,
/*       4  */  -1, +1, +1, +1,  0, +1, +1, +1, -1,
/*       5  */  -1, +1, +1, +1, +1, +1, +1, +1, -1,
/*       6  */  -1, -1, +1, +1, +1, +1, +1, -1, -1,
/*       7  */  -1, -1, -1, +1, +1, +1, -1, -1, -1,
/*       8  */  -1, -1, -1, -1, -1, -1, -1, -1, -1,
        };
        return new GameField(initial);
    }

    // 1-based coordinates!

    public PegType getFeld(int x, int y) {
        return PegType.ofType(field[y * rows + x]);
    }

    public void setFeld(int x, int y, PegType value) {
        field[y * rows + x] = value.type();
    }

    public boolean canJump(int x, int y, MoveDirection move) {
        if (move == MoveDirection.LEFT) {
            return canJumpLeft(x, y);
        }
        if (move == MoveDirection.RIGHT) {
            return canJumpRight(x, y);
        }
        if (move == MoveDirection.UP) {
            return canJumpUp(x, y);
        }
        if (move == MoveDirection.DOWN) {
            return canJumpDown(x, y);
        }
        throw new IllegalArgumentException("Unknown Move: " + move.toString());
    }

    private boolean canJumpRight(int x, int y) {
        checkOutOfBounds(x, y);
        return field[y * rows + x] == PegType.STONE.type()
                && field[y * rows + x + 1] == PegType.STONE.type() && field[y * rows + x + 2] == PegType.EMPTY.type();
    }

    private boolean canJumpLeft(int x, int y) {
        checkOutOfBounds(x, y);
        return field[y * rows + x] == PegType.STONE.type()
                && field[y * rows + x - 1] == PegType.STONE.type() && field[y * rows + x - 2] == PegType.EMPTY.type();
    }

    private boolean canJumpDown(int x, int y) {
        checkOutOfBounds(x, y);
        return field[y * rows + x] == PegType.STONE.type()
                && field[(y + 1) * rows + x] == PegType.STONE.type() && field[(y + 2) * rows + x] == PegType.EMPTY.type();
    }

    private boolean canJumpUp(int x, int y) {
        checkOutOfBounds(x, y);
        return field[y * rows + x] == PegType.STONE.type()
                && field[(y - 1) * rows + x] == PegType.STONE.type() && field[(y - 2) * rows + x] == PegType.EMPTY.type();
    }

    public void jumpRight(int x, int y) {
        checkOutOfBounds(x, y);
        field[y * rows + x] = 0;
        field[y * rows + x + 1] = 0;
        field[y * rows + x + 2] = 1;
    }

    public void jumpLeft(int x, int y) {
        checkOutOfBounds(x, y);
        field[y * rows + x] = 0;
        field[y * rows + x - 1] = 0;
        field[y * rows + x - 2] = 1;
    }

    public void jumpUp(int x, int y) {
        checkOutOfBounds(x, y);
        field[y * rows + x] = 0;
        field[(y - 1) * rows + x] = 0;
        field[(y - 2) * rows + x] = 1;
    }

    public void jumpDown(int x, int y) {
        checkOutOfBounds(x, y);
        field[y * rows + x] = 0;
        field[(y + 1) * rows + x] = 0;
        field[(y + 2) * rows + x] = 1;
    }

    private void checkOutOfBounds(int x, int y) {
        if (x < 1 || y < 1 || x > rows - 1 || y > cols - 1) {
            throw new IndexOutOfBoundsException(x + "," + y);
        }
    }

    public int rows() {
        return rows;
    }

    public int cols() {
        return cols;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("     0  1  2  3  4  5  6  7  8");
        for (int i = 0; i < field.length; i++) {
            if (i % this.rows == 0) {
                result.append("\n").append(String.format("%2d:", i / this.rows));
            }
            result.append(String.format("%3d", field[i]));
        }
        return result.toString();
    }
}
