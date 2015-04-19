package twisted.kinaesthetix.tablet2D;

import twisted.kinaesthetix.tablet2D.Animation;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Player extends GameObject
{
    private Bitmap spritesheet;
    private int score;
    private double dya;
    private boolean up;
    private boolean playing;
    private Animation animation = new Animation();
    private long startTime;

    public Player(Bitmap res, int w, int h, int numFrames)
    {
        x = 100;
        y = GamePanel.HEIGHT/2;
        dy = 0;
        score = 0;
        height = h;
        width = w;
        Bitmap[] image = new Bitmap[numFrames];
        spritesheet = res;
        for(int x=0; x<image.length; x++)
        {
            image[x] = Bitmap.createBitmap(spritesheet, x*width, 0, width, height);
        }
        animation.setFrames(image);
        animation.setDelay(10);
        startTime = System.nanoTime();
    }

    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(animation.getImage(), x, y, null);
    }

    public boolean getPlaying()
    {
        return playing;
    }

    public int getScore()
    {
        return score;
    }

    public void resetDYA()
    {
        dya = 0;
    }

    public void resetScore()
    {
        score = 0;
    }

    public void setPlaying(boolean b)
    {
        playing = b;
    }

    public void setUp(boolean b)
    {
        up = b;
    }

    public void update()
    {
        long elapsed = (System.nanoTime()-startTime)/1000000;
        if(elapsed>100)
        {
            score++;
            startTime = System.nanoTime();
        }
        animation.update();

        // Acceleration
        if(up==true)
        {
            dy = (int)(dya-=1.1);
        }
        else
        {
            dy = (int)(dya+=1.1);
        }

        // Speed cap
        if(dy>14) {dy = 14;}
        if(dy<-14) {dy = -14;}

        y += dy*2;
        dy = 0;
    }

}
