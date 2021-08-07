package chapter1;

/**
 * @apiNote equals()
 */
public class Date {
    private final int year;
    private final int month;
    private final int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public boolean equals(Object obj) {

        /*
        引用判断
         */
        if (this == obj) {
            return true;
        }
        /*
        判空
         */
        if (null == obj) {
            return false;
        }

        /*
        类型判断
         */
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        /*
        类型转换
         */
        Date date = (Date) obj;

        if (this.year != date.getYear()) {
            return false;
        }
        if (this.month != date.getMonth()) {
            return false;
        }
        if (this.day != date.getDay()) {
            return false;
        }

        return true;
    }
}
