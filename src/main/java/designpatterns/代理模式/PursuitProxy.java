package designpatterns.代理模式;

/**
 * 追求代理类
 */
public class PursuitProxy implements GiveGift {
    Pursuit gg;

    public PursuitProxy(SchoolGirl mm) {
        this.gg = new Pursuit(mm);
    }

    @Override
    public void GiveDolls() {
        gg.GiveDolls();
        System.out.println("--然后，加了微信");
    }

    @Override
    public void GiveFlowers() {
        System.out.print("先抱住亲了一口,");
        gg.GiveFlowers();
    }

    @Override
    public void GiveChocolate() {
        System.out.print("是我自己亲手做的巧克力,");
        gg.GiveChocolate();
    }
}
