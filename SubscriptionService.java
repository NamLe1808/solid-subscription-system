package SOLID_OOP_1;

public class SubscriptionService {
    private PlanRepository plan;
    private PricingStrategy price;
    private PaymentMethod payment;
    private NotificationService noti;
    private SubscriptionRepository subR;

    public SubscriptionService(PlanRepository plan,
                               PricingStrategy price,
                               PaymentMethod payment,
                               NotificationService noti,
                               SubscriptionRepository subR) {
        this.plan = plan;
        this.price = price;
        this.payment = payment;
        this.noti = noti;
        this.subR = subR;
    }

    public void checkout(int planId, User user) {

        // 1. lấy plan
        SubscriptionPlan selectedPlan = plan.findById(planId);

        // 2. tạo subscription
        Subscription sub = new Subscription(1, user, selectedPlan);

        // 3. tính tiền
        double total = price.calculate(sub);

        // 4. thanh toán
        payment.pay(total);

        // 5. gửi thông báo
        noti.send("Thanh toán thành công: " + total);

        // 6. lưu
        subR.save(sub);
    }
}
