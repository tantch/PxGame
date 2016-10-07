package com.tantch.pixelscamp.game.entities;

import com.badlogic.gdx.files.FileHandle;

public abstract class PxSkill {
	
	


	protected String name;
	
	
	public PxSkill(){
		this.name = "empty";

	}
	
	public String getName(){
		
		return name;
		
	
	}

	
	public abstract boolean useSkill(PxAvatar caster,PxAvatar target);
	
	
	
	
	
	
	
	

}
