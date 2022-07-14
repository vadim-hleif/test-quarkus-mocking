package test.quarkus.mocking

import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class A(private val bean: B) {

    fun checkThatMockIsInjected(i: Int): String {
        logClassAndHash(label = "from annotation created (NOT OK)", obj = bean)
        return bean.someMethod(i)
    }

}
