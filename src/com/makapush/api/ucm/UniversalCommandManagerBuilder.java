package com.makapush.api.ucm;

import com.makapush.api.ucm.commands.CommandListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniversalCommandManagerBuilder<E> {
    String prefix;
    Map<String, CommandListener<E>> commands = new HashMap<>();

    public UniversalCommandManagerBuilder(String prefix){
        this.prefix = prefix;
    }

    public UniversalCommandManagerBuilder<E> addCommand(CommandListener<E> commandListener){
        commands.put(commandListener.getCommand(), commandListener);
        return this;
    }


    public UniversalCommandManager<E> build(){
        return new UCMimpl<>(prefix, commands);
    }

}
