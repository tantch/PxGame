package com.tantch.pixelscamp.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PxAvatar {

	private String name;
	private int attack;
	private int defense;
	private int currentHP;
	private int maxHP;
	

	private Texture face;
	
	
	public PxAvatar(String name){
		this.name = name;
		this.attack = 1;
		this.defense = 0;
		this.currentHP = 10;
		this.maxHP = 10;
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
	
	public int getMaxHP() {
		return maxHP;
	}
	public int getCurrentHP(){
		return currentHP;
	}
	public boolean incAtk(int value){
		//if (value < 0 && )
		return false;
	}
	
	
	public void draw(SpriteBatch batch, int i, int j){
		
		batch.draw(face, 250,400);

		
	}
	
}
