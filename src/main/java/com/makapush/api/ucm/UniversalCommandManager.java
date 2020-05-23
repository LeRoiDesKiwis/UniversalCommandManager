package com.makapush.api.ucm;

import com.makapush.api.ucm.commands.CommandListener;

import java.util.HashMap;
import java.util.Map;

public abstract class UniversalCommandManager<E> {

    DefaultEventHandler<E> defaultEventHandler;
    String defaultPrefix;
    Map<String, CommandListener<E>> commands;
    HashMap<CustomPrefixIdentifier<?>, String> prefixes = new HashMap<>();

    public abstract void manageCommands(String message, E event, CustomPrefixIdentifier<?> prefixIdentifier);

    public abstract void addCustomPrefix(String prefix, CustomPrefixIdentifier<?> identifier);
    public abstract String getCustomPrefix(CustomPrefixIdentifier<?> identifier);

    public void setDefaultPrefix(String defaultPrefix) {
        this.defaultPrefix = defaultPrefix;
    }

    public String getDefaultPrefix() {
        return defaultPrefix;
    }

    public void setDefaultEventHandler(DefaultEventHandler<E> defaultEventHandler) {
        this.defaultEventHandler = defaultEventHandler;
    }
    public DefaultEventHandler<E> getDefaultEventHandler() {
        return defaultEventHandler;
    }

    public Map<String, CommandListener<E>> getCommands() {
        return commands;
    }
    public HashMap<CustomPrefixIdentifier<?>, String> getPrefixes() {
        return prefixes;
    }
}
