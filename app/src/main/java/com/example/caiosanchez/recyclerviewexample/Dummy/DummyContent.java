package com.example.caiosanchez.recyclerviewexample.Dummy;

import com.example.caiosanchez.recyclerviewexample.Model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Caio Sanchez on 23/02/2016.
 */
public class DummyContent {
    public static final List<Item> ITEMS = new ArrayList<>();
    private static final int size = 5;

    static {
        for (int i = 1; i <= size; i++) {
            ITEMS.add(createDummyItem(i));
        }
    }

    public static void addNewItem() {
        int indice = ITEMS.size();
        indice++;

        ITEMS.add(createDummyItem(indice));
    }

    private static Item createDummyItem(int position) {
        return new Item("Item: " + position, details(position));
    }

    private static String details(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Detalhe item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMais detalhes, click aqui.");
        }

        return builder.toString();
    }
}
