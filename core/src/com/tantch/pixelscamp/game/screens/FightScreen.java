package com.tantch.pixelscamp.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.tantch.pixelscamp.game.PxGame;
import com.tantch.pixelscamp.game.entities.PxAvatar;
import com.tantch.pixelscamp.game.screens.inputs.AvatarScreenInputProcessor;
import com.tantch.pixelscamp.game.screens.inputs.FightScreenInputProcessor;

public class FightScreen implements Screen {

	final PxGame game;
	OrthographicCamera camera;
	private Viewport viewport;
	private int w;
	private int h;

	private PxAvatar avatar;
	private PxAvatar enemy;

    private ShapeRenderer shapeRenderer;
	private BitmapFont font;

	public FightScreen(PxGame game, PxAvatar avatar, PxAvatar enemy) {
		this.game = game;

		this.avatar = avatar;
		this.enemy = enemy;
		this.shapeRenderer = new ShapeRenderer();
		this.font = new BitmapFont();

		// camera and res solutions
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		camera = new OrthographicCamera();
		camera.setToOrtho(false);
		viewport = new FitViewport(640, 980, camera);

		Gdx.input.setInputProcessor(new FightScreenInputProcessor(this));

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0.5f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		game.batch.setProjectionMatrix(camera.combined);
		
		//avatar hp
		if(this.avatar.isAlive()){
			shapeRenderer.begin(ShapeType.Filled);
			shapeRenderer.setColor(1, 0, 0, 1);
			shapeRenderer.rect(this.w/4+100, h/2-25, (float)(this.avatar.getMaxHP()-this.avatar.getCurrentHP())/this.avatar.getMaxHP()*-200, -15);
			shapeRenderer.end();
			shapeRenderer.begin(ShapeType.Filled);
			shapeRenderer.setColor(0, 1, 0, 1);
			shapeRenderer.rect(this.w/4-100, h/2-25, (float) this.avatar.getCurrentHP()/this.avatar.getMaxHP()*200, -15);
			shapeRenderer.end();
		}
		//enemy hp
		if(this.enemy.isAlive()){
			shapeRenderer.begin(ShapeType.Filled);
			shapeRenderer.setColor(1, 0, 0, 1);
			shapeRenderer.rect(this.w*3/4+100, h/2-25, (float)(this.enemy.getMaxHP()-this.enemy.getCurrentHP())/this.enemy.getMaxHP()*-200, -15);
			shapeRenderer.end();
			shapeRenderer.begin(ShapeType.Filled);
			shapeRenderer.setColor(0, 1, 0, 1);
			shapeRenderer.rect(this.w*3/4-100, h/2-25, (float) this.enemy.getCurrentHP()/this.enemy.getMaxHP()*200, -15);
			shapeRenderer.end();
		}
		
		
		game.batch.begin();
		if(avatar.isAlive()){
			avatar.draw(game.batch,this.w/4,this.h/3);
			font.draw(game.batch, this.avatar.getCurrentHP() + " / " + this.avatar.getMaxHP(), this.w/4-10, h/2-25);
		}
		if(enemy.isAlive()){
			enemy.draw(game.batch,this.w*3/4,this.h/3);
			font.draw(game.batch, this.enemy.getCurrentHP() + " / " + this.enemy.getMaxHP(), this.w*3/4-90, h/2-25);
		}
		game.batch.end();

	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}
	
	public void takeDamage(float damage){
	
		avatar.receiveDamage(damage);
		System.out.println("avatar takes " +damage + " damage; Curhp= " + avatar.getCurrentHP());
		
	}
	
	public void attack(){
		enemy.receiveDamage(avatar.getAtk());
		System.out.println("enemy takes " + avatar.getAtk() + " damage; Curhp= " + enemy.getCurrentHP());

		
	}

}
