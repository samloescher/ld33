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
	Rectangle bounds;

	boolean facingRight = true;

	public Bird(int x) {
		this.points = 50;
		position = new Vector2(x, 400);
		initialiseAnimations();
		bounds = new Rectangle(position.x, position.y, width, height);
	}

	public void update(float delta) {
		currentAnimationTime += delta;
		position.x += 0.5f;
	}
	
	public void draw(SpriteBatch batch) {
		TextureRegion bird = flyingAnimation.getKeyFrame(currentAnimationTime);
		batch.draw(bird, facingRight?position.x+width:position.x, position.y,facingRight?-width:width,height);
	}
	
	void initialiseAnimations() {
		flyingAnimation = new Animation(0.4f, AnimationTextures.birdFlyingArray.toArray(new TextureRegion[AnimationTextures.birdFlyingArray.size()]));
		flyingAnimation.setPlayMode(PlayMode.LOOP);
	}
}
