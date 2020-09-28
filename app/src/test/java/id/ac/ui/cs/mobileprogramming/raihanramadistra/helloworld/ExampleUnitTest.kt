package id.ac.ui.cs.mobileprogramming.raihanramadistra.helloworld

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun testIncrement() {
        val counter = Counter()
        assertEquals(0, counter.value)
        counter.increment()
        assertEquals(1, counter.value)
    }

    @Test
    fun testDecrement() {
        val counter = Counter()
        assertEquals(0, counter.value)
        counter.decrement()
        assertEquals(-1, counter.value)
    }
}