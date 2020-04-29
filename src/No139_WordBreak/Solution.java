package No139_WordBreak;
/*
* 这个解法是我觉得最为直观的解法 如果用常规的做法需要仔细推敲
* 为什么可以直接通过s.substring(j, i)来判定(j, i)是否能由wordDict组成 万一可以由(j,k)(k, i)那么还能够处理吗？ 能
* */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        /* base case */
        for (int i = 0; i < len; i ++) {
            dp[i][i] = wordDict.contains(s.substring(i, i + 1));
        }

        /* dp */
        for (int j  = 0; j < len; j ++) {
            dp[0][j] = wordDict.contains(s.substring(0, j + 1)); // 直接算出0到j
            if (dp[0][j]) { //目的已经达到 无需继续
                continue;
            }
            for (int i = j - 1; i >= 0; i --) { // 正常dp算出0到j 我们需要先获取所有的从i到j
                dp[i][j] = wordDict.contains(s.substring(i, j + 1));// 直接算出从i到j
                if (dp[i][j]) {// 需要算出所有的i到j 所以不能break
                    continue;
                }
                for (int r = i; r < j; r ++) {// 何止分割点 分割成i到r r到j
                    dp[i][j] = dp[i][r] && dp[r + 1][j];
                    if (dp[i][j]){// 已经算出来i到j为true 无需继续
                        break;
                    }
                }
            }
        }
        return dp[0][len - 1];
    }

    public static void main(String[] args ) {
        Solution solution = new Solution();
        List<String> wordDict = new ArrayList<>();
        /** case 1 false*/
/*    	String s = "catsandog";
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");*/
        /** case 2 true */
/*    	String s = "applepenapple";
    	wordDict.add("apple");
    	wordDict.add("pen");*/
        /** case 3 true */
/*    	String s = "cars";
    	wordDict.add("car");
    	wordDict.add("ca");
    	wordDict.add("rs");*/
        /** case4 */
        String s = "a";
        wordDict.add("a");
        boolean res = solution.wordBreak(s, wordDict);
        System.out.print(res);
    }
}