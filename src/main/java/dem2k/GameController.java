package dem2k;

public class GameController {

    private final GameField field;
    private final Viewer viewer;
    private final Strategy strategy;
    private final AppConfig config;

    public GameController(GameField field, Viewer viewer, Strategy strategy, AppConfig config) {
        this.field = field;
        this.viewer = viewer;
        this.strategy = strategy;
        this.config = config;
    }

    public void start() {
        viewer.show();
        while (strategy.hasNextMove()) {
            Move move = strategy.getNextMove();
            viewer.animate(move);
            field.move(move);
            viewer.show();
        }

        if (field.checkWin()) {
            System.out.println("Congrats! You won!");
        }
        System.out.println("\n");
    }

}
