package com.tantch.pixelscamp.game.entities;



public class PxEnemy extends PxAvatar
{
	private int dificulty;

	public PxEnemy(String name, int dificulty) {
		super(name);
		this.dificulty = dificulty;
		this.maxHP = 10*this.dificulty;
		this.currentHP= this.maxHP;
	}
	
	public int getDificulty(){
		return dificulty;
	}
	
	public int changeDificulty( int dif){
		if(dif > 8){
			this.dificulty = 8;
			
			
		} else if (dif < 1){
			this.dificulty = 1;
		}
		else {
			this.dificulty = dif;
		}
		this.maxHP = 10*this.dificulty;
		this.currentHP= this.maxHP;
		return this.dificulty;
	}


}
