import greenfoot.*;
import java.util.*;
/**
 * This class defines a crab. Crabs live on the beach.
 */
public class Crab extends Actor
{
    public static int crabCount = 1;
    public static int score = 0;
    public void scoreboard() {
        //displays text for scoreboard
        getWorld().showText("Score: " + String.valueOf(score), 100, 20);
    }
    
    public void win() {
        if (score == 15) {
            getWorld().showText("You Win", 300, 300);
        }
    }

    public static int returnScore() {
        return score;
    }


    public void act()
    {
        // Add your action code here
        moveAndTurn();
        eat();
        scoreboard();
        win();
    }

    public void eat() {
        //method to make crab "eat" worms
        if(isTouching(Worm.class)) {
            removeTouching(Worm.class);
            score++;
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

