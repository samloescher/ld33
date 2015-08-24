package ludumdare._33.assets;

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
	
	static int starWidth = 7;
	static int starHeight = 7;

	static Texture catSitting;
	static Texture catRunning;
	public static TextureRegion catSittingArray[];
	public static TextureRegion catRunningArray[];
	public static TextureRegion catJumpingArray[];

	static Texture catSittingFood;
	static Texture catRunningFood;
	public static TextureRegion catSittingFoodArray[];
	public static TextureRegion catRunningFoodArray[];
	public static TextureRegion catJumpingFoodArray[];

	static Texture maleStanding;
	static Texture maleWalking;
	public static TextureRegion maleStandingArray[];
	public static TextureRegion maleWalkingArray[];
	
	static Texture femaleStanding;
	static Texture femaleWalking;
	public static TextureRegion femaleStandingArray[];
	public static TextureRegion femaleWalkingArray[];

	static Texture birdFlying;
	public static TextureRegion birdFlyingArray[];
	
	static Texture mouseWalking;
	public static TextureRegion mouseWalkingArray[];
	
	static Texture chickenWalking;
	public static TextureRegion chickenWalkingArray[];
	
	static Texture starBlinking;
	public static TextureRegion starBlinkingArray[];

	static {
		loadAllTextures();
		initialiseAnimationArrays();
	}

	private static void loadAllTextures() {
		catSitting = new Texture("images/cat/cat-sitting.png");
		catRunning = new Texture("images/cat/cat-running.png");

		catSittingFood = new Texture("images/cat/cat-with-food-sitting.png");
		catRunningFood = new Texture("images/cat/cat-with-food-running.png");

		maleStanding = new Texture("images/human/male-standing.png");
		maleWalking = new Texture("images/human/male-walking.png");
		
		femaleStanding = new Texture("images/human/female-standing.png");
		femaleWalking = new Texture("images/human/female-walking.png");

		birdFlying = new Texture("images/bird/bird-flying.png");
		
		mouseWalking = new Texture("images/mouse/mouse-walking.png");
		
		chickenWalking = new Texture("images/chicken/chicken-walking.png");
		
		starBlinking = new Texture("images/background/star-default.png");
	}

	private static void initialiseAnimationArrays() {
		catSittingArray = getAnimationTextureRegionArray(catSitting,2);
		catRunningArray = getAnimationTextureRegionArray(catRunning,6);
		catJumpingArray = getAnimationTextureRegionArray(catRunning,2,23);
		
		catSittingFoodArray = getAnimationTextureRegionArray(catSittingFood,2);
		catRunningFoodArray = getAnimationTextureRegionArray(catRunningFood,6);
		catJumpingFoodArray = getAnimationTextureRegionArray(catRunningFood,2,23);
		
		maleStandingArray = getAnimationTextureRegionArray(maleStanding, 4);
		maleWalkingArray = getAnimationTextureRegionArray(maleWalking, 4);
		
		femaleStandingArray = getAnimationTextureRegionArray(femaleStanding, 4);
		femaleWalkingArray = getAnimationTextureRegionArray(femaleWalking, 4);

		birdFlyingArray = getAnimationTextureRegionArray(birdFlying, 5);
		
		mouseWalkingArray = getAnimationTextureRegionArray(mouseWalking, 6,72,true);
		
		chickenWalkingArray = getAnimationTextureRegionArray(chickenWalking, 4, chickenWidth);
		
		starBlinkingArray = getAnimationTextureRegionArray(starBlinking, 10);
	}
	
	static TextureRegion[] getAnimationTextureRegionArray(Texture tex, int frames){
		int width = tex.getWidth()/frames;
		return getAnimationTextureRegionArray(tex, frames,width);
	}
	
	static TextureRegion[] getAnimationTextureRegionArray(Texture tex, int frames, int frameWidth){
		TextureRegion[] array;
		int height = tex.getHeight();
		array = new TextureRegion[frames];
		for(int i = 0; i < frames; i++){
				array[i] = new TextureRegion(tex, i * frameWidth, 0, frameWidth, height);
		}
		
		return array;
	}
	
	static TextureRegion[] getAnimationTextureRegionArray(Texture tex, int frames, int frameWidth, boolean reverse){
		TextureRegion tmp;
		TextureRegion[] array;
		int height = tex.getHeight();
		array = new TextureRegion[frames];
		for(int i = 0; i < frames; i++){
				tmp = new TextureRegion(tex, i * frameWidth, 0, frameWidth, height);
				tmp.flip(reverse, false);
				array[i] = tmp;
		}
		
		return array;
	}

	public static void dispose() {
		catSitting.dispose();
		catRunning.dispose();
		catSittingFood.dispose();
		catRunningFood.dispose();
		maleStanding.dispose();
		maleWalking.dispose();
		femaleStanding.dispose();
		femaleWalking.dispose();
		birdFlying.dispose();
		mouseWalking.dispose();
		chickenWalking.dispose();
		starBlinking.dispose();
	}

}