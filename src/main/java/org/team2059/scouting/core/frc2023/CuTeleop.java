package org.team2059.scouting.core.frc2023;

public class CuTeleop extends CuAuto {

    private int links;

    public CuTeleop(boolean initLine, int botCube, int botCone, int midCube, int midCone,
            int topCube, int topCone, boolean dockedNotEngaged, boolean dockedEngaged, int links) {
        super(initLine, botCube, botCone, midCube, midCone, topCube, topCone, dockedNotEngaged, dockedEngaged);
        this.links = links;
    }

    public int getLinks() {
        return links;
    }
}
