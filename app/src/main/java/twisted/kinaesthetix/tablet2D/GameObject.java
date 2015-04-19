package twisted.kinaesthetix.tablet2D;

import android.graphics.Rect;

public abstract class GameObject
{
    protected int x;
    protected int y;
    protected int dx;
    protected int dy;
    protected int height;
    protected int width;

    public int getHeight()
    {
        return this.height;
    }

    public Rect getRectangle()
    {
        return new Rect(x, y, x+width, y+height);
    }

    public int getWidth()
    {
        return this.width;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }
}
