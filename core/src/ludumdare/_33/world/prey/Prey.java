package ludumdare._33.world.prey;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class Prey {
	
	public int value;
	public Rectangle bounds;
	
	public abstract void update(float delta);
	public abstract void draw(SpriteBatch batch);

}
