package com.sandbox.leetcode;

import com.sandbox.collections.Employee;
import com.sandbox.collections.TreeNode;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

    @Test
    public void anagramMappingsTest() {
        int[] A = new int[]{12, 28, 46, 32, 50};
        int[] B = new int[]{50, 12, 32, 46, 28};

        int[] result = new int[]{1, 4, 3, 2, 0};

        assertThat(Solutions.anagramMappings(A, B), equalTo(result));
    }

    @Test
    public void findComplementTest() {
        System.out.println(Integer.toBinaryString(Solutions.findComplement(5)));
        assertThat(Solutions.findComplement(5), equalTo(2));
        assertThat(Solutions.findComplement(1), equalTo(0));
    }

    @Test
    public void reverseStringTest() {
        assertThat(Solutions.reverseString("hello"), equalTo("olleh"));
    }

    @Test
    public void reverseWordTest() {
        assertThat(Solutions.reverseWords("Let's take LeetCode contest"), equalTo("s'teL ekat edoCteeL tsetnoc"));
    }

    @Test
    public void isToeplitzMatrixTest() {
        // [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
        int[][] input = new int[][]{new int[]{1, 2, 3, 5}, new int[]{5, 1, 2, 3}, new int[]{9, 5, 1, 2}};
        assertTrue(Solutions.isToeplitzMatrix(input));
    }

    @Test
    public void fizzBuzzTest() {
        List<String> expected = new ArrayList<>();
        expected.add("1");
        expected.add("2");
        expected.add("Fizz");
        expected.add("4");
        expected.add("Buzz");
        expected.add("Fizz");
        expected.add("7");
        expected.add("8");
        expected.add("Fizz");
        expected.add("Buzz");
        expected.add("11");
        expected.add("Fizz");
        expected.add("13");
        expected.add("14");
        expected.add("FizzBuzz");

        assertThat(Solutions.fizzBuzz(15), equalTo(expected));
    }

    @Test
    public void distCandiesTest() {
        int[] c1 = new int[]{1, 1, 2, 2, 3, 3};
        int[] c2 = new int[]{1, 1, 2, 3};
        int[] c3 = new int[]{0,0,14,0,10,0,0,0};
        int[] c4 = new int[]{1000,1000,2,1,2,5,3,1};

        assertThat(Solutions.distributeCandies(c1), equalTo(3));
        assertThat(Solutions.distributeCandies(c2), equalTo(2));
        assertThat(Solutions.distributeCandies(c3), equalTo(3));
        assertThat(Solutions.distributeCandies(c4), equalTo(4));
    }

    @Test
    public void matrixReshapeTest() {
        int[][] m1 = new int[][]{new int[]{1, 2}, new int[]{3, 4}};
        int[][] expected = new int[][]{new int[]{1, 2, 3, 4}};

        assertThat(Solutions.matrixReshape(m1, 1, 4), equalTo(expected));
        assertThat(Solutions.matrixReshape(m1, 2, 4), equalTo(m1));
        java.util.Random r = new Random();
        r.nextInt(3);
    }

    @Test
    public void islandPerimeterTest() {
        int[][] grid = new int[][]{
            new int[]{0, 1, 0, 0},
            new int[]{1, 1, 1, 0},
            new int[]{0, 1, 0, 0},
            new int[]{1, 1, 0, 0}};

        assertThat(Solutions.islandPerimeter(grid), equalTo(16));
    }

    @Test
    public void nextGreaterElementTest() {
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};
        int[] expected = new int[]{-1, 3, -1};

        assertThat(Solutions.nextGreaterElement(nums1, nums2), equalTo(expected));
    }

    @Test
    public void contPrimSetBitsTest() {
        assertThat(Solutions.countPrimeSetBits(6, 10), equalTo(4));
        assertTrue(Solutions.isPrime(3));
    }

    @Test
    public void avgOfLevelsTest() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<Double> expected = new ArrayList<>();
        expected.add(3.0);
        expected.add(14.5);
        expected.add(11.0);

        assertThat(Solutions.averageOfLevels(root), equalTo(expected));
    }

    @Test
    public void hasAlternatingBitsTest() {
        int[] vals = new int[]{5, 7, 11, 10};
        boolean[] exp = new boolean[]{true, false, false, true};
        for (int i = 0; i < vals.length; i++) {
            assertThat(Solutions.hasAlternatingBits(vals[i]), equalTo(exp[i]));
        }
    }

    @Test
    public void maxDepthTest() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        assertThat(Solutions.maxDepth(root), equalTo(3));
    }

    @Test
    public void getImportanceTest() {
        Employee e1 = new Employee();
        e1.id = 1;
        e1.importance = 5;
        e1.subordinates = new ArrayList<Integer>(){{add(2); add(3);}};

        Employee e2 = new Employee();
        e2.id = 2;
        e2.importance = 3;
        e2.subordinates = null;

        Employee e3 = new Employee();
        e3.id = 3;
        e3.importance = 3;
        e3.subordinates = null;

        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);

        assertThat(Solutions.getImportance(employees, 1), equalTo(11));
    }

    @Test
    public void maxAreaOfIslandTest() {
        int[][] grid = {new int[]{0, 1, 1}, new int[]{1, 1, 0, 0}};

        assertThat(Solutions.maxAreaOfIsland(grid), equalTo(4));
    }

    @Test
    public void addDigitsTest() {
        assertThat(Solutions.addDigits(38), equalTo(2));
        assertThat(Solutions.addDigits(112), equalTo(4));
        assertThat(Solutions.addDigits(199), equalTo(1));
    }

    @Test
    public void findDigitalRootsTest() {
        assertThat(Solutions.findDigitalRoot(38), equalTo(2));
        assertThat(Solutions.findDigitalRoot(112), equalTo(4));
        assertThat(Solutions.findDigitalRoot(199), equalTo(1));
    }

    @Test
    public void moveZerosTest() {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        assertThat(Solutions.moveZeros(nums), equalTo(new int[]{1, 3, 12, 0, 0}));
    }

    @Test
    public void rotateDigitsTest() {
        assertThat(Solutions.rotateDigits(11), equalTo(4));
        assertThat(Solutions.rotateDigits(20), equalTo(9));
    }
}