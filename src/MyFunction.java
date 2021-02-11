import java.util.function.BiFunction;

public class MyFunction {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = (x,y) -> x+y;
        System.out.println(add.apply(1,2));

        TriFunction<Integer, Integer, Integer, Integer> addThree = (x, y, z) -> x+y+z;
        System.out.println(addThree.apply(1,2,3));

        NoArgsFunction<String> noArgsFunction = () -> "hello";
        System.out.println(noArgsFunction.apply());
    }
}
