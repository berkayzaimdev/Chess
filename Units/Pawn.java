package Chess.Units;

import Chess.Cell;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Pawn extends Unit
{
    private boolean moved = false;
    private int k;
    public Pawn(char c)
    {
        super(c,'p');
        k = this.getColor() == 'w' ? 1 : -1;
    }

    @Override
    public ArrayList<ArrayList<Cell>> getMoveInstance(int x, int y)
    {
        boolean x1=true,x2=true;
        Cell c,ct;
        ArrayList<Cell> availableMoves = new ArrayList<>();
        ArrayList<Cell> attackMoves = new ArrayList<>();
        if ((c=Cell.getCellByXY(x , y + k)) != null)
        {
            if((ct=Cell.getCellByXY(x+1,y+k))!=null)
            {
                if(ct.getUnit()!=null)
                    if(ct.getUnit().getColor()!=this.getColor())
                        attackMoves.add(ct);
            }
            if((ct=Cell.getCellByXY(x-1,y+k))!=null)
            {
                if(ct.getUnit()!=null)
                    if(ct.getUnit().getColor()!=this.getColor())
                        attackMoves.add(ct);
            }
            if(c.getUnit()==null)
                availableMoves.add(c);
        }
        if(!moved)
        {
            if((c=Cell.getCellByXY(x , y + (k*2))) != null)
            {
                if(c.getUnit()==null)
                    availableMoves.add(c);
            }
        }
        return allMoves(availableMoves,attackMoves);
    }

    public void addMovement(ArrayList<Cell> availableMoves,ArrayList<Cell> attackMoves)
    {

    }

    public boolean isMoved() {
        return moved;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }

    public int getK() {
        return k;
    }
}