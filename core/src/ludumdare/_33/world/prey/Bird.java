package ludumdare._33.world.prey;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import ludumdare._33.assets.AnimationTextures;

public class Bird extends Prey{

	public int height = 32;
	public int width = 30;

	Animation flyingAnimation;

	float currentAnimationTime;
	Vector2 position;

	boolean facingRight = true;

	public Bird(int x1, int x2, int y) {
		this.value = 50;
		position = new Vector2(x1, y);
		initialiseAnimations();
		bounds = new Rectangle(position.x, position.y, width, height);
	}

	public void update(float delta) {
		currentAnimationTime += delta;
		position.x += 120f * delta;
		bounds.x = position.x;
	}
	
	public void draw(SpriteBatch batch) {
		TextureRegion bird = flyingAnimation.getKeyFrame(currentAnimationTime);
		batch.draw(bird, facingRight?position.x+width:position.x, position.y,facingRight?-width:width,height);
	}
	
	private void initialiseAnimations() {
		flyingAnimation = new Animation(0.4f, AnimationTextures.birdFlyingArray);
		flyingAnimation.setPlayMode(PlayMode.LOOP);
	}
}
