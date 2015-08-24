package ludumdare._33.ui;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import ludumdare._33.Player;

public class UIOverlay {
	public ArrayList<UIOverlayItem> uiOverlayItems = new ArrayList<UIOverlayItem>();
	public DetectionMeter detectionMeter;
	public ScoreDisplay scoreDisplay;

	public UIOverlay(Player player) {
		uiOverlayItems.add(new MusicToggle(new Vector2(10, 450)));
		uiOverlayItems.add(new SoundToggle(new Vector2(40, 450)));
		detectionMeter = new DetectionMeter();
		scoreDisplay = new ScoreDisplay(player);
	}

	public void draw(SpriteBatch batch) {
		for (UIOverlayItem i : uiOverlayItems) {
			i.draw(batch);
		}
	}

	public void setDetectionLevel(float detectionLevel) {
		detectionMeter.setDetectionLevel(detectionLevel);
	}

	public void drawDetectionMeter(ShapeRenderer renderer) {
		detectionMeter.draw(renderer);
	}

	public void drawScoreDisplay(SpriteBatch batch) {
		scoreDisplay.draw(batch);
	}

}
