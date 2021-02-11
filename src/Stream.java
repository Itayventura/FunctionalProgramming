import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {

    public static List<Integer> doubled(List<Integer> list){
        return list.stream().map(x -> 2*x).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4));
        System.out.println("before doubling " + (list));
        System.out.println("after doubling " + doubled(list));

    }
}
