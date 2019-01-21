/**
 * Class definition for JulianDate subclass used for instantiating, modifying, and printing dates of the Julian Calendar.
 *
 * @author Ky Kartchner
 * @version 1.0
 */
public class JulianDate extends Date {
    /**
     * Sets to default of today's date
     */
    JulianDate() {
        Date date = new JulianDate(1, 1, 1);   // Initialize date to 1/1/1
        int IN_BETWEEN_DAYS = 719_164;               // Days in between 1/1/1 and 1/1/1970 (Gregorian)
        date.addDays(IN_BETWEEN_DAYS);

        final int MILLISECONDS_PER_DAY = 86_400_000;
        long millisecondsPastEpoch = System.currentTimeMillis() + java.util.TimeZone.getDefault().getRawOffset();
        int daysPastEpoch = (int) (millisecondsPastEpoch / MILLISECONDS_PER_DAY);

        date.addDays(daysPastEpoch);

        super.year = date.year;
        super.month = date.month;
        super.day = date.day;
    }

    /**
     * Sets to provided date
     *
     * @param year Year to set
     * @param month Month to set
     * @param day Day to set
     */
    JulianDate(int year, int month, int day) {
        super.year = year;
        super.month = month;
        super.day = day;
    }

    /**
     * Returns whether the specified year is a leap year
     *
     * @param year The year to check
     * @return True if the year is a leap year; False if not
     */
    @Override
    protected boolean isLeapYear(int year) {
        return year % 4 == 0;   // If year is divisible by 4
    }
}