package arithmetic;

import java.util.*;

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

        int[] sortArray = new int[]{4,1,2,1,2};

        System.out.println(singleNumber2(sortArray));

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

    /**
     * 冒泡排序
     * @param array
     * @return
     */
    public static int[] orderArray(int[] array){
        for (int i=0;i<array.length;i++){
            for (int j=0;j<array.length;j++){
                if(array[i]>array[j]){
                    int s = array[i];
                    array[i] = array[j];
                    array[j] = s;
                }
            }
        }
        return array;
    }

    /**
     * 只出现一次的数字--我的初版（垃圾，只超过8.8%的人)
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums){
        int singleNumber=0;
        //算出给map容量
        int mapCount = (int) (nums.length/0.75+1);
        //将出现次数存入
        Map<String,String> countMap = new HashMap<>(mapCount);
        for(int num:nums){
            if(!countMap.containsKey(String.valueOf(num))){
                countMap.put(String.valueOf(num),"1");
            }else {
                int value = Integer.parseInt(countMap.get(String.valueOf(num)))+1;
                countMap.put(String.valueOf(num),String.valueOf(value));
            }
        }
        //解析只出现一次的数字
        if(countMap.containsValue("1")){
            int numPort = 0;
            Set<String> keySet = countMap.keySet();
            Iterator<String> it = keySet.iterator();
            while(it.hasNext()){
                String key = it.next();
                Object value = countMap.get(key);
                if(value.equals("1")){
                    singleNumber=Integer.parseInt(key);
                    break;
                }
            }
        }
        return singleNumber;
    }

    /**
     * 只出现一次的数字--改良版(还是垃圾)
     * 执行用时 :21 ms, 在所有 Java 提交中击败了21.73%的用户
     * 内存消耗 :45.8 MB, 在所有 Java 提交中击败了5.05%的用户
     * @param nums
     * @return
     */
    public static int singleNumber2(int[] nums){
        Map<Integer,String> numMap = new HashMap<>();
        for(int num:nums){
          if(numMap.containsKey(num)){
              numMap.remove(num);
          }else {
              numMap.put(num,"");
          }
        }
        return numMap.keySet().iterator().next();
    }

    /**
     * 只出现一次的数字--使用异或(优化了执行时间)
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.85%的用户
     * 内存消耗 :42.8 MB, 在所有 Java 提交中击败了29.67%的用户
     * @param nums
     * @return
     */
    public static int singleNumber3(int[] nums){
        int result = 0;
        for (int num : nums) {
            result = result^num;
        }
        return result;
    }

    /**
     * 只出现一次的数字2--使用分治异或
     * 执行用时 :2 ms, 在所有 Java 提交中击败了95.10%的用户
     * 内存消耗 :40.4 MB, 在所有 Java 提交中击败了38.81%的用户
     * @param nums
     * @return
     */
    public static int[] singleNumberTwo(int[] nums){
        int[] resultNum = new int[2];
        int result = 0;
        for (int num:nums){
            result ^=num;
        }
        //取得最右边为1的数
        int remake = result&(-result);
        for (int num:nums){
            //== 0、 == mask 两种结果
            if((num&remake)==0){
                resultNum[0] ^= num;
            }else {
                resultNum[1] ^= num;
            }
        }
        return resultNum;
    }

}
