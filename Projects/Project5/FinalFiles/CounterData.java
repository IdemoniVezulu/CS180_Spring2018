package edu.purdue.ramakri7.project5;

/**
 *  CounterData Class - Project 5
 *
 *  This class holds all the data required for a counter.
 *
 *  @author Varun Ramakrishnan, L09
 *  @version 21st April, 2018
 *
 */

import android.os.Parcelable;
import android.os.Parcel;

public class CounterData implements Parcelable
{
    private String  countName;
    private int     countVal;

    public CounterData(String countName, int countVal)
    {
        this.countName = countName;
        this.countVal = countVal;
    }

    public CounterData(String countName)
    {
        this(countName, 0);
    }

    public CounterData(Parcel input)
    {
        countName = input.readString();
        countVal = input.readInt();
    }

    public synchronized void add()
    {
        countVal++;
    }

    public synchronized int getCounterValue()
    {
        return this.countVal;
    }

    public synchronized void setCounterValue(int value)
    {
        this.countVal = value;
    }

    public String getCounterName()
    {
        return this.countName;
    }

    public String valueString()
    {
        return String.format("%d", countVal);
    }

    @Override
    public String toString()
    {
        String  counter;

                counter = String.format("Name: %s\nValue: %d", getCounterName(), getCounterValue());

        return counter;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel endpoint, int flags)
    {
        endpoint.writeString(countName);
        endpoint.writeInt(countVal);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<CounterData> CREATOR = new Parcelable.Creator<CounterData>()
    {
        @Override
        public CounterData createFromParcel(Parcel in)
        {
            return new CounterData(in);
        }

        @Override
        public CounterData[] newArray(int size)
        {
            return new CounterData[size];
        }
    };
}
