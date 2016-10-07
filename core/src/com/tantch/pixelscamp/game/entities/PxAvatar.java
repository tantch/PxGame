package com.tantch.pixelscamp.game.entities;

import java.util.HashMap;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PxAvatar {

	protected String name;
	protected int attack;
	protected int defense;

	protected int currentHP;
	protected int maxHP;
	protected boolean alive;

	protected Texture face;

	protected HashMap<String, PxSkill> skills;

	public PxAvatar(String name) {
		this.name = name;

		this.attack = 1;
		this.defense = 0;
		this.maxHP = 10;
		this.currentHP = maxHP;
		this.alive = true;
		skills = new HashMap<String, PxSkill>();
		face = new Texture("sprites/Face.png");

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

	public int getMaxHP() {
		return maxHP;
	}

	public int getCurrentHP() {
		return currentHP;

	}

	public boolean isAlive() {
		return alive;
	}

	public Texture getFace() {
		return face;
	}

	public boolean incAtk(int value) {
		// if (value < 0 && )
		return false;
	}

	public void draw(SpriteBatch batch, int i, int j) {

		batch.draw(face, i, j);

	}

	public void addSkill(PxSkill skill) {

		skills.put(skill.getName(), skill);
		
		System.out.println("added skill: "  + skill.getName());
	}

	public void receiveDamage(float damage) {
		// TODO reduce with defense
		currentHP -= damage;
		if (currentHP <= 0) {
			currentHP = 0;
			die();
		}

	}

	protected void die() {
		this.alive = false;

	}

	public PxSkill getSkill(String string) {
		if (skills.containsKey(string)) {
			return skills.get(string);
		}
		System.out.println("Error: skill :" +string + " does not exist");
		return null;

	}

}
