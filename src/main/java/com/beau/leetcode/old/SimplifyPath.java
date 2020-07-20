package com.beau.leetcode.old;

// 71 简化路径
public class SimplifyPath {

    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "/";
        }
        String[] ps = path.split("/");
        String res = "";
        for (String p : ps) {
            if (p.equals(".") || p.equals("") || (p.equals("..") && res.lastIndexOf("/") < 0)) {
                continue;
            }else if (p.equals("..") && res.lastIndexOf("/") >= 0) {
                res = res.substring(0, res.lastIndexOf("/"));
            } else {
                res = res +  "/" + p;
            }
        }
        if (res.length() == 0) {
            return "/";
        }
        return res;
    }

    public static void main(String[] args) {
        SimplifyPath s = new SimplifyPath();
        System.out.println(s.simplifyPath("/a/./b/../../c/"));
        System.out.println(s.simplifyPath("/"));
        System.out.println(s.simplifyPath("/../"));
        System.out.println(s.simplifyPath("/a//b////c/d//././/.."));
    }

}