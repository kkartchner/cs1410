/**
 * Class definition for GregorianDate used for instantiating, modifying, and printing dates of the Gregorian Calendar.
 *
 * @author Ky Kartchner
 * @version 1.0
 */
public class GregorianDate {

    /**
     * Stores the value of the year
     */
    private int year;

    /**
     * Stores the value of the month
     */
    private int month;

    /**
     * Stores the value of the day
     */
    private int day;

    /**
     * Sets to default of today's date
     */
    GregorianDate(){
        GregorianDate date = new GregorianDate(1970,1,1);   // Initialize date to 1/1/1970

        final int MILLISECONDS_PER_DAY = 86_400_000;
        long millisecondsPastEpoch = System.currentTimeMillis() + java.util.TimeZone.getDefault().getRawOffset();
        int daysPastEpoch = (int) (millisecondsPastEpoch / MILLISECONDS_PER_DAY);

        date.addDays(daysPastEpoch);

        this.year = date.year;
        this.month = date.month;
        this.day = date.day;
    }

    /**
     * Sets the GregorianDate to provided year, month, and day.
     * @param year Year to assign
     * @param month Month to assign
     * @param day Day to assign
     */
    GregorianDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Adds the specified number of days
     * @param days The number of days to add to the date
     */
    void addDays(int days){
        int daysLeftToAdd = days;
        int lastDayOfMonth = getNumberOfDaysInMonth(this.year, this.month);

        while (daysLeftToAdd > 0){
            this.day++;
            if (this.day > lastDayOfMonth){
                this.day = 1;
                this.month++;

                if (this.month > 12) {
                    this.month = 1;
                    this.year++;
                }
                lastDayOfMonth = getNumberOfDaysInMonth(this.year, this.month );
            }
            daysLeftToAdd--;
        }
    }

    /**
     * Subtracts the specified number of days
     * @param days The number of days to subtract from the date
     */
    void subtractDays(int days){
        int daysLeftToSubtract = days;

        while (daysLeftToSubtract > 0){
            this.day--;
            if (this.day < 1){
                this.month--;
                if (this.month < 1) {
                    this.month = 12;
                    this.year--;
                }
                this.day = getNumberOfDaysInMonth(this.year, this.month );   // Set to last day of the new month
            }
            daysLeftToSubtract--;
        }
    }

    /**
     * Returns whether or not the GregorianDate is in a leap year
     * @return True if is a leap year; False if not
     */
    boolean isLeapYear(){
        return isLeapYear(this.year);
    }

    /**
     * Prints the date (without a carriage return) in mm/dd/yyyy format
     */
    void printShortDate(){
        System.out.printf("%2d/%2d/%4d", this.month, this.day, this.year);
    }

    /**
     * Prints the date (without a carriage return) in Monthname dd, yyyy format
     */
    void printLongDate(){
        System.out.printf("%s %2d, %4d", getCurrentMonthName(), this.day, this.year);
    }

    /**
     * Returns the name of the current month
     * @return The name of the current month using getMonthName(this.month)
     */
    String getCurrentMonthName(){
        return getMonthName(this.month);
    }

    /**
     * Returns integer between 1 and 12 of the current month
     * @return this.month
     */
    int getCurrentMonth(){
        return this.month;
    }

    /**
     * Returns integer of the current year
     * @return this.year
     */
    int getCurrentYear(){
        return this.year;
    }

    /**
     * Returns integer between 1 and 31 of the current day of the month
     * @return this.day
     */
    int getCurrentDayOfMonth(){
        return this.day;
    }

    /**
     * Returns whether the specified year is a leap year
     * @param year The year to check
     * @return True if the year is a leap year; False if not
     */
    private boolean isLeapYear(int year){
        if (year % 4 == 0){              //  If year is divisible by 4
            if (year % 100 == 0){        //      If it is also divisible by 100
                return year % 400 == 0;  //          It's a leap year if also divisible by 400, but common if not
            } else {                          //      Else
                return true;                  //          It is a leap year, so return true
            }                                 //      End If
        } else {                              //  Else
            return false;                     //      It is a common year, so return false
        }

    }

    /**
     * Calculates the number of days in the specified month of the specified year
     * @param year Year to check
     * @param month Month to check
     * @return Number of days in the month
     */
    private int getNumberOfDaysInMonth(int year, int month){
        String monthName = getMonthName(month);
        int numberOfDays = -1;

        switch (monthName){
            case "April": case "June": case "September": case "November":
                numberOfDays = 30;
                break;
            case "February":
                if (isLeapYear(year)){
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
     * @param month Number of month to get the name of between 1 and 12
     * @return Name of specified month
     */
    private String getMonthName(int month){
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December"};

        if (month > 12 || month < 0){
            return "Invalid month";
        } else {
            return monthNames[month - 1];
        }
    }
}