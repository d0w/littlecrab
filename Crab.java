import greenfoot.*;

/**
 * This class defines a crab. Crabs live on the beach.
 */
public class Crab extends Actor
{
    int score = 0;
    public void scoreboard() {
        //displays text for scoreboard
        getWorld().showText("Score: " + String.valueOf(score), 100, 20);
    }

    
    public void act()
    {
        // Add your action code here
        moveAndTurn();
        eat();
        scoreboard();
    }

    public void eat() {
        //method to make crab "eat" worms
        if(isTouching(Worm.class)) {
            removeTouching(Worm.class);
            score++;
            Greenfoot.playSound("slurp.wav");
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
            move(5);
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
            move(-5);
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

