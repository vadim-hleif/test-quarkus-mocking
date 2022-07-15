package test.quarkus.mocking

import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Produces

open class BeanProducer {
    @Produces
    @ApplicationScoped
    fun createEngine(): Engine = Engine()
}