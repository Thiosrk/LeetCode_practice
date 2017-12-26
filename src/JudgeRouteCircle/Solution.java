package JudgeRouteCircle;

/**
 * Created by 69401 on 2017/12/26.
 */
public class Solution {

    /**
     * 1.Description:
     * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle,
     * which means it moves back to the original place.The move sequence is represented by a string. And each move is
     * represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should
     * be true or false representing whether the robot makes a circle.
     *
     * Example 1:
     *
     * Input: "UD"
     * Output: true
     *
     * Example 2:
     *
     * Input: "LL"
     * Output: false
     *
     *
     */

    //LeetCode Runtime: 11 ms
    public boolean judgeCircle(String moves) {

        int updown = 0;
        int leftright = 0;

        for( char ch : moves.toCharArray() ){
//            System.out.println("Char : "+ch);
            switch (ch){
                case 'U':
                    updown++;
                    break;
                case 'D':
                    --updown;
                    break;
                case 'L':
                    ++leftright;
                    break;
                case 'R':
                    --leftright;
                    break;
            }
//            System.out.println("Updown : "+updown);
//            System.out.println("Leftright : "+leftright);
        }

        return (updown == 0) && (leftright == 0);

    }

    /**
     * Better Answer1:
     * public boolean judgeCircle(String moves) {
     *char m[] = moves.toCharArray();
     *int U = gs('U', m);
     *int D = gs('D', m);
     *int L = gs('L', m);
     *int R = gs('R', m);
     *boolean Re;
     *if(U==D&&L==R)
     *Re = true;
     *else
     *Re = false;
     *return Re;
     *}
     //创建方法gs()计算字符数组zfsz[]中字符zm的个数
     *public int gs(char zm, char zfsz[]){
     *int n = 0;
     *for(int i = 0; i < zfsz.length; i++){
     *if(zfsz[i] == zm)
     *n++;
     *}
     *return n;
     *}
     *
     * Better Answer2:
     * public boolean judgeCircle(String moves) {
     *int[] bin = new int[256];
     *for (char s: moves.toCharArray()) {
     *bin[s]++;
     *}
     *return (bin['U'] == bin['D']) && (bin['L'] == bin['R']);
     *}
     */

}
