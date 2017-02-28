package io.github.shredktp.a50moneymonitoring.data;

/**
 * Created by Korshreddern on 27-Feb-17.
 */

public class Money {
    private double amount;
    private String type;
    private String detail;
    private long timestamp;

    public Money(double amount, String type, String detail, long timestamp) {
        this.amount = amount;
        this.type = type;
        this.detail = detail;
        this.timestamp = timestamp;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
