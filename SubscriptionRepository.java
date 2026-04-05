package SOLID_OOP_1;
import java.util.List;
public interface SubscriptionRepository {
    void save(Subscription sub);
    List<Subscription> findAll();
}
