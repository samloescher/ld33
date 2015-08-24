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

	static int birdWidth = 31;
	static int birdHeight = 32;
	
	static int mouseWidth = 72;
	static int mouseHeight = 61;
	
	static int chickenWidth = 12;
	static int chickenHeight = 11;

	static Texture catSitting;
	static Texture catRunning;
	public static ArrayList<TextureRegion> catSittingArray = new ArrayList<TextureRegion>();
	public static ArrayList<TextureRegion> catRunningArray = new ArrayList<TextureRegion>();
	public static ArrayList<TextureRegion> catJumpingArray = new ArrayList<TextureRegion>();

	static Texture catSittingFood;
	static Texture catRunningFood;
	public static ArrayList<TextureRegion> catSittingFoodArray = new ArrayList<TextureRegion>();
	public static ArrayList<TextureRegion> catRunningFoodArray = new ArrayList<TextureRegion>();
	public static ArrayList<TextureRegion> catJumpingFoodArray = new ArrayList<TextureRegion>();

	static Texture maleStanding;
	static Texture maleWalking;
	public static ArrayList<TextureRegion> maleStandingArray = new ArrayList<TextureRegion>();
	public static ArrayList<TextureRegion> maleWalkingArray = new ArrayList<TextureRegion>();

	static Texture birdFlying;
	public static ArrayList<TextureRegion> birdFlyingArray = new ArrayList<TextureRegion>();
	
	static Texture mouseWalking;
	public static ArrayList<TextureRegion> mouseWalkingArray = new ArrayList<TextureRegion>();
	
	static Texture chickenWalking;
	public static ArrayList<TextureRegion> chickenWalkingArray = new ArrayList<TextureRegion>();

	static {
		loadAllTextures();
		initialiseAnimationArrays();
	}

	public static void loadAllTextures() {
		catSitting = new Texture("images/cat/cat-sitting.png");
		catRunning = new Texture("images/cat/cat-running.png");

		catSittingFood = new Texture("images/cat/cat-with-food-sitting.png");
		catRunningFood = new Texture("images/cat/cat-with-food-running.png");

		maleStanding = new Texture("images/human/male-standing.png");
		maleWalking = new Texture("images/human/male-walking.png");

		birdFlying = new Texture("images/bird/bird-flying.png");
		
		mouseWalking = new Texture("images/mouse/mouse-walking.png");
		
		chickenWalking = new Texture("images/chicken/chicken-walking.png");
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
			catSittingFoodArray.add(new TextureRegion(catSittingFood, i * catWidth, 0, catWidth, catHeight));
		}
		for (int i = 0; i < 6; i++) {
			catRunningFoodArray.add(new TextureRegion(catRunningFood, i * catWidth, 0, catWidth, catHeight));
		}
		for (int i = 0; i < 2; i++) {
			catJumpingFoodArray.add(new TextureRegion(catRunningFood, i * catWidth, 0, catWidth, catHeight));
		}

		for (int i = 0; i < 4; i++) {
			maleStandingArray.add(new TextureRegion(maleStanding, i * maleWidth, 0, maleWidth, maleHeight));
		}
		for (int i = 0; i < 4; i++) {
			maleWalkingArray.add(new TextureRegion(maleWalking, i * maleWidth, 0, maleWidth, maleHeight));
		}

		for (int i = 0; i < 5; i++) {
			birdFlyingArray.add(new TextureRegion(birdFlying, i * birdWidth, 0, birdWidth, birdHeight));
		}
		
		for (int i = 0; i < 6; i++) {
			mouseWalkingArray.add(new TextureRegion(mouseWalking, i * mouseWidth, 0, mouseWidth, mouseHeight));
		}
		
		for (int i = 0; i < 4; i++) {
			chickenWalkingArray.add(new TextureRegion(chickenWalking, i * chickenWidth, 0, chickenWidth, chickenHeight));
		}
	}

	public static void dispose() {
		catSitting.dispose();
		catRunning.dispose();
		maleStanding.dispose();
		maleWalking.dispose();
		birdFlying.dispose();
		mouseWalking.dispose();
		chickenWalking.dispose();
	}

}