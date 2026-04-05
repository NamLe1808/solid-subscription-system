package SOLID_OOP_1;

public class SMSNotification implements NotificationService{
    @Override
    public void send(String message) {
        System.out.println("Gửi SMS thành công: " + message);
    }
}
