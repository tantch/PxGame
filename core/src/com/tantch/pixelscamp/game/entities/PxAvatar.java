package com.tantch.pixelscamp.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PxAvatar {

	private String name;
	private int attack;
	private int defense;
	private int totalHP;
	private Texture face;
	
	
	public PxAvatar(String name){
		this.name = name;
		
		face = new Texture("sprites/Face.png");

	}
	
	public String getName(){
		return name;
	}
	
	public int getAtk(){
		return attack;
	}
	
	public int getDef(){
		return defense;
	}
	
	public int getTHP(){
		return totalHP;
	}
	public boolean incAtk(int value){
		//if (value < 0 && )
		return false;
	}
	
	
	public void draw(SpriteBatch batch, int i, int j){
		
		batch.draw(face, 250,400);

		
	}
	
}
