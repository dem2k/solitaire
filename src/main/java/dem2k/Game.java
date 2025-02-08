package dem2k;

public class Game {

    private final GameField field;
    private final Viewer viewer;
    private final Strategy strategy;
    private final AppConfig config;

    public Game(GameField field, Viewer viewer, Strategy strategy, AppConfig config) {
        this.field = field;
        this.viewer = viewer;
        this.strategy = strategy;
        this.config = config;
    }

    public void start() {
        viewer.show();
        while (strategy.hasNextMove()) {
            Move move = strategy.getNextMove();
            viewer.move(move);
            viewer.show();
        }
        //TODO check win.
    }

}
