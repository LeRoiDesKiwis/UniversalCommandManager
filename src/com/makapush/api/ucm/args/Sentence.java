package com.makapush.api.ucm.args;

public class Sentence {

    Argument[] args;

    public Sentence(Argument... args){
        this.args = args;
    }

    public Sentence(ArgumentType... args){
        this.args = new Argument[args.length];
        int i = 0;
        for(ArgumentType argType : args)
            this.args[i] = new Argument(argType);

    }

    public int getWrongArg(Sentence sentence){
        int sentenceArgsLength = sentence.getArgs().length;
        if(args.length > sentenceArgsLength) return args.length -1;
        if(args.length < sentenceArgsLength) return sentenceArgsLength -1;

        int i = 0;
        for (Argument argument : sentence.getArgs()){
            System.out.println(argument.equals(args[i]));
            if(!argument.equals(args[i])) {
                return i;
            }
                i++;
        }
        return -1;
    }

    public boolean isArgMatchingAt(Sentence sentence, int index){
        return sentence.getArgs()[index].equals(args[index]);
    }

    public Argument[] getArgs() {
        return args;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(Argument argument : args){
            builder.append(argument.toString() + ", ");
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Sentence)) return false;
        Sentence sentence = (Sentence) o;
        int testedLength = sentence.getArgs().length;
        if(testedLength != args.length) return false;

        int i = 0;
        for (Argument argument : args){
            if(!argument.equals(sentence.getArgs()[i])) return false;
            i++;
        }
        return true;
    }



    public int indexOf(Argument arg){
        int i = 0;
        for (Argument argument : args){
            if(argument.equals(arg))
                return i;
            i++;
        }
        return -1;
    }















}
