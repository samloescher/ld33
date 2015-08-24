package ludumdare._33.world.human;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;

import ludumdare._33.assets.AnimationTextures;

public class Female extends Human {
	public Female(int x1, int x2) {
		super(x1, x2);
		initialiseAnimations();
		currentAnimation = walkingAnimation;
	}

	private void initialiseAnimations() {
		standingAnimation = new Animation(0.02f, AnimationTextures.femaleStandingArray);
		standingAnimation.setPlayMode(PlayMode.LOOP);
		walkingAnimation = new Animation(0.4f, AnimationTextures.femaleWalkingArray);
		walkingAnimation.setPlayMode(PlayMode.LOOP);
	}
}
