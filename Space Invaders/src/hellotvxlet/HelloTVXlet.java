package hellotvxlet;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Timer;
import javax.tv.xlet.*;
import org.dvb.event.UserEventListener;
import org.bluray.ui.event.HRcEvent;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HStaticText;
import org.havi.ui.HTextButton;
import org.havi.ui.HVisible;
import org.havi.ui.event.HActionListener;


public class HelloTVXlet implements Xlet, HActionListener, UserEventListener {
    
    HScene scene;
    
  
    public HelloTVXlet() {
        
        
    }

    MijnComponent mc=new MijnComponent(0, 0, 720, 576);
    
    public void initXlet(XletContext context) {
        
        scene=HSceneFactory.getInstance().getDefaultHScene();
        
        UserEventRepository rep=new UserEventRepository("naam");
        rep.addAllArrowKeys();
        rep.addKey(HRcEvent.VK_ENTER);
        EventManager manager=EventManager.getInstance();
        manager.addUserEventListener(this, rep);
        
        scene.add(mc);
        scene.validate();
        scene.setVisible(true);
        
        
        Timer t=new Timer();
        MijnTimerTask mtt=new MijnTimerTask();
        mtt.setMc(mc);
        t.scheduleAtFixedRate(mtt, 0, 5);
        //start elke 100ms
    }
    
    public void userEventReceived(UserEvent e){
    if (e.getType()==HRcEvent.KEY_PRESSED)
    {
        if(e.getCode()==HRcEvent.VK_LEFT) mc.x-=5;
        if(e.getCode()==HRcEvent.VK_RIGHT) mc.x+=5;

        if(e.getCode()==HRcEvent.VK_ENTER && mc.shooty<0) { mc.shootx=mc.x + 60; mc.shooty=mc.y;} 
        mc.repaint();
    }
    }

    public void startXlet() {
    
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
        
        
     
    }
    
    public void actionPerformed(ActionEvent arg0)  {
            
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
