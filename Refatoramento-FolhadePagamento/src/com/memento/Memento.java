package com.memento;

import com.company.Copy;
import com.company.Working;

public class Memento {
    private Working state;

    public Memento(Working state){
        this.state = Copy.copyWorking(state);
    }

    public Working getState(){ return this.state; }
}
