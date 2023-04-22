package Chess.Units;

import Chess.Cell;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Rook extends Unit implements canMoveXY
{
    //rok atarken şah ve kalenin oynanmamış olması gerekiyor
    private boolean moved = false;
    public Rook(char color)
    {
        super(color,'r');
    }

    @Override
    public ArrayList<ArrayList<Cell>> getMoveInstance(int x,int y)
    {
        Cell c;
        boolean x1=true,x2=true;
        boolean y1=true,y2=true;
        ArrayList<Cell> availableMoves = new ArrayList<>();
        ArrayList<Cell> attackMoves = new ArrayList<>();
        for(int i=1;i<8;i++)
        {
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

    public void addMovement(ArrayList<Cell> availableMoves,ArrayList<Cell> attackMoves)
    {

    }

    @Override
    public void getMoveXY(int x, int y)
    {

    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }
}
