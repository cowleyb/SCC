public class BombSquare extends GameSquare
{
    private GameBoard board;                            // Object reference to the GameBoard this square is part of.
    private boolean hasBomb; 
    private boolean shown;                           // True if this squre contains a bomb. False otherwise.

	public static final int MINE_PROBABILITY = 15;

	public BombSquare(int x, int y, GameBoard board)
	{
		super(x, y, "dist/images/blank.png");

        this.board = board;
        this.hasBomb = ((int) (Math.random() * MINE_PROBABILITY)) == 0;
        this.shown = false;
       // if (this.hasBomb == true) 
       // {this.setImage("dist/images/bomb.png");}
    }    

    public void leftClicked()
    {
        if (hasBomb == true) 
        {this.setImage("dist/images/bomb.png");}
        else 
        {
            explore(this.getXLocation(), this.getYLocation());
            
        }

        
    }

    
    public void rightClicked()
    {
       System.out.println("hello2");
    }
    private boolean checkBomb(int x, int y)
    {
        if (bounds(x, y) == true)
        {
            GameSquare h = board.getSquareAt(x, y);
            BombSquare hh = (BombSquare)h;
            return hh.hasBomb();
        }
        return false;
        }

    private int bombsinAO(int x, int y)
    {
        int total = 0;
        total += checkBomb(x-1,y) ? 1 : 0;
        total += checkBomb(x,y-1)? 1 : 0;
        total += checkBomb(x-1,y-1)? 1 : 0;
        total += checkBomb(x+1,y)? 1 : 0;
        total += checkBomb(x,y+1)? 1 : 0;
        total += checkBomb(x+1,y+1)? 1 : 0;
        total += checkBomb(x+1,y-1)? 1 : 0;
        total += checkBomb(x-1,y+1)? 1 : 0;
        return total;
    }
    private boolean bounds(int x,int y)
    {
        if (x <0 || y < 0)
        {
            return false;
        }
        else if (x>(board.getWidth() - 20) / 20 - 1 || y > (board.getHeight() - 20) / 20 - 1)
        {
            return false;
        }
        else {

            return true;
        }
    }
    private void explore(int x, int y)
    {
        GameSquare h = board.getSquareAt(x, y);
        BombSquare hh = (BombSquare)h;
        if (bounds(x,y) == false)
        {
            return;
        }
        if (hh.hasBomb == true)
        {
            return;
        } 
        if (hh.shown == true)
        {
            return;
        } 
        hh.shown = true;
        int total = bombsinAO(x, y);
        if (total > 0)
        {
            String filePath = String.format("dist/images/%d.png", total);
            hh.setImage(filePath);
            return;
        }
        hh.setImage("dist/images/0.png");
        explore( x+1, y );
        explore( x-1, y );
        explore( x, y-1 );
            explore( x, y+1 );
    

    }
    public boolean hasBomb()
    {
        return this.hasBomb;
    }
}
