package stream;

import java.util.Arrays;
import java.util.List;

public class MapAndFlatMap {

    public static void main(String[] args){
        List<String> words = Arrays.asList("Hello", "World");
        words.stream()
                .flatMap((String line) -> Arrays.stream(line.split(""))) //代表切除空字串，所以每切一次就讓每個字換行。執行動作後收集結果
                .distinct() // 把不一樣字母分割出來。
                .forEach(System.out::println);
        words.stream()
                .map((String line) -> Arrays.stream(line.split(""))) //代表切除空字串，所以每切一次就讓每個字換行。 單純ㄧ對ㄧ轉換
                .distinct() // 把不一樣字母分割出來。
                .forEach(System.out::println);
    }
}
