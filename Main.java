class Stack {
    private int maxSize;      // 스택의 최대 크기
    private int[] stackArray; // 스택을 저장할 배열
    private int top;          // 스택의 최상단 요소를 가리키는 인덱스

    // 스택 생성자
    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1; // 스택이 비어있음을 나타냄
    }

    // 스택에 값을 추가 (푸시)
    public void push(int value) {
        if (isFull()) {
            System.out.println("스택이 가득 찼습니다.");
        } else {
            stackArray[++top] = value;
            System.out.println("Pushed: " + value);
        }
    }

    // 스택에서 값을 제거하고 반환 (팝)
    public int pop() {
        if (isEmpty()) {
            System.out.println("스택이 비어 있습니다.");
            return -1;
        } else {
            int value = stackArray[top--];
            System.out.println("Popped: " + value);
            return value;
        }
    }

    // 스택의 최상단 값을 반환 (팝하지 않음)
    public int peek() {
        if (isEmpty()) {
            System.out.println("스택이 비어 있습니다.");
            return -1;
        } else {
            return stackArray[top];
        }
    }

    // 스택이 비어있는지 확인
    public boolean isEmpty() {
        return (top == -1);
    }

    // 스택이 가득 찼는지 확인
    public boolean isFull() {
        return (top == maxSize - 1);
    }
}

// 테스트 클래스
public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(5); // 크기 5의 스택 생성

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60); // 스택이 가득 차므로 실패할 것임

        System.out.println("Top element is: " + stack.peek());

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop(); // 스택이 비었으므로 실패할 것임
    }
}
