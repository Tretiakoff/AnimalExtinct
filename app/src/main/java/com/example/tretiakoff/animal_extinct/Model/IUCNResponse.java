package com.example.tretiakoff.animal_extinct.Model;

import java.util.ArrayList;

/**
 * Created by tretiakoff on 08/06/2018.
 */

public class IUCNResponse {

    public String name;
    public ArrayList<IUCNResult> result;

    public IUCNResponse(String name, ArrayList<IUCNResult> result) {
        this.name = name;
        this.result = result;
    }

    public ArrayList<IUCNResult> getResult() {
        return result;
    }

    public String getName() {
        return name;
    }


}
