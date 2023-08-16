package collections;

import java.util.*;

public class Collections {

    public static void main(String[] args) {
//        List<String> aList = new ArrayList<>();
//        aList.add("hello");
//        aList.add("fello");
//        aList.add(0, "gello");
//
//        List<Integer> lList = new LinkedList<>();
//
//        lList.add(1);
//        lList.add(2);
//        lList.add(5);
//
//        Queue<String> qList = new LinkedList<>();
//
//        qList.offer("hello");
//        qList.offer("gello");
//        qList.offer("fello");
//
//        qList.peek();
//        qList.poll();
//
//        Deque<Integer> lDeList = new LinkedList<>();
//
//        lDeList.addFirst(1);
//        lDeList.addFirst(3);
//        lDeList.addFirst(5);
//        lDeList.add(8);
//        lDeList.addLast(6);
//
//
//        Map<Integer, String> map = new HashMap<>();
//
//        map.put(1, "test");
//        map.put(4, "test 2");
//
//        String s = map.get("test 2");
//
//
//        Set<String> strings = new HashSet<>();
//        strings.add("aaa");


        MyList<String> myList = new MyArrayList<>();
        myList.add("hello 1");
        myList.add("hello 2");


        System.out.println(myList.get(0));


    }
}
