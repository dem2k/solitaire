package dem2k;

import org.junit.jupiter.api.Test;

class ConsoleVieweerTest {

    private final AppConfig config = AppConfig.builder().build();

    @Test
    void show() {
        GameField field = GameField.initial();
        Viewer view = new ConsoleVieweer(field, config);
        field.setFeld(2, 4, PegType.MOVEMENT);
        view.show();
    }
}
