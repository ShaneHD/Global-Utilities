package com.github.shanehd.utilities;

import com.sun.javaws.exceptions.InvalidArgumentException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author https://www.github.com/ShaneHD
 * Created by Shane on 20/02/2016.
 */
public class Time {
    private static DateFormat format = new SimpleDateFormat("HH:mm");

    public static Time systemTime() {
        String date = format.format(new Date());
        String[] split = date.split(":");

        try {
            return new Time(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        } catch(InvalidArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    public final int hour, minute;

    public Time(int h, int m) throws InvalidArgumentException {
        if(h < 0 || h > 23 || m < 0 || m > 59)
            throw new InvalidArgumentException(new String[]{"" + h, "" + m});

        hour = h;
        minute = m;
    }

    public Time add(Time time) {
        int h = (hour + time.hour) % 24;
        int m = minute + time.minute;

        if(m > 59) {
            int ah = m / 60;
            m-= ah * 60;
            h+= ah;
        }

        try {
            return new Time(h, m);
        } catch(InvalidArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Time) {
            Time compare = (Time) obj;
            return compare.hour == hour && compare.minute == minute;
        }

        return super.equals(obj);
    }
}
