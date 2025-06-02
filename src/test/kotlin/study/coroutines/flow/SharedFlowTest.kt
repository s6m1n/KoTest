package study.coroutines.flow

import io.kotest.matchers.shouldBe
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test

class SharedFlowTest {
    private val result = mutableListOf<Int>()

    @BeforeEach
    fun setUp() {
        result.clear()
    }

    @Test
    fun `SharedFlow는 최근 값을 새 구독자에게 전달할 수 있다`() = runTest {
        val sharedFlow = MutableSharedFlow<Int>(replay = 2)

        sharedFlow.emit(1)
        sharedFlow.emit(2)
        sharedFlow.emit(3)

        println(sharedFlow)

        val job = launch {
            sharedFlow.collect { value ->
                result.add(value)
            }
        }

        job.join()
        result shouldBe listOf(2, 3)
    }

    @Test
    fun `SharedFlow는 기본적으로 최근 값을 보존하지 않는다`() = runTest {
        val sharedFlow = MutableSharedFlow<Int>() // replay = 0

        sharedFlow.emit(1)
        sharedFlow.emit(2)

        delay(100)

        sharedFlow.collect { value ->
            result.add(value)
            if (result.size == 1) cancel() // 1개만 받고 종료
        }

        println(result) // [] (값 없음) 또는 동시성이 맞으면 이후 emit만 받을 수 있음
    }
}
