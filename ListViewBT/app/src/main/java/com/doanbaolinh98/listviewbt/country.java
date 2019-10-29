package com.doanbaolinh98.listviewbt;

public class country {
    private String countryName;

    // Image name (Without extension)
    private String flagName;
    private int weight;

    public country(String countryName, String flagName, int weight) {
        this.countryName= countryName;
        this.flagName= flagName;
        this.weight= weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getFlagName() {
        return flagName;
    }

    public void setFlagName(String flagName) {
        this.flagName = flagName;
    }

    @Override
    public String toString()  {
        return this.countryName+" (Weight : "+ this.weight+"g )";
    }
}
