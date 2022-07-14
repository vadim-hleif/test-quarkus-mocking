package test.quarkus.mocking

import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Produces


class BeansProvider {

    @Produces
    @ApplicationScoped
    fun b(): B = B()

}
