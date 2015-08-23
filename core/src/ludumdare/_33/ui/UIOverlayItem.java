package ludumdare._33.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class UIOverlayItem {

	TextureRegion textureRegion;
	Vector2 position;
	Vector2 size;

	public UIOverlayItem(TextureRegion textureRegion, Vector2 position, Vector2 size) {
		this.textureRegion = textureRegion;
		this.position = position;
		this.size = size;
	}

	public void draw(SpriteBatch batch) {
		batch.draw(textureRegion, position.x, position.y, size.x, size.y);
	}
}
