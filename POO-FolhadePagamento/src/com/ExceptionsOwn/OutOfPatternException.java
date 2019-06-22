package com.ExceptionsOwn;

public class OutOfPatternException extends RuntimeException {
    public OutOfPatternException(String s){ super(s); }

    public OutOfPatternException(){ super(); }
}
