package test.quarkus.mocking

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan

@SpringBootApplication
@ConfigurationPropertiesScan
class App

fun main(args: Array<String>) {
    SpringApplication.run(App::class.java, *args)
}