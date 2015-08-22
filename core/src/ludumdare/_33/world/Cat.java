package ludumdare._33.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Cat {
	
	Animation sittingAnimation;
	Animation runningAnimation;
	
	Vector2 position;
	Animation currentAnimation;
	float currentAnimationTime;
	
	boolean isStill;
	boolean changedAnimation;
	
	boolean facingRight;
	boolean onFloor;
	
	public Cat(){
		position = new Vector2(0,0);
		initialiseAnimations();
		currentAnimation = sittingAnimation;
	}
	
	public void update(float delta){
		currentAnimationTime += delta;
		updateGravity(delta);
		checkCatOnFloor();
		manageInput();
		if(changedAnimation){
			currentAnimationTime = 0;
		}
	}
	
	public void draw(SpriteBatch batch){
		TextureRegion cat = currentAnimation.getKeyFrame(currentAnimationTime);
		cat.flip(facingRight, false);
		batch.draw(cat, position.x, position.y);
		}
	
	public void manageInput(){
		
		if(Gdx.input.isKeyPressed(Keys.W)){
			jump();
		}
		
		if(Gdx.input.isKeyPressed(Keys.D)){
			moveRight(50);
		}else if(Gdx.input.isKeyPressed(Keys.A)){
			moveRight(-50);
		}else{
			if(!isStill){
				changedAnimation = true;
			}
			currentAnimation = sittingAnimation;
		}
		
	}
	
	public void jump(){
		if(onFloor){
			position.y += 50;
		}
		if(isStill){
			changedAnimation = true;
		}
		currentAnimation = runningAnimation;
	}
	
	public void moveRight(float displacement){
		if(displacement>0){
			facingRight = true;
		}else{
			facingRight = false;
		}
		
		position.x += displacement;
		if(isStill){
			changedAnimation = true;
		}
		currentAnimation = runningAnimation;
	}
	
	void checkCatOnFloor(){
		onFloor = position.y <= 0;
		if(onFloor){
			position.y = 0;
		}
	}
	
	void updateGravity(float delta){
		position.y -= delta * 10;
	}
	
	void initialiseAnimations(){
		
	}
}
