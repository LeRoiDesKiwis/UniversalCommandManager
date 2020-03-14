package com.makapush.api.ucm.commands;

import com.makapush.api.ucm.UniversalCommandManager;
import com.makapush.api.ucm.args.Argument;
import com.makapush.api.ucm.args.Sentence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public abstract class CommandListener<E> {

    private String command;
    private Predicate<E> constraint;
    List<Sentence> sentences;

    public CommandListener(String command, Predicate<E> constraint){
        this.command = command;
        this.constraint = constraint;
        this.sentences = new ArrayList<Sentence>();
    }
    public CommandListener(String command, Sentence[] sentences){
        this.command = command;
        this.constraint = (t) -> true;
        this.sentences = Arrays.asList(sentences);
    }
    public CommandListener(String command, Sentence[] sentences, Predicate<E> constraint){
        this.command = command;
        this.constraint = constraint;
        this.sentences = Arrays.asList(sentences);
    }
    public CommandListener(String command, List<Sentence> sentences){
        this.command = command;
        this.constraint = (t) -> true;
        this.sentences = sentences;
    }
    public CommandListener(String command, List<Sentence> sentences, Predicate<E> constraint){
        this.command = command;
        this.constraint = constraint;
        this.sentences = sentences;
    }
    public CommandListener(String command){
        this.command = command;
        this.constraint = (t) -> true;
    }








    public final String getCommand() {
        return command;
    }
    public final Predicate<E> getConstraint() {
        return constraint;
    }
    public final boolean isValid(E testedClass){
         return (constraint.test(testedClass));
    }
    public List<Sentence> getSentences() {
        return sentences;
    }

    public abstract void onCommand(Argument[] userArgs, E event, UniversalCommandManager<E> ucm);

    public void onConstraintInvalid(Argument[] userArgs, E event,UniversalCommandManager<E> ucm){
        ucm.getDefaultEventHandler().onConstraintInvalid(userArgs, event, ucm);
    }

    public void onWrongArguments(Argument[] userArgs, E event, UniversalCommandManager<E> ucm){
        ucm.getDefaultEventHandler().onMistake(userArgs, this, event, ucm);
    }

    public void commandHelp(E event, UniversalCommandManager<E> ucm){
        ucm.getDefaultEventHandler().onCommandHelp(this, event, ucm);
    }

}
