package test.quarkus.mocking

class B(private val configs: SomeConfigs = SomeConfigs()) {

    fun someMethod(someArgument: Int): String {
        println(configs.retryLimit + someArgument)
        return "result"
    }

}
