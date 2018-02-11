package com.sandbox.leetcode;

import com.sandbox.collections.Employee;
import com.sandbox.collections.TreeNode;

import java.util.*;

public class Solutions {

    public static void main(String[] args) {
        // Given nums = [2, 7, 11, 15], target = 9,
        int[] nums = {15, 7, 11, 2};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));

    }

    // TwoSum
    // difficulty: easy
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        int[] ret = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (m.containsKey(tmp)) {
                ret[0] = i;
                ret[1] = m.get(tmp);
                break;
            } else {
                m.put(nums[i], i);
            }
        }
        return ret;
    }

    // zigzag conversion
    // difficulty: easy
    public static String zigzag(String s, int numRows) {
        if (numRows == 1) return s; // special case

        StringBuilder solution = new StringBuilder();
        List<StringBuilder> l = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            l.add(new StringBuilder());
        }

        int index = 0;
        boolean forward = true;
        for (int i = 0; i < s.length(); i++) { // iterate string
            l.get(index).append(s.charAt(i));

            // select next array
            if (forward) {
                index++;
            } else {
                index--;
            }

            if (index == 0) {
                forward = true;
            } else if (index == numRows - 1) {
                forward = false;
            }
        }

        // merge strings
        for (int i = 0; i < numRows; i++) {
            solution.append(l.get(i));
        }

        return solution.toString();
    }

    // reverse integer
    // dificulty: easy
    public static int reverse(int x) {
        Integer n = x;
        String s = n.toString();
        char[] tmp = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int index = -1;
        if (x < 0) {
            index++;
            sb.append("-");
        }

        for (int i = tmp.length - 1; i > index; i--) {
            sb.append(tmp[i]);
        }
        Integer result = 0;
        try {
            result = new Integer(sb.toString());
        } catch (NumberFormatException e) {
            // ignore
        }
        return result;
    }

    public static int myAtoi(String str) {
        Integer result = 0;
        try {
            result = new Integer(str.trim());
        } catch (NumberFormatException e) {
            // ignore
        }
        return result;
    }

    // lengthOfLongestSubstring
    // difficulty: medium
    // notes: this has terrible runtime
    public static int lengthOfLongestSubstring(String s) {
        char[] cArray = s.toCharArray();
        int len = 0;
        int max = 0;
        int lastIndex = 0;
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < cArray.length; i++) {
            if (charSet.contains(cArray[i])) {
                if (len >= max) {
                    max = len;
                }
                len = 0; // reset
                charSet.clear(); // reset

                lastIndex++;
                i = lastIndex;

                // short circuit unnecessary look up
                if ((cArray.length - lastIndex) < max) break;
            }

            len++;
            charSet.add(cArray[i]);
        }
        // final case
        if (len >= max) {
            max = len;
        }
        return max;
    }

    // find longest palindrome substring
    // difficulty: medium
    public static String longestPalindrome(String s) {
        if (s.length() == 1) return s;

        // test if the chars are all the same
        if (s.substring(0, (s.length() / 2)).equals(s.substring((s.length() / 2)))) {
            return s;
        }

        int max = 0;
        String result = s.substring(0, 1);

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (i != j && s.charAt(i) == s.charAt(j)) {
                    String p = s.substring(i, j + 1);
                    if (isPali(p) && p.length() > max) {
                        max = p.length();
                        result = p;
                    }
                }
            }
        }
        return result;
    }

    public static boolean isPali(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * The Hamming distance between two integers is the number of positions
     * at which the corresponding bits are different.
     * <p>
     * if you XOR 2 integers and count the set bits (1's) you get the hamming distance
     * for those 2 integers.  IOW, you get the number of changes required to make them
     * the same.
     * <p>
     * The hamming distance between 1 and 4 is
     * 0001
     * 0100
     * ----
     * 0101 XOR result
     * 2 positions are different based on the number of set bits in the XOR result
     *
     * @param x integer
     * @param y integer
     * @return hamming distance
     */
    public static int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    /**
     * Given a lower and upper number bound, output a list of every possible
     * self dividing number, including the bounds if possible
     * <p>
     * Integer division by 10 removes the last digit in a number.  Mod'ing a
     * number by 10 gives you the last digit.
     *
     * @param left  starting number in range
     * @param right ending number in range; inclusive
     * @return self divisible numbers in range
     */
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> results = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            boolean valid = true;
            for (int j = i; j > 0; j = j / 10) {
                int lastDigit = j % 10;
                if (lastDigit == 0 || i % lastDigit != 0) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                results.add(i);
            }
        }
        return results;
    }

    /**
     * I was not able to solve this one.  This is the solution provided by leetcode.
     *
     * My initial solution failed for the case where one tree had more levels.
     *
     * @param t1 tree node
     * @param t2 tree node
     * @return t1 node merged into t2 by summing the values
     */
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    /**
     * Treat the moves like coordinates in a 2D plane.  You know that
     * if the point is back to the beginning if (x, y) = (0,0)
     *
     * @param moves String of characters representing moves (U,D,L,R)
     * @return true if back to original position (0, 0)
     */
    public static boolean judgeCircle(String moves) {
        // (0,0) (x, y) (l/r, u/d) (-/+, +/-)
        int x = 0;
        int y = 0;
        for (char c : moves.toCharArray()) {
           if (c == 'U' || c == 'u') {
               y += 1;
           } else if (c == 'D' || c == 'd') {
               y += -1;
           } else if (c == 'L' || c == 'l') {
               x += 1;
           } else if (c == 'R' || c == 'r') {
               x += -1;
           } else {
               throw new RuntimeException("Invalid input");
           }
        }
        return x == 0 && y == 0;
    }

    /**
     * Given an array of 2n integers, your task is to group these integers into n pairs of integer,
     * say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n
     * as large as possible.
     *
     * If you sort the array you know that the every other index is the min of the pair and you
     * are guaranteed to have n pairs since it is an array of 2n integers.
     *
     * @param nums int array
     * @return sum of all min values in the pair
     */
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            sum += nums[i];
        }
        return sum;
    }

    /**
     * Given two lists Aand B, and B is an anagram of A. B is an anagram of A means B is made by
     * randomizing the order of the elements in A.
     *
     * We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith element
     * in A appears in B at index j.
     *
     * These lists A and B may contain duplicates. If there are multiple answers, output any of them.
     *
     *  A, B have equal lengths in range [1, 100].
     *  A[i], B[i] are integers in range [0, 10^5].
     *
     * @param A array of ints
     * @param B array of ints; anagram of A
     * @return array with index mappings from A to B
     */
    public static int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Integer> m = new HashMap<>();
        int[] result = new int[A.length];

        for (int i = 0; i < B.length; i++) {
            m.put(B[i], i);
        }

        for (int i = 0; i < A.length; i++) {
            result[i] = m.get(A[i]);
        }
        return result;
    }

    /**
     * Given a positive integer, output its complement number. The complement strategy is to flip
     * the bits of its binary representation.
     *
     * @param num positive integer
     * @return the complement
     */
    public static int findComplement(int num) {
        String s = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '1') {
                sb.append('0');
            } else if (s.charAt(i) == '0') {
                sb.append('1');
            }
        }
        return Integer.parseInt(sb.toString(), 2);
    }

    /**
     * Write a function that takes a string as input and returns the string reversed.
     *
     * @param s String
     * @return String reversed
     */
    public static String reverseString(String s) {
        char[] chars = s.toCharArray();
        char[] reversed = new char[s.length()];
        int index = 0;
        for (int i = chars.length - 1; i >= 0 ; i--) {
            reversed[index] = chars[i];
            index++;
        }
        return String.valueOf(reversed);
    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for (String word : s.split(" ")) {
            sb.append(" ");
            sb.append(reverseString(word));
        }
        return sb.toString().trim();
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        for (int x = 1; x < matrix.length; x++) {
            for(int y = 1; y < matrix[0].length; y++) {
                // get the previous diagonal values
                int x1 = x - 1;
                int y2 = y - 1;
                // check if valid coordinate
                if (x1 > -1 && y2 > -1) {
                    int val = matrix[x][y];
                    int other = matrix[x1][y2];
                    if (val != other) return false;
                }
            }
        }
        return true;
    }

    public static List<String> fizzBuzz(int n) {
        List<String> results = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
           if (i % 3 == 0 && i % 5 == 0) {
               results.add("FizzBuzz");
           } else if (i % 3 == 0) {
               results.add("Fizz");
           } else if (i % 5 == 0) {
               results.add("Buzz");
           } else {
               results.add(String.valueOf(i));
           }
        }
        return results;
    }

    public static int distributeCandies(int[] candies) {
        Set<Integer> s = new HashSet<>();

        for (int i = 0; i < candies.length; i++) {
            s.add(candies[i]);
        }
        int size = candies.length / 2;
        return Math.min(size, s.size());
    }

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        // original matrix row and columns
        int cc = nums.length;
        int rr = nums[0].length;

        // if the new matrix cannot fit the elements we are done
        if (r * c != rr * cc) {
            return nums;
        }

        // pull the element out of the original matrix
        List<Integer> tmp = new ArrayList<>();
        for (int x = 0; x < cc; x++) {
            for (int y = 0; y < rr; y++) {
                tmp.add(nums[x][y]);
            }
        }

        // add values to new matrix
        int[][] result = new int[r][c];
        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
               result[i][j] = tmp.get(index);
               index++;
            }
        }

        return result;
    }

   public static int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int r = grid.length - 1;
        int c = grid[0].length - 1;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 1) {
                    // check left
                    if (y - 1 < 0) {
                        perimeter++;
                    } else if (grid[x][y-1] == 0) {
                        perimeter++;
                    } else {
                        // do nothing
                    }
                    // check right
                    if (y + 1 > c) {
                        perimeter++;
                    } else if (grid[x][y+1] == 0) {
                        perimeter++;
                    } else {
                        // do nothing
                    }
                    // check up
                    if (x - 1 < 0) {
                        perimeter++;
                    } else if (grid[x-1][y] == 0) {
                        perimeter++;
                    } else {
                        // do nothing
                    }
                    // check down
                    if (x + 1 > r) {
                        perimeter++;
                    } else if (grid[x+1][y] == 0) {
                        perimeter++;
                    } else {
                        // do nothing
                    }
                }
            }
        }
        return perimeter;
   }

   public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] results = new int[nums1.length];
        // build a mapping of indexes
       Map<Integer, Integer> m = new HashMap<>();
       for (int i = 0; i < nums2.length; i++) {
          m.put(nums2[i], i);
       }

       int max = nums2.length;
       int r_index = 0;
       for (int i = 0; i < nums1.length; i++) {
           int index = m.get(nums1[i]);
           if (index + 1 < max) {
               boolean found = false;
               for (int j = index + 1; j < nums2.length; j++) {
                   if (nums2[j] > nums1[i]) {
                       results[r_index] = nums2[j];
                       found = true;
                       r_index++;
                       break;
                   }
               }
               if (!found) {
                   results[r_index] = -1;
                   r_index++;
               }
           } else {
               results[r_index] = -1;
               r_index++;
           }
       }
       return results;
   }

   public static int countPrimeSetBits(int L, int R) {
       int primes = 0;
       for (int i = L; i <= R; i++) {
           String bin = Integer.toBinaryString(i);
           int count = 0;
           for (int j = 0; j < bin.length(); j++) {
               if (bin.charAt(j) == '1') {
                   count++;
               }
           }
           if (isPrime(count)) primes++;
       }
       return primes;
   }

   public static boolean isPrime(int n) {
       if (n < 2) return false;
       if (n == 2) return true;
       if (n % 2 == 0) return false;
       for (int i = 3; i * i <= n; i += 2) {
           if (n % i == 0) return false;
       }
       return true;
   }

    public static List<Double> averageOfLevels(TreeNode root) {
        // breadth first search
        List<Double> results = new ArrayList<>();
        TreeNode r = root;
        Stack<TreeNode> s = new Stack<>();
        s.push(r);
        while (!s.empty()) {
            List<TreeNode> l = new ArrayList<>();
            // pull the current nodes out of the stack
            while (!s.empty()) {
                l.add(s.pop());
            }
            // calculate the average and push them onto the que
            double sum = 0;
            for (TreeNode t : l) {
                sum += t.val;
                if (t.left != null) {
                    s.push(t.left);
                }
                if (t.right != null) {
                    s.push(t.right);
                }
            }
            results.add(sum / l.size());
        }
        return results;
    }

    public static boolean hasAlternatingBits(int n) {
        String s = Integer.toBinaryString(n);
        if (s.length() < 2) return true;
        char prev = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (prev == curr) {
                return false;
            } else {
                prev = curr;
            }
        }
        return true;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        TreeNode n = root;
        Stack<TreeNode> s = new Stack<>();
        s.push(n);
        int depth = 0;
        while (!s.empty()) {
            depth++;
            List<TreeNode> l = new ArrayList<>();
            while (!s.empty()) {
                l.add(s.pop());
            }

            for (TreeNode t : l) {
                if (t.left != null) {
                    s.push(t.left);
                }
                if (t.right != null) {
                    s.push(t.right);
                }
            }
        }
        return depth;
    }

    public static int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> m = new HashMap<>();
        for (Employee e : employees) {
            m.put(e.id, e);
        }
        return calc(m.get(id).subordinates, m, m.get(id).importance);
    }

    public static int calc(List<Integer> l, Map<Integer, Employee> m, int val) {
        if (l == null || l.isEmpty()) return val;

        for (int i : l) {
             val += calc(m.get(i).subordinates, m, m.get(i).importance);
        }
        return val;
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    int val = dfs(row, col, grid);
                    maxArea = Math.max(maxArea, val);
                }
            }
        }
        return maxArea;
    }

    public static int dfs(int r, int c, int[][] grid) {
        int minRow = 0;
        int minCol = 0;
        int maxRow = grid.length -1;
        int maxCol = grid[0].length -1;

        if (r > maxRow) return 0;
        if (minRow > r) return 0;
        if (c > maxCol) return 0;
        if (minCol > c) return 0;

        if (grid[r][c] == 1) {
            grid[r][c] = 0; // visited // alternatively I should copy the grid or use a Set<Coordinates> visited
            return 1 + dfs(r -1, c, grid) + dfs(r + 1, c, grid) + dfs(r, c -1, grid) + dfs(r, c + 1, grid);
        } else {
            return 0;
        }
    }
}
