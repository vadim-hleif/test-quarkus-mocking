package test.quarkus.mocking

import io.mockk.every
import io.quarkiverse.test.junit.mockk.InjectMock
import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import javax.inject.Inject

@QuarkusTest
open class MockingTest {

    @Inject
    lateinit var car: Car

    @InjectMock
    lateinit var engine: Engine

    @Test
    fun `two beans, one is created via producer, second one annotated -- it should work`() {
        every { engine.launch(any()) } returns "not ready"
        assertEquals(engine.launch(1), "not ready")
        logClassAndHash("from test (OK)", engine)

        assertEquals(car.launch(1), "car is not ready")
    }
}