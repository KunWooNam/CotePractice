package arrays;

import java.util.Arrays;
import java.util.HashMap;

public class arrays06 {

    public static void main(String[] args) {

        //실패율 O(M+NlogN)
        int N = 5;
        int[] stages = {2,1,2,6,2,4,3,3};
        int[] result = solution(N, stages);
        System.out.println(Arrays.toString(solution(N, stages)));
    }

    private static int[] solution(int N, int[] stages){
        // 1.스테이지 별 도전자 수를 구함 O(N+M) : 배열은 선언하고 지정하는 작업은 O(N)이다. 루프문의 시간 복잡도 O(M)
        int[] challenger = new int[N+2];
        for (int i = 0; i < stages.length; i++) {
            challenger[stages[i]] += 1;
        }

        //2.스테이지별 실패한 사용자 수 계산 O(1)
        HashMap<Integer, Double> fails = new HashMap<>();
        double total = stages.length;

        // 3.각 스테이지를 순회하며, 실패율 계산 O(N)
        for(int i = 1; i <= N; i++){
            if(challenger[i] == 0){ //4.도전자가 없는 경우, 실패율은 0
                fails.put(i, 0.);
            } else{
                fails.put(i, challenger[i] / total); // 5. 실패율 구함
                total -= challenger[i]; // 6. 다음 스테이지 실패율을 구하기 위해 현재 스테이지의 인원을 뺌
            }
        }

        //7 . 실패율이 높은 스티이지부터 내림차순으로 정렬 O(2*N + M + NlogN)
        // : stream생성은 O(1)
        // , 스트림 정렬연산은 보통 O(NlogN)->(entrySet()을 통해 가져오는 요소의 개수를 N이라고 하면, sorted() 연산은 O(N log N) )
        // , 각 요소를 변환하는 mapToInt()는 O(N)
        // , 스트림을 배열로 변환하는 toArray()는 O(N)
        return fails.entrySet().stream().sorted((o1, o2)-> Double.compare(o2.getValue(), o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
    }
}
