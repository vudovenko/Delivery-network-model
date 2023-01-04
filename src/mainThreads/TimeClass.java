package mainThreads;

import java.util.Date;

public class TimeClass extends Thread {
    private volatile Date date;
    public static final Integer VIRTUAL_HOUR = 100;

    public TimeClass() {
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TimeClass{" +
                "date=" + date +
                '}';
    }

    public synchronized void increaseTime(TypeTime typeTime, Integer number) {
        if (typeTime == TypeTime.MILLISECOND) {
            this.date = new Date(this.date.getTime() + number);
        } else if (typeTime == TypeTime.SECOND) {
            this.date = new Date(this.date.getTime() + number * 1000);
        } else if (typeTime == TypeTime.MINUTE) {
            this.date = new Date(this.date.getTime() + number * 60 * 1000);
        } else if (typeTime == TypeTime.HOUR) {
            this.date = new Date(this.date.getTime() + number * 60 * 60 * 1000);
        } else {
            this.date = new Date(this.date.getTime() + number * 24 * 60 * 60 * 1000);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("\nCurrent time: " + date + "\n");
                Thread.sleep(VIRTUAL_HOUR);
                increaseTime(TypeTime.HOUR, 1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
