package test.quarkus.mocking

import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Produces

class BeanProducer {
    @Produces
    @ApplicationScoped
    fun createEngine(): Engine {
        return Engine()
    }
}