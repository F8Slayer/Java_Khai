package com.linnik.lab4.lib;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Humidifier extends SmartDev {

    private int Humidity;

    final public String[] mode = {"Automatic","Night-mode","Turbo"};
    private String curMode = mode[0];

    protected Humidifier(boolean state) {
        super(state,"Humidifier");
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
        return "will be turned OFF "+ _newData;
    }

    @Override
    public String toString() {
        return super.toString()+"Humidifier{" +
                "Humidity=" + Humidity +
                ", curMode='" + curMode + '\'' +
                '}';
    }

    public int getHumidity() {
        return Humidity;
    }

    public void setHumidity(int temperature) {
        if(temperature<1)
            this.Humidity = 1;
        else if(temperature>6)
            this.Humidity = 6;
        else this.Humidity = temperature;
    }

    public String getCurMode() {
        return curMode;
    }

    public void setCurMode(int index) {
        if(index<mode.length && index>0)
            this.curMode = mode[index];
    }
}
