package search.dfs;
/**
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to determine if the starting player can guarantee a win.

For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".

Follow up:
Derive your algorithm's runtime complexity.
 */
/*
 * dfs的解法，关键在于通过分析我们可以知道，只存在必胜或者必败两种状态，
 * 不存在不确定的状态，因为如果子状态只要有一个必败，那么这个状态就可以是必胜的
 * 必须所有子状态都为必胜，这个状态才为必败，如果这个状态为不确定的话，那么子状态也会有
 * 不确定的状态，这样一直递归到最后都会有不确定的状态，这样是不对的，因为最后的状态一定是
 * 确定的，这样搜索的复杂度为O(n!)
 * 还有一种game theory的解法
 * https://mp.weixin.qq.com/s?__biz=MzA5MzE4MjgyMw==&mid=401839317&idx=1&sn=0660926cc1e5edab1b92aa8160fa93e6&scene=1&
 * srcid=0420AaLUu66WKt6qT0corOWH&key=b28b03434249256ba03ab0052e5c62c6507926fb3e5a69590251573c91822860b933d1c3c7c2f4638751fd2fa913eb01&
 * ascene=0&uin=Mzk2MTg4MTc1&devicetype=iMac+MacBookPro10%2C2+OSX+OSX+10.10.5+build(14F1713)&version=11020201&pass_ticket=EpHcf98WnYVbA%2Bl38jKrd2Pkhz8mCvwXodGDvz1FepVcArRYBsUw8md4O9XSQvEX
 */
public class FlipGameII {
    public boolean canWin(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
       
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String cur = s.substring(0, i) + "--" + s.substring(i + 2);
                if (!canWin(cur)) {
                    return true;
                }
            }
        }
        return false;
    }
}
