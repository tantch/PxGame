package com.tantch.pixelscamp.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tantch.pixelscamp.game.screens.AvatarScreen;

public class PxGame extends Game {
	public SpriteBatch batch;

	@Override
	public void create() {

		this.batch = new SpriteBatch();
		this.setScreen(new AvatarScreen(this));
	}

	@Override
	public void render() {
		super.render();

	}

	@Override
	public void dispose() {

	}
}
