package com.epam.binary_tree_map;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        BinaryTreeMap<Integer, String> map = new BinaryTreeMap<>();

        System.out.println("---- isEmpty");
        System.out.println(map.isEmpty());

        System.out.println("---- size");
        System.out.println(map.size());

        map.put(111, "aaa");
        map.put(222, "bbb");
        map.put(333, "ccc");
        map.put(444, "www");

        System.out.println("---- isEmpty");
        System.out.println(map.isEmpty());

        System.out.println("---- put");
        System.out.println(map.put(555, "ppp"));
        System.out.println(map.put(555, "eee"));

        System.out.println("---- get");
        System.out.println(map.get(777));
        System.out.println(map.get(555));

        System.out.println("---- keySet()");
        System.out.println(map.keySet().toString());

        System.out.println("---- size()");
        System.out.println(map.size());

        System.out.println("---- entrySet()");
        System.out.println(map.entrySet().toString());

        System.out.println("---- remove()");
        System.out.println(map.remove(555));

        System.out.println("---- entrySet()");
        System.out.println(map.entrySet().toString());

        System.out.println("---- size()");
        System.out.println(map.size());

        System.out.println("---- keySet()");
        System.out.println(map.keySet().toString());

        System.out.println("---- values()");
        System.out.println(map.values().toString());

        System.out.println("---- containsValue()");
        System.out.println(map.containsValue("www"));
        System.out.println(map.containsValue("wwwasdasd"));
        System.out.println(map.containsValue("aaa"));
        System.out.println(map.containsValue("bbb"));
        System.out.println(map.containsValue("aaawefsczx"));

        System.out.println("---- containsKey()");
        System.out.println(map.containsKey(111));
        System.out.println(map.containsKey(222));
        System.out.println(map.containsKey(234234));
        System.out.println(map.containsKey(333));
        System.out.println(map.containsKey(234444324));

        Map<Integer, String> map2 = new HashMap<>();
        map2.put(8888, "AAAAAAAAAA");
        map2.put(9999, "VVVVVVVVVV");
        map2.put(1234, "KKKKKKKKKK");

        map.putAll(map2);
        System.out.println("---- putAll()");
        System.out.println(map.entrySet().toString());

        map.clear();
        System.out.println("---- clear()");
        System.out.println("isEmpty = " + map.isEmpty());
    }

}
