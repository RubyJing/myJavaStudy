package designpatterns.建造者模式;

import java.util.*;

/**
 * 点单
 * @Author RubyJing
 * @Date 2020/1/17 9:14
 * @Version 1.0
 */
public class Meal {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item){
        items.add(item);
    }

    public void addItems(List<Item> items){
        if (items!=null && items.size()!=0){
            items.remove(null);
            this.items.addAll(items);
        }
    }

    public boolean removeItem(Item item){
        Objects.requireNonNull(item);
        boolean removed = false;
        final Iterator<Item> each = this.items.iterator();
        while (each.hasNext()){
            if (each.next().name().equals(item.name())){
                each.remove();
                removed = true;
                break;
            }
        }
        return removed;
    }

    public float getCost(){
        float cost = 0.0f;
        for (Item item : items) {
           cost += item.price();
        }
        return cost;
    }

    public void showItems(){
        for (Item item : items) {
            System.out.print("Item: " + item.name());
            System.out.print(", Packing : " + item.packing().packing());
            System.out.println(", Price : " + item.price());
        }
    }

    public List<Item> getItems(){
        return this.items;
    }
}
