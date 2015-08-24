package ludumdare._33.ui;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class UIOverlay {
	public ArrayList<UIOverlayItem> uiOverlayItems = new ArrayList<UIOverlayItem>();

	public UIOverlay() {
		uiOverlayItems.add(new MusicToggle(new Vector2(10, 450)));
		uiOverlayItems.add(new SoundToggle(new Vector2(40, 450)));
	}

	public void draw(SpriteBatch batch) {
		for (UIOverlayItem i : uiOverlayItems) {
			i.draw(batch);
		}
	}
}
