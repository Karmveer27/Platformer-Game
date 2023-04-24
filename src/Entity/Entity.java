package Entity;

public abstract class Entity {
    protected int deltaX;
    protected int deltaY;
    public Entity(int deltaX,int deltaY){
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }
}
