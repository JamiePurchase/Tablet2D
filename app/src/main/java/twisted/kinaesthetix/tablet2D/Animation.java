package twisted.kinaesthetix.tablet2D;

import android.graphics.Bitmap;

public class Animation
{
    private Bitmap[] frames;
    private int currentFrame;
    private long startTime;
    private long delay;
    private boolean playedOnce;

    public int getFrame()
    {
        return currentFrame;
    }

    public Bitmap getImage()
    {
        return frames[currentFrame];
    }

    public boolean playedOnce()
    {
        return playedOnce;
    }

    public void setDelay(long d)
    {
        delay = d;
    }

    public void setFrame(int frame)
    {
        currentFrame = frame;
    }

    public void setFrames(Bitmap[] frames)
    {
        this.frames = frames;
        currentFrame = 0;
        startTime = System.nanoTime();
    }

    public void update()
    {
        long elapsed = (System.nanoTime()-startTime)/1000000;
        if(elapsed>delay)
        {
            currentFrame++;
            startTime = System.nanoTime();
        }
        if(currentFrame==frames.length)
        {
            currentFrame = 0;
            playedOnce = true;
        }
    }
}