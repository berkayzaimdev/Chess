package Chess.Units;

import Chess.Cell;

import java.util.ArrayList;

public class King extends Unit
{
    //rok atarken şah ve kalenin oynanmamış olması gerekiyor
    private boolean moved = false;
    public King(char c)
    {
        super(c,'k');
    }

    @Override
    public ArrayList<ArrayList<Cell>> getMoveInstance(int x, int y)
    {
        //şahın hareket edebileceği hücreleri belirlerken
        // tüm rakip taşların atak yapabileceği hücreleri referans alabiliriz
        Cell c;
        ArrayList<Cell> availableMoves = new ArrayList<>();
        ArrayList<Cell> attackMoves = new ArrayList<>();
        for (int dx = -1; dx <= 1; dx++)
        {
            for (int dy = -1; dy <= 1; dy++)
            {
                if (dx == 0 && dy == 0) continue;
                int newX = x + dx;
                int newY = y + dy;
                if ((c = Cell.getCellByXY(newX, newY)) != null) addMovement(availableMoves, attackMoves, c);
            }
        }
        deleteMovement(availableMoves,attackMoves);
        return allMoves(availableMoves,attackMoves);
    }

    public void addMovement(ArrayList<Cell> availableMoves,ArrayList<Cell> attackMoves,Cell c)
    {
        if(c.getUnit()!=null) {
            if (c.getUnit().getColor() != this.getColor()) attackMoves.add(c);
        }
        else
        {
            availableMoves.add(c);
        }
    }

    public void deleteMovement(ArrayList<Cell> availableMoves, ArrayList<Cell> attackMoves) {
        availableMoves.removeIf(c -> {
            int x = c.getX();
            int y = c.getY();
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    if (dx == 0 && dy == 0) continue;
                    int newX = x + dx;
                    int newY = y + dy;
                    Cell adjacentCell = Cell.getCellByXY(newX, newY);
                    if (adjacentCell != null && adjacentCell.getUnit() instanceof King && adjacentCell.getUnit().getColor()!=getColor())
                        return true;
                }
            }
            return false;
        });

        attackMoves.removeIf(c -> {
            int x = c.getX();
            int y = c.getY();
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    if (dx == 0 && dy == 0) continue;
                    int newX = x + dx;
                    int newY = y + dy;
                    Cell adjacentCell = Cell.getCellByXY(newX, newY);
                    if (adjacentCell != null && adjacentCell.getUnit() instanceof King && adjacentCell.getUnit().getColor()!=getColor())
                        return true;
                }
            }
            return false;
        });
    }



    public void setMoved(boolean moved) {
        this.moved = moved;
    }
}
