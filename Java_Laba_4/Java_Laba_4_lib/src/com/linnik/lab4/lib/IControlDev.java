package com.linnik.lab4.lib;

import java.util.Date;

public interface IControlDev {
    String StartDev(Date _newData) throws InterruptedException;
    String EndDev(Date _newData)throws InterruptedException;
}
