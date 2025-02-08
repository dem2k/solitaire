package dem2k;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TestUtfZeichen {

    @Test
    @Disabled
    void name() {
        System.out.println('•');
        PrintStream out = new PrintStream(System.out, true, StandardCharsets.UTF_8);
        out.println("读写汉字");
        System.out.println("*ü [·](\u00B7) \u2022 • ○  · • ¤ \uE214      ");
    }
}
