package arrays;

import java.util.Arrays;

public class arrays05 {

    public static void main(String[] args) {
        //행렬의 곱셈 O(N^3)

        int[][] arr1 = {
                {1, 4, 4},
                {3, 2, 5},
                {4, 1, 7}
        };
        int[][] arr2 = {
                {3, 3, 3},
                {3, 3, 3},
                {3, 3, 3}
        };

        int[][] result = solution(arr1, arr2);
        System.out.println(Arrays.toString(result[0]));
    }

    private static int[][] solution(int[][] arr1, int[][] arr2){
        int r1 = arr1.length;
        int c1 = arr1[0].length;
        int r2 = arr2.length;
        int c2 = arr2[0].length;

        int[][] result =new int[r1][c2];
        for(int i=0; i<r1; i++){
            for(int j=0; j<c2; j++){
                for(int k=0; k<c1; k++){
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return result;
    }
}
