import java.util.function.BiFunction;

public class MyBiFunction {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = (x,y) -> x+y;
        System.out.println(add.apply(1,2));
    }
}
