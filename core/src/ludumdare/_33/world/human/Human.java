package ludumdare._33.world.human;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import ludumdare._33.assets.AnimationTextures;

public class Human {
	
	int width = 74;
	int height = 108;

	Animation standingAnimation;
	Animation walkingAnimation;
	
	Animation currentAnimation;
	float currentAnimationTime;
	Vector2 position;
	
	HumanState currentState = HumanState.Walking;
	HumanState previousState = HumanState.Walking;
	boolean facingRight = true;
	
	DetectionTriangle detectionArea;
	
	public Human(int x) {
		position = new Vector2(x, 0);
		initialiseAnimations();
		currentAnimation = walkingAnimation;
		detectionArea = new DetectionTriangle();
	}

	public void update(float delta) {
		currentAnimationTime += delta;
		position.x += 0.5f;
		detectionArea.update(new Vector2(position.x + 15,position.y + 80), facingRight);
		if(Gdx.input.isKeyPressed(Keys.N)){
			facingRight = false;
		}
		if(Gdx.input.isKeyPressed(Keys.M)){
			facingRight = true;
		}
	}

	public void draw(SpriteBatch batch) {
		TextureRegion human = currentAnimation.getKeyFrame(currentAnimationTime);
		batch.draw(human, facingRight?position.x+width:position.x, position.y,facingRight?-width:width,height);
	}
	
	public void drawDebug(ShapeRenderer shapeRenderer){
		detectionArea.draw(shapeRenderer);
	}

	void initialiseAnimations() {
		standingAnimation = new Animation(0.02f, AnimationTextures.maleStandingArray.toArray(new TextureRegion[AnimationTextures.maleStandingArray.size()]));
		standingAnimation.setPlayMode(PlayMode.LOOP);
		walkingAnimation = new Animation(0.2f, AnimationTextures.maleWalkingArray.toArray(new TextureRegion[AnimationTextures.maleWalkingArray.size()]));
		walkingAnimation.setPlayMode(PlayMode.LOOP);
	}
}
