package ru.mshkolniy.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Letter {

    @JsonProperty("letter")
    private char letter;

    @JsonProperty("count")
    private int count;

    public Letter(char letter, int count) {
        this.letter = letter;
        this.count = count;
    }
}
