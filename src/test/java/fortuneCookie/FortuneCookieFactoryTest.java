package fortuneCookie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class FortuneCookieFactoryTest {
    public static FortuneCookieFactory fortuneCookieFactory;

    @BeforeEach
    public void setUp() {
        FortuneConfig fortuneConfigGoodFortune = new FortuneConfig(true);
        ArrayList<String> goodFortune = new ArrayList<>();
        goodFortune.add("goodFortune");
        ArrayList<String> badFortune = new ArrayList<>();
        badFortune.add("badFortune");

        fortuneCookieFactory = new FortuneCookieFactory(fortuneConfigGoodFortune, goodFortune, badFortune);
    }

    @Test
    public void shouldIncrementCountByOneAfterOneCookieBaked() {
        fortuneCookieFactory.bakeFortuneCookie();
        Assertions.assertEquals(1, fortuneCookieFactory.getCookiesBaked());
    }

    @Test
    public void shouldIncrementCountByTwoAfterTwoCookiesBaked() {
        fortuneCookieFactory.bakeFortuneCookie();
        fortuneCookieFactory.bakeFortuneCookie();
        Assertions.assertEquals(2, fortuneCookieFactory.getCookiesBaked());
    }

    @Test
    public void shouldSetCounterToZeroAfterResetCookieCreatedCall() {
        fortuneCookieFactory.bakeFortuneCookie();
        fortuneCookieFactory.bakeFortuneCookie();
        fortuneCookieFactory.resetCookiesCreated();
        Assertions.assertEquals(0, fortuneCookieFactory.getCookiesBaked());
    }
}
