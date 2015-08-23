package ludumdare._33.assets;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationTextures {

	static int catWidth = 23;
	static int catHeight = 16;
	
	static int humanWidth = 10;
	static int humanHeight = 10;
	
	static Texture catSitting;
	public static ArrayList<TextureRegion> catSittingArray = new ArrayList<TextureRegion>();
	static Texture catRunning;
	public static ArrayList<TextureRegion> catRunningArray = new ArrayList<TextureRegion>();
	public static ArrayList<TextureRegion> catJumpingArray = new ArrayList<TextureRegion>();

	static {
		loadAllTextures();
		initialiseAnimationArrays();
	}

	public static void loadAllTextures() {
		catSitting = new Texture("images/cat/cat-sitting.png");
		catRunning = new Texture("images/cat/cat-running.png");
	}

	public static void initialiseAnimationArrays() {
		for (int i = 0; i < 2; i++) {
			catSittingArray.add(new TextureRegion(catSitting, i * catWidth, 0, catWidth, catHeight));
		}
		for (int i = 0; i < 6; i++) {
			catRunningArray.add(new TextureRegion(catRunning, i * catWidth, 0, catWidth, catHeight));
		}

		for (int i = 0; i < 2; i++) {
			catJumpingArray.add(new TextureRegion(catRunning, i * catWidth, 0, catWidth, catHeight));
		}
	}

}