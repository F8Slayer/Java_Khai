package com.linnik.lab4.lib;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Hood extends SmartDev {

    private int brightness;

    final public String[] mode = {"white","yellow","natural"};
    private String curRGBColor = mode[0];

    protected Hood(boolean state) {
        super(state,"Hood");
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
        return super.toString()+"Hood{" +
                "brightness=" + brightness +
                ", RGBColor='" + curRGBColor + '\'' +
                '}';
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        if(brightness<0)
            this.brightness = 0;
        else if(brightness>100)
            this.brightness = 100;
        else this.brightness = brightness;
    }

    public String getRGBColor() {
        return curRGBColor;
    }

    public void setRGBColor(int index) {
        if(index<mode.length && index>0)
            this.curRGBColor = mode[index];
    }
}
