package com.makapush.api.ucm;

public abstract class UniversalCommandManager<E> {

    DefaultEventHandler<E> defaultEventHandler;
    String defaultPrefix;

    public abstract void manageCommands(String message, E event, CustomPrefixIdentifier prefixIdentifier);

    public abstract void addCustomPrefix(String prefix, CustomPrefixIdentifier identifier);
    public abstract String getCustomPrefix(CustomPrefixIdentifier identifier);

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
}
