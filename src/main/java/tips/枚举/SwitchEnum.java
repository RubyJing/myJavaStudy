package tips.枚举;

/**
 * 使用switch
 * @Author RubyJing
 * @Date 2019/11/13 10:44
 * @Version 1.0
 */
enum WeekDay{
    /** 日子 **/
    DAY,
    /** 周一 **/
    MONDAY,

    /** 周二 **/
    TUESDAY,

    /** 周三 **/
    WEDNESDAY,

    /** 周四 **/
    THURDARY,

    /** 周五 **/
    FRIDAY,

    /** 周六 **/
    SATURDAY,

    /** 周日 **/
    SUNDAY
}

public class SwitchEnum {
    WeekDay day = WeekDay.DAY;
    private void everyDayDo(){
        switch (day){
            case MONDAY:
                day = WeekDay.MONDAY;
                break;
            case TUESDAY:
                day = WeekDay.TUESDAY;
                break;
            case WEDNESDAY:
                day = WeekDay.WEDNESDAY;
                default:
        }
    }
}
