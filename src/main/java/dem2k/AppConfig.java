package dem2k;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class AppConfig {

    @Builder.Default
    private final long frameDelay = 100L;

}
