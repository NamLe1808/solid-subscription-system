package SOLID_OOP_1;

import java.util.ArrayList;
import java.util.List;

public class MemorySubscriptionRepository implements SubscriptionRepository{
    ArrayList<Subscription> list = new ArrayList<>();
    @Override
    public void save(Subscription sub) {
        list.add(sub);
        System.out.println("Add thành công");
    }
    @Override
    public List<Subscription> findAll() {
        return list;
    }
}
