package SOLID_OOP_1;

public class NormalPricing implements PricingStrategy{
    @Override
    public double calculate(Subscription sub) {
        return sub.getPlan().getPrice();
    }
}
