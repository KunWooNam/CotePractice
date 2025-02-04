package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class arrays04 {

    public static void main(String[] args) {

        int[] answer = {2,2,2,2,3,3,3,3,3,3};
        System.out.println(Arrays.toString(solution(answer)));
    }

    private static int[] solution(int[] answer){
        int[][] pattern = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int[] highScorer = new int[pattern.length];
        for (int i = 0; i < answer.length ; i++) {
            for (int j = 0; j < pattern.length; j++) {
                if(answer[i] == pattern[j][i % pattern[j].length]){
                        highScorer[j]++;
                }
            }

        }
        int maxScore = Arrays.stream(highScorer).max().getAsInt();
        ArrayList<Integer> answers = new ArrayList<>();
        for (int i : highScorer) {
            if(maxScore == i){
                answers.add(i);
            }
        }
        return answers.stream().mapToInt(Integer::intValue).toArray();
    }
}
