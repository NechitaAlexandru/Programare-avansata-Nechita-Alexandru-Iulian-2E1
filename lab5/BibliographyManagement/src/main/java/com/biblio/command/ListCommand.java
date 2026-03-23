package com.biblio.command;

import com.biblio.model.Item;
import com.biblio.repository.Catalog;

public class ListCommand implements Command {
    private Catalog catalog;

    public ListCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void execute() {
        System.out.println("Catalog: " + catalog.getName());
        for (Item item : catalog.getItems()) {
            System.out.println("- " + item.getId() + ": " + item.getTitle() + " [" + item.getLocation() + "]");
        }
    }
}