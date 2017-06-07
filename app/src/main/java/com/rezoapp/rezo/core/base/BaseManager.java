package com.rezoapp.rezo.core.base;

import java.util.Observable;
import java.util.Observer;

public class BaseManager extends Observable {

    public void setObserver(Observer observer) {
        this.deleteObserver(observer);
        this.addObserver(observer);
    };
}
