/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipgraphical;

import java.awt.Graphics;

public interface Ship {
	//ship health
	public void health();
	//Vertical or Horizontal
	public void Orientation();
	//hit method
	public void hit();
	//set x
	public void setX(int x);
	//set y
	public void setY(int y);
	//get x coordinate
	public int getX();
	//get y coordinate
	public int getY();
	//paint component
	public void repaint(Graphics g);
}
