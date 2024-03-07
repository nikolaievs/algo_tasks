package merge_ranges

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

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
        assertThat(expected).containsExactlyInAnyOrderElementsOf(mergeRanges(initial))
    }
}