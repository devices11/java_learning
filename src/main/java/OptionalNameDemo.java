import java.util.Optional;

public class OptionalNameDemo {

    static Optional<String> requestUserName() {
        //Здесь должен быть запрос к пользователю, но пока его не реализовали
        //Поместите в переменную username имя пользователя или оставьте ее пустой, если имя скрыто
        String username = "d";

        if (username.isBlank()) {
            return Optional.empty();
        } else {
            return Optional.of(username);
        }
    }

    public static void main(String[] args) {
        Optional<String> maybeName = requestUserName();
        if (maybeName.isPresent()) {
            //вставьте код здесь
            System.out.println("Привет, " + maybeName.get() + "!");
        } else {
            System.out.println("Ваше право не называть имя!");
        }
    }
}