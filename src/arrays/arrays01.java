package arrays;

import java.util.Arrays;

public class arrays01 {

    public static void main(String[] args) {
        //Arrays sort
        // input range : -100,000 ~ 100,000

        int [] arr = {20, -1, 5, 7, 10, 4};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
