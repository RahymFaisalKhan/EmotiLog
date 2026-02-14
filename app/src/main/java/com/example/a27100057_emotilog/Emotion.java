package com.example.a27100057_emotilog;
import java.time.LocalDate;
import java.time.LocalTime;

/*
* Purpose:
*       Class representing a single logged emotional event in the Emotilog application.Each Emotion object stores
*       the selected emoticon type, the date, and the timestamp at which the event was recorded.
*
* Rationale:
*       A single Emotion class is used to represent all emoticon entries instead
 *      of creating separate classes for each emotion since all emotions share
 *      the same data structure and behavior: they record a timestamp, store a date, and are displayed + summarized
 *      in the same way. Since there is no behavioral difference between emotion types, creating multiple subclasses
 *      would introduce unnecessary complexity and violate good object-oriented design principles.
 * */

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
