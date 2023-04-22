package Chess.Units;

import Chess.Cell;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Queen extends Unit implements canMoveXY,canMoveZ
{
    public Queen(char c)
    {
        super(c,'q');
    }

    @Override
    public ArrayList<ArrayList<Cell>> getMoveInstance(int x,int y)
    {
        Cell c;
        boolean z1=true,z2=true,z3=true,z4=true;
        boolean x1=true,x2=true;
        boolean y1=true,y2=true;
        ArrayList<Cell> availableMoves = new ArrayList<>();
        ArrayList<Cell> attackMoves = new ArrayList<>();
        for(int i=1;i<8;i++)
        {
            if ((c=Cell.getCellByXY(x+i , y+i)) != null && z1)
            {
                if(c.getUnit()!=null)
                {
                    if(c.getUnit().getColor()==this.getColor())
                        z1=false;
                    else
                    {
                        attackMoves.add(c);
                        z1=false;
                    }
                }
                else
                    availableMoves.add(c);
            }
            if ((c=Cell.getCellByXY(x+i , y-i)) != null && z2)
            {
                if(c.getUnit()!=null)
                {
                    if(c.getUnit().getColor()==this.getColor())
                        z2=false;
                    else
                    {
                        attackMoves.add(c);
                        z2=false;
                    }
                }
                else
                    availableMoves.add(c);
            }
            if ((c=Cell.getCellByXY(x-i , y+i)) != null && z3)
            {
                if(c.getUnit()!=null)
                {
                    if(c.getUnit().getColor()==this.getColor())
                        z3=false;
                    else
                    {
                        attackMoves.add(c);
                        z3=false;
                    }
                }
                else
                    availableMoves.add(c);
            }
            if ((c=Cell.getCellByXY(x-i , y-i)) != null && z4)
            {
                if(c.getUnit()!=null)
                {
                    if(c.getUnit().getColor()==this.getColor())
                        z4=false;
                    else
                    {
                        attackMoves.add(c);
                        z4=false;
                    }
                }
                else
                    availableMoves.add(c);
            }
            if ((c = Cell.getCellByXY(x , y+i)) != null && x1)
            {
                if(c.getUnit()!=null)
                {
                    if(c.getUnit().getColor()==this.getColor())
                        x1=false;
                    else
                    {
                        attackMoves.add(c);
                        x1=false;
                    }
                }
                else
                    availableMoves.add(c);
            }
            if ((c=Cell.getCellByXY(x , y-i)) != null && x2)
            {
                if(c.getUnit()!=null)
                {
                    if(c.getUnit().getColor()==this.getColor())
                        x2=false;
                    else
                    {
                        attackMoves.add(c);
                        x2=false;
                    }
                }
                else
                    availableMoves.add(c);
            }
            if ((c=Cell.getCellByXY(x+i , y)) != null && y1)
            {
                if(c.getUnit()!=null)
                {
                    if(c.getUnit().getColor()==this.getColor())
                        y1=false;
                    else
                    {
                        attackMoves.add(c);
                        y1=false;
                    }
                }
                else
                    availableMoves.add(c);
            }
            if ((c=Cell.getCellByXY(x-i , y)) != null && y2)
            {
                if(c.getUnit()!=null)
                {
                    if(c.getUnit().getColor()==this.getColor())
                       y2=false;
                    else
                    {
                        attackMoves.add(c);
                        y2=false;
                    }
                }
                else
                    availableMoves.add(c);
            }
        }
        return allMoves(availableMoves,attackMoves);
    }

    public void addMovement(ArrayList<Cell> availableMoves,ArrayList<Cell> attackMoves,Cell c)
    {

    }

    @Override
    public void getMoveXY(int x, int y)
    {

    }

    @Override
    public void getMoveZ(int x, int y)
    {

    }
}
