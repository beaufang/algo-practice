package com.beau.base.string;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author BeauFang
 * Date: 2020/8/27
 */
public class Sunday {

    public int find(String txt, String pat) {
        int m = pat.length(), n = txt.length();
        int[] shiftTable = genShiftTable(pat);
        int i = 0;
        while (i <= n - m) {
            int j = 0;
            while (j < m && txt.charAt(i + j) == pat.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i;
            }
            // 关注模式串最后一个字符对应主串的字符的下一个字符
            int shift = shiftTable[txt.charAt(i + m)];
            i += shift;
        }
        return -1;
    }

    /**
     * 生成串移动位移辅助表
     */
    private int[] genShiftTable(String pat) {
        int m = pat.length();
        int[] shiftTable = new int[256];
        // 默认移动整个字符模式串
        Arrays.fill(shiftTable, m + 1);
        for (int i = 0; i < m; i++) {
            shiftTable[pat.charAt(i)] = m - i;
        }
        return shiftTable;
    }

    @Test
    public void test() {
        System.out.println(find("aabbbacda", "da"));
        System.out.println(find("aabbbacda", "cd"));
        System.out.println(find("aabbbacda", "ce"));
        System.out.println(find("aabbbacda", "aa"));
    }
}
