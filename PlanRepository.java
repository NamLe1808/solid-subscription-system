package SOLID_OOP_1;

import java.util.List;

public interface PlanRepository {
    List<SubscriptionPlan> findAll();
    SubscriptionPlan findById(int id);
}
