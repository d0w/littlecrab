import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lobster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lobster extends Actor
{
    /**
     * Act - do whatever the Lobster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    int moveSpeed = 4;

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

    public void eat() {
        if (isTouching(Crab.class)) {
            Crab.lives--;
            Greenfoot.playSound("au.wav");
            if (Crab.lives <= 0){
                getWorld().showText("You Lose", 300, 300);
            }
            act();
        }
    }


    public void increaseDif() {
        int score = Crab.returnScore();
        if (score == 5) {
            moveSpeed = 7;
        }
        else if (score == 10) {
            moveSpeed = 10;
        }

    }

    public void act() 
    {
        moveAndTurn();
        eat();// Add your action code here.
        increaseDif();
    }

}
