import greenfoot.*;

/**
 * This class defines a crab. Crabs live on the beach.
 */
public class Crab extends Actor
{
    public void act()
    {
        // Add your action code here
        moveAndTurn();
        eat();
    }
    
    public void eat() {
        //method to make crab "eat" worms
        if(isTouching(Worm.class)) {
            removeTouching(Worm.class);
        }
    }

    public void moveAndTurn() {
        //controls movement
        int random = Greenfoot.getRandomNumber(90);

        if(isAtEdge()) {
            //if at edge, turn to middle
            turnTowards(280, 280);
        }


        if (Greenfoot.isKeyDown("right")) {
            move(4);
            if(random < 20) {
                turn(4);
            } 
            else if(random < 50 && random > 20) {
                turn(-1);
            } else {
                turn(3);
            }
        }
        
        if (Greenfoot.isKeyDown("left")) {
             move(-4);
            if(random < 20) {
                turn(2);
            } 
            else if(random < 50 && random > 20) {
                turn(-1);
            } else {
                turn(3);
            }
        }
    }
}

