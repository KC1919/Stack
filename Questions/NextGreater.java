

import java.util.Stack;
import java.util.Arrays;

public class NextGreater {
    public static long[] nextLargerElement(long[] nums, int n) {
        Stack<Integer> st = new Stack<>();

        long res[] = new long[n];

        Arrays.fill(res, -1);

        for (int i = 0; i < nums.length; i++) {
            if (st.size() == 0) {
                st.push(i);
            } else {
                if (nums[i] < nums[st.peek()]) {
                    st.push(i);
                } else {
                    while (st.size() != 0 && nums[st.peek()] < nums[i]) {
                        res[st.pop()] = nums[i];
                    }
                    if (st.size() == 0) {
                        res[i] = -1;
                    }

                    st.push(i);
                }
            }
        }

        return res;

    }
}
