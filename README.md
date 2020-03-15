# UniversalCommandManager
Made By MAKAPUSH#9414 with the strong help of Messabloo, MinusKube, Akami and Hokkaydo  

## How to download the Library ?  
Just go into [releases section](https://github.com/Maxalus/UniversalCommandManager/releases)  

## Creating the UniversalCommandManager Object  
To use the library, you have to create a UniversalCommandManagerBuilder Object.   
In wich you can put all the CommandClass you want, [(see CommandListener class bottom for use)]()  
Methods: 
- #addCommand() > add a command to the Final UniversalCommandManager Object
- #build() > returns the builded UniversalCommandManager Instance.

## using the UniversalCommandManager Class
This Class is the core of the API.
### How to Manage Commands ?  
The class have a #manageCommands() method, you have to put this into a HandledClass as described here :   
https://ibb.co/PmtS0Nj  
(Example made with the JDA API)  

#### #setDefaultEventHandler()
the class also have a #setDefaultEventHandler(), in which you can put a class extending from DefaultEventHandler with all the default Events listed Bottom :   
- onCommandNotFound()
- onMistake()
- onConstraintInvalid()
- onCommandHelp()

### CommandListener SuperClass :  

All of Your ClassCommand that you have putted in #addCommand methods must extends from the abstract class CommandListener.
you will have a "onCommand()" method with some parameters :

- Argument[] args > The args send by the user who executed the command (see Argument field bottom)
- T event > The Event that you put into #ManageCommand earlier
- UniversalCommandManger ucm > The instance of the CommandManager that actived the method. (see [UniversalCommandManager](https://github.com/Maxalus/UniversalCommandManager/new/master?readme=1#using-the-universalcommandmanager-class))

Moroever, you have some hidden Methods, that can be @Overriden :

- onConstraintInvalid() > thrown if the Constraints you putted on Command Constructor return false, 
- onWrongArgument() > thrown when the command is recognized, but argument are'nt matching with Command args / Sentences (see Sentence Field Bottom)
- commandHelp() > thrown when the user do a command with "help" argument.

you can decide to @Override one of these methods to set custom error / help per commands
else, you can set a default action Using UniversalCommandManager#setDefault (see [#setDefaultEventHandler()](https://github.com/Maxalus/UniversalCommandManager/new/master?readme=1#setdefaulteventhandler)) for each methods.
if you do not want any action, you can simply set empty methods.


## Argument / ArgumentType class :
ArgumentType :
The ArgumentType is an enum class.
it contains those constants INTEGER, DECIMAL, BOOLEAN, TEXT, EMPTY, USER_MENTION
They are used by Sentences and Arguments to check equality between other Arguments. Or to create Arguments classes

### Argument :
The Argument class is the class that replace the good old String.
in this class, you can get the argument as a String, a integer, a long, a Float, a Double or a boolean.
it can also be compared with another Argument. the "equals()" methods compare the Argument text, but also his type.
You can create an Argument by two ways :

String (the type will be automatically detected)
ArgumentType (the String text will be empty)


### Sentence class :
The Sentence class is an Array of Arguments.
it contains few functions :

isArgMatchingAt(Sentence target, int index) > to check if Argument matching with another target at x index.
getWrongArg(Sentence target) > get the not matching arg slot from target. return -1 if the two are matching (recommended to user .equals() method before)
toString() > return all Argument texts (or type if text is empty) contained into the Sentence.
equals() check if two Sentence are matching.
If you used the Library, are simply read the "How to setup" Field, you should have noticed that you can put different Sentence (Which, i call him back, are Argument Group)
So why using Sentences ?
let's suppose that we have a Complex command.
And this command is an SurveyBuilder whish have for command "!survey".

So, we want to set a name, maximum participants, BlackListed users and a Timer. to do that, without using useless extending commands like "!surveyName", "!surveyMaxParticipants" or "surveyBlackList" etc... we have to Use Sentences :

one Sentence for the title : "name", ArgumentType.TEXT
one Sentence for the maximum votes : "maxParticipants", ArgumentType.INTEGER
one Sentence for blacklistedUsers : "addBlackistedUser", ArgumentType.USER_MENTION
one Sentence for maxTime : "Timer", ArgumentType.DECIMAL
if the user is using one of the four Sentences listed above, we can execute the Command and be sure that we have all needed datas without making extra conditions.

Contact me for more Help (MAKAPUSH#9414)
