package ludumdare._33.world.human;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import ludumdare._33.PatrolArea;
import ludumdare._33.world.cat.Cat;

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

	PatrolArea patrolArea;

	Human(int x1, int x2) {
		patrolArea = new PatrolArea(x1, x2);
		position = new Vector2((x1 + x2) / 2, 0);
		detectionArea = new DetectionTriangle();
	}

	public boolean canSeeCat(Cat cat) {
		return detectionArea.canSeeCat(cat.getCatPosition());
	}

	public void update(float delta) {
		currentAnimationTime += delta;
		lookInCorrectDirection();
		walk(delta);
		detectionArea.update(new Vector2(position.x + 15, position.y + 80), facingRight);
	}

	void lookInCorrectDirection() {
		if (facingRight) {
			if (!patrolArea.isInsideBounds(position.x)) {
				facingRight = false;
			}
		} else if (!patrolArea.isInsideBounds(position.x)) {
			facingRight = true;
		}
	}

	void walk(float delta) {
		if (facingRight) {
			position.x += delta * 50;
		} else {
			position.x -= delta * 50;
		}
	}

	public void draw(SpriteBatch batch) {
		TextureRegion human = currentAnimation.getKeyFrame(currentAnimationTime);
		batch.draw(human, facingRight ? position.x + width : position.x, position.y, facingRight ? -width : width,
				height);
	}

	public void drawDebug(ShapeRenderer shapeRenderer) {
		detectionArea.draw(shapeRenderer);
	}
}
