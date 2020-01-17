package designpatterns.建造者模式;

/**
 * 点单建造者
 * @Author RubyJing
 * @Date 2020/1/17 9:21
 * @Version 1.0
 */
public class MealBuilder {

    /**
     * 准备 蔬菜汉堡+可口可乐套餐
     * @return
     */
    public Meal prepareVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    /**
     * 准备 鸡肉汉堡+百事可乐套餐
     * @return
     */
    public Meal prepareNonVegMean(){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }


}
