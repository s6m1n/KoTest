package study.coroutines.flow

import io.kotest.matchers.shouldBe
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.yield
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test

class StateFlowTest {

    private val result = mutableListOf<Int>()

    @BeforeEach
    fun setUp() {
        result.clear()
    }

    @Test
    fun `StateFlow는 항상 현재 값을 보유한다`() = runTest {
        val stateFlow = MutableStateFlow(0)

        val job = launch {
            stateFlow.collect { value ->
                println("${stateFlow.value} ${value}")
                result.add(value)
            }
        }
        yield()
        stateFlow.emit(1)
        stateFlow.emit(2)
        stateFlow.emit(3)

        delay(1000L)

        result shouldBe listOf(0, 1, 2, 3)
    }

    @Test
    fun `StateFlow는 value를 통해 즉시 값을 얻을 수 있다`() = runTest {
        val stateFlow = MutableStateFlow(100)

        result.add(stateFlow.value)

        stateFlow.value = 200

        result.add(stateFlow.value)

        result shouldBe listOf(100, 200)
    }
}
