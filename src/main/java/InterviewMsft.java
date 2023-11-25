import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class InterviewMsft {

// Given a number, palindrome -> 121, give me the next higher palindrome number
    // 123 -> 131
    // 267 -> 272
    // 45 -> 55
    // 2436 -> 2442
    // 24564 -> 24642
    // 26542 -> 26562
    // 871 -> 878
    // 597 -> 606
    // 587 -> 595

    public static void main(String[] args) {

        System.out.println();
        nextGreaterPalindrome(123).forEach(System.out::print);
        System.out.println();
        nextGreaterPalindrome(267).forEach(System.out::print);
        System.out.println();
        nextGreaterPalindrome(45).forEach(System.out::print);
        System.out.println();
        nextGreaterPalindrome(2436).forEach(System.out::print);
        System.out.println();
        nextGreaterPalindrome(24564).forEach(System.out::print);
        System.out.println();
        nextGreaterPalindrome(26542).forEach(System.out::print);
        System.out.println();
        nextGreaterPalindrome(871).forEach(System.out::print);
        System.out.println();
        nextGreaterPalindrome(597).forEach(System.out::print);
        System.out.println();

    }

    private static List<Integer> nextGreaterPalindrome(int number) {

        List<Integer> nums = new ArrayList<>();

        while (number >= 1) {
            int rem = number%10;
            number = number/10;
            nums.add(rem);
        }

        int numsSize = nums.size();
        if (numsSize == 1) {
            nums.add(number);
            return nums;
        }

        // reverse nums list.
        Collections.reverse(nums);
        int mid = numsSize/2;
        int i = mid-1;
        int j = numsSize%2 == 0 ? mid: mid+1;
        // 123 -> 131
        // 267 -> 272
        // 45 -> 55
        // 2436 -> 2442
        // 2346 -> 2442
        // 24564 -> 24642
        // 26542 -> 26562
        // 871 -> 878
        // 8999 -> 9009

        if (nums.get(i) < nums.get(j)) {
            if (numsSize%2 != 0) {
                int rep = nums.get(j) > nums.get(mid)? nums.get(j): nums.get(mid)+1;
                if (rep == 10) {
                    rep = 0;
                    nums.set(i, nums.get(i)+1);
                }
                nums.set(mid, rep);
                nums.set(j, nums.get(i));
            } else {
                nums.set(i, nums.get(j));
            }
        } else {
            int rep = nums.get(i) == 9? nums.get(i): 0;
            nums.set(i, rep);
            if (i-1 >= 0) {
                nums.set(i-1, nums.get(i)+1);
            }
            nums.set(j, nums.get(i));
        }
        i--;
        j++;

        while (i >= 0 && j < numsSize) {
            nums.set(j, nums.get(i));
            i--;
            j++;
        }
        return nums;
    }
}
