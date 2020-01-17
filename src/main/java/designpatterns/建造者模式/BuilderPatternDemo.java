package designpatterns.建造者模式;

/**
 * 演示demo
 * @Author RubyJing
 * @Date 2020/1/17 9:25
 * @Version 1.0
 */
public class BuilderPatternDemo {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: "+ vegMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVegMean();
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: "+nonVegMeal.getCost());

        Meal allMeal = new Meal();
        allMeal.addItems(vegMeal.getItems());
        allMeal.addItems(nonVegMeal.getItems());
        allMeal.addItem(new Coke());
        allMeal.addItem(new Pepsi());
        allMeal.removeItem(new Pepsi());
        System.out.println("\n\nAll Meal");
        allMeal.showItems();
        System.out.println("Total Cost: "+allMeal.getCost());
    }
}
