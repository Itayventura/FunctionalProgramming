import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Stream {

    public static List<Integer> doubled(List<Integer> list){
        return list.stream().map(x -> 2*x).collect(Collectors.toList());
    }

    public static List<Integer> evens(List<Integer> list){
        Predicate<Integer> isEven = x -> (x&1) == 0;
        return list.stream().filter(isEven).collect(Collectors.toList());
    }

    public static List<String> longerThan(int numOfChars, List<String> list){
        Function<Integer, Predicate<String>> predicateGenerator = x -> str -> str.length() > x;
        Predicate<String> isLongerThan = predicateGenerator.apply(numOfChars);
        return list.stream().filter(isLongerThan).collect(Collectors.toList());
    }

    public static int sum(List<Integer> list){

        BinaryOperator<Integer> calcSum = (acc, x) -> acc + x;
        BinaryOperator<Integer> calcSumSimplified = Integer::sum;
        return list.stream().reduce(0, calcSum);
    }

    public static String join(List<String> words){
        //return String.join(",", words);
        return words.stream().collect(Collectors.joining(","));
    }

    public static Set<Integer> set(List<Integer> list){
        //return new HashSet<>(list);
        return list.stream().collect(Collectors.toSet());
    }

    public static Map<Integer, List<String>> groupBy(List<String> words){
        //return words.stream().collect(Collectors.groupingBy(String::length));
        return words.stream().collect(Collectors.groupingBy(word -> word.length()));
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4));
        System.out.println("before doubling " + (list));
        System.out.println("after doubling " + doubled(list));
        System.out.println("after isEven" + evens(list));

        List<String> words = new ArrayList<>(Arrays.asList("a", "ab", "abc", "abcd", "abcde", "abcdef"," abcdefg"));
        System.out.println("before filter with 5 " + words);
        System.out.println("after filter with 5 " + longerThan(5, words));

        System.out.println("sum: " + sum(list));

        List<Integer> anotherList = new ArrayList<>(Arrays.asList(1,2,3,4,1,2,3,2,2,3));

        System.out.println("before set " + (anotherList));
        System.out.println("after set " + set(anotherList));

        System.out.println(join(longerThan(5, words)));

        System.out.println("how many words equals to a? " + words.stream().filter(s -> s.equals("a")).collect(Collectors.counting()));

        System.out.println(groupBy(words));

    }
}
