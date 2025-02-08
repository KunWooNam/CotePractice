package arrays;

import java.util.*;

public class ArraysR04 {

    public static void main(String[] args) {
        //나누어 떨어지는 숫자 배열 https://school.programmers.co.kr/learn/courses/30/lessons/12910
        int[] arr = {5, 9, 7, 10};
        int divisor = 5;
        System.out.println(Arrays.toString(solution(arr, divisor)));

    }

    //나의 풀이
    public static int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int num : arr){
            if(num % divisor == 0){
                list.add(num);
            }
        }
        if(list.size() == 0){ //list.isEmpty()를 쓰자.
            list.add(-1);
        }

        list.sort(Comparator.naturalOrder());
        int[] answer = new int[list.size()];
        if(list.contains(-1)){
            answer = list.stream().distinct().mapToInt(Integer::intValue).toArray();
        } else {
            answer = list.stream().mapToInt(Integer::intValue).toArray();
        }
        return answer;
    }

    //다른사람의 풀이
    public int[] solution2(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr).filter(factor -> factor % divisor == 0).toArray();
        if(answer.length == 0) answer = new int[] {-1};
        java.util.Arrays.sort(answer);
        return answer;
    }
}
