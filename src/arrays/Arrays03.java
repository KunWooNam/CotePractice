package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Arrays03 {

    public static void main(String[] args) {
        //two random number sum arrays
        //array size : above 2 and below 100, range above 0 and below 100
        //time complexcity : O(N^2log(N2)))

        int[] arr = {2, 1, 3, 4, 1};
        int[] result = solution(arr);
        System.out.println(Arrays.toString(result));
    }

    //
    private static int[] solution(int[] arr){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                Integer sum = arr[i] * arr[j];
                System.out.println(i + ", j:" + j);
                System.out.println("sum = " + sum);
                set.add(sum);
            }
        }
        //Stream.sorted() 메서드는 O(k log k)의 시간복잡도
        return set.stream().sorted().mapToInt(Integer::intValue).toArray(); //sorted()메서드는 N2logN2의 시간복잡도를 가짐
    }
}
