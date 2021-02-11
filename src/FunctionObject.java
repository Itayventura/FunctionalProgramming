import java.util.function.Function;

public class FunctionObject {

    protected static class MyMath{
        public static Integer triple(Integer x){
            return x*3;
        }
    }

    public static void main(String[] args){
        Function<Integer, Integer> myTriple = MyMath::triple;
        System.out.println(myTriple.apply(5));
    }
}
