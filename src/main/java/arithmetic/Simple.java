package arithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单难度的算法
 * @author RubyJing
 */
public class Simple {
    public static void main(String[] args) {
//        sumTwoNum(new int[]{1,2,3,4,5},5);
//        sumTwoNum2(new int[]{1,2,3,4,5},5);
//        sumTwoNum3(new int[]{1,2,3,4,5},5);

//        String num = reverseString("abcdefg");
//        System.out.println(num);


    }

    /**
     * 两数之和(暴力法）
     * 时间复杂度为 O(n^2)
     * 空间复杂度：O(1)
     * @param nums
     * @param target
     * @return
     */
    public static int[] sumTwoNum(int[] nums,int target){
        for (int i=0;i<nums.length;i++){
            for (int j=1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    System.out.println(i+""+j);
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("不存在这两个数");
    }

    /**
     * 两数之和（两遍哈希表）
     * 时间复杂度为 O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] sumTwoNum2(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for (int i=0;i<nums.length;i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)&&map.get(complement)!=i){
                System.out.println(i+""+map.get(complement));
                return new int[]{i,map.get(complement)};
            }
        }
        throw new IllegalArgumentException("不存在这两个数!");
    }

    /**
     * 两数之和（一遍哈希表）
     *  * 时间复杂度为 O(n)
     *  * 空间复杂度：O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] sumTwoNum3(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i=0;i<nums.length;i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                System.out.println(map.get(complement)+""+i);
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("不存在这两个数!");
    }

    /**
     * 通过递归反转字符串
     * @param str
     * @return
     */
    public static String reverseString(String str) {
        if(str==null || str.length()<=1){
            return str;
        }else {
            return reverseString(str.substring(1))+str.charAt(0);
        }
    }




}
