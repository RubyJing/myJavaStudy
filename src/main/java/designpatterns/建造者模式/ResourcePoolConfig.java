package designpatterns.建造者模式;

/**
 * 使用建造者模式实现 资源池配置
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/11 16:07
 */
public class ResourcePoolConfig {

    private String name;
    private int maxTotal;
    private int maxIdle;
    private int minIdle;

    public ResourcePoolConfig(ResourcePoolConfigBuilder builder) {
        this.name = builder.name;
        this.maxTotal = builder.maxTotal;
        this.maxIdle = builder.maxIdle;
        this.minIdle = builder.minIdle;
    }

    public static ResourcePoolConfigBuilder builder(){
        return new ResourcePoolConfig.ResourcePoolConfigBuilder();
    }

    public String getName() {
        return name;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public int getMinIdle() {
        return minIdle;
    }

    @Override
    public String toString() {
        return "ResourcePoolConfig{" +
                "name='" + name + '\'' +
                ", maxTotal=" + maxTotal +
                ", maxIdle=" + maxIdle +
                ", minIdle=" + minIdle +
                '}';
    }

    public static class ResourcePoolConfigBuilder {
        private static final int DEFAULT_MAX_TOTAL = 8;
        private static final int DEFAULT_MAX_IDLE = 8;
        private static final int DEFAULT_MIN_IDLE = 0;

        private String name;
        private int maxTotal = DEFAULT_MAX_TOTAL;
        private int maxIdle = DEFAULT_MAX_IDLE;
        private int minIdle = DEFAULT_MIN_IDLE;

        public ResourcePoolConfigBuilder() {
        }

        public ResourcePoolConfig build() {
            // 校验逻辑放到这里来做，包括必填项校验、依赖关系校验、约束条件校验等
            if (name == null || name.isEmpty()){
                throw new IllegalArgumentException("...");
            }
            if (maxIdle > maxTotal){
                throw new IllegalArgumentException("...");
            }
            if (minIdle > maxTotal || minIdle > maxIdle){
                throw new IllegalArgumentException("...");
            }

            return new ResourcePoolConfig(this);
        }

        public ResourcePoolConfigBuilder name(String name){
            if (name == null || name.isEmpty()){
                throw new IllegalArgumentException();
            }
            this.name = name;
            return this;
        }

        public ResourcePoolConfigBuilder maxTotal(int maxTotal){
            if (maxTotal <= 0){
                throw new IllegalArgumentException("...");
            }
            this.maxTotal = maxTotal;
            return this;
        }


        public ResourcePoolConfigBuilder maxIdle(int maxIdle){
            if (maxIdle <= 0){
                throw new IllegalArgumentException("...");
            }
            this.maxIdle = maxIdle;
            return this;
        }

        public ResourcePoolConfigBuilder minIdle(int minIdle){
            if (minIdle <= 0){
                throw new IllegalArgumentException("...");
            }
            this.minIdle = minIdle;
            return this;
        }


    }


}
