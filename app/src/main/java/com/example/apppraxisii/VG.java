package com.example.apppraxisii;

import android.app.Application;

public class VG extends Application {

    private int globalVariable;

    public int getGlobalVariable(){
        return globalVariable;
    }

    public void setGlobalVariable(int value){
        globalVariable = value;
    }

    public void iplusplusGlobalVariable(){
        globalVariable++;
    }

    public void ilesslessGlobalVariable(){
        globalVariable--;
    }

    public void ceroGlobalVariable(){
        globalVariable = 0;
    }

}