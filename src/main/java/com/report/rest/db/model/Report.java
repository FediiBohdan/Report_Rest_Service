package com.report.rest.db.model;

import java.time.LocalDateTime;

public class Report {

    public long id;
    public LocalDateTime dateOfReport;
    public String textOfReport;

    public Report(long id, LocalDateTime dateOfReport, String textOfReport) {
        this.id = id;
        this.dateOfReport = dateOfReport;
        this.textOfReport = textOfReport;
    }

    public Report(LocalDateTime dateOfReport, String textOfReport) {
        this.dateOfReport = dateOfReport;
        this.textOfReport = textOfReport;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDateOfReport() {
        return dateOfReport;
    }

    public void setDateOfReport(LocalDateTime dateOfReport) {
        this.dateOfReport = dateOfReport;
    }

    public String getTextOfReport() {
        return textOfReport;
    }

    public void setTextOfReport(String textOfReport) {
        this.textOfReport = textOfReport;
    }
}
