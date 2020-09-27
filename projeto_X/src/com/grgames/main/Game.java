package com.grgames.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.grgames.entities.Player;

public class Game extends Canvas implements Runnable, KeyListener {

	private static final long serialVersionUID = -5309707430436861883L;

	private final int WIDTH = 200;
	private final int HEIGHT = 140;
	private final int SCALE = 3;
	
	private JFrame jframe;
	private Thread thread;
	private BufferedImage layer;
	
	private Player player;
	
	private boolean isRunning;
	
	public Game() {
		this.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		this.addKeyListener(this);
		initFrame();
		layer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		player = new Player(0, 0, 16, 16, null);
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.start();
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
	
	public synchronized void start() {
		thread = new Thread(this);
		isRunning = true;
		thread.start();
	}
	
	public synchronized void stop() {
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// M�todo respons�vel por TODA logica do jogo.
	public void tick() {
		player.tick();
	}
	
	// M�todo respons�vel por renderizar todo o jogo.
	public void render() {
		
		BufferStrategy bs = getBufferStrategy();
		
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = layer.getGraphics();		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// Inicio Renderiza o jogo.
		player.render(g);
		// Fim Renderiza o jogo.
		
		g.dispose();
		g = bs.getDrawGraphics();
		g.drawImage(layer, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		
		bs.show();
	}
	
	// M�todo respons�vel por deixar o game em loop, deve criar um FPS para deixar ele fluido.
	@Override
	public void run() {
		
		requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0; // Controlador do FPS.
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int frames = 0;
		double timer = System.currentTimeMillis();
		
		while(isRunning) {
		
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			if (delta > 1) {
				tick();
				render();
				delta--;
				frames++;
			}
			
			if (System.currentTimeMillis() - timer >= 1000) {
				System.out.println("FPS: " + frames);
				frames = 0;
				timer += 1000;
			}			
		}
		
		stop();
	}
	
	/*
	 * -- Inico dos m�todos KeyListener.
	 */
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		switch (e.getKeyCode()) {
		
		case KeyEvent.VK_UP:
			player.setUp(true);
			break;
			
		case KeyEvent.VK_DOWN:
			player.setDown(true);
			break;
			
		case KeyEvent.VK_LEFT:
			player.setLeft(true);
			break;
			
		case KeyEvent.VK_RIGHT:
			player.setRight(true);
			break;
		
		default:
			throw new IllegalArgumentException("Valor inesperado: " + e.getKeyCode());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		switch (e.getKeyCode()) {
		
		case KeyEvent.VK_UP:
			player.setUp(false);
			break;
			
		case KeyEvent.VK_DOWN:
			player.setDown(false);
			break;
			
		case KeyEvent.VK_LEFT:
			player.setLeft(false);
			break;
			
		case KeyEvent.VK_RIGHT:
			player.setRight(false);
			break;
		
		default:
			throw new IllegalArgumentException("Valor inesperado: " + e.getKeyCode());
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	/*
	 * -- Final dos m�todos KeyListener.
	 */

}
