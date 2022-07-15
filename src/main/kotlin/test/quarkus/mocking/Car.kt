package test.quarkus.mocking

import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class Car(private val engine: Engine) {

    fun launch(additionalRetries: Int): String {
        val engineState = engine.launch(additionalRetries)
        logClassAndHash("from codebase (NOT OK)", engine)

        return "car is $engineState"
    }

}