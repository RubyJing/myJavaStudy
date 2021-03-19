package arithmetic;

import java.util.*;

/**
 * 数组类型相关的算法题目
 *
 * @author RubyJing
 */
public class ArrayTitle {
    public static void main(String[] args) {
        System.out.println(findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }

    /**
     * 剑指 Offer 03. 数组中重复的数字
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
     * 请找出数组中任意一个重复的数字。
     *
     * 计数排序：时间空间一般，但是比用Set效率高
     *
     */
    public static int findRepeatNumber(int[] nums) {
        //计数排序
        int[] count = new int[100000];
        for(int num : nums){
            count[num]++;
        }
        int randomNum = -1;
        for(int i = 0; i < 100000 ; i++){
            if(count[i] > 1){
                randomNum = i;
                break;
            }
        }
        return randomNum;
    }


    /**
     * 剑指 Offer 03. 数组中重复的数字
     *
     * 原地置换法
     *
     * 如果没有重复数字，那么正常排序后，数字i应该在下标为i的位置，
     * 所以思路是重头扫描数组，遇到下标为i的数字如果不是i的话，
     * （假设为m),那么我们就拿与下标m的数字交换。
     * 在交换过程中，如果有重复的数字发生，那么终止返回true
     *
     * 执行速度快，空间一般
     *
     */
    public static int findRepeatNumber2(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i){
                if (nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    /**
     * 剑指 Offer 03. 数组中重复的数字
     * 利用Set不可以重复原则：性能一般，空间和时间普通
     */
    public static int findRepeatNumberOfficial(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            if (!numSet.add(num)) {
                return num;
            }
        }
        return -1;
    }

    /**
     * 1122.数组的相对排序
     * 给你两个数组，arr1 和 arr2，
     * <p>
     * arr2 中的元素各不相同
     * arr2 中的每个元素都出现在 arr1 中
     * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
     * <p>
     * 示例：
     * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
     * 输出：[2,2,2,1,4,3,3,9,6,7,19]
     * <p>
     * 提示：
     * 1 <= arr1.length, arr2.length <= 1000
     * 0 <= arr1[i], arr2[i] <= 1000
     * <p>
     * 执行用时：3ms ;内存消耗36.9MB。-> 执行慢，内存消耗少
     */
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int length = arr1.length;
        int[] notInArr2 = new int[length];
        int[] inArr2 = new int[length];
        int notSize = 0;
        int inSize = 0;

        //先将arr1排好序
        TenSort.insertionSort(arr1);

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] == arr2[i]) {
                    inArr2[inSize++] = arr1[j];
                    arr1[j] = -1;
                }
            }
        }

        for (int arr : arr1) {
            if (arr != -1) {
                notInArr2[notSize++] = arr;
            }
        }

        //去除多余的空白
        notInArr2 = Arrays.copyOfRange(notInArr2, 0, notSize);

        for (int value : notInArr2) {
            inArr2[inSize++] = value;
        }

        inArr2 = Arrays.copyOfRange(inArr2, 0, inSize);

        return inArr2;
    }

    /**
     * 1122.数组的相对排序
     * 使用计数排序解决
     * 执行用时:0 ms;内存消耗:38.3MB。 ->执行快，内存消耗还可以
     */
    public static int[] relativeSortArray2(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        //将arr1中的数记录下来
        for (int num1 : arr1) {
            count[num1]++;
        }
        //先安排arr2中的数
        int i = 0;
        for (int num2 : arr2) {
            while (count[num2] > 0) {
                arr1[i++] = num2;
                count[num2]--;
            }
        }
        //再安排剩下的数字
        for (int j = 0; j < count.length; j++) {
            while (count[j] > 0) {
                arr1[i++] = j;
                count[j]--;
            }
        }
        return arr1;
    }

    /**
     * 26. 删除排序数组中的重复项 -- 双指针法(速度快，空间差）
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    /**
     * 485. 最大连续1的个数 -- 我的思路：时间好,空间不行
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                max = Math.max(count, max);
                count = 0;
            }
        }
        return Math.max(count, max);
    }

    /**
     * 1086.复写零 --执行时间短
     */
    public static void duplicateZeros2(int[] arr) {
        int i;
        int count = 0;
        for (i = 0; i < arr.length; i++) {
            count++;
            if (arr[i] == 0) {
                count++;
            }
            if (count >= arr.length) {
                break;
            }
        }
        for (int j = arr.length - 1; j >= 0; j--) {
            if (arr[i] != 0) {
                arr[j] = arr[i];
            } else if (arr[i] == 0 && count > arr.length && j == arr.length - 1) {
                //防止最后一个是0的情况,多出的0不复制
                arr[j] = arr[i];
            } else {
                arr[j] = arr[i];
                arr[j - 1] = arr[i];
                j--;
            }
            i--;
        }
    }

    /**
     * 1086.复写零 --思路好，效率一般
     */
    public static void duplicateZeros(int[] arr) {
        ArrayList<Integer> arrList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            arrList.add(arr[i]);
            if (arr[i] == 0) {
                arrList.add(0);
            }
            arr[i] = arrList.get(i);
        }
    }

    /**
     * 771. 宝石与石头 --思路好，但是效率不好
     */
    public int numJewelsInStones2(String J, String S) {
        String a = "[^" + J + "]";
        S = S.replaceAll(a, "");
        return S.length();
    }

    /**
     * 771. 宝石与石头 --我的思路:时间好，空间差
     */
    public int numJewelsInStones(String J, String S) {
        char[] aa = J.toCharArray();
        char[] bb = S.toCharArray();
        int sum = 0;
        for (int i = 0; i < bb.length; i++) {
            for (int j = 0; j < aa.length; j++) {
                if (aa[j] == bb[i]) {
                    sum++;
                }
            }
        }
        return sum;
    }

    /**
     * 1281题：整数的各位积和之差 --优秀答案
     */
    public static int subtractProductAndSum2(int n) {
        int muti = 1;
        int sum = 0;
        while (n != 0) {
            muti *= n % 10;
            sum += n % 10;
            n /= 10;
        }
        return muti - sum;
    }

    /**
     * 1281题：整数的各位积和之差 --我的思路
     * -
     */
    public static int subtractProductAndSum(int n) {
        //分析出各个位置
        int length = String.valueOf(n).length();
        if (length <= 1) {
            return 0;
        }
        int[] nums = new int[length];
        //个位
        int num = n % 10;
        int mod = 100;
        int division = 10;
        for (int i = 0; i < length; i++) {
            nums[i] = num;
            num = n % mod / division;
            division *= 10;
            mod *= 10;
        }
        //计算
        int product = nums[0];
        int sum = nums[0];
        for (int j = 1; j < nums.length; j++) {
            product *= nums[j];
            sum += nums[j];
        }
        return product - sum;

    }

    /**
     * 两数之和(暴力法）
     * 时间复杂度为 O(n^2)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] sumTwoNum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    System.out.println(i + "" + j);
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("不存在这两个数");
    }

    /**
     * 两数之和（两遍哈希表）
     * 时间复杂度为 O(n)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] sumTwoNum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                System.out.println(i + "" + map.get(complement));
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("不存在这两个数!");
    }

    /**
     * 两数之和（一遍哈希表）
     * * 时间复杂度为 O(n)
     * * 空间复杂度：O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] sumTwoNum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                System.out.println(map.get(complement) + "" + i);
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("不存在这两个数!");
    }

    /**
     * 通过递归反转字符串
     *
     * @param str
     * @return
     */
    public static String reverseString(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        } else {
            return reverseString(str.substring(1)) + str.charAt(0);
        }
    }


    /**
     * 只出现一次的数字--我的初版（垃圾，只超过8.8%的人)
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int singleNumber = 0;
        //算出给map容量
        int mapCount = (int) (nums.length / 0.75 + 1);
        //将出现次数存入
        Map<String, String> countMap = new HashMap<>(mapCount);
        for (int num : nums) {
            if (!countMap.containsKey(String.valueOf(num))) {
                countMap.put(String.valueOf(num), "1");
            } else {
                int value = Integer.parseInt(countMap.get(String.valueOf(num))) + 1;
                countMap.put(String.valueOf(num), String.valueOf(value));
            }
        }
        //解析只出现一次的数字
        if (countMap.containsValue("1")) {
            int numPort = 0;
            Set<String> keySet = countMap.keySet();
            Iterator<String> it = keySet.iterator();
            while (it.hasNext()) {
                String key = it.next();
                Object value = countMap.get(key);
                if (value.equals("1")) {
                    singleNumber = Integer.parseInt(key);
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
     *
     * @param nums
     * @return
     */
    public static int singleNumber2(int[] nums) {
        Map<Integer, String> numMap = new HashMap<>();
        for (int num : nums) {
            if (numMap.containsKey(num)) {
                numMap.remove(num);
            } else {
                numMap.put(num, "");
            }
        }
        return numMap.keySet().iterator().next();
    }

    /**
     * 只出现一次的数字--使用异或(优化了执行时间)
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.85%的用户
     * 内存消耗 :42.8 MB, 在所有 Java 提交中击败了29.67%的用户
     *
     * @param nums
     * @return
     */
    public static int singleNumber3(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }

    /**
     * 只出现一次的数字2--使用分治异或
     * 执行用时 :2 ms, 在所有 Java 提交中击败了95.10%的用户
     * 内存消耗 :40.4 MB, 在所有 Java 提交中击败了38.81%的用户
     *
     * @param nums
     * @return
     */
    public static int[] singleNumberTwo(int[] nums) {
        int[] resultNum = new int[2];
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        //取得最右边为1的数
        int remake = result & (-result);
        for (int num : nums) {
            //== 0、 == mask 两种结果
            if ((num & remake) == 0) {
                resultNum[0] ^= num;
            } else {
                resultNum[1] ^= num;
            }
        }
        return resultNum;
    }

}
