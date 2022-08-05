package test.quarkus.mocking

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class BeanProducer {

    @Bean
    fun createEngine(): Engine {
        return Engine()
    }
}