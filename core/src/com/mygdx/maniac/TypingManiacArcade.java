package com.mygdx.maniac;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

import com.mygdx.maniac.screens.datosUsuarios.DatosUsuario;


import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.Gdx;
import com.mygdx.maniac.screens.game.assets.Assets;
import com.mygdx.maniac.screens.preIngreso.PreIngreso;
/*import javax.xml.soap.Node;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.Text;*/


public class TypingManiacArcade extends Game {

	public SpriteBatch batch;
	public Texture tituloI,fondo1,fondo2,fondo3;
	public BitmapFont opciones, tituloPI, font;
	public TextButton play,arcade,musica,nivel1,nivel2,nivel3,jugadore1,jugadore2,jugadore3,continuarPI;
	public int height;
	public int width;
	public Skin skin;
	public Stage stage,stage2,stage3,stage4;
	public TextField nombre;
	public int jugadorOn;


	public Music pMusica;

	public DatosUsuario datos;
	//public Label label;
	//public Checkbox checkbox;

	@Override
	public void create () {
		// ------------ configuraciones  generales ventanas ----------- //
		this.skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
		this.tituloI = new Texture("images/Typing Maniac.png");
		this.batch = new SpriteBatch();

		this.datos = new DatosUsuario();
		this.height= Gdx.graphics.getHeight();
		this.width= Gdx.graphics.getWidth();
		this.jugadorOn = 1;

		// Inicializate the music
		this.pMusica = Assets.getMusic(Assets.MUSIC_3);
		this.pMusica.play();
		// ------------------------------------------------- //
		// ---------------------- PreIngreso -----------------------//
		this.fondo3 = new Texture("images/background3.jpg");
		this.stage = new Stage();
		this.font = new BitmapFont();
		this.tituloPI = new BitmapFont();
		this.jugadore1 = new TextButton("Nueva partida", skin);
		this.jugadore1.setName("Nueva partida");
		this.jugadore2 = new TextButton("Nueva partida", skin);
		this.jugadore2.setName("Nueva partida");
		this.jugadore3 = new TextButton("Nueva partida", skin);
		this.jugadore3.setName("Nueva partida");
		// ------- Nuevo ------ //
		this.stage4 = new Stage();
		this.nombre = new TextField("Nombre",skin);
		this.continuarPI = new TextButton("CONTINUAR", skin);
		// ---------------------------------------------------------//
		// ------------------------- Menu --------------------------//
		this.stage2 = new Stage();
		this.opciones = new BitmapFont();
		this.fondo1 = new Texture("images/background2.jpg");
		//this.table = new Table().pad(30);
		this.play = new TextButton("Modo Campana", skin);
		this.arcade = new TextButton("Modo Arcade", skin);
		this.musica = new TextButton("Yes",skin);
		//this.checkbox = new Checkbox();
		//stage.addActor(table);
		//table.add(play).size(160,50);
		//table.row().pad(50, 0, 10, 0);
		//table.add(arcade).size(160,50);
		// --------------------------------------------------------------- //
		// ------------------------- Niveles ----------------------------- //
		this.stage3 = new Stage();
		this.fondo2 = new Texture("images/background1.jpg");
		this.nivel1 = new TextButton("Nivel 1", skin);
		this.nivel2 = new TextButton("Nivel 2", skin);
		this.nivel3 = new TextButton("Nivel 3", skin);
		// ---------------------------------------------------------------- //

		this.setScreen(new PreIngreso(this));
		//this.setScreen(new Menu(this));
		//this.setScreen(new Niveles(this));

	}

	@Override
	public void render () {
		super.render();
		//procesarEntrada();
		//ScreenUtils.clear(1, 0, 0, 1);

	}

	@Override
	public void dispose () {
		super.dispose();
		fondo1.dispose();
		fondo2.dispose();
		tituloI.dispose();
	}

	private void procesarEntrada(){
//		boolean esp = Gdx.input.isKeyPressed(Input.Keys.E);
//
//		if(esp){
//			titulo.setColor(Color.BLUE);
//		}
//		play.addListener(new ChangeListener() {
//			@Override
//			public void changed(ChangeEvent event, Actor actor) {
//				this.setScreen((new Niveles(game)));
//			}
//		});
	}
}
