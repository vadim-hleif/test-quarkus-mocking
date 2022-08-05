package test.quarkus.mocking

import io.kotest.matchers.shouldBe
import io.quarkus.test.junit.QuarkusTest
import io.quarkus.test.junit.mockito.InjectMock
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import javax.inject.Inject


@QuarkusTest
internal class MockingTest {

    private  val engineManuallyCreated: Engine = mock()
    private val carManuallyCreated: Car = Car(engineManuallyCreated)

    @Test
    fun `no Quarkus CDI -- OK`() {
        whenever(engineManuallyCreated.launch(any())).thenReturn("not ready")
        assertEquals(engineManuallyCreated.launch(1), "not ready")
        logClassAndHash("from test (OK)", engineManuallyCreated)

        assertEquals(carManuallyCreated.launch(1), "car is not ready")
    }

    @InjectMock
    private lateinit var engine: Engine

    @Inject
    private lateinit var car: Car

    @Test
    fun `Quarkus CDI -- NOT OK`() {
        whenever(engine.launch(any())).thenReturn("not ready")
        assertEquals(engine.launch(1), "not ready")
        logClassAndHash("from test (OK)", engine)

        // in this class the real mock is injected
        engine.launch(1) shouldBe "not ready"

        // but in application context it's not mocked
        assertEquals(car.launch(1), "car is not ready")
    }
}