package streamapi;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.*;

class Test {
    public Test() {}
    public static void someStat(Test t) {
        System.out.println(Thread.currentThread());
    }
}

public class StreamApi {
    public static void main(String[] args) throws IOException {
        // Creation
        Stream<Path> names = Files.list(Paths.get("."));
        IntStream nums = IntStream.of(2,1,8,4,3,8);
        IntStream rnge = IntStream.rangeClosed(1, 25);
        
        ArrayList<String> emps = new ArrayList<>();
        emps.add("Mike"); emps.add("Bob");  emps.add("Alex");
        emps.add("Tom");  emps.add("Ann");  emps.add("Pite");
        
        Stream<String> strEmps = emps.stream(); 
        Stream<String> parEmps = emps.parallelStream();
        
        Stream<Path>  parNames = names.parallel();
        System.out.println(names.isParallel());
        
        DoubleStream many = DoubleStream.generate(()->Math.random());
        
        Stream<String>  langs = Stream.<String>builder()
                .add("Java").add("C++").add("Scala").add("R")
                .build();
        
        IntStream.iterate(1, i-> i+3)           // бесконечный поток
                .sorted()                       // его НЕльзя!! отсортировать
                .forEach(System.out::print);    // самый кjроткий вариан печати

        // объединение 2-х потоков. Данные первого, а затем второго.
        Stream.concat(langs, strEmps).forEach(System.out::println);  
        
        // Зачем?
        int sum = 0;
        int[] data = {2,1,8,4,3,8};
        for(var item : data) {
            if(item%2==0) sum+=item;
        }
        System.out.println(sum);
        
        IntStream nums2 = IntStream.of(2,1,8,4,3,8);
        System.out.println(nums2.sum());
        System.out.println(nums2.filter(i->i%2==0).reduce(0, (a,b)->a+b));
        
        // intermediate operations
        IntStream.of(2,1,8,4,3,8).distinct().sorted().forEach(i->System.out.print(i+" "));
        System.out.println(IntStream.of(2,1,8,4,3,8).allMatch(i->i>0));
                
        System.out.println();
        System.out.println();
        
        // parallel stream
        ArrayList<Test> list=new ArrayList<>();
        for(int i=1; i<=10; ++i)   list.add(new Test());
        list.stream().parallel().forEach(Test::someStat);
        
        langs.mapToInt(i->i.length()).skip(1).forEach(i->System.out.print(i+" "));
        langs.mapToInt(i->i.length())
             .peek(i->System.out.println("Get "+i)) // Отладка!
             .forEach(System.out::println);
        
        IntStream is = IntStream.iterate(1, i-> i+3);
        is.dropWhile( i-> i<1000).limit(10).forEach(System.out::println);

        var res = nums.filter(i->i>21).findFirst();
        System.out.println(res);
    }    
}
