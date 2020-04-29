package No139_WordBreak;
/*
* 如果仔细观察的话会发现 这个问题实质上也是一个可重复选择的背包问题 字典为选择数组 s为上限 只不过他问的方式比较特别
* 正常的话会问能否由字典中的单词组成s 且使得单词数目最少。 而这题却问s能否由字典中的单词组成 虽然看似不同 但实际上是减小了难度的
* 同样的思路：s 可以由[0,s-1] 和 1组成 也可由[0,s - 2]和 2组成 ...0和组成 即dp[i] 一定可由dp[j]加上某个长度的单词组成
* 所以如果dp[j]是true 且 这个单词也在字典中存在 那么dp[i]就为true
* 可能你会想问 万一这个单词虽然在字典中不存在 但是字典中存在可以组成这个单词的单词怎么办(先去readme看本质 不懂再继续往下看)
* 其实没必要这么考虑 因为如果你想组成长度为i的字符串 你必定是从长度为0, i - 1的字符串加上某一个单词组成的 如果这个单词可以由其他多个单词组成
* 那么他就偏离了这个思想
* 如果非要解释 可以这么理解 相对前面已经计算出的所有情况 dp[i]仅相当于多出来了最后一个字符 我们要做的就是去字典里找一个(一个就足够)单词加在末尾 使得它能
* 把这个字符补上 所以我们尝试把字典中的各个字符加载末尾 如果可以补上 我们再去看去掉这个单词的字符串是否能被组成(已经在前面被计算)
* 但是如果按上述方法实现 代码会比较复杂 所以我们选择了之前在d[i]上去掉各个长度的字符串 看去掉的字符串是否在字典里以及剩余的字符串是否能被组成 实质上是和上述方法一样的思想
* 那么现在我们考虑之前说的情况 如果去掉的这个单词可以由其他多个单词组成 那么就相当于它去掉了多个单词 因此这种情况是不会出现的 因为我们是从小到大删除单词
* 所以当你去掉组成这个单词的某一个单词时 你就已经可以知道结果了
*
* */
import java.util.ArrayList;
import java.util.List;

class Solution2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];

        /* base case */
        dp[0] = true;

        /* dp */
        for (int i = 1; i <= len; i ++) {
            for (int j = 1; j <= i; j ++) {
                dp[i] = dp[i - j] && wordDict.contains(s.substring(i - j, i));
                if (dp[i]) { //一旦为true后 就无须继续了 否则可能会重新被置位false
                    break;
                }
            }
        }
        return dp[len];
    }

    public static void main(String[] args ) {
        Solution2 solution = new Solution2();
        List<String> wordDict = new ArrayList<>();
        /** case 1 false*/
/*    	String s = "catsandog";
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");*/
        /** case 2 true */
    	String s = "applepenapple";
    	wordDict.add("apple");
    	wordDict.add("pen");
        /** case 3 true */
/*    	String s = "cars";
    	wordDict.add("car");
    	wordDict.add("ca");
    	wordDict.add("rs");*/
        /** case4 */
/*        String s = "a";
        wordDict.add("a");*/
        boolean res = solution.wordBreak(s, wordDict);
        System.out.print(res);
    }
}