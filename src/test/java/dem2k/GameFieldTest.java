package dem2k;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GameFieldTest {

    @Test
    void test_english() {
        GameField field = GameField.english();
        assertEquals(PegType.EMPTY, field.getFeld(4, 4));
        assertEquals(PegType.BORDER, field.getFeld(1, 1));
        assertEquals(PegType.BORDER, field.getFeld(2, 2));
        assertEquals(PegType.BORDER, field.getFeld(6, 6));
        assertEquals(PegType.BORDER, field.getFeld(2, 6));
        assertEquals(PegType.BORDER, field.getFeld(7, 7));
    }

    @Test
    void test_get_feld() {
        GameField zstd = GameField.english();
        assertEquals(PegType.BORDER, zstd.getFeld(1, 1));
        assertEquals(PegType.STONE, zstd.getFeld(3, 1));
        assertEquals(PegType.EMPTY, zstd.getFeld(4, 4));
    }

    @Test
    void test_can_jump_right() {
        GameField zstd = GameField.english();
        assertTrue(zstd.canJumpRight(2, 4));
        assertFalse(zstd.canJumpLeft(2, 4));
    }

    @Test
    void test_can_jump_left() {
        GameField zstd = GameField.english();
        assertTrue(zstd.canJumpLeft(6, 4));
        assertFalse(zstd.canJumpRight(6, 4));
    }

    @Test
    void test_jump_left() {
        GameField field = GameField.english();
        field.jumpLeft(6, 4);
        assertEquals(PegType.EMPTY, field.getFeld(5, 4));
        assertEquals(PegType.EMPTY, field.getFeld(6, 4));
        assertEquals(PegType.STONE, field.getFeld(4, 4));
    }

    @Test
    void test_jump_right() {
        GameField field = GameField.english();
        field.jumpRight(2, 4);
        assertEquals(PegType.EMPTY, field.getFeld(2, 4));
        assertEquals(PegType.EMPTY, field.getFeld(3, 4));
        assertEquals(PegType.STONE, field.getFeld(4, 4));
    }

    @Test
    void test_jump_up() {
        GameField field = GameField.english();
        field.jumpUp(4, 6);
        assertEquals(PegType.EMPTY, field.getFeld(4, 6));
        assertEquals(PegType.EMPTY, field.getFeld(4, 5));
        assertEquals(PegType.STONE, field.getFeld(4, 4));
    }

    @Test
    void test_jump_down() {
        GameField field = GameField.english();
        field.jumpDown(4, 2);
        assertEquals(PegType.EMPTY, field.getFeld(4, 2));
        assertEquals(PegType.EMPTY, field.getFeld(4, 3));
        assertEquals(PegType.STONE, field.getFeld(4, 4));
    }

    @Test
    void test_can_jump_up() {
        GameField field = GameField.english();
        assertTrue(field.canJumpUp(4, 6));
        assertFalse(field.canJumpDown(4, 6));
    }

    @Test
    void test_can_jump_down() {
        GameField field = GameField.english();
        assertTrue(field.canJumpDown(4, 2));
        assertFalse(field.canJumpUp(4, 2));
    }

    @Test
    void test_set_feld() {
        GameField field = GameField.english();
        field.setFeld(4, 4, PegType.MOVEMENT);
        assertEquals(PegType.MOVEMENT, field.getFeld(4, 4));
    }

}
