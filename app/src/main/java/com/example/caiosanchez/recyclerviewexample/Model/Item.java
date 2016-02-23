package com.example.caiosanchez.recyclerviewexample.Model;

/**
 * Created by Caio Sanchez on 23/02/2016.
 */
public class Item {
    public final String content;
    public final String details;

    public Item(String content, String details) {
        this.content = content;
        this.details = details;
    }

    @Override
    public String toString() {
        return content;
    }
}
