package tips.对象克隆;

import java.io.Serializable;

/**
 * 汽车
 * @author RubyJing
 */
public class Car implements Serializable {
    /** 品牌*/
    private String brand;
    /** 最高时速 */
    private int maxSpeed;

    public Car(String brand, int maxSpeed) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
