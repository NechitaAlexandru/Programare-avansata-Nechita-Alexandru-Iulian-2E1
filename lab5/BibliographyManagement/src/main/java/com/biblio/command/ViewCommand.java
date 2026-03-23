package com.biblio.command;

import com.biblio.exception.CommandException;
import com.biblio.model.Item;
import java.awt.Desktop;
import java.io.File;
import java.net.URI;

public class ViewCommand implements Command {
    private Item item;

    public ViewCommand(Item item) {
        this.item = item;
    }

    @Override
    public void execute() throws CommandException {
        if (item == null) {
            throw new CommandException("Cannot view a null item.");
        }

        try {
            Desktop desktop = Desktop.getDesktop();
            String loc = item.getLocation();
            if (loc.startsWith("http")) {
                desktop.browse(new URI(loc));
            } else {
                desktop.open(new File(loc));
            }
        } catch (Exception e) {
            throw new CommandException("Failed to open item: " + item.getTitle(), e);
        }
    }
}
