package Stream;

import sun.net.www.content.text.Generic;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class streamPro {

    public static <T> Stream<T> collectionToStream(Collection<T> collection) {
        return Optional
                .ofNullable(collection)
                .map(Collection::stream)
                .orElseGet(Stream::empty);
    }

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1,2,3);
        List<String> strList = Arrays.asList("A","B", "C", "AA", "AB");
        List<String> strList2 = null;


        Stream<Integer> integerStream = collectionToStream(intList);
        Stream<String> stringStream = collectionToStream(strList);

        collectionToStream(strList)
                .filter(str->str.contains("A"))
                .map(String::length)
                .forEach(System.out::println);

        List<String> listOpt = Optional.ofNullable(strList2)
                .orElseGet((Supplier<? extends List<String>>) new ArrayList<String>());
        
        System.out.println("end");
    }
}
