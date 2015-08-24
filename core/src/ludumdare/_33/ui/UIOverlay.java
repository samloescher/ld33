package ludumdare._33.ui;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class UIOverlay {
	public ArrayList<UIOverlayItem> uiOverlayItems = new ArrayList<UIOverlayItem>();
	public DetectionMeter detectionMeter;

	public UIOverlay() {
		uiOverlayItems.add(new MusicToggle(new Vector2(10, 450)));
		uiOverlayItems.add(new SoundToggle(new Vector2(40, 450)));
		detectionMeter = new DetectionMeter();
	}

	public void draw(SpriteBatch batch) {
		for (UIOverlayItem i : uiOverlayItems) {
			i.draw(batch);
		}
		
	}
	
	public void setDetectionLevel(float detectionLevel){
		detectionMeter.setDetectionLevel(detectionLevel);
	}
	
	public void drawDetectionMeter(ShapeRenderer renderer){
		detectionMeter.draw(renderer);
	}
	
}
