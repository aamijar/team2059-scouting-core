package org.team2059.scouting.core.frc2020;

import java.io.Serializable;

public class IrControlPanel implements Serializable
{
    private boolean rotation;
    private boolean position;
    
    
    public IrControlPanel(boolean rotation, boolean position)
    {
        this.rotation = rotation;
        this.position = position;
    }

    public boolean getRotation()
    {return rotation;}
    public boolean getPosition()
    {return position;}

}