package Chess.Units;

import Chess.Cell;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public abstract class Unit
{
    private String image;
    private char type,color;

    public Unit(char color,char type)
    {
        this.color=color;
        this.type=type;
        this.image="C:\\Users\\ASUS\\Downloads\\DERS\\2.Sınıf\\1.Dönem\\Nyp\\My_Projects\\src\\main\\java\\Chess\\Units\\Icons\\"+color+type+".png";
    }

    public String getImage() {
        return image;
    }

    public char getType() {
        return type;
    }

    public char getColor() {
        return color;
    }

    public abstract ArrayList<ArrayList<Cell>> getMoveInstance(int x, int y);
    //public abstract void addMovement(ArrayList<Cell> availableMoves,ArrayList<Cell> attackMoves,Cell c);
    public ArrayList<ArrayList<Cell>> allMoves(ArrayList<Cell> availableMoves,ArrayList<Cell> attackMoves)
    {
        ArrayList<ArrayList<Cell>> result = new ArrayList<>();
        result.add(availableMoves);
        result.add(attackMoves);
        return result;
    }
}

interface canMoveXY
{
    void getMoveXY(int x,int y);
}

interface canMoveZ
{
    void getMoveZ(int x,int y);
}
