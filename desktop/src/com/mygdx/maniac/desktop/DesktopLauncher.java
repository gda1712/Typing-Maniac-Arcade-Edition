package com.mygdx.maniac.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.maniac.TypingManiacArcade;

public class DesktopLauncher {
	/* Class Desktop Game
	* */

	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 512;

	public static void main (String[] arg) {
		// We defined the aplication desktop settings
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = DesktopLauncher.SCREEN_WIDTH;
		config.height = DesktopLauncher.SCREEN_HEIGHT;
		config.resizable = false;
		config.title = "Typing Maniac Arcade Edition";

		// We save the config
		new LwjglApplication(new TypingManiacArcade(), config);
	}
}
