package com.linnik.lab4.lib;

public abstract class SmartDev implements IControlDev {
    private boolean state;
    private String type;

    protected SmartDev(boolean state,String type) {
        setState(state);
        setType(type);
    }

    @Override
    public String toString() {
        return
                "state=" + state +
                ", type='" + type + '\'' +
                '\n';
    }

    public String changeState() {
        if(state){
            state=false;
            return "Device "+getType()+" OFF";
        }
        else {
            state=true;
            return "Device "+getType()+" ON";
        }
    }

    public String isState() {
        if(state) return "ON";
        else return "OFF";
    }

    protected void setState(boolean state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    protected void setType(String type) {
        this.type = type;
    }
}
