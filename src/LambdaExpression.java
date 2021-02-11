import java.util.function.Function;

public class LambdaExpression {

    public static void main(String[] args) {
        Function<Integer, Integer> abs = x -> x < 0? -x:x;
        System.out.println(abs.apply(-1) + abs.apply(1));
    }
}
