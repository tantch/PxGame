package com.tantch.pixelscamp.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PxAvatar {

	private String name;
	private int attack;
	private int defense;
	private float curHp;
	private float totalHp;
	private Texture face;

	public PxAvatar(String name) {
		this.name = name;

		face = new Texture("sprites/Face.png");

		attack = 10;
		defense = 10;
		totalHp = 16;
		curHp = totalHp;

	}

	public String getName() {
		return name;
	}

	public int getAtk() {
		return attack;
	}

	public int getDef() {
		return defense;
	}

	public float getTHp() {
		return totalHp;
	}
	public float getCurHp() {
		return curHp;
	}


	public boolean incAtk(int value) {
		// if (value < 0 && )
		return false;
	}

	public void draw(SpriteBatch batch, int i, int j) {

		batch.draw(face, i, j);

	}

	public void receiveDamage(float damage) {
		//TODO reduce with defense
		curHp-=damage;
		if(curHp<=0){
			curHp=0;
			die();
		}

	}

	private void die() {
		// TODO Auto-generated method stub
		
	}

}
