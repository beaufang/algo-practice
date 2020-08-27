package com.beau.base.string;

import java.util.*;

/**
 * @author BeauFang
 * Date: 2020/8/27
 */
public class AC {

    // trie 树根节点
    private final AcNode root;
    // 模式串
    private final Set<String> pats;

    public AC(Set<String> pats) {
        this.pats = pats;
        // 根节点用无效字符占位
        root = new AcNode('#');
        buildTrie();
        buildFailurePointer();
    }

    /**
     * 构建 Trie 树，将所有模式串插入 Trie 树
     */
    private void buildTrie() {
        for (String pat : pats) {
            AcNode cur = root;
            for (char c : pat.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new AcNode(c);
                }
                cur = cur.children[c - 'a'];
            }
            cur.isEndingChar = true;
            cur.length = pat.length();
        }
    }


    /**
     * BFS 构建失败指针
     */
    private void buildFailurePointer() {
        Queue<AcNode> queue = new LinkedList<>();
        root.fail = null;
        queue.add(root);
        while (!queue.isEmpty()) {
            AcNode p = queue.remove();
            // 为所有的 p 的子节点添加失败指针
            for (AcNode pc : p.children) {
                if (pc == null) continue;
                if (p == root) {
                    // 如果是第二层(只有一个字符，不存在后缀)，失败指针直接指向 root
                    pc.fail = root;
                } else {
                    // 沿着父节点的失败指针查找，直到在失败指针所指的孩子节点存在查找的字符
                    AcNode q = p.fail;
                    while (q != null) {
                        AcNode qc = q.children[pc.data - 'a'];
                        if (qc != null) {
                            pc.fail = qc;
                            break;
                        }
                        q = q.fail;
                    }
                    if (q == null) {
                        pc.fail = root;
                    }
                }
                queue.add(pc);
            }
        }
    }


    public void match(String txt) { // text是主串
        int n = txt.length();
        AcNode p = root;
        for (int i = 0; i < n; i++) {
            int idx = txt.charAt(i) - 'a';
            while (p.children[idx] == null && p != root) {
                // 失败指针发挥作用的地方
                p = p.fail;
            }
            p = p.children[idx];
            if (p == null) p = root; // 如果没有匹配的，从root开始重新匹配
            AcNode tmp = p;
            // 打印出可以匹配的模式串
            while (tmp != root) {
                if (tmp.isEndingChar) {
                    int pos = i - tmp.length + 1;
                    System.out.println("匹配起始下标" + pos + "; 长度" + tmp.length
                            + " 单词 " + txt.substring(pos, pos + tmp.length));
                }
                // 当前字符的后缀，可能也是一个适配的单词
                tmp = tmp.fail;
            }
        }
    }

    static class AcNode {
        public char data;
        // 字符集只包含a~z这26个字符
        public AcNode[] children = new AcNode[26];
        // 结尾字符为true
        public boolean isEndingChar = false;
        // 当isEndingChar=true时，记录模式串长度
        public int length = -1;
        // 失败指针
        public AcNode fail;

        public AcNode(char data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Set<String> pats = new HashSet<>(Arrays.asList("she", "he", "her", "this", "his", "is"));
        AC ac = new AC(pats);
        ac.match("asherthis");
    }
}
