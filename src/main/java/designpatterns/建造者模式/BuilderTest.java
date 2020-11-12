package designpatterns.建造者模式;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/11 17:13
 */
public class BuilderTest {

    public static void main(String[] args) {
//        ResourcePoolConfig resourcePoolConfig = new
//                ResourcePoolConfig.ResourcePoolConfigBuilder()
//                .maxIdle(8)
//                .minIdle(10)
//                .name("厕所")
//                .build();

        ResourcePoolConfig resourcePoolConfig2 =
                ResourcePoolConfig.builder()
                .maxIdle(8)
                .minIdle(5)
                .name("厕所")
                .build();
        System.out.println(resourcePoolConfig2.toString());

    }
}
