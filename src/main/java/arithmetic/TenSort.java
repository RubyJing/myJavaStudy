package arithmetic;

/**
 * 十种排序方法
 * @Author RubyJing
 * @Date 2019/9/30 17:24
 * @Version 1.0
 */
public class TenSort {
    public static void main(String[] args) {

    }

    /**
     * 冒泡排序-->两两比对
     * 时间复杂度:O(n^2)
     * 空间复杂度：O(1)
     * 最好情况：O(n)
     * 排序方式:In-place
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
}
