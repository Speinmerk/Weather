package ru.speinmerk.weather.models;

import android.os.Parcel;
import android.os.Parcelable;

public class City implements Parcelable {
    public static final String KEY_PARCELABLE = "City.class";
    public String name;
    public int temperature;
    public int humidity;
    public int windSpeed;
    public int pressure;

    public City(String name, int temperature, int humidity, int windSpeed, int pressure) {
        this.name = name;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.temperature);
        dest.writeInt(this.humidity);
        dest.writeInt(this.windSpeed);
        dest.writeInt(this.pressure);
    }

    protected City(Parcel in) {
        this.name = in.readString();
        this.temperature = in.readInt();
        this.humidity = in.readInt();
        this.windSpeed = in.readInt();
        this.pressure = in.readInt();
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel source) {
            return new City(source);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };
}
