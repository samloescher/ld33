package ludumdare._33.input;

import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.InputProcessor;

import ludumdare._33.ui.UIOverlay;
import ludumdare._33.ui.UIOverlayItem;

public class InputManager implements InputProcessor {

	private UIOverlay uiOverlay;

	public InputManager(UIOverlay uiOverlay) {
		this.uiOverlay = uiOverlay;
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		screenY = 480 - screenY;
		if (button == Buttons.LEFT) {
			for (UIOverlayItem item : uiOverlay.uiOverlayItems) {
				if (item.bounds.contains(screenX, screenY)) {
					item.pressed();
				}
			}
		}
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

}
