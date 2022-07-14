package test.quarkus.mocking

import io.kotest.matchers.shouldBe
import io.quarkus.test.junit.QuarkusTest
import io.quarkus.test.junit.mockito.InjectMock
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.eq
import org.mockito.kotlin.whenever
import javax.inject.Inject

@QuarkusTest
internal class MockingTest {

    @Inject
    @InjectMocks
    private lateinit var annotationCreatedBean: A

    @InjectMock
    private lateinit var methodCreatedBean: B

    @Test
    fun `two beans, one is created via producer, second one annotated -- it should work`() {
        val mockedResult = "another string"
        whenever(methodCreatedBean.someMethod(eq(42))) doReturn mockedResult

        logClassAndHash(label = "from test (OK)", obj = methodCreatedBean)
        methodCreatedBean.someMethod(42) shouldBe mockedResult

        annotationCreatedBean.checkThatMockIsInjected(42) shouldBe mockedResult
    }
}