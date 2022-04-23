import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * @author Miguel Angel Cortes Hernandez
 * @version 20/Abril/2022
 * @apiNote class streetlights for threads desmostration
 */

public class StreetLights extends JFrame implements ActionListener{
    
    private JButton On, Off, info;
    private JPanel panel;
    private SLight A, B, C;
    public Message obj = new Message();
   
    public StreetLights(){
        super("Tester_StreetLights");//title
        Off = new JButton("off Lights");//buttons to GUI
        On = new JButton("on Lights");
        info = new JButton("credits");
        panel = new JPanel();
        panel.setBackground(new Color(50,150, 200));//set Color to background
        Container contain = getContentPane();
        panel.add(Off);//add buttons to panel
        panel.add(On);
        panel.add(info);//opcional
        contain.add(panel);
        Off.addActionListener(this);//create listener to buttons
        On.addActionListener(this);
        info.addActionListener(this);//opcional
        setSize(1200, 600);//window size
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);//position
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==On){
            A=new SLight(134, 187, 0); //call constructor from SLight class 
            B=new SLight(500, 554, 1000);  
            C=new SLight(867, 920, 2000);  

            A.start();//ejecutable thread
            //*****this part is to sincronize trafficLights, it do correct, */
            /*try {
                B.sleep(1000);
            } catch (InterruptedException io) {
                obj.error();
            }*/
            B.start();
            /*try {
                C.sleep(1000);
            } catch (InterruptedException io) {
                obj.error();
            }*/
            C.start();
            
        }

        if(e.getSource()==Off){
            obj.exit();}//call method exit from Message class
        
        if(e.getSource()==info){//this is opcional
            obj.author();//call method author froma Message class
        }
    }


    public static void main(String[] args) {//main method
        new StreetLights();//call constructor from StreetLights class
    }
/**
 * @author Miguel Angel Cortes Hernandez
 * @version 20/Abril/2022
 * @apiNote internal class Slights for handling threads
 */
    protected class SLight extends Thread {//internal class
       
        private int SLx, CLx, time, i;//global var 

        protected SLight(int value2, int value3, int value){
            time = value; SLx = value2; CLx = value3;}//updater var
    
        @Override
        public void run() {//run method
            Graphics g = getGraphics();//create Graphics var
            while(true){//first while to thread process
                g.setColor(new Color(50, 50, 50));//gray 
                g.fillRoundRect(SLx,134,200,333,20,20);//traffic_Light figure
                while(i<1){//internal while to sincronize thread
                g.setColor(new Color(50, 100, 50));
                g.fillOval(CLx, 167, 87, 67);//on green
                g.setColor(new Color(100, 100, 50));
                g.fillOval(CLx, 267, 87, 67);//off yellow
                g.setColor(new Color(100, 50, 50));
                g.fillOval(CLx, 364, 87, 70);//off red
                i++;//while's counter
                try{sleep(time);}catch(InterruptedException ie){obj.error();}}//time's wait to initialize lights

                g.setColor(new Color(50, 250, 50));
                g.fillOval(CLx, 167, 87, 67);//on green
                g.setColor(new Color(100, 100, 50));
                g.fillOval(CLx, 267, 87, 67);//off yellow
                g.setColor(new Color(100, 50, 50));
                g.fillOval(CLx, 364, 87, 70);//off red
                try{sleep(1000);}catch(InterruptedException ie){obj.error();}//wait one second to start again
                    
                g.setColor(new Color(50,100, 50));
                g.fillOval(CLx, 167, 87, 67);//off green
                g.setColor(new Color(250, 250, 50));
                g.fillOval(CLx, 267, 87, 67);//on yellow
                g.setColor(new Color(100,50,50));
                g.fillOval(CLx, 364, 87, 70);//off red
                try{sleep(1000);}catch(InterruptedException ie){obj.error();}
                
                g.setColor(new Color(50,100,50));
                g.fillOval(CLx, 167, 87, 67);//off green
                g.setColor(new Color(100,100,50));
                g.fillOval(CLx, 267, 87, 67);//off yellow
                g.setColor(new Color(250, 50, 50));
                g.fillOval(CLx, 364, 87, 70);//on red
                try{sleep(1000);}catch(InterruptedException ie){obj.error();}
             }//end first while
        }//end method run
    
       
    }//end internal class
}//end main class
