package merge_ranges

import kotlin.math.max
import kotlin.math.min

/**
 *
 * TASK
 *
 * Ranges
 *
 * Your program will be given a set of ranges. Each range consists of a start integer and
 * an end integer. The start integer will always be less than the end integer
 *
 * Example input:
 * { {100 200} {2 9} {1 5} {12 14} {16 20} {21 25} {19 23} }
 *
 * The program should merge any "overlapping" ranges and output the resulting set of
 * distinct ranges (in any order).
 * You can assume the number of ranges will be reasonably small, so don't worry too much
 * about efficiency initially.
 * We might discuss how to improve performance later.
 * There's no need to produce a complete runnable program, but try to go into as much
 * detail as possible when describing your solution.
 * If you feel the problem is under-specified, or if you're unsure about anything, please ask
 * of course!
 *
 * Example input:
 * { {100 200} {2 9} {1 5} {12 14} {16 20} {21 25} {19 23} }
 * Example output from the example input above would be:
 * { {100 200} {1 9} {12 14} {16 25} }
 */
fun mergeRanges(ranges: List<IntRange>): List<IntRange> = ranges.fold(mutableListOf()) { acc, range ->
    acc.filter { el ->
        el.first >= range.first && el.first <= range.last
                || el.last >= range.first && el.last <= range.last
    }.let { elements ->
        if (acc.removeAll(elements)){
            val lower = elements.minBy { it.first }.first
            val upper = elements.maxBy { it.last }.last
            acc.add(IntRange(min(lower, range.first), max(upper, range.last)))

        } else acc.add(range)
    }
    acc
}
