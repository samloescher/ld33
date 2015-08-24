package ludumdare._33.world.prey;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import ludumdare._33.assets.AnimationTextures;

public class Mouse extends Prey {
	public int height = 31;
	public int width = 36;

	Animation walkingAnimation;

	float currentAnimationTime;
	Vector2 position;

	boolean facingRight = false;

	public Mouse(int x) {
		this.value = 40;
		position = new Vector2(x, 0);
		initialiseAnimations();
		bounds = new Rectangle(position.x, position.y, width, height);
	}

	public void update(float delta) {
		currentAnimationTime += delta;
		position.x += 160.0f * delta;
		bounds.x = position.x;
	}
	
	public void draw(SpriteBatch batch) {
		TextureRegion mouse = walkingAnimation.getKeyFrame(currentAnimationTime);
		batch.draw(mouse, facingRight?position.x+width:position.x, position.y,facingRight?-width:width,height);
	}
	
	private void initialiseAnimations() {
		walkingAnimation = new Animation(0.2f, AnimationTextures.mouseWalkingArray);
		walkingAnimation.setPlayMode(PlayMode.LOOP);
	}
}
