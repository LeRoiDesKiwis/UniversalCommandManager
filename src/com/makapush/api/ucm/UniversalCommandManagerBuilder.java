package com.makapush.api.ucm;

import com.makapush.api.ucm.commands.CommandListener;

import java.util.ArrayList;
import java.util.List;

public class UniversalCommandManagerBuilder<E> {
    String prefix;
    List<CommandListener<E>> commands = new ArrayList<>();

    public UniversalCommandManagerBuilder(String prefix){
        this.prefix = prefix;
    }

    public UniversalCommandManagerBuilder<E> addCommand(CommandListener<E> commandListener){
        commands.add(commandListener);
        return this;
    }


    public UniversalCommandManager<E> build(){
        return new UCMimpl<>(prefix, commands);
    }

}
