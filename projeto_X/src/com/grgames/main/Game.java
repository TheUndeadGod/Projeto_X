package com.grgames.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Game extends Canvas implements KeyListener {

	private static final long serialVersionUID = -5309707430436861883L;

	private final int WIDTH = 200;
	private final int HEIGHT = 140;
	private final int SCALE = 3;
	
	private JFrame jframe;
	
	public Game() {
		this.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		initFrame();
	}
	
	public static void main(String[] args) {
		new Game();
	}
	
	// Inicia o JFrame.
	public void initFrame() {
		jframe = new JFrame("Projeto X");
		jframe.add(this);
		jframe.pack();
		jframe.setVisible(true);
		jframe.setResizable(false);
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/*
	 * -- Inico dos m�todos KeyListener.
	 */
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
	
	/*
	 * -- Final dos m�todos KeyListener.
	 */

}
