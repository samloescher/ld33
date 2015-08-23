package ludumdare._33.world.cat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import ludumdare._33.Assets.AnimationTextures;
import ludumdare._33.world.Platforms;
import ludumdare._33.world.World;

public class Cat {
	
	public int height = 80;
	public int width = 115;

	Animation sittingAnimation;
	Animation runningAnimation;
	Animation jumpingAnimation;
	
	Animation currentAnimation;
	float currentAnimationTime;
	public Vector2 position;
	Rectangle floorCheck = new Rectangle(0,0,width,2);
	
	CatState previousState = CatState.Sitting;
	CatState currentState = CatState.Sitting;
	boolean facingRight = true;
	boolean onFloorOrPlatform;
	
	Vector2 displacement = new Vector2();
	float velocityY;
	
	public Cat() {
		position = new Vector2(100, 0);
		initialiseAnimations();
		currentAnimation = sittingAnimation;
	}

	public void update(float delta) {
		currentAnimationTime += delta;
		onFloorOrPlatform = currentlyOnFloorOrPlatform();
		manageInput();
		updateVelocityY(delta);
		updateDisplacement();
		updateState();
		clampToWorldBounds();
		displacement.x = 0;
		displacement.y = 0;
	}

	public void draw(SpriteBatch batch) {
		TextureRegion cat = currentAnimation.getKeyFrame(currentAnimationTime);
		batch.draw(cat, facingRight?position.x+width:position.x, position.y,facingRight?-width:width,height);
	}

	public void manageInput() {

		if (Gdx.input.isKeyPressed(Keys.W)) {
			if(onFloorOrPlatform){
				velocityY = 700;
			}else{
				displacement.y += 4;
			}
		}
		
		if (Gdx.input.isKeyPressed(Keys.S)) {
			if(onFloorOrPlatform){
				displacement.y -= 4;
			}
		}

		if (Gdx.input.isKeyPressed(Keys.D)) {
			displacement.x += 7;
		} else if (Gdx.input.isKeyPressed(Keys.A)) {
			displacement.x -= 7;
		}
		
	}
	
	void updateVelocityY(float delta) {
		if(!onFloorOrPlatform){
			velocityY -= delta * 1000;
		}
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
	}

	public void updateState(){
		if(!onFloorOrPlatform){
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
	
	void clampToWorldBounds(){
		position.x = MathUtils.clamp(position.x, World.bounds.x, World.bounds.width - width);
		position.y = MathUtils.clamp(position.y, World.bounds.y, World.bounds.height - height);
	}
	
	public boolean currentlyOnFloorOrPlatform() {
		floorCheck.x = position.x;
		floorCheck.y = position.y;
		if (position.y == 0 || Platforms.collidingWithPlatform(floorCheck)){
			return true;
		}
		return false;
	}

	void changeState(CatState state){
		previousState = currentState;
		currentState = state;
	}

	void initialiseAnimations() {
		sittingAnimation = new Animation(0.5f, AnimationTextures.catSittingArray.toArray(new TextureRegion[AnimationTextures.catSittingArray.size()]));
		sittingAnimation.setPlayMode(PlayMode.LOOP);
		runningAnimation = new Animation(0.05f, AnimationTextures.catRunningArray.toArray(new TextureRegion[AnimationTextures.catRunningArray.size()]));
		runningAnimation.setPlayMode(PlayMode.LOOP);
		jumpingAnimation = new Animation(0.4f, AnimationTextures.catJumpingArray.toArray(new TextureRegion[AnimationTextures.catJumpingArray.size()]));
		jumpingAnimation.setPlayMode(PlayMode.LOOP);
	}
}
