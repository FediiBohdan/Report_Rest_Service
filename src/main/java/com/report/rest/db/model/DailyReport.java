package com.report.rest.db.model;

public class DailyReport {

    public String name;
    public String surname;
    public String textOfReport;

    public DailyReport(String name, String surname, String textOfReport) {
        this.name = name;
        this.surname = surname;
        this.textOfReport = textOfReport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTextOfReport() {
        return textOfReport;
    }

    public void setTextOfReport(String textOfReport) {
        this.textOfReport = textOfReport;
    }
}
