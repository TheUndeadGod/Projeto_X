package com.grgames.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player extends Entity {

	private boolean up, down, left, right;
	
	public Player(double x, double y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
		this.setSpeed(1.4);
	}
	
	public void tick() {
		
		checkMove();
	}
	
	public void render(Graphics g) {
		
		g.setColor(Color.WHITE);
		g.fillRect(getOffsetCameraX(), getOffsetCameraY(), getMaskWidth(), getMaskHeight());
	}

	public void checkMove() {
		
		if (isUp()) {
			this.setY( getY() - getSpeed() );
		}
		else if (isDown()) {
			this.setY( getY() + getSpeed() );
		}		
		
		if (isLeft()) {
			this.setX( getX() - getSpeed() );
		}
		else if (isRight()) {
			this.setX( getX() + getSpeed() );
		}
	}
	
	/*
	 * M�todos GETs.
	 */
	
	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

}
