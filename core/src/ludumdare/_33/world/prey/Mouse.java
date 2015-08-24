package ludumdare._33.world.prey;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import ludumdare._33.PatrolArea;
import ludumdare._33.assets.AnimationTextures;

public class Mouse extends Prey {
	public int height = 31;
	public int width = 36;

	Animation walkingAnimation;

	float currentAnimationTime;
	Vector2 position;

	boolean facingRight = false;
	
	PatrolArea patrolArea;

	public Mouse(int x1, int x2) {
		this.value = 40;
		position = new Vector2(x1, 0);
		patrolArea = new PatrolArea(x1, x2);
		initialiseAnimations();
		bounds = new Rectangle(position.x, position.y, width, height);
	}

	public void update(float delta) {
		currentAnimationTime += delta;
		lookInCorrectDirection();
		walk(delta);
		bounds.x = position.x;
	}
	void lookInCorrectDirection() {
		if(patrolArea.isLeftOfBounds(position.x)){
			facingRight = true;
		}else if(patrolArea.isRightOfBounds(position.x)){
			facingRight = false;
		}
	}

	void walk(float delta) {
		if (facingRight) {
			position.x += delta * 160f;
		} else {
			position.x -= delta * 160f;
		}
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
