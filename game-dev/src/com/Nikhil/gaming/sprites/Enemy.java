package com.Nikhil.gaming.sprites;

import javax.swing.ImageIcon;

public class Enemy extends Sprite{
	
	public Enemy(int x,int speed) {
		y = 30;
		this.x = x;
		this.speed = speed;
		w = 100;
		h = 100;
		image = new ImageIcon(Player.class.getResource("spider.gif"));

	}
	
	public void move() {
		if(y>900) {
			y=0;
		}
		y += speed; 
	}
}
