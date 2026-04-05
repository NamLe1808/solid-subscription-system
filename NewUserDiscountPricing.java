package SOLID_OOP_1;

public class NewUserDiscountPricing implements PricingStrategy{
    @Override
    public double calculate(Subscription sub) {
        return sub.getPlan().getPrice() + (sub.getPlan().getPrice() * 0.2);
    }
}
