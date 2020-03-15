package com.makapush.api.ucm;

import com.makapush.api.ucm.args.Argument;
import com.makapush.api.ucm.args.Sentence;
import com.makapush.api.ucm.commands.CommandListener;
import com.makapush.api.ucm.util.DefaultDefaultEventHandler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UCMimpl<E> extends UniversalCommandManager<E> {


    private Map<String, CommandListener<E>> commands;
    private HashMap<Object, String> prefixes = new HashMap<>();

    private Argument expectedArg;

    UCMimpl(String defaultPrefix, Map<String, CommandListener<E>> commands){
        super.defaultPrefix = defaultPrefix;
        this.commands = commands;
        setDefaultEventHandler(new DefaultDefaultEventHandler<>());
    }

    @Override
    public void manageCommands(String message, E event, CustomPrefixIdentifier prefixIdentifier){
        String serverPrefix = getCustomPrefix(prefixIdentifier);
        if(message.startsWith(serverPrefix)){

            String commandKey = message.split(" ")[0].replaceFirst(serverPrefix, "");
            System.out.println(commandKey);
            if(commands.containsKey(commandKey)){
                CommandListener<E> command = commands.get(commandKey);
                Argument[] args = getUserArguments(message, serverPrefix, command.getCommand());

                if(message.startsWith(serverPrefix + command.getCommand())){

                    if(message.startsWith(serverPrefix + command.getCommand() + " help")){
                        command.commandHelp(event, this);
                        return;
                    }

                    if(command.isValid(event)) {
                        if(isArgumentsValid(args, command.getSentences())) {
                            command.onCommand(args, event, this);
                        } else {
                            command.onWrongArguments(args, event, this);
                        }

                    } else {
                        command.onConstraintInvalid(args, event, this);
                    }
                    return;

                }

            }
            defaultEventHandler.onCommandNotFound(event, this);
        }
    }


    @Override
    public void addCustomPrefix(String prefix, CustomPrefixIdentifier identifier) {
        prefixes.put(identifier, prefix);
    }

    @Override
    public String getCustomPrefix(CustomPrefixIdentifier identifier) {
        return (prefixes.containsKey(identifier))
        ? prefixes.get(identifier)
        : defaultPrefix;
    }


    private Argument[] getUserArguments(String message, String serverPrefix, String cmd) {

        ArgumentParser tokenizer = new ArgumentParser(message.replaceFirst(serverPrefix + cmd, ""), " ");
        var arguments = new Argument[tokenizer.countArgs()];

        short index = 0;
        while (tokenizer.hasNext()){
            Argument argument = tokenizer.nextArg();
            if(argument == null) break;
            arguments[index] = argument;
            index++;
        }

        System.out.println(Arrays.toString(arguments));

        return arguments;
    }

    public Map<String, CommandListener<E>> getCommands() {
        return commands;
    }


    private boolean isArgumentsValid(Argument[] userArg, List<Sentence> commandSentences){
        if(commandSentences.isEmpty()) return true;
        Sentence userSentence = new Sentence(userArg);
        for (Sentence commandSentence : commandSentences){
            if(userSentence.equals(commandSentence)) return true;
        }
        return false;
    }






}