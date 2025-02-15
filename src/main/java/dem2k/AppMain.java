package dem2k;

import picocli.CommandLine;

@CommandLine.Command(name = "solitaire", mixinStandardHelpOptions = true, version = "v0.1.1-SNAPSHOT",
        description = "this_is_a_simple_but_powerful_foobar_command")
public class AppMain {

    @CommandLine.Option(names = "-d", description = "Delay between Frames", required = false)
    private static long frameDelay = 100L;

    @CommandLine.Option(names = {"-?", "-h"}, description = "Display this Help Message", usageHelp = true)
    private static boolean usageHelpRequested = false;

    public static void main(String[] args) {

        AppMain app = CommandLine.populateCommand(new AppMain(), args);

        if (usageHelpRequested) {
            CommandLine.usage(app, System.out);
            System.exit(1);
        }

        AppConfig config = AppConfig.builder()
                .frameDelay(frameDelay)
                .build();
        app.runWithConfig(config);
    }

    private void runWithConfig(AppConfig config) {
        GameField field = GameField.european();
        Viewer viewer = new ConsoleVieweer(field, config);
        Strategy strategy = new TestStrategy(field, config);
        GameController game = new GameController(field, viewer, strategy, config);
        game.start();
    }

}
