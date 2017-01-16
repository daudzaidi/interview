package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by shyamsunderpandita on 21/12/16.
 * Set the maximum to X pages per student.

 To check if this is feasible just start allocating books to the first student until the next book would push over the threshold X. Then switch to the next and so on (this works because they say the allocations need to be contiguous).

 If you run out of books then it's feasible (you can always go back and give students less books to read to fit the other students). If you run out of students then it's not.

 This check will be O(N) where N is the number of books.

 Now that you have this, do a binary search for X. Complexity is O(NlogM) where N is the number of books and M is the total number of pages.

 */
public class AllocateBooks {

    public int books(ArrayList<Integer> A, int B) {

        int students = B;
        long high;
        long low = 0;
        long mid, res = 0;

        if (B > A.size())
            return -1;


        long sum = 0;

        // sum of the pages
        for (int pages : A)
            sum += pages;

        high = sum;

        while (low <= high) {

            mid = low + ((high - low) >> 1);

            if (isPossible(A, B, mid, sum)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (int) res;

    }

    private boolean isPossible(ArrayList<Integer> A, int B, long maxPage, long totalPages) {

        if (maxPage < totalPages / B)
            return false;

        int index = 0;
        int n = A.size();
        int i;

        for (i = 0; i < B && index < n; i++) {
            long page = maxPage;
            long total = 0;

            while (total < maxPage && index < n) {
                total += A.get(index);
                if (total > maxPage)
                    break;
                index++;
            }
        }

        if (index < n)
            return false;

        return true;
    }

    public static void main(String... args){
        AllocateBooks books = new AllocateBooks();
        ArrayList<Integer> list = new ArrayList<>();
        /*list.add(73);
        list.add(58);
        list.add(30);
        list.add(72);
        list.add(44);
        list.add(78);
        list.add(23);
        list.add(9);*/

        list.add(12);
        list.add(34);
        list.add(67);
        list.add(90);

        System.out.println(books.books(list,2));
    }
}
