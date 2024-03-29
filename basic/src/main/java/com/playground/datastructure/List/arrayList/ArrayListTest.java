package com.playground.datastructure.List.arrayList;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import java.util.stream.Collectors;

/**
 * @desc ArrayList遍历方式和效率的测试程序。
 *
 */
public class ArrayListTest {

    public static void main(String[] args) {
        List<String> list = null;
        list.stream().filter(s -> s.equals("1"))
            .map(o ->{
                return o + "2";
            }).collect(Collectors.toList());
        /*for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        isRandomAccessSupported(list);
        iteratorThroughRandomAccess(list);
        iteratorThroughIterator(list);
        iteratorThroughFor2(list);

//         stream access
        getList(list);*/

    }

    public static void getList(List list){
        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        list.stream().forEach(o -> System.out.println(o));
        endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println("iteratorThroughRandomAccess：" + interval + " ms");
    }

    private static void isRandomAccessSupported(List list) {
        if (list instanceof RandomAccess) {
            System.out.println("RandomAccess implemented!");
        } else {
            System.out.println("RandomAccess not implemented!");
        }

    }

    public static void iteratorThroughRandomAccess(List list) {

        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println("iteratorThroughRandomAccess：" + interval + " ms");
    }

    public static void iteratorThroughIterator(List list) {

        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        for (Iterator iter = list.iterator(); iter.hasNext(); ) {
            iter.next();
        }
        endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println("iteratorThroughIterator：" + interval + " ms");
    }


    public static void iteratorThroughFor2(List list) {

        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        for (Object obj : list) ;
        endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println("iteratorThroughFor2：" + interval + " ms");
    }
}
