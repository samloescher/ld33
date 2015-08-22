package ludumdare._33.world.cat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ludumdare._33.AnimationTextures;

public class Cat {
	
	int height = 80;
	int width = 115;

	Animation sittingAnimation;
	Animation runningAnimation;
	Animation jumpingAnimation;
	
	Animation currentAnimation;
	float currentAnimationTime;
	Vector2 position;
	
	CatState previousState = CatState.Sitting;
	CatState currentState = CatState.Sitting;
	boolean facingRight;
	
	Vector2 displacement = new Vector2();
	float velocityY;
	
	public Cat() {
		position = new Vector2(0, 0);
		initialiseAnimations();
		currentAnimation = sittingAnimation;
	}

	public void update(float delta) {
		currentAnimationTime += delta;
		manageInput();
		updateVelocityY(delta);
		updateDisplacement();
		updateState();

		displacement.x = 0;
		displacement.y = 0;
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
			displacement.x += 5;
		} else if (Gdx.input.isKeyPressed(Keys.A)) {
			displacement.x -= 5;
		}
		
	}
	
	void updateVelocityY(float delta) {
		velocityY -= delta * 1000;
		displacement.y = velocityY * delta;
		
	}
	
	void updateDisplacement(){
		if(displacement.x > 0){
			facingRight = true;
		}else if(displacement.x < 0){
			facingRight = false;
		}
		position.x += displacement.x;
		position.y += displacement.y;
				
		if(position.y < 0){
			position.y = 0;
		}
	}

	public void updateState(){
		if(position.y > 0){
			changeState(CatState.Jumping);
		}else if(displacement.x != 0){
			changeState(CatState.Running);
		}else{
			changeState(CatState.Sitting);
		}
		
		if(previousState != currentState){
			currentAnimationTime = 0;
		}
		switch(currentState){
		case Sitting:
			currentAnimation = sittingAnimation;
			break;
		case Running:
			currentAnimation = runningAnimation;
			break;
		case Jumping:
			currentAnimation = jumpingAnimation;
			break;
		}
	}
	
	public void jump() {
		if (position.y == 0) {
			velocityY = 700;
		}
	}

	void changeState(CatState state){
		previousState = currentState;
		currentState = state;
	}

	void initialiseAnimations() {
		sittingAnimation = new Animation(0.5f, AnimationTextures.catSittingArray.toArray(new TextureRegion[AnimationTextures.catSittingArray.size()]));
		sittingAnimation.setPlayMode(PlayMode.LOOP);
		runningAnimation = new Animation(0.1f, AnimationTextures.catRunningArray.toArray(new TextureRegion[AnimationTextures.catRunningArray.size()]));
		runningAnimation.setPlayMode(PlayMode.LOOP);
		jumpingAnimation = new Animation(0.4f, AnimationTextures.catJumpingArray.toArray(new TextureRegion[AnimationTextures.catJumpingArray.size()]));
		jumpingAnimation.setPlayMode(PlayMode.LOOP);
	}
}
