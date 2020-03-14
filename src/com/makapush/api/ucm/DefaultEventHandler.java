package com.makapush.api.ucm;

import com.makapush.api.ucm.args.Argument;
import com.makapush.api.ucm.commands.CommandListener;

public interface DefaultEventHandler<E> {

    void onCommandNotFound(E event, UniversalCommandManager<E> universalCommandManager);
    void onMistake(Argument[] userArgs, CommandListener<E> command, E event, UniversalCommandManager<E> universalCommandManager);
    void onConstraintInvalid(Argument[] args, E event, UniversalCommandManager<E> universalCommandManager);
    void onCommandHelp(CommandListener<E> commandListener, E event, UniversalCommandManager<E> universalCommandManager);
}
