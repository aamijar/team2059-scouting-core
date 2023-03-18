package org.team2059.scouting.core.frc2023;

import java.io.Serializable;

public class CuEndgame implements Serializable {

    private boolean dockedNotEngaged;
    private boolean dockedEngaged;
    private boolean park;

    public CuEndgame(boolean dockedNotEngaged, boolean dockedEngaged, boolean park) {
        this.dockedNotEngaged = dockedNotEngaged;
        this.dockedEngaged = dockedEngaged;
        this.park = park;
    }

    public boolean getDockedNotEngaged() {
        return dockedNotEngaged;
    }

    public boolean getDockedEngaged() {
        return dockedEngaged;
    }

    public boolean getPark() {
        return park;
    }
}
