package com.example.covid_19;

public class VaccineSample {
    private String Country;
    private String VaccineType;
    private String date;
    private String numberOfDose;
    private String dailyPercentage;

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getVaccineType() {
        return VaccineType;
    }

    public void setVaccineType(String vaccineType) {
        VaccineType = vaccineType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getNumberOfDose()
    {
        return numberOfDose;
    }
    public void setNumberOfDose(String doses){
        this.numberOfDose = doses;
    }
public String  getDailyPercentage(){
        return dailyPercentage;
}
public void setDailyPercentage(String percent){
        this.dailyPercentage = percent;
}
    @Override
    public String toString() {
        return getCountry() +getDate();
    }


}
