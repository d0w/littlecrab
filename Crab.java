import greenfoot.*;
import java.util.*;
/**
 * This class defines a crab. Crabs live on the beach.
 */
public class Crab extends Actor
{
    public static int crabCount = 1;
    public static int score = 0;
    public int value = 4;
    public static int lives = 3;
    public void scoreboard() {
        //displays text for scoreboard
        getWorld().showText("Score: " + String.valueOf(score), 70, 20);
    }

    public void win() {
        if (score == 15) {
            getWorld().showText("You Win", 300, 300);
        }
    }

    public static int returnScore() {
        return score;
    }

    public void lifeCounter() 
    {
        //displays text for lives counter
        getWorld().showText("Lives: " + String.valueOf(lives), 200, 20);
    }
    
    public static int returnLives() {
        return Crab.lives;
    }
    
    public void act()
    {
        // Add your action code here
        moveAndTurn(value);
        eat();
        scoreboard();
        lifeCounter();
        win();
        eatAnt();
    }

    public void eat() {
        //method to make crab "eat" worms
        if(isTouching(Worm.class)) {
            removeTouching(Worm.class);
            score++;
            Greenfoot.playSound("slurp.wav");
        }
    }

    public void eatAnt() {
        //method to make crab eat ants
        if (isTouching(Ant.class)) {
            removeTouching(Ant.class);
            value = value + 2;
        }
    }

    public void moveAndTurn(int value) {
        //controls movement
        int random = Greenfoot.getRandomNumber(90);

        if(isAtEdge()) {
            //if at edge, turn to middle
            turnTowards(280, 280);
        }

        if (Greenfoot.isKeyDown("right")) {
            move(value);
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
            move(-1 * value);
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

