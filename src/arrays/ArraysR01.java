package arrays;

public class ArraysR01 {

    public static void main(String[] args) {
        //배열의 평균값 구하기 https://school.programmers.co.kr/learn/courses/30/lessons/120817
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(solution(arr));

    }

    private static double solution(int[] numbers) {
        double answer = 0;
        double sum = 0;
        for (int i : numbers) {
            sum += i;
        }
        answer = sum / numbers.length;
        return answer;
        //다른이의 답안 : return Arrays.stream(numbers).average().orElse(0);

    }

}
