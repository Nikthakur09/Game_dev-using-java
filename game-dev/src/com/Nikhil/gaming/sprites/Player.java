package com.Nikhil.gaming.sprites;

import javax.swing.ImageIcon;

public class Player extends Sprite{
	
	public Player(){
		w=200;
		h=200;
		x=30;
		y=460;
		image = new ImageIcon(Player.class.getResource("avatar.gif"));
	}
	public void move() {
		x += speed;
	}
	public boolean iswin() {
		return x > 1500;
	}
}
