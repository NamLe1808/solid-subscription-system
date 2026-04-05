package SOLID_OOP_1;

public class CreditCardPayment implements PaymentMethod{
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán bằng CreditCard: " + amount);
    }
}
