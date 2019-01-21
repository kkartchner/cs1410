/**
 * Class definition for GregorianDate subclass used for instantiating, modifying, and printing dates of the Gregorian Calendar.
 *
 * @author Ky Kartchner
 * @version 1.0
 */
public class GregorianDate extends Date {
    /**
     * Sets to default of today's date
     */
    GregorianDate() {
        Date date = new GregorianDate(1970, 1, 1);   // Initialize date to 1/1/1970

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
    GregorianDate(int year, int month, int day) {
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
        if (year % 4 == 0) {              //  If year is divisible by 4
            if (year % 100 == 0) {        //      If it is also divisible by 100
                return year % 400 == 0;  //          It's a leap year if also divisible by 400, but common if not
            } else {                          //      Else
                return true;                  //          It is a leap year, so return true
            }                                 //      End If
        } else {                              //  Else
            return false;                     //      It is a common year, so return false
        }
    }
}