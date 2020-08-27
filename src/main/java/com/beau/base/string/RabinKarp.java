package com.beau.base.string;

import org.junit.Test;

/**
 * @author BeauFang
 * Date: 2020/8/25
 */
public class RabinKarp {

    // 基数，相当于 256 进制，如果只映射 a-z,可以用 26
    public final int D = 256;
    // 质数，用于取模。用质数取模，可以减少 hash 冲突
    public final int Q = 9997;

    public int find(String txt, String pat) {
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int patHash = 0, txtHash = 0;

        // 计算模式串，和主串 0 开始的子串 hash 值
        for (i = 0; i < M; i++) {
            patHash = (D * patHash + pat.charAt(i)) % Q;
            txtHash = (D * txtHash + txt.charAt(i)) % Q;
        }

        int highestPow = 1;  // pow(256, M-1)
        for (i = 0; i < M - 1; i++) {
            highestPow = (highestPow * D) % Q;
        }

        for (i = 0; i <= N - M; i++) { // 枚举起点
            // hash 值相同，做进一步比较
            if (patHash == txtHash) {
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j))
                        break;
                }
                if (j == M)
                    return i;
            }
            if (i < N - M) {
                txtHash = (D * (txtHash - txt.charAt(i) * highestPow) + txt.charAt(i + M)) % Q;
                if (txtHash < 0) {
                    txtHash += Q;
                }
            }
        }
        return -1;
    }

    @Test
    public void test() {
        System.out.println(find("aabbbacda", "da"));
        System.out.println(find("aabbbacda", "cd"));
        System.out.println(find("aabbbacda", "ce"));
        System.out.println(find("aabbbacda", "aa"));
    }
}
