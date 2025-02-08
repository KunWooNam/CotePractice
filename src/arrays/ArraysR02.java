package arrays;

import java.util.Arrays;

public class ArraysR02 {

    public static void main(String[] args) {
        //배열 뒤집기 https://school.programmers.co.kr/learn/courses/30/lessons/120821
        int[] num_list = {10, 20, 30, 40, 50};
        System.out.println(Arrays.toString(solution(num_list)));
    }

    private static int[] solution(int[] num_list) {

        int[] answer = new int[num_list.length];
        for(int i=0; i<num_list.length; i++){
            int maxIndex = num_list.length-1;
            if(maxIndex != 0 ){ // for문의 마지막에서 index범위 에러가 발생하기 때문에 else로 예외처리를 해줘야한다. 음수값의 인덱스를 참조하게된다.
                answer[i] = num_list[maxIndex - i];
            } else {
                answer[i] = num_list[0];
            }
        }
        return answer;

        //기타 답안 :  List<Integer> list = Arrays.stream(numList).boxed().collect(Collectors.toList());
        // Collections.reverse(list);
        // return list.stream().mapToInt(Integer::intValue).toArray();

        //기타 답안 2 : return LongStream.range(1, num_list.length + 1 ).mapToInt(i -> num_list[(int) (num_list.length - i)]).toArray();
        // LongStream.range(1, num_list.length + 1 ) : start부터 end-1까지의 long 타입 숫자를 생성하는 스트림을 만듦.
        // .mapToInt(i -> num_list[(int) (num_list.length - i]) : num_list.length가 5인 경우 num_list[4] → 50, 반환된값은 toArray()에 의해 0번인덱스에 대입됨.
    }
}
