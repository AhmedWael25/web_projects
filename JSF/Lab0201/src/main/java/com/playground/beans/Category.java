package com.playground.beans;

import java.io.Serializable;

public class Category implements Serializable {

    private String label;
    private String value;
    private int votes;

    public Category(String label, String value, int votes) {
        this.label = label;
        this.value = value;
        this.votes = votes;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "Category{" +
                "label='" + label + '\'' +
                ", value='" + value + '\'' +
                ", votes=" + votes +
                '}';
    }
}
