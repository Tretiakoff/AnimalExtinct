package com.example.tretiakoff.animal_extinct.Model;

/**
 * Created by tretiakoff on 08/06/2018.
 */

public class IUCNResult {

    private int speciesId;
    private Object taxonomicnotes;
    private String rationale;
    private String geographicrange;
    private String population;
    private String populationtrend;
    private String habitat;
    public String threats;
    private String conservationmeasures;
    private Object usetrade;

    public IUCNResult(int speciesId, Object taxonomicnotes, String rationale, String geographicrange, String population, String populationtrend, String habitat, String threats, String conservationmeasures, Object usetrade) {
        this.speciesId = speciesId;
        this.taxonomicnotes = taxonomicnotes;
        this.rationale = rationale;
        this.geographicrange = geographicrange;
        this.population = population;
        this.populationtrend = populationtrend;
        this.habitat = habitat;
        this.threats = threats;
        this.conservationmeasures = conservationmeasures;
        this.usetrade = usetrade;
    }

    public String getThreats() {
        return threats;
    }
}
