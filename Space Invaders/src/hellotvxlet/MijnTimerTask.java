/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;
import java.util.TimerTask;
/**
 *
 * @author student
 */
public class MijnTimerTask extends TimerTask {
    
    MijnComponent mc;
    int totalAliens = MijnComponent.aliens;
    int meestRechts = 1;
    
    public void setMc (MijnComponent mc_p)
    {
        mc = mc_p;
    }
    
    public void run()
    {
        System.out.println(".");
        mc.ay++;  

        int links=-1;
        int minx=10000;
        int maxx=-10000;
        
        for (int i=0;i<mc.aliens;i++)
        {
            if (mc.alienXa[i]<minx && mc.alienYa[i]>0) 
            {
                minx=mc.alienXa[i]; links=i; 
            }
            
            if (mc.alienXa[i]>maxx && mc.alienYa[i]>0) 
            { 
                maxx=mc.alienXa[i]; meestRechts=i; 
            }
        }
        if (links==-1) { links=0; }
        
        System.out.println("links="+links);
        
        if (mc.alienXa[meestRechts]>720-110 ) {
            for (int i=0;i<mc.aliens;i++)
            mc.alienRa[i]=-1; 
        }
       
        if (mc.alienXa[links]<=0) 
        {
            for (int i=0;i<mc.aliens;i++)
            {
                mc.alienRa[i]=+1;
            }
        }
        
        for(int i=0; i < mc.aliens; i++)
        {
            mc.alienXa[i]+=mc.alienRa[i];
        }
    
        if(mc.ay>570) mc.ay=0;
        
        if (mc.shooty>0)
            {
                 for (int i=0;i<mc.aliens;i++)
                 if(mc.alienXa[i] < mc.shootx && mc.alienXa[i]+110 > mc.shootx && mc.alienYa[i] < mc.shooty && mc.alienYa[i]+101 > mc.shooty)
                 {
                    mc.alienYa[i]=-200;
                    totalAliens--;
                    mc.shooty=-200;
                 }
            }
        if (mc.shooty>-10)
        {
            mc.shooty-=10;
        }
        
        if ( totalAliens== 0)
        {
            mc.einde = true;
        }
        
        mc.repaint();

    }

}
