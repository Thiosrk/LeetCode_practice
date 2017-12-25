package HammingDistance;

/**
 * Created by 69401 on 2017/12/25.
 */
public class Solution {

    /**
     *1.Description:
     * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
     * Given two integers x and y, calculate the Hamming distance.
     *
     * 2.Note:
     * 0 ≤ x, y < 2^31.
     *
     * 3.Example:
     *
     * Input: x = 1, y = 4
     *
     * Output: 2
     *
     * Explanation:
     * 1   (0 0 0 1)
     * 4   (0 1 0 0)
     *       ↑   ↑
     *
     * The above arrows point to positions where the corresponding bits are different.
     */

    public int hammingDistance(int x, int y) {
        int xor = x^y;
        int n = 1;
        int result = 0;

        while ( xor > 0 ){
//            int tmp = (int)Math.pow(2,n);
//            System.out.println("n : "+n);
//            System.out.println("xor1 : "+xor);

            if( (xor & n) == n ) {
//                System.out.println(n);
                xor -= n;
                ++result;
            }
//            System.out.println("xor2 : "+xor);
            n = 2*n;
        }

        return result;
    }

    /**
     * Better Answer:
     *
     * int res = x^y;
     * int count = 0;
     * do{
     *     count +=res & 1;
     *     res = res >> 1;
     * }while(res != 0);
     *
     * return count;
     */

}
