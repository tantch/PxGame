package com.tantch.pixelscamp.game.entities.skills;

import com.badlogic.gdx.files.FileHandle;
import com.tantch.pixelscamp.game.entities.PxAvatar;
import com.tantch.pixelscamp.game.entities.PxSkill;

public class PxPhysicalSkill extends PxSkill {

	private float baseDmg;
	private float attackMod;

	public PxPhysicalSkill() {
		baseDmg = 0f;
		attackMod = 0f;
	}

	public PxPhysicalSkill(String name, float baseDmg, float attackMod) {

		this.name = name;
		this.baseDmg = baseDmg;
		this.attackMod = attackMod;

	}

	@Override
	public boolean useSkill(PxAvatar caster, PxAvatar target) {

		float totalDmg = this.baseDmg + this.attackMod * caster.getAtk();

		target.receiveDamage(totalDmg);

		return true;
	}

	public void loadSkill(FileHandle file) {

		String data = file.readString();

		String[] dataLines = data.split("\n");
		String name = dataLines[0].split("#:")[1];
		System.out.println("Name: " + name);
		this.name =name;
		String baseDmg = dataLines[1].split("#:")[1];
		System.out.println("baseDmg: " + baseDmg);
		this.baseDmg = Float.parseFloat(baseDmg);
		String attackMod = dataLines[2].split("#:")[1];
		System.out.println("attackMod: " + attackMod);
		this.attackMod = Float.parseFloat(attackMod);

	}
}
