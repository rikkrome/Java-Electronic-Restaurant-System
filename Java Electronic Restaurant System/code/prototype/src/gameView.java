import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JPanel;

public class gameView {
	
	
	private JPanel mainView;

	public gameView(String TableNumber){
		System.out.println("gameView");
		try {
			Desktop.getDesktop().open(new File("Tic-Tac-Toe.jar"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		JPanel contentPane = prototype_standard.returnContentPaneView();
//
//    	mainView = new JPanel();
//
//		mainView.setLayout(new BorderLayout(0, 0));
//		
//		GameFrame frame = new GameFrame();
//		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		frame.setSize(650,450);
//		frame.setVisible(true);
//		frame.setup();
//		frame.intro();
//		frame.run();
		
//		mainView.add(frame);
//		contentPane.removeAll();
//    	contentPane.add(frame); 
	}
	 public JPanel returnView(){    	
	    	
			return mainView;
	    }
	

}

@SuppressWarnings("serial")
class GameFrame extends JFrame
{
	Image raster;
	static Graphics rasterGraphics;
	private Image Background,gameover,gameover2,Intro0,Intro1,Intro2,Intro3,Intro4,
	IntroLoading0,IntroLoading1,IntroLoading2,IntroLoading3,
	IntroLoading4,IntroLoading5,IntroLoading6,IntroLoading7,
	IntroLoading8,IntroLoading9,Introone,Introtwo,Introthree;
			
	public static final AffineTransform identity = new AffineTransform();
	public static ArrayList<ScreenObj> ScreenObjs = new ArrayList<ScreenObj>();
	
	public GameFrame()
	{
		ScreenObjs.add(new Player());		
		this.addKeyListener((Player)ScreenObjs.get(0));//This line is not ideal		
	}
	public void setup()
	{
		raster = this.createImage(650, 450);
		rasterGraphics = raster.getGraphics();	
		Background = new ImageIcon("background.png").getImage();
		gameover = new ImageIcon("gameoverbk.png").getImage();
		gameover2 = new ImageIcon("gameoverw.png").getImage();
		Intro0 = new ImageIcon("Intro0.png").getImage();
		Intro1 = new ImageIcon("Intro1.png").getImage();
		Intro2 = new ImageIcon("Intro2.png").getImage();
		Intro3 = new ImageIcon("Intro3.png").getImage();
		Intro4 = new ImageIcon("Intro4.png").getImage();
		Introone = new ImageIcon("Introone.png").getImage();
		Introtwo = new ImageIcon("Introtwo.png").getImage();
		Introthree = new ImageIcon("Introthree.png").getImage();
		IntroLoading0 = new ImageIcon("IntroLoading0.png").getImage();
		IntroLoading1 = new ImageIcon("IntroLoading1.png").getImage();
		IntroLoading2 = new ImageIcon("IntroLoading2.png").getImage();
		IntroLoading3 = new ImageIcon("IntroLoading3.png").getImage();
		IntroLoading4 = new ImageIcon("IntroLoading4.png").getImage();
		IntroLoading5 = new ImageIcon("IntroLoading5.png").getImage();
		IntroLoading6 = new ImageIcon("IntroLoading6.png").getImage();
		IntroLoading7 = new ImageIcon("IntroLoading7.png").getImage();
		IntroLoading8 = new ImageIcon("IntroLoading8.png").getImage();
		IntroLoading9 = new ImageIcon("IntroLoading9.png").getImage();
	}
	public void CreateBall()
	{
		ScreenObjs.add(new Ball((float)200,300,0, 4.0f, 3.6f,0));
	}
	public void run()
	{
		int FrameNumber=0;
		int Invincible=1;
		CreateBall();
		CreateWalls();
		while (true)
		{
			FrameNumber++;
			if (Invincible > 0)
				Invincible--;
			DrawBackground(rasterGraphics);
			rasterGraphics.drawString("Score: "+ScreenObj.score,55,85);
			boolean nextLevel = true;
			for (int i=ScreenObjs.size()-1;i>=0;i--)
			{
				ScreenObj so = ScreenObjs.get(i);
				//Act on the various objects
				so.Act(FrameNumber,Invincible);		
				
				//Draw various screen objects							
				so.Draw(rasterGraphics,Invincible);
				if (so instanceof Wall)
					nextLevel = false;
				

				
			}
			if (nextLevel)
			{
				    outtro();
				    break;
			}
			//Draw final Image
			this.getGraphics().drawImage(raster,0,0,null);			
			try{
				Thread.sleep(10);
			}catch(Exception e){}

		}
	}
	public void DrawBackground(Graphics g)
	{
		g.drawImage(Background,0,0,650,450,null);			

	}

	public void CreateWalls()
	{	//Left
		ScreenObjs.add(new Wall((float)63,105));
		ScreenObjs.add(new Wall((float)63,160));
		ScreenObjs.add(new Wall((float)63,225));
		ScreenObjs.add(new Wall((float)63,350));
		//LeftMid
		ScreenObjs.add(new Wall((float)170,160));
		ScreenObjs.add(new Wall((float)170,240));
		//Mid
		ScreenObjs.add(new Wall((float)280,160));
		ScreenObjs.add(new Wall((float)280,240));
		//RightMid
		ScreenObjs.add(new Wall((float)390,160));
		ScreenObjs.add(new Wall((float)390,240));
		//right
		ScreenObjs.add(new Wall((float)475,105));
		ScreenObjs.add(new Wall((float)475,160));
		ScreenObjs.add(new Wall((float)475,225));
		ScreenObjs.add(new Wall((float)475,350));	
	}
	public void outtro()
	{
		for (int i=0;i< 10;i++)
		{	

			EndCard(rasterGraphics);
			Font stringFont = new Font( "SansSerif", Font.PLAIN, 30); 
			rasterGraphics.setFont( stringFont );
			rasterGraphics.drawString("Final Score: "+ScreenObj.score,170,300);
			this.getGraphics().drawImage(raster,0,0,null);			
			try{
				Thread.sleep(80);
			}catch(Exception e){}

			EndCard2(rasterGraphics);
			rasterGraphics.drawString("Final Score: "+ScreenObj.score,170,300);
			this.getGraphics().drawImage(raster,0,0,null);			
			try{
				Thread.sleep(80);
			}catch(Exception e){}
			
		}
	}
	public static void redscreen()
	{
		red(rasterGraphics);
		try{
			Thread.sleep(80);
		}catch(Exception e){}
	}
	public static void red(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillRect(0,0,650,450);
	}
	public void EndCard(Graphics g)
	{
		g.drawImage(gameover,0,0,650,450,null);			

	}
	public void EndCard2(Graphics g)
	{
		g.drawImage(gameover2,0,0,650,450,null);			

	}
	public void intro()
	{
		for(int i = 0 ; i <2 ; i++)
		{				
			
			Intro0(rasterGraphics);
			this.getGraphics().drawImage(raster,0,0,null);			
			try{
				Thread.sleep(80);
			}catch(Exception e){}
			
			Intro1(rasterGraphics);
			this.getGraphics().drawImage(raster,0,0,null);			
			try{
				Thread.sleep(80);
			}catch(Exception e){}
			
			Intro2(rasterGraphics);
			this.getGraphics().drawImage(raster,0,0,null);			
			try{
				Thread.sleep(80);
			}catch(Exception e){}
			
			Intro3(rasterGraphics);
			this.getGraphics().drawImage(raster,0,0,null);			
			try{
				Thread.sleep(80);
			}catch(Exception e){}
			
			Intro4(rasterGraphics);
			this.getGraphics().drawImage(raster,0,0,null);			
			try{
				Thread.sleep(80);
			}catch(Exception e){}
			
		}
		
		//0%
		IntroLoading0(rasterGraphics);
		this.getGraphics().drawImage(raster,0,0,null);			
		try{
			Thread.sleep(200);
		}catch(Exception e){}
		
		//1%
		IntroLoading1(rasterGraphics);
		this.getGraphics().drawImage(raster,0,0,null);			
		try{
			Thread.sleep(1000);
		}catch(Exception e){}
		
		//5%
		IntroLoading2(rasterGraphics);
		this.getGraphics().drawImage(raster,0,0,null);			
		try{
			Thread.sleep(500);
		}catch(Exception e){}
		
		//20%
		IntroLoading3(rasterGraphics);
		this.getGraphics().drawImage(raster,0,0,null);			
		try{
			Thread.sleep(300);
		}catch(Exception e){}
		
		//22%
		IntroLoading4(rasterGraphics);
		this.getGraphics().drawImage(raster,0,0,null);			
		try{
			Thread.sleep(300);
		}catch(Exception e){}
		//10%
		IntroLoading5(rasterGraphics);
		this.getGraphics().drawImage(raster,0,0,null);			
		try{
			Thread.sleep(500);
		}catch(Exception e){}
		//50%
		IntroLoading6(rasterGraphics);
		this.getGraphics().drawImage(raster,0,0,null);			
		try{
			Thread.sleep(300);
		}catch(Exception e){}
		
		//80%
		IntroLoading7(rasterGraphics);
		this.getGraphics().drawImage(raster,0,0,null);			
		try{
			Thread.sleep(300);
		}catch(Exception e){}
		//99%
		IntroLoading8(rasterGraphics);
		this.getGraphics().drawImage(raster,0,0,null);			
		try{
			Thread.sleep(2000);
		}catch(Exception e){}
		//100%
		IntroLoading9(rasterGraphics);
		this.getGraphics().drawImage(raster,0,0,null);			
		try{
			Thread.sleep(300);
		}catch(Exception e){}
		//321 
		Introthree(rasterGraphics);
		this.getGraphics().drawImage(raster,0,0,null);			
		try{
			Thread.sleep(500);
		}catch(Exception e){}
		Introtwo(rasterGraphics);
		this.getGraphics().drawImage(raster,0,0,null);			
		try{
			Thread.sleep(500);
		}catch(Exception e){}
		Introone(rasterGraphics);
		this.getGraphics().drawImage(raster,0,0,null);			
		try{
			Thread.sleep(500);
		}catch(Exception e){}	
	}
	//intro photos
	public void Introone(Graphics g)
	{
		g.drawImage(Introone,0,0,650,450,null);			
	}
	public void Introtwo(Graphics g)
	{
		g.drawImage(Introtwo,0,0,650,450,null);			
	}
	public void Introthree(Graphics g)
	{
		g.drawImage(Introthree,0,0,650,450,null);			
	}
	public void Intro0(Graphics g)
	{
		g.drawImage(Intro0,0,0,650,450,null);			
	}
	public void Intro1(Graphics g)
	{
		g.drawImage(Intro1,0,0,650,450,null);			
	}
	public void Intro2(Graphics g)
	{
		g.drawImage(Intro2,0,0,650,450,null);			
	}
	public void Intro3(Graphics g)
	{
		g.drawImage(Intro3,0,0,650,450,null);			
	}
	public void Intro4(Graphics g)
	{
		g.drawImage(Intro4,0,0,650,450,null);			
	}
	public void IntroLoading0(Graphics g)
	{
		g.drawImage(IntroLoading0,0,0,650,450,null);			
	}
	public void IntroLoading1(Graphics g)
	{
		g.drawImage(IntroLoading1,0,0,650,450,null);			
	}
	public void IntroLoading2(Graphics g)
	{
		g.drawImage(IntroLoading2,0,0,650,450,null);			
	}
	public void IntroLoading3(Graphics g)
	{
		g.drawImage(IntroLoading3,0,0,650,450,null);			
	}
	public void IntroLoading4(Graphics g)
	{
		g.drawImage(IntroLoading4,0,0,650,450,null);			
	}
	public void IntroLoading5(Graphics g)
	{
		g.drawImage(IntroLoading5,0,0,650,450,null);			
	}
	public void IntroLoading6(Graphics g)
	{
		g.drawImage(IntroLoading6,0,0,650,450,null);			
	}
	public void IntroLoading7(Graphics g)
	{
		g.drawImage(IntroLoading7,0,0,650,450,null);			
	}
	public void IntroLoading8(Graphics g)
	{
		g.drawImage(IntroLoading8,0,0,650,450,null);			
	}
	public void IntroLoading9(Graphics g)
	{
		g.drawImage(IntroLoading9,0,0,650,450,null);			
	}
}

abstract class ScreenObj
{
	//public Point2D location;
	public Vector2D location, Velocity;
	public int Radius;

	public float Speed, Delta, MaxSpeed;
	public float Angle, DeltaAngle;	
	public java.awt.Image image;
	public boolean isAlive;
	static float score = 0;
	
	public abstract void Act(int frame, int Invincible);
	public abstract void Draw(Graphics g, int Invincible);
	public void Die()
	{
		isAlive = false;
		GameFrame.ScreenObjs.remove(this);
	}
	/**
	 * @returns the distance between this ScreenObj and the one passed in
	 */
	public float Distance(ScreenObj so)
	{
		double XDelta = location.getX() - so.location.getX();
		double YDelta = location.getY() - so.location.getY();
		return (float)Math.sqrt(XDelta * XDelta + YDelta*YDelta);
	}	
	public void Score(float point)
	{
		score += point;
	}
	public void BlockCollision()
	{
		Velocity.setX(Velocity.getX() * -1);
		Velocity.setY(Velocity.getY() * -1);
	}
	public void PlayerCollision()
	{
		Velocity.setY(Velocity.getY() * -1);
	}
}
class Player extends ScreenObj implements KeyListener
{		
	public boolean UP, DOWN, RIGHT, LEFT, RL, RR, SPACE;
	public final int MOVE_AMOUNT = 20;		
	public Player()
	{
		location = new Vector2D();
		Velocity = new Vector2D();
		location.set(280,408);	
		Delta = 0.3f;
		MaxSpeed = 7f;
		DeltaAngle = 5;
		image = new ImageIcon("hand.png").getImage();
		if (image.getHeight(null) < 8)
			System.err.println("Could not find ship");
	}
	public void Draw(Graphics g, int Invinsible) 
	{		
		AffineTransform at = new AffineTransform();
		at.setTransform(GameFrame.identity);
		at.translate(location.getX()-32,location.getY()-32);
		at.rotate(Math.toRadians(Angle),32,32);
		
		Graphics2D g2d = (Graphics2D)g;
		if (Invinsible == 0 || Invinsible % 3 == 0)
			g2d.drawImage(image,at,null);
	}
	public void Act(int frame, int Invincible)
	{
		//boundaries
		if (location.getX() > 447)
			location.set(446, location.getY());
		else if (location.getX() < 90)
			location.set(91,location.getY());
			ShipMovment();			
	}
	/**
	 * Called from act
	 */
	private void ShipMovment()
	{					
			if (RIGHT)
			{
				location.set(location.getX()+MOVE_AMOUNT, location.getY());
			}
			if (LEFT)
			{
				location.set(location.getX()-MOVE_AMOUNT, location.getY());
			}						
	}
	
	//KeyListener
	public void keyTyped(KeyEvent e) { /*do nothing*/ }

    /** Handle the key-pressed event from the text field. */
    public void keyPressed(KeyEvent e) 
    { 	    		    	
    	if (e.getKeyCode() == KeyEvent.VK_RIGHT)
    	{
    		RIGHT=true;
    	}
    	if (e.getKeyCode() == KeyEvent.VK_LEFT)
    	{
    		LEFT=true;
    	}	    	
    }
    /** Handle the key-released event from the text field. */
    public void keyReleased(KeyEvent e) 
    {	    		    	
    	if (e.getKeyCode() == KeyEvent.VK_RIGHT)
    	{
    		RIGHT=false;
    	}
    	if (e.getKeyCode() == KeyEvent.VK_LEFT)
    	{
    		LEFT=false;
    	}	    	             
    }
}
class Ball extends ScreenObj
{
	public Ball(float x, float y, float Angle, float xv, float yv,int score)
	{
		MaxSpeed = 7f;
		location = new Vector2D();
		Velocity = new Vector2D();
		location.set(x,y);
		Velocity.set(xv, yv);
		this.Angle = Angle;
		Speed = (float)(4.0);
		Radius = 15;
	}					
	public void Act(int frame, int Invinsible)
	{			
		if (location.getX() > 480)
		{
			Velocity.setX(Velocity.getX() * -1);
			location.set(479, location.getY());
		}			
		else if (location.getX() < 55)
		{
			Velocity.setX(Velocity.getX() * -1);
			location.set(56,location.getY());
		}			
		if (location.getY() > 378)
		{
			Velocity.setY(Velocity.getY() * -1);
			location.set(location.getX(),377);
			score += -0.5;
			GameFrame.redscreen();
			
		}			
		else if (location.getY() < 80)
		{
			Velocity.setY(Velocity.getY() * -1);
			location.set(location.getX(),81);
	    }			
 		location = location.add( Velocity );
		//collision Detection
		for (ScreenObj so : GameFrame.ScreenObjs)
		{
			if (so == this)
				continue;
			if (so instanceof Player && Distance(so) < 40+Radius)
			{			
				Velocity.setY(Velocity.getY() + (float)0.2);
				this.PlayerCollision();
				break;
			}
			if (so instanceof Wall && Distance(so) < 20+Radius)
			{							
				Velocity.setX(Velocity.getX() + (float)1.9);						
				this.BlockCollision();
				break;
			}	
			if (so instanceof Ball && Distance(so) < 20+Radius)
			{							
				Velocity.setX(Velocity.getX() + (float)1.9);						
				this.BlockCollision();
				break;
			}	
		}
	}
	public void Draw(Graphics g, int i)
	{
		g.setColor(Color.WHITE);
		g.fillOval((int)location.getX()-Radius, (int)location.getY()-Radius, Radius*2, Radius*2);
	}	

}	
class Wall extends ScreenObj
{
	public int Radius;		
	public Wall(float x, float y)
	{			
		image = new ImageIcon("Block.png").getImage();
		location = new Vector2D();
		Velocity = new Vector2D();
		location.set(x,y);
		Radius = 18;	
	}
	public void Act(int frame, int Invinsible)
	{
		for (ScreenObj so : GameFrame.ScreenObjs)
		{
			if (so == this)
				continue;
			 if (so instanceof Ball && Distance(so) < 17+Radius)
			{
				 int i = 1*2;
				this.Die();
				so.Score(i++);
				break;
			}
		}			
	}
	public void Draw(Graphics g, int Invinsible) 
	{
		g.drawImage(image,(int)location.getX()-Radius,(int)location.getY()-Radius,Radius*2,Radius*2,null);
	}	
}
class Vector2D 
{
    private float x;
    private float y;
    public Vector2D() 
    {
        this.setX(0);
        this.setY(0);
    }

    public Vector2D(float x, float y) 
    {
        this.setX(x);
        this.setY(y);
    }
    public void set(float x, float y) 
    {
        this.setX(x);
        this.setY(y);
    }
    public void setX(float x) 
    {
        this.x = x;
    }
    public void setY(float y) 
    {
        this.y = y;
    }
    public float getX() 
    {
        return x;
    }
    public float getY() 
    {    	
        return y;
    }
    //Specialty method used during calculations of ball to ball collisions.
    public float dot(Vector2D v2) 
    {
    	float result = 0.0f;
        result = this.getX() * v2.getX() + this.getY() * v2.getY();
        return result;
    }
    public float getLength() 
    {
        return (float) Math.sqrt(getX() * getX() + getY() * getY());
    }
    public Vector2D add(Vector2D v2) 
    {
        Vector2D result = new Vector2D();
        result.setX(getX() + v2.getX());
        result.setY(getY() + v2.getY());
        return result;
    }
    public Vector2D subtract(Vector2D v2) 
    {
        Vector2D result = new Vector2D();
        result.setX(this.getX() - v2.getX());
        result.setY(this.getY() - v2.getY());
        return result;
    }
    public Vector2D multiply(float scaleFactor) 
    {
        Vector2D result = new Vector2D();
        result.setX(this.getX() * scaleFactor);
        result.setY(this.getY() * scaleFactor);
        return result;
    }
    //Specialty method used during calculations of ball to ball collisions.
    public Vector2D normalize() 
    {
    	float length = getLength();
        if (length != 0.0f) 
        {
            this.setX(this.getX() / length);
            this.setY(this.getY() / length);
        } 
        else 
        {
            this.setX(0.0f);
            this.setY(0.0f);
        }
        return this;
    }
    public String toString()
    {
    	return "("+x+", "+y+")";
    }
}
