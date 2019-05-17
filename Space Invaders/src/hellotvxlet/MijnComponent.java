

package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import org.havi.ui.HComponent;
import java.awt.MediaTracker;

public class MijnComponent extends HComponent {
    
    Image spaceship;
    Image achtergrond;
    Image alien;
    static int aliens = 10;
    
    int alienXa[]=new int[aliens];
    int alienYa[]=new int[aliens];
    int alienRa[]= new int[aliens]; 
    
    int alienR=1;
    int alienR2=1;
    int alienR3=1;

    int x = 225;
    int y = 400;
    int ay = 0;
    int shootx=300, shooty=-300;
    boolean einde = false;
    
    public MijnComponent(int x, int y, int x2, int y2)
    {
        for (int i=0;i<aliens;i++)  
        { 
            alienXa[i]=110*i; alienYa[i]=50;
            if( i >= 6)
            {
                alienXa[i]=110*(i-5); alienYa[i-5]=150;
            }
        }
        
        for (int i=0;i<aliens;i++) 
        {
            alienRa[i]=1;
        }
        
        
        this.setBounds(x, y, x2, y2);
        spaceship=this.getToolkit().getImage("spaceship.png");
        
        achtergrond = this.getToolkit().getImage("sterren.png");
        
        alien = this.getToolkit().getImage("alien.png");
        
        MediaTracker mt=new MediaTracker(this);
        mt.addImage(spaceship, 1);
        

        mt.addImage(alien,2);
        
        try
        {
            mt.waitForAll();
        }
        catch(InterruptedException ex)
        {
            ex.printStackTrace();
        }
    }
    
    
    public void paint(Graphics g)
    {
        if (!einde)
            {
                g.drawImage(achtergrond, 0, ay, this);
                g.drawImage(achtergrond, 0, ay-570, this);
                g.drawImage(spaceship, x, y, this);  
                for (int i=0;i<aliens;i++) 
                {
                    g.drawImage(alien, alienXa[i], alienYa[i], this); 
                }
                g.fillOval(shootx, shooty, 10, 10);
            }
        else 
            {
                g.drawImage(achtergrond, 0, ay, this);
                g.drawImage(achtergrond, 0, ay-570, this);
                g.drawString("VICTORY, YOU SAVED THE UNIVERSE",200,300);
            }
    }
    }

