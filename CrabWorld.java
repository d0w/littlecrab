import greenfoot.*;  // (Actor, World, Greenfoot, GreenfootImage)
import java.util.*;

public class CrabWorld extends World
{
    /**
     * Create the crab world (the beach). Our world has a size 
     * of 560x560 cells, where every cell is just 1 pixel.
     */

    int width = getWidth();
    int height = getHeight();
    int difficulty = 15;
    public CrabWorld() 
    {

        super(560, 560, 1);

        makeCrabs();
        makeLobsters();
        makeButtons();
        makeWorms(difficulty);
        makeAnts(3);

    }

    public void makeButtons() {
        addObject(new Button(), 30, 530);
        showText("Restart", 30, 530);
    }

    public void makeCrabs() {
        int width = getWidth();
        int height = getHeight();
        addObject(new Crab(), 280, 280);
    }
    

    public void makeAnts(int number) {

        for (int i = 0; i < number; i++) {
            int x = Greenfoot.getRandomNumber(width);
            int y = Greenfoot.getRandomNumber(height);
            addObject(new Ant(), x, y);
        }

    }

    public void makeLobsters() {

        int x = Greenfoot.getRandomNumber(width);
        int y = Greenfoot.getRandomNumber(height);
        addObject(new Lobster(), x, y);
    }

    public void makeWorms(int number) {
        for (int i = 0; i < number; i++) {
            int x = Greenfoot.getRandomNumber(width);
            int y = Greenfoot.getRandomNumber(height);
            addObject(new Worm(), x, y);
        }
    }

}