package com.biblio.command;

import com.biblio.exception.CommandException;
import com.biblio.repository.Catalog;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class SaveCommand implements Command {
    private Catalog catalog;
    private String path;

    public SaveCommand(Catalog catalog, String path) {
        this.catalog = catalog;
        this.path = path;
    }

    @Override
    public void execute() throws CommandException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(path), catalog);
        } catch (Exception e) {
            throw new CommandException("Failed to save catalog to " + path, e);
        }
    }
}