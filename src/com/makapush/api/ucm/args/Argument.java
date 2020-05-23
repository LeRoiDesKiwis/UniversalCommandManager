package com.makapush.api.ucm.args;

public class Argument {

    String arg;
    ArgumentType type;

    public Argument(String arg){
        this.arg = arg;
        this.type = getSelfType();
    }
    public Argument(ArgumentType type){
        this.arg = "";
        this.type = type;
    }

    @Override
    public String toString(){
        if(arg.isEmpty())
            return type.toString();
        return arg;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Argument)) return false;
        Argument argument = (Argument) o;
        if(argument.getType() == ArgumentType.TEXT) return argument.getType() == type && argument.toString().equalsIgnoreCase(arg);
        return (argument.getType() == type);
    }

    public String toStringDebug(){
        return arg + ",(" + type + ")";
    }

    public boolean isEmpty(){
        return arg.isEmpty();
    }

    public ArgumentType getType(){
        return type;
    }

    private ArgumentType getSelfType(){
        if(isEmpty()) return ArgumentType.EMPTY;
        try {
            Integer.parseInt(arg);
            return ArgumentType.INTEGER;
        } catch (NumberFormatException e){
        }
        try {
            Double.parseDouble(arg);
            return ArgumentType.DECIMAL;
        } catch (NumberFormatException e){
        }
        if(arg.equals("true") || arg.equals("false") || arg.equals("yes") || arg.equals("no")) return ArgumentType.BOOLEAN;
        return ArgumentType.TEXT;
    }

    public int getAsInt(){
        try {
            return Integer.parseInt(arg);
        }catch (NumberFormatException e){
            e.printStackTrace();
            return -1;
        }
    }

    public long getAsLong(){
        try {
            return Long.parseLong(arg);
        }catch (NumberFormatException e){
            e.printStackTrace();
            return -1;
        }
    }

    public float getAsFloat(){
        try {
            return Float.parseFloat(arg);
        }catch (NumberFormatException e){
            e.printStackTrace();
            return -1;
        }
    }

    public double getAsDouble(){
        try {
            return Double.parseDouble(arg);
        }catch (NumberFormatException e){
            e.printStackTrace();
            return -1;
        }
    }

    public boolean getAsBoolean(){
        switch (arg){
            case "yes" :
            case "true" :
                return true;
            case "no" :
            case "false" :
                return false;
        }
        switch (getAsInt()){
            case 0 : return false;
            case 1 : return true;
        }
        return false;
    }

    public String getAsString(){
        return arg;
    }

}
