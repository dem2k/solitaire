package dem2k;

import org.junit.jupiter.api.Test;

class ConsoleVieweerTest {

    private final AppConfig config = AppConfig.builder().build();

    @Test
    void english() {
        GameField field = GameField.english();
        Viewer view = new ConsoleVieweer(field, config);
        field.setFeld(2, 4, PegType.MOVEMENT);
        view.show();
    }

    @Test
    void european() {
        GameField field = GameField.european();
        Viewer view = new ConsoleVieweer(field, config);
        field.setFeld(2, 4, PegType.MOVEMENT);
        view.show();
    }

}
