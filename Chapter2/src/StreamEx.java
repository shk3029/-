/*
     ** 스트림 **
     1. 생성하기 : 스트림 인스턴스 생성
     2. 가공하기 : 필터링 및 맵 등 원하는 결과를 만들어가는 중간 작업
     3. 결과만들기 : 최종적으로 결과를 만들어내는 작업
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class StreamEx {

    public static void main(String[] args) {
        StreamEx streamEx = new StreamEx();
        streamEx.stream_Array();
        streamEx.correction_stream();
        streamEx.stream_builder();
        streamEx.steam_paralle();

    }

    // 배열 스트림 (Arrays.stream)
    public void stream_Array() {
        String[] arr = new String[]{"a","b", "c"};
        Stream<String> stream = Arrays.stream(arr);
        Stream<String> streamExOfArrayPart = Arrays.stream(arr, 1, 3); // 1~2요소 [b,c]
        streamExOfArrayPart.forEach(System.out::println);
    }

    /*
        컬랙션 스트림 (Correction.stream)
        컬렉션 타입(Collection, List, Set)의 경우 인터페이스에 추가된 디폴트 메소드 stream 을 이용해서 스트림을 만들 수 있습니다.
     */
    public void correction_stream() {
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> stream = streamOf(list);
        Stream<String> parallelStream = list.parallelStream(); // 병럴처리 스트림
        parallelStream.peek(System.out::println);
    }


    public Stream<String> streamOf(List<String> list) {
        return list == null || list.isEmpty()
                ? Stream.empty()
                : list.stream();
    }

    /*
        Stream.builder()
        빌더(Builder)를 사용하면 스트림에 직접적으로 원하는 값을 넣을 수 있습니다. 마지막에 build 메소드로 스트림을 리턴합니다.
     */
    public void stream_builder() {
        Stream<String> builderStream =
                Stream.<String>builder()
                    .add("js").add("yo").add("ka")
                    .build();
        System.out.println("steamBuilder");
    }

    /*
      Stream.generate()
      generate 메소드를 이용하면 Supplier<T> 에 해당하는 람다로 값을 넣을 수 있습니다.
      Supplier<T> 는 인자는 없고 리턴값만 있는 함수형 인터페이스죠. 람다에서 리턴하는 값이 들어갑니다.
    */
    public void stream_generate() {
        Stream.generate(() -> "jongseon").limit(5);
     }

     /*
        Stream.iterate()
        iterate 메소드를 이용하면 초기값과 해당 값을 다루는 람다를 이용해서 스트림에 들어갈 요소를 만듭니다.
        다음 예제에서는 30이 초기값이고 값이 2씩 증가하는 값들이 들어가게 됩니다.
        즉 요소가 다음 요소의 인풋으로 들어갑니다. 이 방법도 스트림의 사이즈가 무한하기 때문에 특정 사이즈로 제한해야 합니다.
      */
     public void stream_iterate() {
         Stream<Integer> integerStream = Stream.iterate(30, n -> n+2).limit(5);
     }


     public void steam_paralle() {
        List<String> ex = Arrays.asList("a", "b", "c");
        List<String> lst = new ArrayList<String>(Arrays.asList("a,b,c,d","a","b"));
        lst.add("a");
        System.out.println(lst.iterator());
     }

}












