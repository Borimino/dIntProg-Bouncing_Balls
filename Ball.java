import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends Actor
{
    private Vector vel;
    
    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        handleWallCollision();
        handleBallCollision();
        move();
    }    

    public Ball(int xVel, int yVel)
    {
        vel= new Vector(xVel,yVel);
    }

    public void move()
    {
        setLocation(getX()+vel.getX(), getY()+vel.getY());
    }
    
    public boolean hitTopWall()
    {
        if(getY()-getImage().getHeight()/2 <= 0)
        {
            return true;
        }
        return false;
    }
    
    public boolean hitBottomWall()
    {
        if(getY()+getImage().getHeight()/2 >= getWorld().getHeight())
        {
            return true;
        }
        return false;
    }
    
    public boolean hitLeftWall()
    {
        if(getX()-getImage().getWidth()/2 <= 0)
        {
            return true;
        }
        return false;
    }
    
    public boolean hitRightWall()
    {
        if(getX()+getImage().getWidth()/2 >= getWorld().getWidth())
        {
            return true;
        }
        return false;
    }
    
    public void handleWallCollision()
    {
        if(hitTopWall())
        {
            vel = vel.verticalFlip();
        }
        if(hitBottomWall())
        {
            vel = vel.verticalFlip();
        }
        if(hitLeftWall())
        {
            vel = vel.horizontalFlip();
        }
        if(hitRightWall())
        {
            vel = vel.horizontalFlip();
        }
    }
    
    public Vector getVelocity()
    {
        return vel;
    }
    
    public void setVelocity(Vector v)
    {
        vel = v;
    }
    
    public Ball getCollidingBall()
    {
        return (Ball) getOneIntersectingObject(Ball.class);
    }
    
    public void handleBallCollision()
    {
        if(getCollidingBall() != null)
        {
            Vector tmp = getCollidingBall().getVelocity();
            getCollidingBall().setVelocity(getVelocity());
            setVelocity(tmp);
        }
    }
}