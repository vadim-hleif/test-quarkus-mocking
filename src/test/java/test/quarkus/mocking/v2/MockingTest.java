package test.quarkus.mocking.v2;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static test.quarkus.mocking.v2.LoggingUtils.logClassAndHash;

@QuarkusTest
class MockingTest {

    @InjectMock
    Engine engine;

    @Inject
    Car car;

    @Test
    void testProducesAnnotation() {
        when(engine.launch(any())).thenReturn("not ready");
        assertEquals(engine.launch(1), "not ready");
        logClassAndHash("from test (OK)", engine);

        assertEquals(car.launch(1), "car is not ready");
    }

}