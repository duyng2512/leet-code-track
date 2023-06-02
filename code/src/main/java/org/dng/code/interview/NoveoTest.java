package org.dng.code.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NoveoTest {

    public static void main1(String[] args) {
        List<? extends Number> list1 = new ArrayList<>();
        // list1.add(100);
        // list1.get(0);

        List<Number> list2 = new ArrayList<>();
        list2.add(10);
        list2.add(10.0f);
        list2.forEach(System.out::println);

    }

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        Map<Boolean, List<Integer>> partitions = stream.collect(Collectors.partitioningBy(n -> (n > 3)));
        List<Integer> list1 = new ArrayList<>(partitions.get(true));
        List<Integer> list2 = new ArrayList<>(partitions.get(false));

        System.out.println(list1);
        System.out.println(list2);

    }

}
