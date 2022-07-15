package test.quarkus.mocking

import io.quarkus.test.junit.QuarkusTest
import io.quarkus.test.junit.mockito.InjectMock
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import javax.inject.Inject


@QuarkusTest
internal class MockingTest {

    @Inject
    private lateinit var car: Car

    @InjectMock
    private lateinit var engine: Engine

    @Test
    fun `two beans, one is created via producer, second one annotated -- it should work`() {
        whenever(engine.launch(any())).thenReturn("not ready")
        assertEquals(engine.launch(1), "not ready")
        logClassAndHash("from test (OK)", engine)

        assertEquals(car.launch(1), "car is not ready")
    }
}