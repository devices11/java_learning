package virtualATS;

// допишите реализацию класса Smartphone
public class Smartphone extends MobilePhone{

    public Smartphone(String number) {
        super(number);
    }

    public final void makeCall(String targetNumber, String appName) {
        System.out.println("Звоним с номера " + getNumber());
        System.out.println("Позвоним через приложение " + appName + " по номеру " + targetNumber );
        System.out.println("Привет!");
    }

    // объявите метод sendEmail()
        public void sendEmail(String email, String messageText) {
        System.out.println("Напишем другу сообщение " + messageText + " по email " + email);
    }

}