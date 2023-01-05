package mainThreads;

import java.util.Date;

public class TimeClass extends Thread {
    private static volatile Date date;
    public static final Integer VIRTUAL_HOUR = 1000;

    public TimeClass() {
        this.date = new Date();
    }

    public static Date getCurrentDate() {
        return date;
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
