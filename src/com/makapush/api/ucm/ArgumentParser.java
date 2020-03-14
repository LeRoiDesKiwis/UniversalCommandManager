package com.makapush.api.ucm;

import com.makapush.api.ucm.args.Argument;

public class ArgumentParser {

    private String str;
    private String delimiters;
    private int maxPos;
    private int currentPos;

    public ArgumentParser(String str, String delimiters){
        this.str = removeUselessSpace(str);
        this.delimiters = delimiters;
        this.maxPos = this.str.length();
        this.currentPos = 0;
    }



    public boolean hasNext(){
        return currentPos < maxPos;
    }

    public Argument nextArg(){
        int startPos = currentPos;
        short argSize = 0;
        while (currentPos < maxPos){
            char c = str.charAt(currentPos);

            currentPos++;
            argSize++;

            if (delimiters.indexOf(c) >= 0 || currentPos >= maxPos) {

                var arg = str.substring(startPos, startPos + argSize);
                for(char a : delimiters.toCharArray()){
                    arg = arg.replaceAll(a+"", "");
                }
                return new Argument(arg);

            }
        }
        return null;
    }

    public void resetPosition(){
        this.currentPos = 0;
    }

    public int countArgs(){
        int argNumber = 0;
        for (int i = 0; i < maxPos; i++){
            char c = str.charAt(i);
            if(delimiters.indexOf(c) >= 0 || i == maxPos - 1) argNumber++;
        }
        return argNumber;
    }

    private String removeUselessSpace(String str){

        char lastChar = ' ';
        var stringBuilder = new StringBuilder();
        for (char c : str.toCharArray()){
            if(c == ' ' && lastChar == ' ') continue;
            stringBuilder.append(c);
            lastChar = c;
        }
        return stringBuilder.toString();

    }


}
