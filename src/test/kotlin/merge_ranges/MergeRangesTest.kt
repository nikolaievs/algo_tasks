package merge_ranges

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MergeRangesTest {
    @Test
    fun `should merge ranges correctly`() {
        // given
        val initial = listOf(
            100..200, 2..9, 1..5, 12..14, 16..20, 21..25, 19..23, 5..11
        )
        val expected = listOf(
            100..200, 1..11, 12..14, 16..25,
        )

        // when and then
        assertEquals(expected, mergeRanges(initial))
    }
}