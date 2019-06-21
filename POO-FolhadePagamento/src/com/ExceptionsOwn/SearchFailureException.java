package com.ExceptionsOwn;

public class SearchFailureException extends RuntimeException {
    public SearchFailureException(){ super("A busca falhou."); }
}
