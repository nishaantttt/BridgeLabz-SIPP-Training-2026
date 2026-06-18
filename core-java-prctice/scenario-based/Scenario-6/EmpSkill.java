import java.util.*;

public class EmpSkill {
    public static void findTeams(int[] arr, int target, int index, List<Integer> current) {
        if (target == 0) {
            System.out.println(current);
            return;
        }

        if (index == arr.length || target < 0) {
            return;
        }

        current.add(arr[index]);
        findTeams(arr, target - arr[index], index + 1, current);

        current.remove(current.size() - 1);
        findTeams(arr, target, index + 1, current);
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 7};
        int target = 10;

        findTeams(arr, target, 0, new ArrayList<>());
    }
}