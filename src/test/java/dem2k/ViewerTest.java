package dem2k;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ViewerTest {

    private final AppConfig config = AppConfig.builder().build();
    private GameField field;
    private Viewer viewer;

    @BeforeEach
    void setUp() {
        field = GameField.english();
        viewer = new ConsoleVieweer(field, config);
        viewer.show();
    }

    @Test
    void test_clone() {
        Move move = new Move(2, 4, MoveDirection.RIGHT);
        ConsoleVieweer local = new ConsoleVieweer(field.clone(), config);
        local.animate(move);
        assertEquals(PegType.EMPTY, field.getFeld(4, 4));
    }

    @Test
    void jump_right() {
        Move move = new Move(2, 4, MoveDirection.RIGHT);
        viewer.animate(move);
        assertEquals(PegType.STONE, field.getFeld(4, 4));
        assertEquals(PegType.EMPTY, field.getFeld(2, 4));
    }

    @Test
    void jump_left() {
        Move move = new Move(6, 4, MoveDirection.LEFT);
        viewer.animate(move);
        assertEquals(PegType.STONE, field.getFeld(4, 4));
        assertEquals(PegType.EMPTY, field.getFeld(6, 4));
    }

    @Test
    void jump_down() {
        Move move = new Move(4, 2, MoveDirection.DOWN);
        viewer.animate(move);
        assertEquals(PegType.STONE, field.getFeld(4, 4));
        assertEquals(PegType.EMPTY, field.getFeld(4, 2));
    }

    @Test
    void jump_up() {
        Move move = new Move(4, 6, MoveDirection.UP);
        viewer.animate(move);
        assertEquals(PegType.STONE, field.getFeld(4, 4));
        assertEquals(PegType.EMPTY, field.getFeld(4, 6));
    }

}
