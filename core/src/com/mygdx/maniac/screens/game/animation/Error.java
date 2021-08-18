package com.mygdx.maniac.screens.game.animation;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.maniac.screens.Screen;
import com.mygdx.maniac.screens.game.assets.Assets;

public class Error {

    private Vector2 position;
    private com.badlogic.gdx.graphics.g2d.Animation<TextureRegion> animation;
    private float stateTime;

    public Error(int posX, int posY) {
        // COnstructor
        this.position = new Vector2();

        this.position.set(posX, posY);
        System.out.println(this.position);
        this.animation = Assets.getAnimation(Assets.ERROR_ANIMATION);
        this.stateTime = 0.f;
    }

    public void draw(Batch batch, float deltaTime) {
        // Draw the error X
        this.stateTime += deltaTime;
        batch.draw(this.animation.getKeyFrame(this.stateTime),
                this.position.x,
                this.position.y,
                0.f,
                0.f,
                20,
                20,
                1, 1, 45
        );

    }

    public boolean isAnimationFinished() {
        // If the animation ends return true.
        //this.animation.isAnimationFinished()
        System.out.println(this.stateTime);
        if(this.animation.isAnimationFinished(this.stateTime)) {
            System.out.println("Final");
            return true;
        }

        return false;
    }

}
