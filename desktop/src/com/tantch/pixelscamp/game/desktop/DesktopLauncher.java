package com.tantch.pixelscamp.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.tantch.pixelscamp.game.PxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//config.resizable=false;
				config.height = 960;
				config.width= 640;
		new LwjglApplication(new PxGame(), config);
	}
}
