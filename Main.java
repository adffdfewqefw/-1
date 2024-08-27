import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 읽기 위한 BufferedReader와 결과를 저장하기 위한 StringBuilder
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 첫 번째 줄에서 n 값을 읽어옴
        int n = Integer.parseInt(br.readLine());
        
        // 다음 n줄에서 수열을 읽어옴
        int[] sequence = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }

        // 스택을 초기화
        Stack<Integer> stack = new Stack<>();
        // 현재까지 스택에 push한 숫자를 추적
        int currentNumber = 1;
        
        // 수열을 처리하기 위한 인덱스
        int index = 0;

        // 수열을 순회하면서 스택 연산을 수행
        for (int i = 0; i < n; i++) {
            int target = sequence[i]; // 현재 목표 숫자

            // 목표 숫자에 도달할 때까지 스택에 숫자를 push
            while (currentNumber <= target) {
                stack.push(currentNumber++);
                sb.append("+\n"); // push 연산을 기록
            }

            // 스택의 최상단이 목표 숫자와 일치하는 경우 pop
            if (stack.peek() == target) {
                stack.pop();
                sb.append("-\n"); // pop 연산을 기록
            } else {
                // 목표 숫자가 스택의 최상단과 일치하지 않으면 수열을 만들 수 없음
                System.out.println("NO");
                return;
            }
        }

        // 모든 연산 결과를 출력
        System.out.print(sb.toString());
    }
}
