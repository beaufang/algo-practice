package com.beau;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author BeauFang
 * Date: 2020/8/7
 */
public class BastTest {

    /**
     *  Collections.singletonList 生成的集合时不可变的，无法进行修改操作
     */
    @Test
    public void testUnsupportedOperationException() {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, Collections.singletonList(1));
        map.get(1).add(2);
    }
}
