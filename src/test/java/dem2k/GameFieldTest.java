package dem2k;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GameFieldTest {

    private final GameField field = GameField.english();

    @Test
    void test_english() {
        assertEquals(PegType.EMPTY, field.getFeld(4, 4));
        assertEquals(PegType.BORDER, field.getFeld(1, 1));
        assertEquals(PegType.BORDER, field.getFeld(2, 2));
        assertEquals(PegType.BORDER, field.getFeld(6, 6));
        assertEquals(PegType.BORDER, field.getFeld(2, 6));
        assertEquals(PegType.BORDER, field.getFeld(7, 7));
    }

    @Test
    void test_get_feld() {
        assertEquals(PegType.BORDER, field.getFeld(1, 1));
        assertEquals(PegType.STONE, field.getFeld(3, 1));
        assertEquals(PegType.EMPTY, field.getFeld(4, 4));
    }

    @Test
    void test_can_jump_right() {
        assertTrue(field.canMove(2, 4,MoveDirection.RIGHT));
        assertFalse(field.canMove(2, 4, MoveDirection.LEFT));
    }

    @Test
    void test_can_jump_left() {
        assertTrue(field.canMove(6, 4, MoveDirection.LEFT));
        assertFalse(field.canMove(6, 4, MoveDirection.RIGHT));
    }

    @Test
    void test_jump_left() {
        field.move(new Move(6, 4, MoveDirection.LEFT));
        assertEquals(PegType.EMPTY, field.getFeld(5, 4));
        assertEquals(PegType.EMPTY, field.getFeld(6, 4));
        assertEquals(PegType.STONE, field.getFeld(4, 4));
    }

    @Test
    void test_jump_right() {
        field.move(new Move(2, 4, MoveDirection.RIGHT));
        assertEquals(PegType.EMPTY, field.getFeld(2, 4));
        assertEquals(PegType.EMPTY, field.getFeld(3, 4));
        assertEquals(PegType.STONE, field.getFeld(4, 4));
    }

    @Test
    void test_jump_up() {
        field.move(new Move(4, 6, MoveDirection.UP));
        assertEquals(PegType.EMPTY, field.getFeld(4, 6));
        assertEquals(PegType.EMPTY, field.getFeld(4, 5));
        assertEquals(PegType.STONE, field.getFeld(4, 4));
    }

    @Test
    void test_jump_down() {
        field.move(new Move(4, 2, MoveDirection.DOWN));
        assertEquals(PegType.EMPTY, field.getFeld(4, 2));
        assertEquals(PegType.EMPTY, field.getFeld(4, 3));
        assertEquals(PegType.STONE, field.getFeld(4, 4));
    }

    @Test
    void test_can_jump_up() {
        assertTrue(field.canMove(4, 6, MoveDirection.UP));
        assertFalse(field.canMove(4, 6, MoveDirection.DOWN));
    }

    @Test
    void test_can_jump_down() {
        assertTrue(field.canMove(4, 2, MoveDirection.DOWN));
        assertFalse(field.canMove(4, 2, MoveDirection.UP));
    }

    @Test
    void test_set_feld() {
        field.setFeld(4, 4, PegType.MOVEMENT);
        assertEquals(PegType.MOVEMENT, field.getFeld(4, 4));
    }

    @Test
    void test_check_win() {
        // Setze alle Felder auf EMPTY außer Ränder und Mittelpunkt
        for (int y = 1; y < field.rows() - 1; y++) {
            for (int x = 1; x < field.cols() - 1; x++) {
                if (x == 4 && y == 4) continue;
                field.setFeld(x, y, PegType.EMPTY);
            }
        }
        // Setze Mittelfeld auf STONE
        field.setFeld(4, 4, PegType.STONE);

        assertTrue(field.checkWin());
    }

}
