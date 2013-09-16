/**
 * This class models a Vector. The coordinated <tt>x</tt> and <tt>y</tt> are
 * integers
 * @author Jeppe B
 */
public class Vector  
{
    private int x;
    private int y;
    
    public Vector(int x, int y){
        this.x = x;
        this.y = y;
    }
        
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    /**
     * Returns a new Vector that is flipped vertically
     */
    public Vector verticalFlip() {
        return new Vector(x, -y);
    }
    
    /**
     * Returns a new Vector that is flipped horizontally
     */
    public Vector horizontalFlip() {
        return new Vector(-x, y);
    }
    
    public String toString(){
        return "(" + x + ", " + y + ")";
    }
    
    public double length(){
        return Math.sqrt(x*x+y*y);
    }
    public Vector scale(int f){
        return new Vector(x*f, y*f);
    }
}