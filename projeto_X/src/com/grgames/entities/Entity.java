package com.grgames.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.grgames.world.Camera;

public class Entity {

	public double x, y, speed;
	private int width, heigth;
	private BufferedImage sprite;
	private int maskX, maskY, maskWidth, maskHeight;
	
	public Entity(double x, double y, int width, int height, BufferedImage sprite) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.heigth = height;
		this.sprite = sprite;
		
		this.maskX = 0;
		this.maskY = 0;
		this.maskWidth = width;
		this.maskHeight = height;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		
//		g.drawImage(sprite, getOffsetCameraX(), getOffsetCameraY(), null);
		
		g.setColor(Color.WHITE);
		g.fillRect(getXInteiro(), getYInteiro(), width, heigth);
	}
	
	public void setMask(int maskX, int maskY, int maskWidth, int maskHeight){
		this.maskX = maskX;
		this.maskY = maskY;
		this.maskWidth = maskWidth;
		this.maskHeight = maskHeight;
	}
	
	/*
	 * M�todos GETs.
	 */
	
	public int getOffsetCameraX() {
		return (int) (getX() - Camera.getX());
	}
	
	public int getOffsetCameraY() {
		return (int) (getY() - Camera.getY());
	}
		
	public double getX() {
		return x;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public int getXInteiro() {
		return (int) x;
	}
	
	public int getYInteiro() {
		return (int) y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeigth() {
		return heigth;
	}

	public BufferedImage getSprite() {
		return sprite;
	}

	public int getMaskX() {
		return maskX;
	}

	public int getMaskY() {
		return maskY;
	}

	public int getMaskWidth() {
		return maskWidth;
	}

	public int getMaskHeight() {
		return maskHeight;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
}
