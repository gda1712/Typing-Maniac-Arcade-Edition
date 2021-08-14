package com.mygdx.maniac;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import com.mygdx.maniac.screens.menu.Menu;


public class TypingManiacArcade extends Game {
	public SpriteBatch batch;
	public Texture img;
	public BitmapFont font;
	
	@Override
	public void create () {

		this.font = new BitmapFont();
		this.batch = new SpriteBatch();
		this.setScreen(new Menu(this));
	}

	@Override
	public void render () {
		super.render();

		//ScreenUtils.clear(1, 0, 0, 1);

	}
	
	@Override
	public void dispose () {

	}
}
