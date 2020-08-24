import greenfoot.*;  // (Actor, World, Greenfoot, GreenfootImage)

public class CrabWorld extends World
{
    /**
     * Create the crab world (the beach). Our world has a size 
     * of 560x560 cells, where every cell is just 1 pixel.
     */

    int width = getWidth();
    int height = getHeight();
    public CrabWorld() 
    {
        super(560, 560, 1);
        makeCrabs();
        makeLobsters();
        makeWorms();

    }

    public void makeCrabs() {
        int width = getWidth();
        int height = getHeight();
        addObject(new Crab(), 280, 280);
    }

    public void makeLobsters() {
        
        int x = Greenfoot.getRandomNumber(width);
        int y = Greenfoot.getRandomNumber(height);
        addObject(new Lobster(), x, y);
    }
    
    public void makeWorms() {
        for (int i = 0; i < 10; i++) {
            int x = Greenfoot.getRandomNumber(width);
            int y = Greenfoot.getRandomNumber(height);
            addObject(new Worm(), x, y);
        }
    }
}