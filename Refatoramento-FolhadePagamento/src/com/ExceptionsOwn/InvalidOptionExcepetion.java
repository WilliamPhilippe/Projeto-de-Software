package com.ExceptionsOwn;

public class InvalidOptionExcepetion extends RuntimeException {
    public InvalidOptionExcepetion(){ super("Opcao invalida. Tente novamente."); }

    public InvalidOptionExcepetion(String s){ super("Opcao invalida. Tente novamente. " + s); }
}
