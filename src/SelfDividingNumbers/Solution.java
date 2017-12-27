package SelfDividingNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 69401 on 2017/12/27.
 */
public class Solution {

    /**
     * 1.Description:
     * A self-dividing number is a number that is divisible by every digit it contains.
     * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
     * Also, a self-dividing number is not allowed to contain the digit zero.
     * Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
     *
     * 2.Example1:
     * Input:
     * left = 1, right = 22
     * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
     *
     * 3.Note:
     * The boundaries of each input argument are 1 <= left <= right <= 10000.
     */

    //LeetCode Runtime: 14 ms
    public List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> res = new ArrayList<Integer>();

        for ( int i = left ; i <= right ; ++i ){

            System.out.println("The number is : "+i);
            int[] num = new int[4];
            boolean flag = true;

            num[0] = (i%10000 - i%1000)/1000;
            num[1] = (i%1000 - i%100)/100;
            num[2] = (i%100 - i%10)/10;
            num[3] = i%10;

            if ((num[3] == 0) || (i%num[3] != 0)){
                System.out.println("个位数："+(num[3]));
                flag = false;
            } if ( i > 10 ){
                System.out.println("十位数："+(num[2]));
                if ( num[2] == 0 ||i%num[2] != 0 )
                    flag = false;
            } if (i > 100 ){
                System.out.println("百位数："+(num[1]));
                if ( num[1] == 0 || i%num[1] != 0 )
                    flag = false;
            } if (i > 1000 ) {
                System.out.println("千位数："+(num[0]));
                if (num[0] ==0 || i % num[0] != 0 )
                    flag = false;
            }
            if (flag)
                res.add(i);

        }

        return res;
    }

    /**
     * Better Answer:
     * public List<Integer> selfDividingNumbers(int left, int right) {
     *List<Integer> res = new LinkedList<>();
     *for (int i = left; i <= right; i++) {
     *if (isSelfDividing(i)) {
     *res.add(i);
     *}
     *}
     *return res;
     *}
     *private static boolean isSelfDividing(int a) {
     *int b = a;
     *while (b != 0) {
     *int d = b % 10;
     *if (d == 0) {
     *return false;
     *}
     *if (a % d != 0) {
     *return false;
     *}
     *b /= 10;
     *}
     *return true;
     *}
     */

    /**
     * 分析：遇到十进制数与位数相关的问题比起用10^n，使用/10的循环更加快捷
     */
}
