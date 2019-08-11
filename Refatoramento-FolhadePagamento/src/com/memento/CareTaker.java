package com.memento;

import java.util.Stack;

public class CareTaker {
    private Stack<Memento> undo = new Stack<>();
    private Stack<Memento> redo = new Stack<>();

    public void pushUndo (Memento memento){
        this.undo.push(memento);
    }

    public void pushRedo (Memento memento){
        this.redo.push(memento);
    }

    public Memento runUndo(Memento runningMemento){
        this.redo.push(runningMemento);
        return this.undo.pop();
    }

    public Memento runRedo(Memento runningMemento){
        this.undo.push(runningMemento);
        return this.redo.pop();
    }

    public void clearRedo(){ this.redo.clear(); }

    public boolean redoIsEmpty(){ return this.redo.empty(); }

    public boolean undoIsEmpty(){ return this.undo.isEmpty(); }


}
