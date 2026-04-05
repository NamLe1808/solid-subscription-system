package SOLID_OOP_1;
import java.util.List;
import java.util.ArrayList;
public class MemoryPlanRepository implements PlanRepository{
    private List<SubscriptionPlan> plans = new ArrayList<>();

    public MemoryPlanRepository() {
        // dữ liệu có sẵn (giống DB)
        plans.add(new SubscriptionPlan(1, "BASIC", 100));
        plans.add(new SubscriptionPlan(2, "PREMIUM", 200));
        plans.add(new SubscriptionPlan(3, "VIP", 300));
    }

    @Override
    public List<SubscriptionPlan> findAll() {
        return plans;
    }

    @Override
    public SubscriptionPlan findById(int id) {
        for (SubscriptionPlan p : plans) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
