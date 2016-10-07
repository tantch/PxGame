package com.tantch.pixelscamp.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tantch.pixelscamp.game.entities.PxAvatar;
import com.tantch.pixelscamp.game.entities.skills.PxPhysicalSkill;
import com.tantch.pixelscamp.game.screens.AvatarScreen;

public class PxGame extends Game {
	public SpriteBatch batch;
	
	@Override
	public void create() {

		this.batch = new SpriteBatch();

		//hardcoded player 
		//TODO load
		
		PxAvatar avatar = new PxAvatar("Psy"); 
		PxPhysicalSkill punch = new PxPhysicalSkill();
		punch.loadSkill(Gdx.files.internal("skills/RightPunch.pxskl"));
		avatar.addSkill(punch);
		
		this.setScreen(new AvatarScreen(this,avatar));
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose() {
		this.batch.dispose();
	}
}
