package ludumdare._33.world.prey;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Prey {
	
	int points;
	
	public abstract void update(float delta);
	public abstract void draw(SpriteBatch batch);

}
