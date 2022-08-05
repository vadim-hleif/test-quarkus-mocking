package test.quarkus.mocking

import org.springframework.stereotype.Component

@Component
class Car(private val engine: Engine) {

    fun launch(additionalRetries: Int): String {
        val engineState = engine.launch(additionalRetries)
        logClassAndHash("from codebase (NOT OK)", engine)

        return "car is $engineState"
    }

}