package com.beau.base.string;

import java.util.Arrays;

/**
 * @author BeauFang
 * Date: 2020/8/26
 */
public class BM {
    // 模式串
    private final String pat;
    // 坏字符映射表,bc[i]表示坏字符在模式串中最靠右的位置
    private final int[] bc;
    // 好后缀映射表，gs[i]表示在模式串中（除开好后缀部分）和长度为i的后缀匹配的子串中最右的子串的起始下标
    private final int[] gs;
    // prefix[i]表示长度为i的后缀，是否是模式串的前缀
    private final boolean[] prefix;
    // 模式串的长度；
    private final int m;

    public BM(String pat) {
        this.pat = pat;
        this.m = pat.length();
        // 映射所有字符
        this.bc = new int[256];
        this.gs = new int[m];
        this.prefix = new boolean[m];
        genBc();
        genGs();
        System.out.println("bc" + Arrays.toString(bc));
        System.out.println("gs" + Arrays.toString(gs));
    }

    public int find(String txt) {
        int n = txt.length();
        int i = 0;
        while (i <= n - m) {
            int j = m - 1;
            // 对齐模式串，从模式串的最后一位开始比较
            while (j >= 0 && txt.charAt(i + j) == pat.charAt(j)) {
                j--;
            }
            // 模式串从后到前匹配完成
            if (j == -1) {
                return i;
            }
            // 根据坏字符移动的位数
            int x = j - bc[txt.charAt(i + j)];
            // 根据好后缀移动的位数
            int y = 0;
            // 如果有好后缀
            if (j < m - 1) {
                y = moveByGs(j);
            }
            System.out.println("x " + x + " y " + y);
            i += Math.max(x, y);
        }
        return -1;
    }

    /**
     * 根据好后缀计算模式串应该移动的步数移动的步数
     */
    private int moveByGs(int j) {
        // 好后缀的长度
        int k = m - 1 - j;
        // case 1 如果模式串中存在完全匹配的公共后缀
        if (gs[k] != -1) {
            // newJ = gs[k] - 1;
            return j - gs[k] + 1;
        }
        // case 2 查找前缀
        // 因为已知 pat[j+1...m-1] 的公共后缀是不存在的,所以从 j + 2 开始查找前缀
        for (int r = j + 2; r <= m - 1; r++) {
            // r 处后缀的长度位 (m - 1) - (r + 1)
            if (prefix[m - r]) {
                // 模式串右移到和索引r处对齐，一共需要移动r位
                return r;
            }
        }
        // case 3 直接将整个模式串前移
        return m;
    }

    /**
     * 生成坏字符表
     */
    private void genBc() {
        // 如果坏字符在模式串中不存在，则返回 -1
        Arrays.fill(bc, -1);
        for (int i = 0; i < m; i++) {
            // 最右侧的坐标会覆盖左侧
            bc[pat.charAt(i)] = i;
        }
    }

    /**
     * 填充 gs(suffix数组) 和 prefix数组
     */
    private void genGs() {
        // 初始化，默认模式串中找不到和好后缀匹配的子串
        Arrays.fill(gs, -1);
        // 枚举所有公共后缀的结束索引
        // 从左侧开始枚举，这样的话，如果右侧出现了相同的公共后缀，会覆盖掉左侧的值
        for (int i = 0; i < m - 1; i++) {
            int j = i;
            // 公共后缀的长度
            int k = 0;
            // 从后缀最右侧的字符开始比较
            // m-1-k 表示模式串中倒数第k个字符
            while (j >= 0 && pat.charAt(j) == pat.charAt(m - 1 - k)) {
                k++;
                j--;
                gs[k] = j + 1;
            }
            if (j == -1) {
                //如果公共后缀子串也是模式串的前缀子串
                prefix[k] = true;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new BM("abd").find("abcacabdc"));
        System.out.println(new BM("caca").find("abcacabdc"));
        System.out.println(new BM("deadea").find("abcacabdc"));
        System.out.println(new BM("cd").find("aabbbacda"));
    }

}
