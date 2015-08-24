package ludumdare._33.world.environment;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.math.Vector2;

import ludumdare._33.assets.AnimationTextures;

public class Star {
	public int height = 14;
	public int width = 14;

	Animation blinkingAnimation;

	float currentAnimationTime;
	Vector2 position;

	public Star(int x, int y) {
		position = new Vector2(x, y);
		initialiseAnimations();
	}

	public void update(float delta) {
		currentAnimationTime += delta;
	}
	
	public void draw(SpriteBatch batch) {
		TextureRegion star = blinkingAnimation.getKeyFrame(currentAnimationTime);
		batch.draw(star, position.x, position.y, width, height);
	}
	
	private void initialiseAnimations() {
		blinkingAnimation = new Animation(0.5f, AnimationTextures.starBlinkingArray.toArray(new TextureRegion[AnimationTextures.starBlinkingArray.size()]));
		blinkingAnimation.setPlayMode(PlayMode.LOOP);
	}
}
