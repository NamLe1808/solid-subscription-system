package SOLID_OOP_1;

public class MomoPayment implements PaymentMethod{
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán bằng Momo: " + amount);
    }
}
