package com.example.volly.dummy;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class GameCompany {
        @SerializedName("name")
        public  String gameCompanyName;
        @SerializedName("year")
        public  String gameCompanyYearFounded;
        @SerializedName("console")
        public  String gameCompanyLatestConsole;

        public GameCompany(String name, String year, String console)
        {
            this.gameCompanyName = name;
            this.gameCompanyYearFounded= year;
            this.gameCompanyLatestConsole = console;
        }

        public String getName() {
            return gameCompanyName;
        }
        public String getConsole() {
            return gameCompanyLatestConsole;
        }
        public String getYear() {
            return gameCompanyYearFounded;
        }
}

