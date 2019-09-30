package com.beatharmony.util;

public class StringResponse {
    private String text;

    public StringResponse() {}

    public StringResponse(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
