package com.linnik.lab4.lib;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Fridge extends SmartDev {

    private int temperature;

    final public String[] mode = {"Normal cooling","Deep freeze","Vacation"};
    private String curMode = mode[0];

    protected Fridge(boolean state) {
        super(state,"Fridge");
    }

    public String[] getMode() {
        return mode;
    }

    @Override
    public String StartDev(Date _newData)   throws InterruptedException {
        TimerTask task = new TimerTask() {
            public void run() {
                setState(true);
                System.out.println("Device "+getType()+" will be turned ON " + new Date());
                cancel();
            }
        };

        Timer timer = new Timer("Timer");

        timer.schedule (task, _newData);
        System.out.println("Device at " + _newData);
        return "Will be turned ON "+ _newData;
    }

    @Override
    public String EndDev(Date _newData) throws InterruptedException {
        TimerTask task = new TimerTask() {
            public void run() {
                setState(false);
                System.out.println("Device "+getType()+" will be turned OFF " + new Date());
                cancel();
            }
        };

        Timer timer = new Timer("Timer");

        timer.schedule (task, _newData);
        return "Will be turned OFF "+ _newData;
    }

    @Override
    public String toString() {
        return super.toString()+"Fridge{" +
                "temperature =" + temperature +
                ", Current Mode ='" + curMode + '\'' +
                '}';
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        if(temperature<1)
            this.temperature = 1;
        else if(temperature>6)
            this.temperature = 6;
        else this.temperature = temperature;
    }

    public String getCurMode() {
        return curMode;
    }

    public void setCurMode(int index) {
        if(index<mode.length && index>0)
            this.curMode = mode[index];
    }
}
