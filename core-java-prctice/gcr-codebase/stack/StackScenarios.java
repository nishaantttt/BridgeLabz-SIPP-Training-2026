import java.util.*;

public class StackScenarios {

    // ==========================
    // Scenario 1: Array Stack
    // ==========================
    static class UndoBuffer {
        private String[] data;
        private int top;

        UndoBuffer(int maxDepth) {
            data = new String[maxDepth];
            top = -1;
        }

        boolean push(String edit) {
            if (top == data.length - 1) {
                return false;
            }
            data[++top] = edit;
            return true;
        }

        String pop() {
            if (isEmpty())
                throw new RuntimeException("Nothing to undo");
            return data[top--];
        }

        String peek() {
            if (isEmpty())
                throw new RuntimeException("Stack Empty");
            return data[top];
        }

        boolean isEmpty() {
            return top == -1;
        }
    }

    // ==========================
    // Scenario 2: Linked List Stack
    // ==========================
    static class CallStack {

        static class Frame {
            String functionName;
            Frame next;

            Frame(String name, Frame next) {
                this.functionName = name;
                this.next = next;
            }
        }

        private Frame top = null;

        void push(String functionName) {
            top = new Frame(functionName, top);
        }

        String pop() {
            if (isEmpty())
                throw new RuntimeException("No active call");

            String ans = top.functionName;
            top = top.next;
            return ans;
        }

        String peek() {
            if (isEmpty())
                throw new RuntimeException("No active call");
            return top.functionName;
        }

        boolean isEmpty() {
            return top == null;
        }
    }

    // ==========================
    // Scenario 3: Valid Parentheses
    // ==========================
    static boolean isValidConfig(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {

                if (stack.isEmpty())
                    return false;

                char top = stack.pop();

                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{'))
                    return false;
            }
        }

        return stack.isEmpty();
    }

    // ==========================
    // Scenario 4: Next Greater Element
    // ==========================
    static int[] nextGreater(int[] arr) {

        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                ans[stack.pop()] = arr[i];
            }

            stack.push(i);
        }

        return ans;
    }

    // ==========================
    // Scenario 5: Stock Span
    // ==========================
    static int[] stockSpan(int[] price) {

        int n = price.length;
        int[] span = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }

            if (stack.isEmpty())
                span[i] = i + 1;
            else
                span[i] = i - stack.peek();

            stack.push(i);
        }

        return span;
    }

    static void printArray(int[] arr) {
        for (int x : arr)
            System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        // ==========================
        // Scenario 1 Demo
        // ==========================
        System.out.println("===== Scenario 1: Array Stack =====");

        UndoBuffer undo = new UndoBuffer(3);

        undo.push("Edit1");
        undo.push("Edit2");
        undo.push("Edit3");

        System.out.println("Top = " + undo.peek());
        System.out.println("Undo = " + undo.pop());
        System.out.println("Top = " + undo.peek());

        // ==========================
        // Scenario 2 Demo
        // ==========================
        System.out.println("\n===== Scenario 2: Linked List Stack =====");

        CallStack cs = new CallStack();

        cs.push("main()");
        cs.push("login()");
        cs.push("validate()");

        System.out.println("Current Function = " + cs.peek());
        System.out.println("Return From = " + cs.pop());
        System.out.println("Current Function = " + cs.peek());

        // ==========================
        // Scenario 3 Demo
        // ==========================
        System.out.println("\n===== Scenario 3: Valid Parentheses =====");

        String s1 = "{[()]}";
        String s2 = "{[(])}";

        System.out.println(s1 + " -> " + isValidConfig(s1));
        System.out.println(s2 + " -> " + isValidConfig(s2));

        // ==========================
        // Scenario 4 Demo
        // ==========================
        System.out.println("\n===== Scenario 4: Next Greater Element =====");

        int[] arr = {4, 5, 2, 25, 7, 8};

        System.out.print("Array: ");
        printArray(arr);

        System.out.print("Next Greater: ");
        printArray(nextGreater(arr));

        // ==========================
        // Scenario 5 Demo
        // ==========================
        System.out.println("\n===== Scenario 5: Stock Span =====");

        int[] price = {100, 80, 60, 70, 60, 75, 85};

        System.out.print("Prices: ");
        printArray(price);

        System.out.print("Span:   ");
        printArray(stockSpan(price));
    }
}