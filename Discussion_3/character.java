public class character {
    private int pointX;
    private int pointY;

    public MoveLeft(){
        pointX--;
    }

    public MoveRight(){
        pointX++;
    }

    public MoveUp(){
        pointY--;
    }

    public MoveDown(){
        pointY++;
    }

    public int[] GetLocation(){
        return { pointX, pointY };
    }
}
