package ludumdare._33.world.human;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import ludumdare._33.assets.AnimationTextures;

public class Human {
	
	int width = 50;
	int height = 100;

	Animation standingAnimation;
	Animation walkingAnimation;
	
	Animation currentAnimation;
	float currentAnimationTime;
	Vector2 position;
	
	HumanState currentState = HumanState.Walking;
	HumanState previousState = HumanState.Walking;
	boolean facingRight;
	
	DetectionTriangle detectionArea;
	
	public Human(int x) {
		position = new Vector2(x, 0);
		initialiseAnimations();
		currentAnimation = walkingAnimation;
		detectionArea = new DetectionTriangle();
	}

	public void update(float delta) {
		currentAnimationTime += delta;
	}

	public void draw(SpriteBatch batch) {
		TextureRegion human = currentAnimation.getKeyFrame(currentAnimationTime);
		human.flip(facingRight, false);
		batch.draw(human, position.x, position.y,width,height);
	}
	
	public void drawDebug(ShapeRenderer shapeRenderer){
		detectionArea.draw(shapeRenderer);
	}

	void initialiseAnimations() {
		standingAnimation = new Animation(0.02f, AnimationTextures.humanStandingArray.toArray(new TextureRegion[AnimationTextures.humanStandingArray.size()]));
		standingAnimation.setPlayMode(PlayMode.LOOP);
		walkingAnimation = new Animation(0.2f, AnimationTextures.humanWalkingArray.toArray(new TextureRegion[AnimationTextures.humanWalkingArray.size()]));
		walkingAnimation.setPlayMode(PlayMode.LOOP);
	}
}
