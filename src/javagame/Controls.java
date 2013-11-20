package javagame;

import javax.sound.midi.Soundbank;

import org.newdawn.slick.*;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;


public class Controls extends BasicGameState implements ComponentListener{


	private MouseOverArea[] areas = new MouseOverArea[2];
	Image startButton;

	StateBasedGame sbg;

	public Controls(int state)
	{

	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{


		//replace these with "Play" and "About"
		startButton = new Image("res/images/buttons/SGB_buttonstart_01.png");

		this.sbg = sbg;

		areas[0] = new MouseOverArea(gc, startButton, 200, 400 + (0*100), 200, 90, this);
		areas[0].setNormalColor(new Color(1,1,1,0.8f));
		areas[0].setMouseOverColor(new Color(1,1,1,0.9f));




	}

	//for drawing things on screen
	public void render(GameContainer gc, StateBasedGame sgb, Graphics g) throws SlickException
	{
		g.setBackground(Color.red);
		



		for (int i=0;i<1;i++) {
			areas[i].render(gc, g);
		}
		
		g.drawString("WASD to move. Shift Key to swing baseball bat. Left mouse shoot. Right mouse reload. Shoot the zombies. Good luck." , 20, 200);
	}

	//for updating logics of the game
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException 
	{


	}

	public int getID()
	{
		return 3; //returns the ID of this class (menu is 0)
	}

	@Override
	public void componentActivated(AbstractComponent source) {
		System.out.println("ACTIVL : "+source);

		if (source == areas[0]) 
		{
			System.out.println("Entering Game");
			((Menu)sbg.getState(0)).titleBGM.stop();
			((Play)sbg.getState(1)).gameBGM.loop();
			sbg.enterState(1, new FadeOutTransition(Color.white, 1000), new FadeInTransition(Color.white, 1000) );
		}

	}


}


