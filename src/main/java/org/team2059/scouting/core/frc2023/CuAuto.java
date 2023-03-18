package org.team2059.scouting.core.frc2023;

import java.io.Serializable;

public class CuAuto implements Serializable {

    private boolean initLine;
    private int botCube;
    private int botCone;
    private int midCube;
    private int midCone;
    private int topCube;
    private int topCone;
    private boolean dockedNotEngaged;
    private boolean dockedEngaged;

    public CuAuto(boolean initLine, int botCube, int botCone, int midCube, int midCone,
            int topCube, int topCone, boolean dockedNotEngaged, boolean dockedEngaged) {
        this.initLine = initLine;
        this.botCube = botCube;
        this.botCone = botCone;
        this.midCube = midCube;
        this.midCone = midCone;
        this.topCube = topCube;
        this.topCone = topCone;
        this.dockedNotEngaged = dockedNotEngaged;
        this.dockedEngaged = dockedEngaged;
    }

    public boolean getInitLine() {
        return initLine;
    }

    public int getBotCone() {
        return botCone;
    }

    public int getBotCube() {
        return botCube;
    }

    public int getMidCube() {
        return midCube;
    }

    public int getMidCone() {
        return midCone;
    }

    public int getTopCone() {
        return topCone;
    }

    public int getTopCube() {
        return topCube;
    }

    public boolean getDockedNotEngaged() {
        return dockedNotEngaged;
    }

    public boolean getDockedEngaged() {
        return dockedEngaged;
    }
}
