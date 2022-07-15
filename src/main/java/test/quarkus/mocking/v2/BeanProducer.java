package test.quarkus.mocking.v2;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

public class BeanProducer {

    @Produces
    @ApplicationScoped
    Engine createEngine() {
        return new Engine();
    }

}
