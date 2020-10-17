package org.team2059.scouting.core.frc2020;

import java.io.Serializable;

public class IrEndgame implements Serializable
{

    private boolean park;
    private boolean climbAttempt;
    private boolean climb;
    private boolean level;
    
    public IrEndgame(boolean park, boolean climbAttempt, boolean climb, boolean level)
    {
        this.park = park;
        this.climbAttempt = climbAttempt;
        this.climb = climb;
        this.level = level;
    }

    public boolean getPark()
    {return park;}
    public boolean getClimbAttempt()
    {return climbAttempt;}
    public boolean getClimb()
    {return climb;}
    public boolean getLevel()
    {return level;}
}