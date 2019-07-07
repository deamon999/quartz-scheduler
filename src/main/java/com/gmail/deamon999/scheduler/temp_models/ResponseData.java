package com.gmail.deamon999.scheduler.temp_models;

public class ResponseData {
    private int compliance;
    private String explanation;

    public ResponseData(int compliance, String explanation) {
        this.compliance = compliance;
        this.explanation = explanation;
    }

    public ResponseData() {
    }

    public int getCompliance() {
        return compliance;
    }

    public void setCompliance(int compliance) {
        this.compliance = compliance;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
