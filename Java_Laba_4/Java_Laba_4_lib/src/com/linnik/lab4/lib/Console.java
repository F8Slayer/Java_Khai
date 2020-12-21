package com.linnik.lab4.lib;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Console {
     static Scanner in = new Scanner(System.in);
     static ArrayList<SmartDev> devs= new ArrayList<>();
     public static void main(String[] args) throws InterruptedException {

         devs.add(new Fridge(true));
         boolean menu = true;

         while(menu){
             System.out.println("\n1 Add new Device");
             System.out.println("2 Delete existing Device");
             System.out.println("My current devices:");
             int index=3;
             if(devs.size()!=0)
                 for (SmartDev dev : devs){
                     System.out.println((index++)+" "+dev.getType()+" / "+dev.isState());
                 }
             else System.out.println("You have no devices!");
             int mChoice=0;
             in = new Scanner(System.in);
             System.out.print("Input menu: ");
             mChoice = in.nextInt();

             switch (mChoice){
                 case 1:
                     SmartDev tempDev = addDev();
                     if(tempDev!=null){
                        devs.add(tempDev);
                     }
                     else System.out.println("Error adding new device!");
                     break;
                 case 2:{
                    int delD=deleteDev();
                    if(delD>=0){
                        devs.remove(delD);
                    }
                 }
                 default:{
                     while (showDev(mChoice)!=0);

                 }
             }
         }
        // SmartDev fridge = new Fridge(true);
        // fridge.StartDev(new Date("November 10, 2020 16:00:00"));


       //  fridge.StartDev(getTransformDate());

        // System.out.println(fridge.changeState());
        //  System.out.println(fridge.toString());
    }

    public static Date getTransformDate() {
        Date d=new Date();
        in = new Scanner(System.in);
        System.out.print("Input at what time (hours): ");
        int H = in.nextInt();
        System.out.print("Input at what time (minutes): ");
        int M = in.nextInt();
        return TransformDate(d,H,M);
    }

    public static SmartDev addDev(){
        System.out.println("\n1 Fridge");
        System.out.println("2 Floor");
        System.out.println("3 Humidifier");
        System.out.println("4 Hood");
        System.out.println("5 Lights");
        int mChoice=0;
        in = new Scanner(System.in);
        System.out.print("Input a device: ");
        mChoice = in.nextInt();
        SmartDev result=null;
        switch (mChoice){
            case 1:result=new Fridge(false);
                break;
            case 2:result=new Floor(true);
                break;
            case 3:result=new Humidifier(false);
                break;
            case 4:result=new Hood(false);
                break;
            case 5:result=new Lights(false);
                break;
        }
        return result;
    }

    public static int deleteDev(){
         int index = 0;
        if(devs.size()!=0) {
            for (SmartDev dev : devs) {
                System.out.println((index++) + " " + dev.getType() + " / " + dev.isState());
            }
            int mChoice = 0;
            in = new Scanner(System.in);
            System.out.print("Input a device: ");
            mChoice = in.nextInt();
            return mChoice;
        }
        else {
            System.out.println("You have no devices!");
            return -1;
        }
    }

    public static int showDev(int M) {
        M-=3;
        SmartDev curDev=devs.get(M);
        System.out.println(curDev.toString());
        if(curDev.isState()=="ON") System.out.println("\n1 Turn OFF");
        else System.out.println("\n1 Turn ON");
        if (curDev instanceof Fridge) {
            System.out.println("2 Set temperature (from 1 to 6 in C)");
            System.out.println("3 Change mode");
            System.out.println("4 Turn ON by timer");
            System.out.println("5 Turn OFF by timer");
        }
        else if (curDev instanceof Floor) {
            System.out.println("2 Set temperature");
            System.out.println("3 Change mode");
            System.out.println("4 Turn ON by timer");
            System.out.println("5 Turn OFF by timer");
        }
        else if (curDev instanceof Hood) {
            System.out.println("2 Set brightness");
            System.out.println("3 Change the backlight color");
            System.out.println("4 Turn ON by timer");
            System.out.println("5 Turn OFF by timer");
        }
        else if (curDev instanceof Lights) {
            System.out.println("2 Set brightness");
            System.out.println("3 Change lighting color");
            System.out.println("4 Turn ON by timer");
            System.out.println("5 Turn OFF by timer");
        }
        else if (curDev instanceof Humidifier) {
            System.out.println("2 Set humidity level");
            System.out.println("3 Change mode");
            System.out.println("4 Turn ON by timer");
            System.out.println("5 Turn OFF by timer");
        }else {
            System.out.print("");
        }
        System.out.println("0 exit");
        int mChoice = 0;
        in = new Scanner(System.in);
        System.out.print("Input a menu: ");
        mChoice = in.nextInt();
        if (curDev instanceof Fridge) {
            switch (mChoice) {
                case 1:{
                    curDev.changeState();
                    break;
                }
                case 2:{
                    int temp = 0;
                    in = new Scanner(System.in);
                    System.out.print("Input a temperature: ");
                    temp = in.nextInt();
                    ((Fridge) curDev).setTemperature(temp);
                    break;
                }
                case 3: {
                    int indx=0;
                    for(String s : ((Fridge) curDev).getMode()){
                        System.out.println((indx++)+" "+s);
                    }
                    int mChoice2 = 0;
                    in = new Scanner(System.in);
                    System.out.print("Input a mode: ");
                    mChoice2 = in.nextInt();
                    ((Fridge) curDev).setCurMode(mChoice2);
                    break;
                }
                case 4: {
                    try {
                        System.out.println("\n"+curDev.StartDev(getTransformDate()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                case 5: {
                    try {
                        System.out.println("\n"+curDev.EndDev(getTransformDate()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        else if (curDev instanceof Floor) {
            switch (mChoice) {
                case 1:{
                    curDev.changeState();
                    break;
                }
                case 2:{
                    int temp = 0;
                    in = new Scanner(System.in);
                    System.out.print("Input a temperature (from 10 to 30): ");
                    temp = in.nextInt();
                    ((Floor) curDev).setTemperature(temp);
                    break;
                }
                case 3: {
                    int indx=0;
                    for(String s : ((Floor) curDev).getMode()){
                        System.out.println((indx++)+" "+s);
                    }
                    int mChoice2 = 0;
                    in = new Scanner(System.in);
                    System.out.print("Input a mode: ");
                    mChoice2 = in.nextInt();
                    ((Floor) curDev).setCurMode(mChoice2);
                    break;
                }
                case 4: {
                    try {
                        System.out.println("\n"+curDev.StartDev(getTransformDate()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                case 5: {
                    try {
                        System.out.println("\n"+curDev.EndDev(getTransformDate()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        else if (curDev instanceof Humidifier) {
            switch (mChoice) {
                case 1:{
                    curDev.changeState();
                    break;
                }
                case 2:{
                    int temp = 0;
                    in = new Scanner(System.in);
                    System.out.print("Input a humidity level (from 1 to 6): ");
                    temp = in.nextInt();
                    ((Humidifier) curDev).setHumidity(temp);
                    break;
                }
                case 3: {
                    int indx=0;
                    for(String s : ((Humidifier) curDev).getMode()){
                        System.out.println((indx++)+" "+s);
                    }
                    int mChoice2 = 0;
                    in = new Scanner(System.in);
                    System.out.print("Input a mode: ");
                    mChoice2 = in.nextInt();
                    ((Humidifier) curDev).setCurMode(mChoice2);
                    break;
                }
                case 4: {
                    try {
                        System.out.println("\n"+curDev.StartDev(getTransformDate()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                case 5: {
                    try {
                        System.out.println("\n"+curDev.EndDev(getTransformDate()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        else if (curDev instanceof Lights) {
            switch (mChoice) {
                case 1:{
                    curDev.changeState();
                    break;
                }
                case 2:{
                    int temp = 0;
                    in = new Scanner(System.in);
                    System.out.print("Input a brightness: ");
                    temp = in.nextInt();
                    ((Lights) curDev).setBrightness(temp);
                    break;
                }
                case 3: {
                    int indx=0;
                    for(String s : ((Lights) curDev).getMode()){
                        System.out.println((indx++)+" "+s);
                    }
                    int mChoice2 = 0;
                    in = new Scanner(System.in);
                    System.out.print("Input a color variant: ");
                    mChoice2 = in.nextInt();
                    ((Lights) curDev).setRGBColor(mChoice2);
                    break;
                }
                case 4: {
                    try {
                        System.out.println("\n"+curDev.StartDev(getTransformDate()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                case 5: {
                    try {
                        System.out.println("\n"+curDev.EndDev(getTransformDate()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        else if (curDev instanceof Hood) {
            switch (mChoice) {
                case 1:{
                    curDev.changeState();
                    break;
                }
                case 2:{
                    int temp = 0;
                    in = new Scanner(System.in);
                    System.out.print("Input a brightness: ");
                    temp = in.nextInt();
                    ((Hood) curDev).setBrightness(temp);
                    break;
                }
                case 3: {
                    int indx=0;
                    for(String s : ((Hood) curDev).getMode()){
                        System.out.println((indx++)+" "+s);
                    }
                    int mChoice2 = 0;
                    in = new Scanner(System.in);
                    System.out.print("Input a backlight color: ");
                    mChoice2 = in.nextInt();
                    ((Hood) curDev).setRGBColor(mChoice2);
                    break;
                }
                case 4: {
                    try {
                        System.out.println("\n"+curDev.StartDev(getTransformDate()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                case 5: {
                    try {
                        System.out.println("\n"+curDev.EndDev(getTransformDate()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return mChoice;
    }


    public static Date TransformDate(Date d, int newH,int newM) {
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        if(newH<d.getHours()){
            c.add(Calendar.DATE, 1);
            d= c.getTime();
            d.setSeconds(0);
        }
        else if ((newH==d.getHours())){
            if(newM<=d.getMinutes()){
                c.add(Calendar.DATE, 1);
                d= c.getTime();
                d.setSeconds(0);
            }
            else {
                d.setHours(newH);
                d.setMinutes(newM);
                d.setSeconds(0);
            }
        }
        else {
            d.setHours(newH);
            d.setMinutes(newM);
            d.setSeconds(0);
        }
        return d;
    }
}


