package lambdatest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class App {
    private String context;

    public static void main(String[] args) {

        App app1 = new App("Context 1");
        App app2 = new App("Context 2");
        // app1.run1();
        // app2.run1();

        app1.run2();

    }

    public App(String context) {
        this.context = context;
    }

    private void run1() {
        List<String> list = Arrays.asList("a", "b", "c");

        list.stream().forEach(new MyConsumer());

        list.stream().forEach(theParameter -> {
            System.out.println("The value is " + theParameter + ", Context is " + context);
        });
    }

    private void run2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 8, 4, 2);

        list.stream().sorted().forEach(i -> {System.out.println("Sorted i: " + i);});

        int sum = 0;
        for (int i: list) {
            sum += i;
        }
        System.out.println("Silly sum is: " + sum);

        System.out.println(list.stream().collect(Collectors.summarizingInt(i->i)).getAverage());

        final Set<Integer> s = new HashSet<Integer>();
        list.forEach(i -> s.add(i));

        Set<Integer> s2 = list.stream().collect(Collectors.toSet());

        List<String> strs = list.stream().map(i -> {return Integer.toString(i);}).collect(Collectors.toList());
    }

}
