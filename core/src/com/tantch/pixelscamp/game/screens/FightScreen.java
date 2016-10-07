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
import com.tantch.pixelscamp.game.entities.PxEnemy;
import com.tantch.pixelscamp.game.screens.inputs.AvatarScreenInputProcessor;
import com.tantch.pixelscamp.game.screens.inputs.FightScreenInputProcessor;

import java.util.Random;

public class FightScreen implements Screen {

	final PxGame game;
	OrthographicCamera camera;
	private Viewport viewport;
	
	/*
	 * trying out enemy
	 */
	Random r = new Random();
	private float enemyAttTimer = 0;
	private double nDelta = 0;
	/*
	 * end
	 */
	
	
	private PxAvatar avatar;
	private PxEnemy enemy;
	

    private ShapeRenderer shapeRenderer;
	private BitmapFont font;

	public FightScreen(PxGame game, PxAvatar avatar, PxEnemy enemy) {
		this.game = game;

		this.avatar = avatar;
		this.enemy = enemy;
		this.shapeRenderer = new ShapeRenderer();
		this.font = new BitmapFont();

		// camera and res solutions

		camera = new OrthographicCamera();
		camera.setToOrtho(false);
		viewport = new FitViewport(640, 960, camera);

		Gdx.input.setInputProcessor(new FightScreenInputProcessor(this));

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {
		
		this.enemyAtt(delta);
		Gdx.gl.glClearColor(0, 0.5f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		game.batch.setProjectionMatrix(camera.combined);
		
		//avatar hp
		if(this.avatar.isAlive()){
			shapeRenderer.begin(ShapeType.Filled);
			shapeRenderer.setColor(1, 0, 0, 1);
			shapeRenderer.rect(250, 350, (float)(this.avatar.getMaxHP()-this.avatar.getCurrentHP())/this.avatar.getMaxHP()*-200, -15);
			shapeRenderer.end();
			shapeRenderer.begin(ShapeType.Filled);
			shapeRenderer.setColor(0, 1, 0, 1);
			shapeRenderer.rect(50, 350, (float) this.avatar.getCurrentHP()/this.avatar.getMaxHP()*200, -15);
			shapeRenderer.end();
		}
		//enemy hp
		if(this.enemy.isAlive()){
			shapeRenderer.begin(ShapeType.Filled);
			shapeRenderer.setColor(1, 0, 0, 1);
			shapeRenderer.rect(600, 350, (float)(this.enemy.getMaxHP()-this.enemy.getCurrentHP())/this.enemy.getMaxHP()*-200, -15);
			shapeRenderer.end();
			shapeRenderer.begin(ShapeType.Filled);
			shapeRenderer.setColor(0, 1, 0, 1);
			shapeRenderer.rect(400, 350, (float) this.enemy.getCurrentHP()/this.enemy.getMaxHP()*200, -15);
			shapeRenderer.end();
		}
		
		
		game.batch.begin();
		if(avatar.isAlive()){
			avatar.draw(game.batch,100,500);
			font.draw(game.batch, this.avatar.getCurrentHP() + " / " + this.avatar.getMaxHP(), 250, 300);
		}
		if(enemy.isAlive()){
			enemy.draw(game.batch,400,500);
			font.draw(game.batch, this.enemy.getCurrentHP() + " / " + this.enemy.getMaxHP(), 500,300);
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
	
	public void enemyAtt(float delta){
		this.enemyAttTimer+=delta;	
		
		if(this.nDelta == 0){
			double n = (r.nextInt(250)+75)/100.0;
			System.out.println("nDelta: " + n);
			this.nDelta = 1*n;
		}
		
		if(this.enemyAttTimer > this.nDelta){
			
			System.out.println("Enemy attacking with delta: " + nDelta);
			this.enemyAttTimer = 0;
			this.takeDamage(this.enemy.getAtk());
			this.nDelta = 0;
		}
	}

}
