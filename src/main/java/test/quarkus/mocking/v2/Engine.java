package test.quarkus.mocking.v2;

public class Engine {

    private final Config config = new Config();

    public String launch(Integer arg) {
        System.out.printf("going to retry %d times %n", arg + config.getRetryTimes());

        return "ready";
    }
}
