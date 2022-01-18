import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.of;

public class Main {
    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(5);
//        list.add(3);
//        list.add(6);
//        list.add(1);
//        list.add(2);
//        list.add(8);
//        list.add(9);
//        list.add(0);
//        list.add(2);
//        list.add(9);
//        List<Integer> newList = list.stream()
//                .skip(3)
//                .filter(value -> value % 2 == 0)
//                .collect(Collectors.toList());
//        System.out.println(newList);
//
//        List<Integer> newList1 = list.stream()
//                .skip(3)
//                .limit(3)
//                .filter(value -> value % 2 == 0)
//                .collect(Collectors.toList());
//        System.out.println(newList1);
//
//        List<Integer> newList2 = list.stream()
//                .distinct()
//                .collect(Collectors.toList());
//        System.out.println(newList2);
//
//        long count = list.stream()
//                .filter(value -> value % 2 == 0)
//                .count();
//        System.out.println(count);
//
//        Optional<Integer> min = list.stream()
//                .filter(value -> value % 2 == 0)
//                .min((Integer::compareTo));
//        System.out.println(min);
//        min.ifPresent(System.out::println);
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(10));
        }
        System.out.println("изначальный первый поток: " + list);

        List<Integer> list1 = list.stream()
                .filter(value -> value % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("(1)количество чётных чисел: " + list1.size());
        System.out.println("--------------------------------------------------");

        List<Integer> list2 = list.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("(2)по возрастанию: " + list2);
        System.out.println("--------------------------------------------------");

        List<Integer> list3 = list.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("(2)по убыванию: " + list3);
        System.out.println("--------------------------------------------------");

        Optional<Integer> max = list.stream().max(Integer::compare);
        System.out.println("(3) максимальное: " + max.get());
        Optional<Integer> min = list.stream().min(Integer::compare);
        System.out.println("(3) минимальное: " + min.get());
        System.out.println("--------------------------------------------------");

        ArrayList<Integer> list00 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list00.add(random.nextInt(100));
        }
        System.out.println("изначальный второй поток: " + list00);

        List<Integer> list4 = list00.stream()
                .filter(value -> value > 20)
                .sorted()
                .collect(Collectors.toList());
        System.out.print("(4) 20+, по возр, *10: ");
        for (int a : list4) {
            System.out.print("[" + a * 10 + "] ");
        }
        System.out.println();
        System.out.println("--------------------------------------------------");

        Optional<Integer> list5 = list00.stream()
                .skip(5)
                .limit(10)
                .distinct()
                .max(Comparator.naturalOrder());
        System.out.println("(5)макс уникальное: " + list5.get() );
        System.out.println("--------------------------------------------------");

        List<Integer> list6 = list00.stream()
                .skip(5)
                .limit(10)
                .map(value -> value * 10)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.print("(6): ");
        for (int a : list6) {
            System.out.print("[" + a + 5 + "] ");
        }
        System.out.println();
        System.out.println("--------------------------------------------------");
    }
}
