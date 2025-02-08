package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

public class ArraysR03 {

    public static void main(String[] args) {
        // N^2 배열 자르기 https://school.programmers.co.kr/learn/courses/30/lessons/87390
        int n = 4;
        long left = 7, right = 14;
        System.out.println(Arrays.toString(solution(n, left, right)));
    }

    //내 풀이 - (혼자못풀었음)
    public static int[] solution(int n, long left, long right) {
        int len = ((int)right - (int)left) + 1;
        int[] answer = new int[len];
        int idx = 0;
        for(long i = left; i <= right; i++){
            long row = i / n + 1; // n=5, i+1 하는 경우 i가 20인경우 해는 4가된다. 그러나 실제로 20~24인덱스의 값들은 5번째 행에 존재한다. 규칙상 5번째행에 존재하는 경우 6이 있어야한다.
            long col = i % n + 1; //n=5, i+1 경우 i가 19이면 나머지가 0이된다. 인덱스 19번의 경우 행은 실제로 5번째 행이므로 오류가 발생한다.
            answer[idx++] = (int)Math.max(row,col);
        }
        return answer;
    }

    //다른풀이
    public static int[] solution2(int n, long left, long right) {
        return LongStream.rangeClosed(left, right).mapToInt(value -> (int) (Math.max(value / n, value % n) + 1)).toArray();
    }

    public static List<Long> solution3(int n, long left, long right) {

        List<Long> list = new ArrayList<>();

        for(long i=left;i<right+1;i++){
            list.add(Math.max(i/n,i%n) + 1);
        }

        return list;
    }
}
