package com.Nikhil.gaming;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.Nikhil.gaming.sprites.Enemy;
import com.Nikhil.gaming.sprites.Player;

public class Board extends JPanel{
	Timer timer;
	BufferedImage backgroundImage;
	Player player;
	Enemy enemies[] = new Enemy[4];
	public Board() {
		setSize(1500,920);
		loadImageBackGround();
		player = new Player();
		gameLoop();
		loadEnemies();
		bindEvents();
		setFocusable(true);
		
	}
	
	public void gameOver(Graphics pen) {
		if(player.iswin()) {
			pen.setFont(new Font("times", Font.BOLD, 100));
			pen.setColor(Color.RED);
			pen.drawString("winner ! ! !", 1500/3, 920/2);
			timer.stop();
		}
		for(Enemy e : enemies) {
			if(isCollide(e)) {
				pen.setFont(new Font("times", Font.BOLD, 100));
				pen.setColor(Color.RED);
				pen.drawString("Game Over", 1500/3, 920/2);
				timer.stop();
			}
		}
	}
	private boolean isCollide(Enemy enemy) {
		int xdis = Math.abs(player.x - enemy.x);
		int ydis = Math.abs(player.y - enemy.y);
		int maxH = Math.max(player.h,enemy.h);
		int maxW = Math.max(player.w,enemy.w);
		return xdis <=maxW -100 && ydis <=maxH -160;
		
	}
	private void gameLoop() {
		timer = new Timer(50,(e)->repaint());
		timer.start();
	}
	private void loadEnemies() {
		int x = 350;
		int gap = 300;
		int speed = 5;
		for(int i=0;i<4;i++) {
			enemies[i] = new Enemy(x,speed);
			x += gap;
			speed += 5;
		}
	}
	private void loadImageBackGround() {
		try {
			backgroundImage = ImageIO.read(Board.class.getResource("backgroundimg.jpg"));
		} catch (IOException e) {
			System.out.println("BkImg not found");
			System.exit(1);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void bindEvents() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
					player.speed = 10;
				}
				else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					player.speed = - 10;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				player.speed = 0;
			}
			
		});
	}
	
	private void printE(Graphics pen) {
		for(Enemy enemy : enemies) {
			enemy.draw(pen);
			enemy.move();
		}
	}
	@Override
	public void paintComponent(Graphics pen){
		//All printing logic will be here
		//super matlab mtlb upar to parrent kon hai JPannel to hum JPannel ki taraf ja rhe hAI
		super.paintComponent(pen);//cleanup jo hoga board pe clean ho jayega
		pen.drawImage(backgroundImage,0,0,1500,920,null);
		player.draw(pen);
		player.move();
		printE(pen);
		gameOver(pen);
		
	}

}
