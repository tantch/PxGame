package com.tantch.pixelscamp.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.tantch.pixelscamp.game.PxGame;
import com.tantch.pixelscamp.game.entities.PxAvatar;
import com.tantch.pixelscamp.game.screens.inputs.AvatarScreenInputProcessor;

public class AvatarScreen implements Screen {

	final PxGame game;
	OrthographicCamera camera;
    private Viewport viewport;
    
    private PxAvatar avatar;
    private ShapeRenderer shapeRenderer;
	private BitmapFont font;
    
    public AvatarScreen(PxGame game,PxAvatar avatar) {
		this.game = game;
		this.avatar= avatar;
		this.shapeRenderer = new ShapeRenderer();
		this.font = new BitmapFont();
		
		//camera nad res solutions
		float w = Gdx.graphics.getWidth();                                      
	    float h = Gdx.graphics.getHeight(); 
		camera = new OrthographicCamera();
		camera.setToOrtho(false);
        viewport = new FitViewport(640, 980, camera);
        
        
		
		Gdx.input.setInputProcessor(new AvatarScreenInputProcessor(this));

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		game.batch.setProjectionMatrix(camera.combined);

		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(0, 1, 0, 1);
		shapeRenderer.rect(250, 600, 100, -10);
		shapeRenderer.end();
		
		game.batch.begin();
		avatar.draw(game.batch,250,400);
		font.draw(game.batch, this.avatar.getCurrentHP() + " / " + this.avatar.getMaxHP(), 250, 600);
		font.draw(game.batch, "Attack: " + this.avatar.getAtk(), 200, 500);
		font.draw(game.batch, "Defense: " + this.avatar.getDef(), 300, 500);
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

		this.font.dispose();

	}

	public void fight(PxAvatar enemy) {
		game.setScreen(new FightScreen(game,avatar,enemy));
		
	}

}
