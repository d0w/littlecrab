import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ant extends Actor
{
    /**
     * Act - do whatever the Lobster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    int moveSpeed = 2;

    public void moveAndTurn() {

        //controls movement of the lobster
        /** moveAndTurn() Controls lobster movement and gives random turning
         * @param no parameters
         * @return void
         */

        move(moveSpeed);

        if(isAtEdge()) {
            int width = getWorld().getWidth() / 2;
            int height = getWorld().getHeight() / 2;
            turnTowards(width, height);
        }

        if (Greenfoot.getRandomNumber(100) < 10) {
            turn(Greenfoot.getRandomNumber(90));
        }

        if (Greenfoot.mouseClicked(this) && moveSpeed > 0) {
            moveSpeed = moveSpeed - 1;

        }

        if (moveSpeed < 1) {
            moveSpeed = 4;
        }
    }

    public void act() 
    {
        moveAndTurn();  
    }

}
