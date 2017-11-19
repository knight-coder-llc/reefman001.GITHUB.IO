/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipgraphical;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;


public class BattleShipGraphical extends JPanel implements MouseMotionListener, MouseListener, ActionListener{
    
        PatrolBoat patrolBoat;
	Submarine submarine;
	Destroyer destroyer;
	static Timer timer;
	Image img;
	int x = 0; int y = 0;
	boolean isMouseDrag;
	boolean isMousePressed;
	Point mousePoint;
        
        public BattleShipGraphical(){
		patrolBoat = new PatrolBoat();
		submarine = new Submarine();
		destroyer = new Destroyer();
		setBackground(Color.LIGHT_GRAY);
		addMouseMotionListener(this);
		addMouseListener(this);
		isMouseDrag = false;
		isMousePressed = false;
		timer = new Timer(2, this);
		timer.start();
	}
    @Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		super.repaint();
	}
	@Override
	public void paintComponent(Graphics g){
		/*frame width and height = 800 pixels,each rectangular panel is 512 X 512
		scale can be set: 32, 64 etc.*/
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		//+3 -3
		g.fillRect(0, 0, getWidth()/2-4, getHeight()/2 + 112);
		g.fillRect(getWidth()/2+4, 0, getWidth()/2, getHeight()/2 + 112);
		//starting point-> x1,y1, ending point ->x2,y2
		g.setColor(Color.BLACK);
		for(int i = 0; i < getWidth()/2 + 4; i+= 55){
			g.drawLine(i, 0, i, getHeight()/2 + 111);
			g.drawLine(0, i, getWidth()/2 - 5, i);
		}
		//draw grid for attack board
		for(int j = 0,i = getWidth()/2 + 4; i < getWidth(); i+= 55, j+=55){
			g.drawLine(i, 0, i, getHeight()/2 + 111);
			g.drawLine(getWidth()/2 + 4, j, getWidth(), j);
		}
		//ship factory implementation
		patrolBoat.repaint(g);
		submarine.repaint(g);
		destroyer.repaint(g);
		
	}
	
	public static void main(String[] args) {
		/*splash
		JWindow window = new JWindow();
	    
	    window.getContentPane().add(new JLabel("", new ImageIcon("C:\\Users\\Notorious-V\\Desktop\\resources\\robot.png"), SwingConstants.CENTER));
	    window.setBounds(150, 0, 1600, 1200);
	    window.setVisible(true);
	    try {
	        Thread.sleep(5000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	    window.setVisible(false);
	    window.dispose();*/
		//set modern look and feel for the application
		try {
            for(LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ign){}
        }
		
		//create the frame
		JFrame f = new JFrame();
		f.setSize(1120,  930);//1036 800
		f.setTitle("BattleShip");
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.add(new BattleShipGraphical());
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create components for the frame
		JMenuBar jmenuBar = new JMenuBar();
		f.setJMenuBar(jmenuBar);
		
		JMenu jMenu = new JMenu("File");
		jmenuBar.add(jMenu);
		
		JMenuItem mnItem_New = new JMenuItem("New Game");
		jMenu.add(mnItem_New);
		
		JMenuItem mnItem_Exit = new JMenuItem("Exit");
		jMenu.add(mnItem_Exit);
		mnItem_Exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				System.exit(0);
			}
		});
	}
   //mouse control implementations
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//x = e.getX(); y = e.getY();
		//System.out.println(x +" "+ y);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
    //this method will grab the image
	@Override
	public void mousePressed(MouseEvent e) {
	  
		Graphics2D g2d = (Graphics2D) getGraphics();
		mousePoint = new Point(e.getX(), e.getY());
		//submarine.setX(x); submarine.setY(y);
		
		g2d.drawImage(submarine.img, submarine.getX(), submarine.getY(), null);
		//get mouse coordinates
		System.out.println(isMouseDrag);
      
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		x = e.getX(); y = e.getY();
		//define ship placement patterns to be set within grid bounds. Defined for vertical: if(orientate() == 1 && ....) else{};
		if(x >= 477 || y >= 530){return;}
		
		//reset drag if mouse is released.
		//isMouseDrag = false;
		submarine.setX((x/55)*55);//((x/53)*53)+15);
		submarine.setY((y/55)*55);//((y/53)*53)+5);
		System.out.println(isMouseDrag+", "+x+", "+ y+" patrol boat cords: "+submarine.getX()+", "+submarine.getY());
		//patrolBoat.repaint(g);
		isMouseDrag = false;
		//e.consume();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		Graphics2D g2d = (Graphics2D) getGraphics();
		x = e.getX(); y = e.getY();
		
		isMouseDrag = true;
		//g2d.setXORMode(getBackground());
		if(x >= 477 || y >= 530){return;}
		g2d.drawImage(submarine.img, submarine.getX(), submarine.getY(), null);
		
		submarine.setX(x); submarine.setY(y);
		//super.repaint();
		//g.clearRect(x, y, submarine.img.getWidth(null), submarine.img.getHeight(null));
		//repaint();
		
		System.out.println("mouse is dragged!"+" "+isMouseDrag);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

