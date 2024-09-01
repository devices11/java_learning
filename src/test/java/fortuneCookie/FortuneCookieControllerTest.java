package fortuneCookie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class FortuneCookieControllerTest {
    public static FortuneCookieController goodFactoryController;
    public static FortuneCookieController badFactoryController;

    @BeforeAll
    public static void setUp() {
        ArrayList<String> goodFortune = new ArrayList<>();
        goodFortune.add("goodFortune");
        ArrayList<String> badFortune = new ArrayList<>();
        badFortune.add("badFortune");

        FortuneConfig fortuneConfigGoodFortune = new FortuneConfig(true);
        FortuneCookieFactory fortuneCookieFactoryGoodFortune = new FortuneCookieFactory(fortuneConfigGoodFortune, goodFortune, badFortune);
        goodFactoryController = new FortuneCookieController(fortuneCookieFactoryGoodFortune);

        FortuneConfig fortuneConfigBadFortune = new FortuneConfig(false);
        FortuneCookieFactory fortuneCookieFactoryBadFortune = new FortuneCookieFactory(fortuneConfigBadFortune, goodFortune, badFortune);
        badFactoryController = new FortuneCookieController(fortuneCookieFactoryBadFortune);
    }

    @Test
    public void shouldReturnPositiveFortune() {
        Assertions.assertEquals("goodFortune", goodFactoryController.tellFortune().getFortuneText());
    }

    @Test
    public void shouldReturnNegativeFortune() {
        Assertions.assertEquals("badFortune", badFactoryController.tellFortune().getFortuneText());
    }
}
