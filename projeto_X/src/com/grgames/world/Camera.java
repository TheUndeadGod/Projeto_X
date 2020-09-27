package com.grgames.world;

public class Camera {

	private static int x = 0;
	private static int y = 0;
	
	public static int clamp(int atual, int min, int max) {
		
		if(atual < min){
			atual = min;
		}
		
		if(atual > max) {
			atual = max;
		}
		
		return atual;
	}

	/*
	 * Métodos GETs.
	 */
	
	public static int getX() {
		return x;
	}

	public static int getY() {
		return y;
	}
	
}
