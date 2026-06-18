import java.util.ArrayList;
import java.util.List;

public class ArraySubset {

    public static void generateSubsets(int[] arr, int index, List<Integer> current) {        
        if (index == arr.length) {
            System.out.println(current);
            return;
        }

        current.add(arr[index]);
        generateSubsets(arr, index + 1, current);

        current.remove(current.size() - 1);
        generateSubsets(arr, index + 1, current);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        generateSubsets(arr, 0, new ArrayList<>());
    }
}