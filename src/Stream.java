import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    public static List<String> longerThanFiveChars(List<String> list){
        Predicate<String> isLongerThanFiveChar = s -> s.length() > 5;
        return list.stream().filter(isLongerThanFiveChar).collect(Collectors.toList());
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4));
        System.out.println("before doubling " + (list));
        System.out.println("after doubling " + doubled(list));
        System.out.println("after isEven" + evens(list));

        List<String> words = new ArrayList<>(Arrays.asList("a", "ab", "abc", "abcd", "abcde", "abcdef"," abcdefg"));
        System.out.println("before filter " + words);
        System.out.println("after filter " + longerThanFiveChars(words));

    }
}
