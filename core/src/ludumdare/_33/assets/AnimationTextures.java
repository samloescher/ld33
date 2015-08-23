package ludumdare._33.assets;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationTextures {

	static int catWidth = 23;
	static int catHeight = 16;
	
	static int femaleWidth = 37;
	static int femaleHeight = 50;
	
	static int maleWidth = 37;
	static int maleHeight = 54;
	
	static Texture catSitting;
	static Texture catRunning;
	public static ArrayList<TextureRegion> catSittingArray = new ArrayList<TextureRegion>();
	public static ArrayList<TextureRegion> catRunningArray = new ArrayList<TextureRegion>();
	public static ArrayList<TextureRegion> catJumpingArray = new ArrayList<TextureRegion>();
	
	
	static Texture maleStanding;
	static Texture maleWalking;
	public static ArrayList<TextureRegion> maleStandingArray = new ArrayList<TextureRegion>();
	public static ArrayList<TextureRegion> maleWalkingArray = new ArrayList<TextureRegion>();
	
	

	static {
		loadAllTextures();
		initialiseAnimationArrays();
	}

	public static void loadAllTextures() {
		catSitting = new Texture("images/cat/cat-sitting.png");
		catRunning = new Texture("images/cat/cat-running.png");
		
		maleStanding = new Texture("images/human/male-standing.png");
		maleWalking = new Texture("images/human/male-walking.png");
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
		
		for (int i = 0; i < 4; i++) {
			maleStandingArray.add(new TextureRegion(maleStanding, i * maleWidth, 0, maleWidth, maleHeight));
		}
		for (int i = 0; i < 4; i++) {
			maleWalkingArray.add(new TextureRegion(maleWalking, i * maleWidth, 0, maleWidth, maleHeight));
		}
	}
	
	public static void dispose(){
		catSitting.dispose();
		catRunning.dispose();
		maleStanding.dispose();
		maleWalking.dispose();		
	}

}