package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        var compare = year.compareTo(other.year)
        if (compare == 0) {
            compare = month.compareTo(other.month)
        }
        if (compare == 0) {
            compare = dayOfMonth.compareTo(other.dayOfMonth)
        }
        return compare
    }
}

operator fun MyDate.plus(timeInterval: TimeInterval) = this.addTimeIntervals(timeInterval, 1)
operator fun MyDate.plus(r: RepeatedTimeInterval) = this.addTimeIntervals(r.ti, r.n)

operator fun MyDate.rangeTo(other: MyDate) = DateRange(this, other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}
class RepeatedTimeInterval(val ti: TimeInterval, val n: Int)
operator fun TimeInterval.times(n: Int) = RepeatedTimeInterval(this, n)

class DateRange(val start: MyDate, val endInclusive: MyDate) : Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> = DateIterator(this)

    operator fun contains(d: MyDate) = (start <= d) && (d <= endInclusive)
}

class DateIterator(val dateRange: DateRange) : Iterator<MyDate> {

    var current: MyDate = dateRange.start

    override fun hasNext() = current <= dateRange.endInclusive


    override fun next(): MyDate {
        val result = current
        current = current.addTimeIntervals(TimeInterval.DAY, 1)
        return result
    }

}
