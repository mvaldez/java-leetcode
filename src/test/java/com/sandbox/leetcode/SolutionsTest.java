package com.sandbox.leetcode;

import com.sandbox.collections.TreeNode;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 *
 * @author {@link "markvaldez@gmail.com"}
 */
public class SolutionsTest {
    @Test
    public void twoSum() throws Exception {
        // Given nums = [2, 7, 11, 15], target = 9,
        int[] nums = {15, 7, 11, 2};
        int target = 9;

        System.out.println(Arrays.toString(Solutions.twoSum(nums, target)));

    }

    @Test
    public void zigzagTest() throws Exception {
        String original = "PAYPALISHIRING";
        String expected = "PAHNAPLSIIGYIR";
        String actual = Solutions.zigzag(original, 3);
        assertEquals(expected, actual);

        assertEquals("AB", Solutions.zigzag("AB", 1));
    }

    @Test
    public void reverseTest() {
        int expected1 = 321;
        int expected2 = -321;

        int actual1 = Solutions.reverse(123);
        int actual2 = Solutions.reverse(-123);
        Solutions.reverse(1534236469); // should not throw NFE

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    @Test
    public void myAtoiTest() {
        assertEquals(10, Solutions.myAtoi("   010"));
    }

    @Test
    public void lengthOfLongestSubstringTest() {
        assertEquals(3, Solutions.lengthOfLongestSubstring("dvdf"));
    }

    @Test
    public void longestPalindromeTest() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<2000; i++) {
            sb.append("a");
        }

        StringBuilder sb1 = new StringBuilder();
        for (int i=0; i<493; i++) {
            sb1.append("f");
        }

        StringBuilder sb2 = new StringBuilder();
        for (int i=0; i<494; i++) {
            sb2.append("g");
        }

        String s = "ibvjkmpyzsifuxcabqqpahjdeuzaybqsrsmbfplxycsafogotliyvhxjtkrbzqxlyfwujzhkdafhebvsdhkkdbhlhmaoxmbkqiwiusngkbdhlvxdyvnjrzvxmukvdfobzlmvnbnilnsyrgoygfdzjlymhprcpxsnxpcafctikxxybcusgjwmfklkffehbvlhvxfiddznwumxosomfbgxoruoqrhezgsgidgcfzbtdftjxeahriirqgxbhicoxavquhbkaomrroghdnfkknyigsluqebaqrtcwgmlnvmxoagisdmsokeznjsnwpxygjjptvyjjkbmkxvlivinmpnpxgmmorkasebngirckqcawgevljplkkgextudqaodwqmfljljhrujoerycoojwwgtklypicgkyaboqjfivbeqdlonxeidgxsyzugkntoevwfuxovazcyayvwbcqswzhytlmtmrtwpikgacnpkbwgfmpavzyjoxughwhvlsxsgttbcyrlkaarngeoaldsdtjncivhcfsaohmdhgbwkuemcembmlwbwquxfaiukoqvzmgoeppieztdacvwngbkcxknbytvztodbfnjhbtwpjlzuajnlzfmmujhcggpdcwdquutdiubgcvnxvgspmfumeqrofewynizvynavjzkbpkuxxvkjujectdyfwygnfsukvzflcuxxzvxzravzznpxttduajhbsyiywpqunnarabcroljwcbdydagachbobkcvudkoddldaucwruobfylfhyvjuynjrosxczgjwudpxaqwnboxgxybnngxxhibesiaxkicinikzzmonftqkcudlzfzutplbycejmkpxcygsafzkgudy";

        assertEquals("bab", Solutions.longestPalindrome("babad"));
        assertEquals("bb", Solutions.longestPalindrome("cbbd"));
        assertEquals(sb.toString(), Solutions.longestPalindrome(sb.toString()));
        assertEquals(sb2.toString(), Solutions.longestPalindrome(sb1.toString() + sb2.toString()));
        assertEquals("fklkf", Solutions.longestPalindrome(s));

    }

    @Test
    public void isPaliTest() {
        assertTrue(Solutions.isPali("aba"));
        assertTrue(Solutions.isPali("bb"));
        assertTrue(Solutions.isPali("tacocat"));
        assertTrue(Solutions.isPali("racecar"));

        assertFalse(Solutions.isPali("abab"));
        assertFalse(Solutions.isPali("ac"));
        assertFalse(Solutions.isPali("ababac"));
    }

    @Test
    public void hammTest() {
        assertTrue(Solutions.hammingDistance(1, 4) == 2);
    }

    @Test
    public void selfDivNumTest() {
        MatcherAssert.assertThat(Solutions.selfDividingNumbers(1, 22),
            equalTo(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22)));
    }

    @Test
    public void mergeTreeNodesTest() {

/*
Input:
        Tree 1                     Tree 2
          1                         2
         / \                       / \
        3   2                     1   3
       /                           \   \
      5                             4   7
*/
        TreeNode n1 = new TreeNode(1);
        n1.left = new TreeNode(3);
        n1.right = new TreeNode(2);
        n1.left.left = new TreeNode(5);

        TreeNode n2 = new TreeNode(2);
        n2.left = new TreeNode(1);
        n2.right = new TreeNode(3);
        n2.left.right = new TreeNode(4);
        n2.right.right= new TreeNode(7);

        System.out.println("---- n1 ----");
        TreeNode.preOrderTraversal(n1);

        System.out.println("---- n1 ----");
        TreeNode.preOrderTraversal(n2);

        TreeNode t = Solutions.mergeTrees(n1, n2);

        System.out.println("---- solution ----");
        TreeNode.preOrderTraversal(t);
    }

    @Test
    public void judgeCircleTest() {
        String moves = "UUDDLLRRUDLRDURL";
        assertTrue(Solutions.judgeCircle(moves));
    }

    @Test
    public void arrayPairSumTest() {
        int[] a = new int[4];
        a[0] = 1;
        a[1] = 4;
        a[2] = 3;
        a[3] = 2;

        assertThat(Solutions.arrayPairSum(a), equalTo(4));
    }
}