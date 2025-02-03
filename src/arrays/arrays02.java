package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class arrays02 {

    public static void main(String[] args) {
        // Arrays sort And Remove Duplication
        // input range : -100,000 ~ 100,000
        // time complexity : O(NlogN)

        int[] arr = {20, -1, 5, 7, 10, 4};
        int[] result = solution(arr);
        for (int i : result) {
            System.out.println("i = " + i);
        }
        System.out.println(arr[3]);

        int[] result2 = solution2(arr);
        for (int i : result2) {
            System.out.println("i = " + i);
        }
        System.out.println(arr[3]);
    }

    private static int[] solution(int[] arr){
        Integer[] result = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);
        Arrays.sort(result, Collections.reverseOrder());
        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }

    //Implementation with TreeSet
    private static int[] solution2(int[] arr){
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int num : arr) {
            set.add(num);
        }

        int[] result = new int[set.size()];
        for (int i = 0; i< result.length; i++){
            result[i] = set.pollFirst(); //컬렉션의 가장작은 수를 반환하고 컬렉션에서 삭제
        }
        return result;
    }
}
