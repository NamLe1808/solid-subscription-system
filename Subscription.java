package SOLID_OOP_1;

public class Subscription {
    private int id;
    private User user;
    private SubscriptionPlan plan;

    private String status;

    public Subscription(int id, User user, SubscriptionPlan plan) {
        this.id = id;
        this.user = user;
        this.plan = plan;
        this.status = "ACTIVE";
    }

    // Getter
    public User getUser() {
        return user;
    }

    public SubscriptionPlan getPlan() {
        return plan;
    }

    public String getStatus() {
        return status;
    }

    // Logic đơn giản (Entity được phép có)
    public void expire() {
        this.status = "EXPIRED";
    }

    public void activate() {
        this.status = "ACTIVE";
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "user=" + user +
                ", plan=" + plan +
                ", status='" + status + '\'' +
                '}';
    }
}
