package Chess.Units;

import Chess.Cell;

import java.util.ArrayList;

public class Bishop extends Unit implements canMoveZ
{
    public Bishop(char c)
    {
        super(c,'b');
    }

    @Override
    public ArrayList<ArrayList<Cell>> getMoveInstance(int x,int y)
    {
        Cell c;
        boolean z1=true,z2=true,z3=true,z4=true;
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
        }
        return allMoves(availableMoves,attackMoves);
    }

    public void addMovement(ArrayList<Cell> availableMoves,ArrayList<Cell> attackMoves)
    {

    }

    @Override
    public void getMoveZ(int x, int y)
    {

    }
}
