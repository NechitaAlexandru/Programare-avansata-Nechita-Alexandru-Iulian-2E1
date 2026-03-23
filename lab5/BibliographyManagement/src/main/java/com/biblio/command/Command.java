package com.biblio.command;

import com.biblio.exception.CommandException;

public interface Command {
    void execute() throws CommandException;
}