package Chess;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import Chess.Units.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class Board extends GridPane
{
    private Cell[][] cells = new Cell[8][8];

    public Board()
    {
        for(int m=0;m<2;m++)
            for(int k=0;k<8;k++)
            {
                Label s = new Label(Integer.toString(8-k));
                Label h = new Label(String.valueOf((char) (65 + k)));
                s.setPrefSize(16,16);
                h.setPrefSize(16,16);
                add(s, (m*9), k+1);
                add(h,k+1, (m*10));
            }
        for(int i=1;i<9;i++)
            for(int j=1;j<9;j++)
            {
                Color c;
                if((i + j)%2==0)
                    c = Color.web("#b58863");
                else
                    c = Color.web("#f0d9b5");
                cells[i-1][j-1] = new Cell(c,this,j,i);
                add(cells[i-1][j-1],j,9-i);
            }
        char color = 'w';
        int c = 1;
        for(int i=0;i<2;i++)
        {
            cells[7*i][0].setUnit(new Rook(color));
            cells[7*i][7].setUnit(new Rook(color));
            cells[7*i][1].setUnit(new Knight(color));
            cells[7*i][6].setUnit(new Knight(color));
            cells[7*i][2].setUnit(new Bishop(color));
            cells[7*i][5].setUnit(new Bishop(color));
            cells[7*i][3].setUnit(new Queen(color));
            cells[7*i][4].setUnit(new King(color));
            for(int j=0;j<8;j++)
            {
                cells[7*i+c][j].setUnit(new Pawn(color));
            }
            color = 'b';
            c=-1;
        }
    }
}