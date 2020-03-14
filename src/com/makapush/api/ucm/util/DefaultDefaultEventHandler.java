package com.makapush.api.ucm.util;

import com.makapush.api.ucm.DefaultEventHandler;
import com.makapush.api.ucm.UniversalCommandManager;
import com.makapush.api.ucm.args.Argument;
import com.makapush.api.ucm.commands.CommandListener;

public class DefaultDefaultEventHandler<E> implements DefaultEventHandler<E> {

    @Override
    public void onCommandNotFound(E event, UniversalCommandManager<E> ucm) {
        System.out.println("Command Not Found for prefix " + ucm.getDefaultPrefix());
        System.out.println("please, custom tour own DefaultEventHandler with universalCommandManager#setDefaultEventHandler() !");
    }

    @Override
    public void onMistake(Argument[] userArgs, CommandListener<E> command, E event, UniversalCommandManager<E> universalCommandManager) {
        System.out.println("Mistake error ");
        System.out.println("please, custom tour own DefaultEventHandler with universalCommandManager#setDefaultEventHandler() !");
    }

    @Override
    public void onConstraintInvalid(Argument[] args, E event, UniversalCommandManager<E> universalCommandManager) {
        System.out.println("Constraint Invalid ");
        System.out.println("please, custom tour own DefaultEventHandler with universalCommandManager#setDefaultEventHandler() !");
    }

    @Override
    public void onCommandHelp(CommandListener<E> commandListener, E event, UniversalCommandManager<E> universalCommandManager) {
        System.out.println("asked help for command \"" + commandListener.getCommand() +"\"");
        System.out.println("please, custom tour own DefaultEventHandler with universalCommandManager#setDefaultEventHandler() !");
    }
}
