package virtualATS;

public class MobilePhone extends Phone{
    public MobilePhone(String number) {
        super(number);
    }

    //объявите метод sendSms()
        public void sendSms(String message, String targetNumber) {
        System.out.println("Отправляем сообщение " + message + " по номеру " + targetNumber);
    }
}