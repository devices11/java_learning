package priceCalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PriceCalculatorTest {

    private final PriceCalculator priceCalculator = new PriceCalculator();

    @Test
    public void shouldBeNegativeWhenBikeAndDistanceIs0Km() {
        Assertions.assertTrue(priceCalculator.calculatePrice(TransportType.BIKE, 0) < 0);
    }

    @Test
    public void shouldBe200WhenBikeAndDistanceIs20Km() {
        Assertions.assertEquals(200, (int) priceCalculator.calculatePrice(TransportType.BIKE, 20));
    }

    @Test
    public void shouldBeNegativeWhenBikeAndDistanceIs21Km() {
        Assertions.assertTrue(priceCalculator.calculatePrice(TransportType.BIKE, 21) < 0);
    }

    @Test
    public void shouldBeNegativeWhenCarAndDistanceIs0Km() {
        Assertions.assertTrue(priceCalculator.calculatePrice(TransportType.CAR, 0) < 0);
    }

    @Test
    public void shouldBe7000WhenCarAndDistanceIs1000Km() {
        Assertions.assertEquals(7000, (int) priceCalculator.calculatePrice(TransportType.CAR, 1000));
    }

    @Test
    public void shouldBeNegativeWhenCarAndDistanceIs1001Km() {
        Assertions.assertTrue(priceCalculator.calculatePrice(TransportType.CAR, 1001) < 0);
    }

    @Test
    public void shouldBeNegativeWhenTruckAndDistanceIs0Km() {
        Assertions.assertTrue(priceCalculator.calculatePrice(TransportType.TRUCK, 0) < 0);
    }

    @Test
    public void shouldBe100000WhenTruckAndDistanceIs10000Km() {
        Assertions.assertEquals(50000, (int) priceCalculator.calculatePrice(TransportType.TRUCK, 10000));
    }

    @Test
    public void shouldBeNullWhenDron() {
        Assertions.assertNull(priceCalculator.calculatePrice(TransportType.DRONE, 0));
    }
}
