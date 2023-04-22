package Chess;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import Chess.Units.*;
import java.util.ArrayList;


public class Cell extends StackPane
{
    private static final int CELL_WH=45;
    private static final Color attackedcolor=Color.CRIMSON;
    private static char turn='w';
    private final Color color;


    private Unit unit;
    private Rectangle bg;
    private Board board;
    private int x,y;
    private static ArrayList<Cell> cells = new ArrayList<>();
    private static ArrayList<ArrayList<Cell>> availablecells = new ArrayList<>();
    private static Cell previouscell;
    private static boolean check = false;



    Cell(Color color,Board board,int x,int y)
    {
        this.x=x;
        this.y=y;
        this.board=board;
        this.setWidth(CELL_WH);
        this.setHeight(CELL_WH);
        this.color=color;
        cells.add(this);
        this.bg = new Rectangle(CELL_WH, CELL_WH, color);
        this.getChildren().add(bg);
        setOnMouseClicked(e->
        {
            System.out.println("I clicked on "+((char)(64+x))+y);
            if(check)
                System.out.println("Sah cekili vaziyette!");
            if(previouscell==this)
            {
                System.out.println("test1");
                clear();
                availablecells = new ArrayList<>();
                previouscell=null;
            }
            else if(unit!=null)
            {
                System.out.println("test2 start");
                if(unit.getColor()==turn)
                {
                    System.out.println("My unit's color is :"+unit.getColor());
                    if(previouscell==null)
                    {
                        availablecells = unit.getMoveInstance(x,y);
                        fill();
                        previouscell = this;
                    }
                    else
                    {
                        if(Cell.getCellByXY(x,y).getUnit().getColor()==previouscell.getUnit().getColor())
                        {
                            clear();
                            previouscell=null;
                            availablecells = unit.getMoveInstance(x,y);
                            fill();
                            previouscell = this;
                        }
                    }
                }
                else if(previouscell!=null)
                {
                    System.out.println("saldır");
                    for(Cell cell : availablecells.get(1))
                    {
                        if(cell==this)
                        {
                            clear();
                            removeUnit();
                            setUnit(previouscell.getUnit());
                            if(getUnit() instanceof Pawn)
                            {
                                if(!(((Pawn) getUnit()).isMoved()))
                                    ((Pawn) getUnit()).setMoved(true);
                                int destinationRow = ((Pawn) getUnit()).getK() == 1 ? 8 : 1;
                                if(this.y==destinationRow)
                                {
                                    //pawn to special
                                }
                            }
                            previouscell.removeUnit();
                            previouscell=null;
                            availablecells = new ArrayList<>();
                            turn = turn == 'w' ? 'b' : 'w';
                            check=setCheck();
                            break;
                        }
                    }
                }
                System.out.println("test2 end");
            }
            else
            {
                System.out.println("the cell hasnt unit");
                boolean flag=false;
                if(previouscell!=null)
                {
                    if(previouscell.unit.getColor()==turn)
                    {
                        for(Cell cell : availablecells.get(0))
                        {
                            if(this==cell)
                            {
                                setUnit(previouscell.unit);
                                if(getUnit() instanceof Pawn)
                                {
                                    if(!(((Pawn) getUnit()).isMoved()))
                                        ((Pawn) getUnit()).setMoved(true);
                                    int destinationRow = ((Pawn) getUnit()).getK() == 1 ? 8 : 1;
                                    if(this.y==destinationRow)
                                    {
                                        //pawn to special unit
                                    }
                                }
                                flag=true;
                                previouscell.removeUnit();
                                check=setCheck();
                                break;
                            }
                        }
                        if(flag)
                        {
                            clear();
                            availablecells = new ArrayList<>();
                            previouscell = null;
                            turn = turn == 'w' ? 'b' : 'w';
                        }
                        else
                        {
                            System.out.println("i clicked an unit but didnt clicked its instance");
                            clear();
                            availablecells = new ArrayList<>();
                            previouscell = null;
                        }
                    }
                }
            }
        });
    }

    public void setUnit(Unit unit)
    {
        this.unit = unit;
        Image image = new Image(unit.getImage());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(45);
        imageView.setFitHeight(45);
        this.getChildren().add(imageView);
    }

    public void removeUnit()
    {
        this.unit = null;
        this.getChildren().remove(1);
    }

    public Unit getUnit() {
        return unit;
    }

    public static Cell getCellByXY(int x, int y)
    {
        for(Cell c : cells)
            if(c.x == x && c.y == y)
                return c;

        return null;
    }
    public Rectangle getBg() {
        return bg;
    }

    public Color getColor() {
        return color;
    }

    public static Color getAttackedcolor() {
        return attackedcolor;
    }

    public void clear()
    {
        for(Cell cell : availablecells.get(0))
            cell.getChildren().remove(cell.getChildren().get(1));
        for(Cell cell : availablecells.get(1))
            cell.getBg().setFill(cell.getColor());
    }

    public void fill()
    {
        for(Cell cell : availablecells.get(0))
            cell.getChildren().add(new Circle(10, Color.GRAY));
        for(Cell cell : availablecells.get(1))
            cell.getBg().setFill(Cell.getAttackedcolor());
    }

    public static boolean setCheck()
    {
        char enemyturn = turn == 'w' ? 'b' : 'w';
        System.out.println("bir sonraki hamle rengi : "+enemyturn);
        for(Cell c:cells)
        {
            if (c.getUnit() instanceof King)
            {
                if(c.getUnit().getColor() == enemyturn)
                {
                    System.out.println("Sah bulundu! renk : "+turn);
                    for (Cell ct : cells)
                        if (ct.getUnit() != null)
                            if (ct.getUnit().getColor() == turn)
                                for (ArrayList<Cell> moves : ct.getUnit().getMoveInstance(ct.getX(), ct.getY()))
                                    if (moves.contains(c))
                                    {
                                        System.out.println("Sah cekildi.");
                                        return true;
                                    }
                }
            }
        }
        return false;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
