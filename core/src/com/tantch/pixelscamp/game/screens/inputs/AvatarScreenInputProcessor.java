package com.tantch.pixelscamp.game.screens.inputs;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.tantch.pixelscamp.game.entities.PxAvatar;
import com.tantch.pixelscamp.game.entities.PxEnemy;
import com.tantch.pixelscamp.game.entities.skills.PxPhysicalSkill;
import com.tantch.pixelscamp.game.screens.AvatarScreen;

public class AvatarScreenInputProcessor implements InputProcessor {

	private AvatarScreen screen;

	public AvatarScreenInputProcessor(AvatarScreen avatarScreen) {
		this.screen = avatarScreen;
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {

		Random r = new Random();
		int dif = r.nextInt(10) + 1;

		PxEnemy enemy = new PxEnemy("Enemy", dif);


		System.out.println("change to fight screen");
		screen.fight(enemy);
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
