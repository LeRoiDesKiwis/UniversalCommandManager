package com.makapush.api.ucm;

public class CustomPrefixIdentifier<Type> {

    Type identifier;

    public CustomPrefixIdentifier(Type id){
        this.identifier = id;
    }

    public Type getIdentifier() {
        return identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof CustomPrefixIdentifier) {
            CustomPrefixIdentifier<?> that = (CustomPrefixIdentifier<?>) o;
            return that.identifier.equals(identifier);
        }
        return false;
    }
}
