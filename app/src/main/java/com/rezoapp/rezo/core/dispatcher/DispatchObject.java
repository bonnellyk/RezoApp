package com.rezoapp.rezo.core.dispatcher;

public class DispatchObject {

    private DISPATCH_ACTION dispatchAction;
    private Object data;

    public DispatchObject(DISPATCH_ACTION dispatchAction, Object data) {
        this.dispatchAction = dispatchAction;
        this.data = data;
    }

    public DISPATCH_ACTION getDispatchAction() {
        return this.dispatchAction;
    }

    public Object getData() {
        return this.data;
    }

    public enum DISPATCH_ACTION {

    }
}
