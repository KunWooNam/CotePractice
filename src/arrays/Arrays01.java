package arrays;

import java.util.Arrays;

public class Arrays01 {

    public static void main(String[] args) {
        // Arrays sort
        // input range : -100,000 ~ 100,000
        // time complexity : O(N)

        Integer[] arr = {20, -1, 5, 7, 10, 4};
        Integer[] result = solution(arr);
        System.out.println("arr.toString() = " + Arrays.toString(result));
    }

    private static Integer[] solution(Integer[] arr){
        Integer[] result = arr.clone();
        Arrays.sort(result);
        return result;
    }
}
