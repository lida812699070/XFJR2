package tomcat360.com.hyxfjr.model.entity;

/**
 * Created by Administrator on 2017/4/20 0020.
 */

public class MyBillHistory {
    private String year;
    private String month;
    private String time;
    private double money;
    private int type;

    public MyBillHistory(String year, int type) {
        this.year = year;
        this.type = type;
    }

    public MyBillHistory(String month, String time, double money, int type) {
        this.month = month;
        this.time = time;
        this.money = money;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "MyBillHistory{" +
                "year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", time='" + time + '\'' +
                ", money=" + money +
                ", type=" + type +
                '}';
    }
}
