package dem2k;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ViewerTest {

    private final AppConfig config = AppConfig.builder().build();

    @Test
    void jump_right() {
        GameField field = GameField.initial();
        Viewer viewer = new ConsoleVieweer(field, config);
        viewer.show();

        Move move = new Move(2, 4, MoveDirection.RIGHT);
        viewer.move(move);

        assertEquals(PegType.STONE, field.getFeld(4, 4));
        assertEquals(PegType.EMPTY, field.getFeld(2, 4));
    }

    @Test
    void jump_left() {
        GameField field = GameField.initial();
        Viewer viewer = new ConsoleVieweer(field, config);
        viewer.show();

        Move move = new Move(6, 4, MoveDirection.LEFT);
        viewer.move(move);

        assertEquals(PegType.STONE, field.getFeld(4, 4));
        assertEquals(PegType.EMPTY, field.getFeld(6, 4));
    }

    @Test
    void jump_down() {
        GameField field = GameField.initial();
        Viewer viewer = new ConsoleVieweer(field, config);
        viewer.show();

        Move move = new Move(4, 2, MoveDirection.DOWN);
        viewer.move(move);

        assertEquals(PegType.STONE, field.getFeld(4, 4));
        assertEquals(PegType.EMPTY, field.getFeld(4, 2));
    }

    @Test
    void jump_up() {
        GameField field = GameField.initial();
        Viewer viewer = new ConsoleVieweer(field, config);
        viewer.show();

        Move move = new Move(4, 6, MoveDirection.UP);
        viewer.move(move);

        assertEquals(PegType.STONE, field.getFeld(4, 4));
        assertEquals(PegType.EMPTY, field.getFeld(4, 6));
    }

}
