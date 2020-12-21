package com.linnik.lab4.lib;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Floor extends SmartDev {

    private int temperature;

    final public String[] mode = {"Heating","Cooling","Automatic"};
    private String curMode = mode[0];

    protected Floor(boolean state) {
        super(state,"Floor");
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
        return super.toString()+"Floor{" +
                "temperature=" + temperature +
                ", curMode='" + curMode + '\'' +
                '}';
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        if(temperature<10)
            this.temperature = 10;
        else if(temperature>30)
            this.temperature = 30;
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
