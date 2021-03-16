package arithmetic;

/**
 * 额外练习
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/4 11:42
 */
public class ExtraTest {

    public static void main(String[] args) {
        ExtraTest extraTest = new ExtraTest();
//        extraTest.normalFindIncreaseArraysGreaterOrEqualToFirst();
//        extraTest.nullParamsFindIncreaseArraysGreaterOrEqualToFirst();
        System.out.println(extraTest.isPalindromeString("abaddddaba"));
    }

    /**
     * 判断是否回文字符串
     *
     * @param word 字符串
     * @return true 是，false 不是
     */
    protected boolean isPalindromeString(String word) {
        if (word.length() <= 1) {
            return false;
        }
        int length = word.length();
        int mid = length / 2;
        for (int i = 0, j = length - 1; i < mid; i++,j--) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 写一个二分查找的变体算法，查找递增数组中第一个大于等于某个给定值的元素
     *
     * @param arrays 递增数组
     * @param num    给定元素
     * @return 第一个大于等于某个给定值的元素。不存在返回-1
     */
    protected int findIncreaseArraysGreaterOrEqualToFirst(int[] arrays, int num) {
        int index = -1;
        if (arrays == null || arrays.length == 0) {
            return index;
        }

        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] >= num) {
                index = i;
                break;
            }
        }

        return index;
    }

    //单元测试

    /**
     * 正常传参 运行
     */
    protected void normalFindIncreaseArraysGreaterOrEqualToFirst() {
        System.out.println("normal-1:" + findIncreaseArraysGreaterOrEqualToFirst(new int[]{0, 1, 2, 3, 4, 5, 6, 7}, 10));
        System.out.println("normal-2:" + findIncreaseArraysGreaterOrEqualToFirst(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 10}, 10));
        System.out.println("normal-3:" + findIncreaseArraysGreaterOrEqualToFirst(new int[]{0, 1, 2, 3, 4, 10, 6, 7, 10}, 10));
    }

    /**
     * 参数传空 运行
     */
    protected void nullParamsFindIncreaseArraysGreaterOrEqualToFirst() {
        System.out.println("nullParams-1:" + findIncreaseArraysGreaterOrEqualToFirst(new int[]{}, 10));
        System.out.println("nullParams-2:" + findIncreaseArraysGreaterOrEqualToFirst(null, 10));
        System.out.println("nullParams-3:" + findIncreaseArraysGreaterOrEqualToFirst(null, 0));
    }
}
