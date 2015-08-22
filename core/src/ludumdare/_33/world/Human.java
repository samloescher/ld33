package ludumdare._33.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Human {
	
	Animation standingAnimation;
	Animation walkingAnimation;
	
	Vector2 position;
	Animation currentAnimation;
	float currentAnimationTime;
	
	boolean isStill;
	boolean changedAnimation;
	
	boolean facingRight;
	
	public Human(int x){
		position = new Vector2(x,0);
		initialiseAnimations();
		currentAnimation = standingAnimation;
	}
	
	public void update(float delta){
		currentAnimationTime += delta;
		manageInput();
		if(changedAnimation){
			currentAnimationTime = 0;
		}
	}
	
	public void draw(SpriteBatch batch){
		TextureRegion human = currentAnimation.getKeyFrame(currentAnimationTime);
		human.flip(facingRight, false);
		batch.draw(human, position.x, position.y);
		}
	
	public void manageInput(){
		
		if(Gdx.input.isKeyPressed(Keys.N)){
			moveRight(50);
		}else if(Gdx.input.isKeyPressed(Keys.M)){
			moveRight(-50);
		}else{
			if(!isStill){
				changedAnimation = true;
			}
			currentAnimation = standingAnimation;
		}
		
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
		currentAnimation = walkingAnimation;
	}
	
	void initialiseAnimations(){
		
	}
}
