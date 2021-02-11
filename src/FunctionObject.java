import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionObject {

    protected static class MyMath{
        public static Integer triple(Integer x){
            return x*3;
        }
        public static Integer subtract(Integer x, Integer y){ return x-y;}
        public static Integer add(Integer x, Integer y){ return x+y;}
        public static Integer combineTwoAndThree(BiFunction<Integer, Integer, Integer> function){
            return function.apply(2,3);
        }

        public static Function<Integer, Integer> createMultiplier(Integer x){
            return (Integer y) -> x*y;
        }

    }

    public static void main(String[] args){
        Function<Integer, Integer> myTriple = MyMath::triple;
        System.out.println(myTriple.apply(5));

        System.out.println(MyMath.combineTwoAndThree(MyMath::add));
        System.out.println(MyMath.combineTwoAndThree(MyMath::subtract));
        System.out.println(MyMath.combineTwoAndThree((x,y) -> x+x-y-y));

        System.out.println(MyMath.createMultiplier(2).apply(3));
        System.out.println(MyMath.createMultiplier(10).apply(6));
    }
}
