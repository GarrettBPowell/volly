package com.example.volly.dummy;

import com.google.gson.annotations.SerializedName;

public class GameCompany {
        @SerializedName("name")
        public  String gameCompanyName;
        @SerializedName("year")
        public  int gameCompanyYearFounded;
        @SerializedName("recentConsole")
        public  String gameCompanyLatestConsole;

        public GameCompany(String name, int year, String console)
        {
            this.gameCompanyName = name;
            this.gameCompanyYearFounded= year;
            this.gameCompanyLatestConsole = console;
        }

        public String getName() {
            return gameCompanyName;
        }
        public int getYear() {
        return gameCompanyYearFounded;
    }
        public String getConsole() {
            return gameCompanyLatestConsole;
        }

}

