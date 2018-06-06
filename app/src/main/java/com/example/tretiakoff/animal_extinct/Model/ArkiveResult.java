package com.example.tretiakoff.animal_extinct.Model;

/**
 * Created by tretiakoff on 06/06/2018.
 */

public class ArkiveResult {

    public ArkiveResult(ArkiveResponseHeader responseHeader, ArkiveResponse response) {
        this.responseHeader = responseHeader;
        this.response = response;
    }

    private ArkiveResponseHeader responseHeader;

    public ArkiveResponse getResponse() {
        return response;
    }

    public void setResponse(ArkiveResponse response) {
        this.response = response;
    }

    private ArkiveResponse response;
}
