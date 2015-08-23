package ludumdare._33.world.environment.hidables;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Foliage {
	TextureRegion textureRegion;
	Vector2 position;
	Vector2 size;

	protected Foliage(TextureRegion textureRegion, Vector2 position, Vector2 size) {
		this.textureRegion = textureRegion;
		this.position = position;
		this.size = size;
	}

	public void draw(SpriteBatch batch) {
		batch.draw(textureRegion, position.x, position.y, size.x, size.y);
	}
}
