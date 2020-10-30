package functionalModule.alert;

/**
 * 告警规则，可以自由配置
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/10/30 9:52
 */
public class AlertRule {

    public Rule getMarchedRule(String api) {
        switch (api) {
            case "api1":
                return new Rule(100, 5);
            default:
                return null;
        }
    }

    protected class Rule {
        private long maxTps;
        private long maxErrorCount;

        public Rule(long maxTps, long maxErrorCount) {
            this.maxTps = maxTps;
            this.maxErrorCount = maxErrorCount;
        }

        public long getMaxTps() {
            return maxTps;
        }

        public long getMaxErrorCount() {
            return maxErrorCount;
        }
    }
}
