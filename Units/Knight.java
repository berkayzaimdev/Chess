package Chess.Units;

import Chess.Cell;

import java.util.ArrayList;

public class Knight extends Unit
{
    public Knight(char c)
    {
        super(c,'n');
    }

    @Override
    public ArrayList<ArrayList<Cell>> getMoveInstance(int x, int y)
    {
        Cell c;
        ArrayList<Cell> availableMoves = new ArrayList<>();
        ArrayList<Cell> attackMoves = new ArrayList<>();
        for(int i=1;i>-2;i-=2)
        {
            if((c=Cell.getCellByXY(x+(2*i),y+i))!=null)
                addMovement(availableMoves,attackMoves,c);
            if((c=Cell.getCellByXY(x+(2*i),y-i))!=null)
                addMovement(availableMoves,attackMoves,c);
            if((c=Cell.getCellByXY(x-i,y-(2*i)))!=null)
                addMovement(availableMoves,attackMoves,c);
            if((c=Cell.getCellByXY(x-i,y+(2*i)))!=null)
                addMovement(availableMoves,attackMoves,c);
        }
        return allMoves(availableMoves,attackMoves);
    }

    public void addMovement(ArrayList<Cell> availableMoves,ArrayList<Cell> attackMoves,Cell c)
    {
        if(c.getUnit()!=null)
        {
            if (c.getUnit().getColor() != this.getColor())
                attackMoves.add(c);
        }
        else
            availableMoves.add(c);
    }
}
