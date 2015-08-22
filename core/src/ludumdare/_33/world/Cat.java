package ludumdare._33.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ludumdare._33.Assets;

public class Cat {
	
	int height = 80;
	int width = 115;

	Animation sittingAnimation;
	Animation runningAnimation;

	Vector2 position;
	Animation currentAnimation;
	float currentAnimationTime;

	boolean isStill;
	boolean changedAnimation;

	boolean facingRight;
	float velocityY;
	boolean onFloor;

	public Cat() {
		position = new Vector2(0, 0);
		initialiseAnimations();
		currentAnimation = sittingAnimation;
	}

	public void update(float delta) {
		currentAnimationTime += delta;
		updateGravity(delta);
		checkCatOnFloor();
		manageInput();
		if (changedAnimation) {
			currentAnimationTime = 0;
			changedAnimation = false;
		}
	}

	public void draw(SpriteBatch batch) {
		TextureRegion cat = currentAnimation.getKeyFrame(currentAnimationTime);
		batch.draw(cat, facingRight?position.x+width:position.x, position.y,facingRight?-width:width,height);
	}

	public void manageInput() {

		if (Gdx.input.isKeyPressed(Keys.W)) {
			jump();
		}

		if (Gdx.input.isKeyPressed(Keys.D)) {
			moveRight(5);
		} else if (Gdx.input.isKeyPressed(Keys.A)) {
			moveRight(-5);
		} else {
			currentAnimation = sittingAnimation;
		}

	}

	public void jump() {
		if (onFloor) {
			velocityY = 700;
		}
		if (isStill) {
			changedAnimation = true;
		}
		currentAnimation = runningAnimation;
	}

	public void moveRight(float displacement) {
		if (displacement > 0) {
			facingRight = true;
		} else if(displacement < 0) {
			facingRight = false;
		}

		position.x += displacement;
		if (isStill) {
			changedAnimation = true;
		}
		currentAnimation = runningAnimation;
	}

	void checkCatOnFloor() {
		onFloor = position.y <= 0;
		if (onFloor) {
			position.y = 0;
		}
	}

	void updateGravity(float delta) {
		velocityY -= delta * 1000;
		position.y  += velocityY * delta;
	}

	void initialiseAnimations() {
		sittingAnimation = new Animation(0.5f, Assets.catSittingArray.toArray(new TextureRegion[Assets.catSittingArray.size()]));
		sittingAnimation.setPlayMode(PlayMode.LOOP);
		runningAnimation = new Animation(0.1f, Assets.catRunningArray.toArray(new TextureRegion[Assets.catRunningArray.size()]));
		runningAnimation.setPlayMode(PlayMode.LOOP);
	}
}
