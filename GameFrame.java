/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipgraphical;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

public class GameFrame implements ActionListener {
	public static GameFrame frame;
	private final int WIDTH = 1000, HEIGHT = 800;
	//renderArt renderer;
	
	public GameFrame(){
		try{
            for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e){
            try{
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }catch (Exception ign){}
        }
		
		JFrame jFrame = new JFrame();
		//renderer = new renderArt();
		//add menu bar
		JMenuBar jMenuBar = new JMenuBar();
		jFrame.setJMenuBar(jMenuBar);
		//add menu
		JMenu jMenu = new JMenu("File");
		jMenuBar.add(jMenu);
		//add menu options
		JMenuItem jMenuItem = new JMenuItem("New Game");
		jMenu.add(jMenuItem);
		
		JMenuItem jMenuExit = new JMenuItem("Exit");
		jMenu.add(jMenuExit);
		 
		 jMenuExit.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0){
	                System.exit(0);
	            }
	        });
		//create frame
		//jFrame.add(renderer);
		jFrame.setSize(WIDTH, HEIGHT);
		jFrame.setLocationRelativeTo(null);
		jFrame.setTitle("Battleship");
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	//paint method
	void repaint(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
	}
	//action event handler
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
	}
	
	public static void main(String[] args) {
		frame = new GameFrame();

	}

	
}

