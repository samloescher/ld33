package ludumdare._33.world.environment.hidables;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Foliage {
	TextureRegion textureRegion;
	public Rectangle bounds;

	protected Foliage(TextureRegion textureRegion, Vector2 position, Vector2 size) {
		this.textureRegion = textureRegion;
		bounds = new Rectangle(position.x,position.y,size.x,size.y);
	}

	public void draw(SpriteBatch batch) {
		batch.draw(textureRegion, bounds.x, bounds.y, bounds.width, bounds.height);
	}
}
