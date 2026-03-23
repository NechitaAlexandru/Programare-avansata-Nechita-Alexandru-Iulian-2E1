package com.biblio.repository;

import com.biblio.model.Item;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private List<Item> items = new ArrayList<>();

    public Catalog() { }

    public Catalog(String name) {
        this.name = name;
    }

    public void add(Item item) {
        items.add(item);
    }

    public Item findById(String id) {
        return items.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Item> getItems() { return items; }
    public void setItems(List<Item> items) { this.items = items; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}