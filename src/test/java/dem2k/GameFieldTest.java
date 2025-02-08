package dem2k;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GameFieldTest {

    @Test
    void test_initial() {
        GameField field = GameField.initial();
        assertEquals(FieldType.EMPTY, field.getFeld(4, 4));
        assertEquals(FieldType.BORDER, field.getFeld(1, 1));
        assertEquals(FieldType.BORDER, field.getFeld(2, 2));
        assertEquals(FieldType.BORDER, field.getFeld(6, 6));
        assertEquals(FieldType.BORDER, field.getFeld(2, 6));
        assertEquals(FieldType.BORDER, field.getFeld(7, 7));
    }

    @Test
    void test_get_feld() {
        GameField zstd = GameField.initial();
        assertEquals(FieldType.BORDER, zstd.getFeld(1, 1));
        assertEquals(FieldType.STONE, zstd.getFeld(3, 1));
        assertEquals(FieldType.EMPTY, zstd.getFeld(4, 4));
    }

    @Test
    void test_can_jump_right() {
        GameField zstd = GameField.initial();
        assertTrue(zstd.canJumpRight(2, 4));
        assertFalse(zstd.canJumpLeft(2, 4));
    }

    @Test
    void test_can_jump_left() {
        GameField zstd = GameField.initial();
        assertTrue(zstd.canJumpLeft(6, 4));
        assertFalse(zstd.canJumpRight(6, 4));
    }

    @Test
    void test_jump_left() {
        GameField field = GameField.initial();
        field.jumpLeft(6, 4);
        assertEquals(FieldType.EMPTY, field.getFeld(5, 4));
        assertEquals(FieldType.EMPTY, field.getFeld(6, 4));
        assertEquals(FieldType.STONE, field.getFeld(4, 4));
    }

    @Test
    void test_jump_right() {
        GameField field = GameField.initial();
        field.jumpRight(2, 4);
        assertEquals(FieldType.EMPTY, field.getFeld(2, 4));
        assertEquals(FieldType.EMPTY, field.getFeld(3, 4));
        assertEquals(FieldType.STONE, field.getFeld(4, 4));
    }

    @Test
    void test_jump_up() {
        GameField field = GameField.initial();
        field.jumpUp(4, 6);
        assertEquals(FieldType.EMPTY, field.getFeld(4, 6));
        assertEquals(FieldType.EMPTY, field.getFeld(4, 5));
        assertEquals(FieldType.STONE, field.getFeld(4, 4));
    }

    @Test
    void test_jump_down() {
        GameField field = GameField.initial();
        field.jumpDown(4, 2);
        assertEquals(FieldType.EMPTY, field.getFeld(4, 2));
        assertEquals(FieldType.EMPTY, field.getFeld(4, 3));
        assertEquals(FieldType.STONE, field.getFeld(4, 4));
    }

    @Test
    void test_can_jump_up() {
        GameField field = GameField.initial();
        assertTrue(field.canJumpUp(4, 6));
        assertFalse(field.canJumpDown(4, 6));
    }

    @Test
    void test_can_jump_down() {
        GameField field = GameField.initial();
        assertTrue(field.canJumpDown(4, 2));
        assertFalse(field.canJumpUp(4, 2));
    }

    @Test
    void test_set_feld() {
        GameField field = GameField.initial();
        field.setFeld(4, 4, FieldType.MOVEMENT);
        assertEquals(FieldType.MOVEMENT, field.getFeld(4, 4));
    }

}
