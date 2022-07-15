package test.quarkus.mocking.v2;

import javax.enterprise.context.ApplicationScoped;

import static test.quarkus.mocking.v2.LoggingUtils.logClassAndHash;

@ApplicationScoped
public class Car {
    private final Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public String launch(Integer additionalRetries) {
        String engineState = engine.launch(additionalRetries);
        logClassAndHash("from codebase (OK)", engine);

        return "car is %s".formatted(engineState);
    }
}
