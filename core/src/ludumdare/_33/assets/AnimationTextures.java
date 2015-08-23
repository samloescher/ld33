package ludumdare._33.assets;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationTextures {

	static int catWidth = 23;
	static int catHeight = 16;
	
	static int humanWidth = 16;
	static int humanHeight = 28;
	
	static Texture catSitting;
	static Texture catRunning;
	public static ArrayList<TextureRegion> catSittingArray = new ArrayList<TextureRegion>();
	public static ArrayList<TextureRegion> catRunningArray = new ArrayList<TextureRegion>();
	public static ArrayList<TextureRegion> catJumpingArray = new ArrayList<TextureRegion>();
	
	
	static Texture humanStanding;
	static Texture humanWalking;
	public static ArrayList<TextureRegion> humanStandingArray = new ArrayList<TextureRegion>();
	public static ArrayList<TextureRegion> humanWalkingArray = new ArrayList<TextureRegion>();
	
	

	static {
		loadAllTextures();
		initialiseAnimationArrays();
	}

	public static void loadAllTextures() {
		catSitting = new Texture("images/cat/cat-sitting.png");
		catRunning = new Texture("images/cat/cat-running.png");
		
		humanStanding = new Texture("images/human/human-standing.png");
		humanWalking = new Texture("images/human/human-walking.png");
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
		
		for (int i = 0; i < 2; i++) {
			humanStandingArray.add(new TextureRegion(humanStanding, i * humanWidth, 0, humanWidth, humanHeight));
		}
		for (int i = 0; i < 3; i++) {
			humanWalkingArray.add(new TextureRegion(humanWalking, i * humanWidth, 0, humanWidth, humanHeight));
		}
	}

}