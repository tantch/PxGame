package com.tantch.pixelscamp.game.entities;

import com.badlogic.gdx.graphics.Texture;

public class PxAvatar {

	private String name;
	private int attack;
	private int defense;
	private int totalHP;
	private Texture sprite;
	
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
	
	
}
