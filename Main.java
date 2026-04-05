package SOLID_OOP_1;

public class Main {
    public static void main(String[] args) {

        // ===== 1. Repository =====
        PlanRepository planRepo = new MemoryPlanRepository();
        SubscriptionRepository subRepo = new MemorySubscriptionRepository();

        // ===== 2. Users =====
        User user1 = new User(1, "Nam", "nam@gmail.com");
        User user2 = new User(2, "An", "an@gmail.com");

        // ===== 3. Hiển thị danh sách plan =====
        System.out.println("===== DANH SÁCH GÓI =====");
        for (SubscriptionPlan p : planRepo.findAll()) {
            System.out.println(p);
        }

        // =====================================================
        // CASE 1: User thường - giá bình thường - thanh toán Momo - Email
        // =====================================================
        System.out.println("\n===== CASE 1: NORMAL USER =====");

        PricingStrategy pricing1 = new NormalPricing();
        PaymentMethod payment1 = new MomoPayment();
        NotificationService noti1 = new EmailNotification();

        SubscriptionService service1 = new SubscriptionService(
                planRepo, pricing1, payment1, noti1, subRepo
        );

        service1.checkout(1, user1);


        // =====================================================
        // CASE 2: User mới - giảm giá - Credit Card - SMS
        // =====================================================
        System.out.println("\n===== CASE 2: NEW USER DISCOUNT =====");

        PricingStrategy pricing2 = new NewUserDiscountPricing();
        PaymentMethod payment2 = new CreditCardPayment();
        NotificationService noti2 = new SMSNotification();

        SubscriptionService service2 = new SubscriptionService(
                planRepo, pricing2, payment2, noti2, subRepo
        );

        service2.checkout(2, user2);


        // =====================================================
        // CASE 3: User lâu năm - giảm giá dài hạn - Momo - Email
        // =====================================================
        System.out.println("\n===== CASE 3: LONG TERM USER =====");

        PricingStrategy pricing3 = new LongTermDiscountPricing();
        PaymentMethod payment3 = new MomoPayment();
        NotificationService noti3 = new EmailNotification();

        SubscriptionService service3 = new SubscriptionService(
                planRepo, pricing3, payment3, noti3, subRepo
        );

        service3.checkout(3, user1);


        // =====================================================
        // CASE 4: Test thay đổi hành vi runtime (DI đúng nghĩa)
        // =====================================================
        System.out.println("\n===== CASE 4: CHANGE BEHAVIOR RUNTIME =====");

        SubscriptionService dynamicService = new SubscriptionService(
                planRepo,
                new NormalPricing(),
                new MomoPayment(),
                new EmailNotification(),
                subRepo
        );

        // chạy lần 1
        dynamicService.checkout(1, user1);

        // đổi strategy (không sửa class)
        dynamicService = new SubscriptionService(
                planRepo,
                new NewUserDiscountPricing(),
                new CreditCardPayment(),
                new SMSNotification(),
                subRepo
        );

        // chạy lần 2
        dynamicService.checkout(1, user1);


        // =====================================================
        // CASE 5: Test nhiều lần mua (lưu nhiều subscription)
        // =====================================================
        System.out.println("\n===== CASE 5: MULTIPLE SUBSCRIPTIONS =====");

        SubscriptionService service5 = new SubscriptionService(
                planRepo,
                new NormalPricing(),
                new MomoPayment(),
                new EmailNotification(),
                subRepo
        );

        service5.checkout(1, user1);
        service5.checkout(2, user1);
        service5.checkout(3, user2);


        // =====================================================
        // CASE 6: Hiển thị tất cả subscription đã lưu
        // =====================================================
        System.out.println("\n===== DANH SÁCH SUBSCRIPTIONS =====");

        for (Subscription s : subRepo.findAll()) {
            System.out.println(s);
        }
    }

}
