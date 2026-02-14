package com.example.a27100057_emotilog;
import java.time.LocalDate;
import java.time.LocalTime;

public class Emotion {
    LocalTime time_stamp;
    LocalDate date;

    private String Emoticon;

    Emotion (String Emoticon)
    {
        date = LocalDate.now();
        time_stamp = LocalTime.now();
        this.Emoticon = Emoticon;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime_stamp(LocalTime time_stamp) {
        this.time_stamp = time_stamp;
    }

    public String getEmoticon() {
        return Emoticon;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime_stamp() {
        return time_stamp;
    }

    @Override
    public String toString() {
        return Emoticon + " - " + date + " " + time_stamp;
    }

}
