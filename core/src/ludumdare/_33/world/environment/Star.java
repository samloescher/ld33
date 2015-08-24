package ludumdare._33.world.environment;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import ludumdare._33.assets.AnimationTextures;

public class Star {
	int height;
	int width;

	Animation blinkingAnimation;

	float currentAnimationTime;
	public Vector2 position;

	public Star(int height, int width, int x, int y) {
		position = new Vector2(x, y);
		this.height = height;
		this.width = width;
		currentAnimationTime = MathUtils.random(0, 10);
		initialiseAnimations();
	}

	public void update(float delta) {
		currentAnimationTime += delta;
	}
	
	public void draw(SpriteBatch batch, float cameraOffset) {
		TextureRegion star = blinkingAnimation.getKeyFrame(currentAnimationTime);
		batch.draw(star, position.x + cameraOffset, position.y, width, height);
	}
	
	private void initialiseAnimations() {
		blinkingAnimation = new Animation(0.5f, AnimationTextures.starBlinkingArray);
		blinkingAnimation.setPlayMode(PlayMode.LOOP);
	}
}
