package ludumdare._33.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class UIOverlayItem {

	TextureRegion textureRegion;
	public Rectangle bounds;
	
	UIOverlayItem(TextureRegion textureRegion, Vector2 position, Vector2 size) {
		this.textureRegion = textureRegion;
		
		bounds = new Rectangle(position.x, position.y, size.x, size.y);
	}

	void draw(SpriteBatch batch) {
		batch.draw(textureRegion, bounds.x, bounds.y, bounds.width, bounds.height);
	}
	
	void changeTexture(TextureRegion textureRegion) {
		this.textureRegion = textureRegion;
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
	public abstract void pressed();
}
