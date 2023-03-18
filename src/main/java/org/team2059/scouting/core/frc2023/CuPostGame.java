package org.team2059.scouting.core.frc2023;

import java.io.Serializable;

public class CuPostGame implements Serializable {

    private boolean sustainibilityBonus;
    private boolean activationBonus;
    private boolean coopBonus;
    private String matchResult;
    private String notes;

    public CuPostGame(boolean sustainibilityBonus, boolean activationBonus, boolean coopBonus,
            String matchResult, String notes) {
        this.sustainibilityBonus = sustainibilityBonus;
        this.activationBonus = activationBonus;
        this.coopBonus = coopBonus;
        this.matchResult = matchResult;
        this.notes = notes;
    }

    public boolean getSustainibilityBonus() {
        return sustainibilityBonus;
    }

    public boolean getActivationBonus() {
        return activationBonus;
    }

    public boolean getCoopBonus() {
        return coopBonus;
    }

    public String getMatchResult() {
        return matchResult;
    }

    public String getNotes() {
        return notes;
    }
}