package leTumbler;

class AirportDatabase {
    private static Airport vnukovo = new Airport(
            "Внуково",
            "Москва",
            "MOSCOW          ",
            "Europe/Moscow"
    );

    private static Airport pulkovo = new Airport(
            "Пулково",
            "Санкт-Петербург",
            "SAINT-PETERSBURG",
            "Europe/Moscow"
    );

    private static Airport vladivostok = new Airport(
            "Владивосток",
            "Владивосток",
            "VLADIVOSTOK     ",
            "Asia/Vladivostok"
    );

    private static Airport koltsovo = new Airport(
            "Кольцово",
            "Екатеринбург",
            "YEKATERINBURG   ",
            "Asia/Yekaterinburg"
    );

    public static Airport getAirportByCode(String airportCode) throws IllegalStateException {
        /* С помощью оператора switch case верните правильный аэропорт по его коду:
         * VKO - vnukovo
         * LED - pulkovo
         * SVX - koltsovo
         * VVO - vladivostok
         * Для неверного кода пробросьте исключение.
         */

        if (airportCode.equals("VKO")) {
            return vnukovo;
        } else if (airportCode.equals("LED")) {
            return pulkovo;
        } else if (airportCode.equals("SVX")) {
            return koltsovo;
        } else if (airportCode.equals("VVO")) {
            return vladivostok;
        } else {
            throw new IllegalStateException("Неизвестный код аэропорта: " + airportCode);
        }

    }
}
