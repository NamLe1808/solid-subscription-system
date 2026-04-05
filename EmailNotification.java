package SOLID_OOP_1;

public class EmailNotification implements NotificationService{
    @Override
    public void send(String message) {
        System.out.println("Gửi email thành công: " + message);
    }
}
