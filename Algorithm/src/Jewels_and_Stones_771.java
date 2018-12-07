import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sun.rmi.runtime.Log;

/*
771. Jewels and Stones

You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

당신은 보석 인 돌의 종류를 나타내는 문자열 J와 당신이 가지고있는 돌들을 나타내는 S가 주어집니다. S의 각 캐릭터는 가지고있는 돌의 유형입니다. 당신은 얼마나 많은 돌이 보석인지 알고 싶습니다.
J의 문자는 별개이며 J 및 S의 문자는 모두 문자입니다. 문자는 대소 문자를 구분하므로 "a"는 "A"와 다른 유형의 돌로 간주됩니다.

Example 1:
Input: J = "aA", S = "aAAbbbb"
Output: 3

Example 2:
Input: J = "z", S = "ZZ"
Output: 0
Note:

S and J will consist of letters and have length at most 50.
The characters in J are distinct.
 */
public class Jewels_and_Stones_771 {
	public static void main(String[] args) {
        Solution1 sol = new Solution1();
        String J = "z";
        String S = "ZZZz";
        System.out.println(">>>>> result" +   sol.numJewelsInStones(J,S));
	}
}

class Solution1 {
    public int numJewelsInStones(String J, String S) {
        int result = 0;
        List<Character> list = new ArrayList<Character>();
        for(int i=0; i<J.length(); i++) {
            list.add(J.charAt(i));

        }
        for(Character test : list) {
            for(int i=0; i<S.length(); i++) {
                if(test.equals(S.charAt(i))) {
                    result++;
                }
            }
        }
        return result;
    }
}