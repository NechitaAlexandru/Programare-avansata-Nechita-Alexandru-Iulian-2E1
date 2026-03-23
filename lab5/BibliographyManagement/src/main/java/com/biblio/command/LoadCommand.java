package com.biblio.command;

import com.biblio.exception.CommandException;
import com.biblio.repository.Catalog;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class LoadCommand implements Command {
    private String path;
    private Catalog catalog;

    public LoadCommand(String path) {
        this.path = path;
    }

    @Override
    public void execute() throws CommandException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            this.catalog = objectMapper.readValue(new File(path), Catalog.class);
        } catch (Exception e) {
            throw new CommandException("Failed to load catalog from " + path, e);
        }
    }

    public Catalog getCatalog() {
        return catalog;
    }
}