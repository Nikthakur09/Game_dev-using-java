package com.Nikhil.gaming;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
	//constructor tbhi call hota hai jab oblect bnta hai
	Board board = new Board();
	GameFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //band karne k liye
		this.setSize(1500,920);//size of the frame
		add(board);
		this.setVisible(true);//screen dikh rahi hai
		this.setResizable(false); // size change na ho
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameFrame frame = new GameFrame();
		
		
	}

}
