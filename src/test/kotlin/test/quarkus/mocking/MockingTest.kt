package test.quarkus.mocking

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ContextConfiguration

@SpringBootTest
@ContextConfiguration
internal class MockingTest {

    private val engineManuallyCreated: Engine = mock()
    private val carManuallyCreated: Car = Car(engineManuallyCreated)

    @Test
    fun `no Spring DI -- OK`() {
        whenever(engineManuallyCreated.launch(any())).thenReturn("not ready")
        assertEquals(engineManuallyCreated.launch(1), "not ready")
        logClassAndHash("from test (OK)", engineManuallyCreated)

        assertEquals(carManuallyCreated.launch(1), "car is not ready")
    }

    @MockBean
    private lateinit var engine: Engine

    @Autowired
    private lateinit var car: Car

    @Test
    fun `Spring DI -- OK`() {
        whenever(engine.launch(any())).thenReturn("not ready")
        assertEquals(engine.launch(1), "not ready")
        logClassAndHash("from test (OK)", engine)

        assertEquals(car.launch(1), "car is not ready")
    }
}