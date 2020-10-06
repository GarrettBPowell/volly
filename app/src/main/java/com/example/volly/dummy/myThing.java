package com.example.volly.dummy;

import com.google.gson.annotations.SerializedName;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class myThing {
        @SerializedName("name")
        public  String name;
        @SerializedName("year")
        public  String year;
        @SerializedName("color")
        public  String color;

        public myThing(String name, String year, String color)
        {
            this.name = name;
            this.year= year;
            this.color = color;
        }

        public String getName() {
            return name;
        }
        public String getConsole() {
            return year;
        }
        public String getYear() {
            return color;
        }
}

