/**
 * Class definition for Date base class used for instantiating, modifying, and printing dates of extended date classes.
 *
 * @author Ky Kartchner
 * @version 1.0
 */
public abstract class Date {
    /**
     * Stores the value of the year
     */
    protected int year;

    /**
     * Stores the value of the month
     */
    protected int month;

    /**
     * Stores the value of the day
     */
    protected int day;


    /**
     * Adds the specified number of days
     *
     * @param days The number of days to add to the date
     */
    void addDays(int days) {
        int daysLeftToAdd = days;
        int lastDayOfMonth = getNumberOfDaysInMonth(this.year, this.month);

        while (daysLeftToAdd > 0) {
            this.day++;
            if (this.day > lastDayOfMonth) {
                this.day = 1;
                this.month++;

                if (this.month > 12) {
                    this.month = 1;
                    this.year++;
                }
                lastDayOfMonth = getNumberOfDaysInMonth(this.year, this.month);
            }
            daysLeftToAdd--;
        }
    }

    /**
     * Subtracts the specified number of days
     *
     * @param days The number of days to subtract from the date
     */
    void subtractDays(int days) {
        int daysLeftToSubtract = days;

        while (daysLeftToSubtract > 0) {
            this.day--;
            if (this.day < 1) {
                this.month--;
                if (this.month < 1) {
                    this.month = 12;
                    this.year--;
                }
                this.day = getNumberOfDaysInMonth(this.year, this.month);   // Set to last day of the new month
            }
            daysLeftToSubtract--;
        }
    }

    /**
     * Returns whether or not the GregorianDate is in a leap year
     *
     * @return True if is a leap year; False if not
     */
    boolean isLeapYear() {
        return isLeapYear(this.year);
    }

    /**
     * Prints the date (without a carriage return) in mm/dd/yyyy format
     */
    void printShortDate() {
        System.out.printf("%2d/%2d/%4d", this.month, this.day, this.year);
    }

    /**
     * Prints the date (without a carriage return) in Monthname dd, yyyy format
     */
    void printLongDate() {
        System.out.printf("%s %2d, %4d", getCurrentMonthName(), this.day, this.year);
    }

    /**
     * Returns the name of the current month
     *
     * @return The name of the current month using getMonthName(this.month)
     */
    String getCurrentMonthName() {
        return getMonthName(this.month);
    }

    /**
     * Returns integer between 1 and 12 of the current month
     *
     * @return this.month
     */
    int getCurrentMonth() {
        return this.month;
    }

    /**
     * Returns integer of the current year
     *
     * @return this.year
     */
    int getCurrentYear() {
        return this.year;
    }

    /**
     * Returns integer between 1 and 31 of the current day of the month
     *
     * @return this.day
     */
    int getCurrentDayOfMonth() {
        return this.day;
    }

    /**
     * Returns whether the specified year is a leap year
     *
     * @param year The year to check
     * @return True if the year is a leap year; False if not
     */
    protected abstract boolean isLeapYear(int year);

    /**
     * Calculates the number of days in the specified month of the specified year
     *
     * @param year  Year to check
     * @param month Month to check
     * @return Number of days in the month
     */
    private int getNumberOfDaysInMonth(int year, int month) {
        String monthName = getMonthName(month);
        int numberOfDays = -1;

        switch (monthName) {
            case "April":
            case "June":
            case "September":
            case "November":
                numberOfDays = 30;
                break;
            case "February":
                if (isLeapYear(year)) {
                    numberOfDays = 29;
                } else {
                    numberOfDays = 28;
                }
                break;
            case "Invalid month":
                break;
            default:
                numberOfDays = 31;
                break;
        }

        return numberOfDays;
    }

    /**
     * Determines and returns the month name of the provided month number
     *
     * @param month Number of month to get the name of between 1 and 12
     * @return Name of specified month
     */
    private String getMonthName(int month) {
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December"};

        if (month > 12 || month < 0) {
            return "Invalid month";
        } else {
            return monthNames[month - 1];
        }
    }
}