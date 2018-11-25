package lambdatest;

import java.util.function.Consumer;

public class MyConsumer implements Consumer<String> {

    @Override
    public void accept(String t) {
        System.out.println("The value is " + t);
    }

}