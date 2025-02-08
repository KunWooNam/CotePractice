package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Arrays07 {

    public static void main(String[] args) {
        //방문길이 O(N)
        String dirs = "ULURRDLLU";
        System.out.println(solution(dirs));
    }

    // 1. 좌표평면을 벗어나는지 체크
    private static boolean isValidMove(int nx, int ny){
        return 0 <= nx && nx < 11 && 0<= ny && ny < 11;
    }

    // 2. 다음 좌표 결정을 위한 해시맵 생성
    private static final HashMap<Character, int[]> location = new HashMap<>();

    private static void initLocation(){
        location.put('U', new int[]{0,1});
        location.put('D', new int[]{0,-1});
        location.put('L', new int[]{-1,0});
        location.put('R', new int[]{1,0});
    }

    public static int solution(String dirs){
        initLocation();
        int x = 5, y = 5;
        HashSet<String> answer = new HashSet<>(); // 3. Set구조는 중복불허, 겹치는 좌표는 1개로 처리

        // 4. 주어진 명령어로 움직이면서 좌표 저장
        for (int i = 0; i < dirs.length(); i++) {
            int[] offset = location.get(dirs.charAt(i)); //O(1)
            int nx = x + offset[0];
            int ny = y + offset[1];
            if (!isValidMove(nx, ny)) { // 5.좌표평면을 벗어난 좌표는 넘어감
                continue;
            }
            // 6. A에서 B로 간 경우 B에서 A도 추가해야 한다.( 방향에 관계없이 경로가 같다면 경로의 갯수는 1개)
            answer.add(x + " " + y + " " + nx + " " + ny);
            answer.add(nx + " " + ny + " " + x + " " + y);
            // 7.좌표를 이동했으므로 업데이트
            x = nx;
            y = ny;
        }

        return answer.size() / 2;

    }
}
