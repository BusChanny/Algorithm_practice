import java.util.Arrays;

public class LeetCode_704_Binary_Search {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};

        System.out.println(Search(nums, 9));
    }

    private static int Search(int[] nums, int target) {
        return Arrays.binarySearch(nums, target);

    }

}
