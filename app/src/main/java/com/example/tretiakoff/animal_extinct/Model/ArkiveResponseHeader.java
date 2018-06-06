package com.example.tretiakoff.animal_extinct.Model;

/**
 * Created by tretiakoff on 06/06/2018.
 */

public class ArkiveResponseHeader {

    public ArkiveResponseHeader(boolean zkConnected, int status, int qTime, ArkiveParams params) {
        this.zkConnected = zkConnected;
        this.status = status;
        this.qTime = qTime;
        this.params = params;
    }

    private boolean zkConnected;

    private int status;

    private int qTime;

    private ArkiveParams params;
}
