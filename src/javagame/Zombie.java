package javagame;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

public class Zombie 
{
	
	private float zombieX = 300;
	private float zombieY = 300;
	
	float zombiedx = 0;
	float zombiedy = 0;
	
	private float zombieWidth = 50;
	private float zombieHeight = 50;
	private float zombieSpeed = 3;
	private float zombieAngle = 90f;
	private int zombieHealth = 1;
	
	float zombieLength = 0;
	
	Rectangle zombieRect;
	Image zombieImage;
	
	Zombie(Image i)
	{
		this.zombieRect = new Rectangle(this.zombieX, this.zombieY, this.zombieWidth, this.zombieHeight);
		this.zombieImage = i;
	}
	
	void setX(float x)
	{
		this.zombieX = x;
	}
	
	void setY(float y)
	{
		this.zombieY = y;
	}
	
	Image getImage()
	{
		return this.zombieImage;
	}
	
	void updateRect()
	{
		this.zombieRect.setLocation(zombieX, zombieY);
	}
	
	Rectangle getRect()
	{
		return zombieRect;
	}
	
	float getX()
	{
		return zombieX;
	}
	
	float getY()
	{
		return zombieY;
	}
	
	float getAngle()
	{
		return zombieAngle;
	}
	
	float getSpeed()
	{
		return zombieSpeed;
	}
	
	float getWidth()
	{
		return zombieImage.getWidth();
	}
	
	float getHeight()
	{
		return zombieImage.getHeight();
	}
	
	void setAngle(float angle)
	{
		this.zombieAngle = angle;
	}
	
	int getHealth()
	{
		return zombieHealth;
	}
	
	float getDX()
	{
		return zombiedx;
	}
	
	float getDY()
	{
		return zombiedy;
	}

	public void move(Player hero) 
	{
		zombiedx = hero.getX() - zombieX;
		zombiedy = hero.getY() - zombieY;
		zombieLength = (float) Math.sqrt(zombiedx*zombiedx + zombiedy*zombiedy);
		zombiedx /= zombieLength;
		zombiedy /= zombieLength;
		zombieX += zombiedx;
		zombieY += zombiedy;
		
	}
	
}