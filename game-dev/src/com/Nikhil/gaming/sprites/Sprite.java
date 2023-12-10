package com.Nikhil.gaming.sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public abstract class Sprite {
	public int speed;
	public int x,y,w,h;
	ImageIcon image;
	public void draw(Graphics pen) {
		pen.drawImage(image.getImage(),x,y,w,h,null);
	}


}
