package test.quarkus.mocking

open class Engine {
    private val config = Config()

    fun launch(retryTimes: Int): String {
        println("going to retry ${retryTimes + config.retryTimes} times")

        return "ready"
    }

}