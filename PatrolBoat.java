/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipgraphical;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class PatrolBoat implements Ship {
	int health;
	int orientate;
	int x, y;
	//supply image
	Image img;
	
	public PatrolBoat(){
		health = 1;
		orientate = 0;
		//get ship image may need method to return this image for drawing
		img = new ImageIcon("C:\\Users\\Notorious-V\\Desktop\\resources\\BattleShipSprites\\PatrolBoat.png").getImage();
		//starting x y coordinates
		x = 0;//110;
		y = 0;//110;
	}
	@Override
	public void health() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Orientation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hit() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}
	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}
	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		this.x = x;
	}
	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		this.y = y;
	}
	@Override
	public void repaint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(img, x, y, null);
	}
	
}
