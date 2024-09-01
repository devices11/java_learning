package cinema;

import java.util.List;

public class Calculator {

    private Calculator() {}

    public static double calculate(List<MediaItem> mediaItems) {
        // Напишите реализацию метода, который будет возвращать общее количество дней,
        // потраченных на просмотр фильмов и сериалов
        double sum = 0;
        for (MediaItem mediaItem : mediaItems) {
            if (mediaItem instanceof Movie) {
                Movie movie = (Movie) mediaItem;
                sum += movie.getRuntime();
            }

            if (mediaItem instanceof Series) {
                Series series = (Series) mediaItem;
                sum += series.getRuntime() * series.getSeriesCount();
            }
        }
        return sum;
    }
}