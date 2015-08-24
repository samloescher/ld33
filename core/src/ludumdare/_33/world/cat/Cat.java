package ludumdare._33.world.cat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import ludumdare._33.assets.AnimationTextures;
import ludumdare._33.particles.BloodSplatterParticles;
import ludumdare._33.world.World;
import ludumdare._33.world.environment.Platforms;

public class Cat {
	
	public Rectangle bounds;
	
	public int height = 48;
	public int width = 69;

	Animation sittingAnimation;
	Animation runningAnimation;
	Animation jumpingAnimation;
	
	Animation sittingFoodAnimation;
	Animation runningFoodAnimation;
	Animation jumpingFoodAnimation;
	
	Animation currentAnimation;
	float currentAnimationTime;
	Vector2 position;
	Rectangle floorCheck = new Rectangle();
	
	CatState previousState = CatState.Sitting;
	CatState currentState = CatState.Sitting;
	public boolean hasFood = true;
	boolean facingRight = true;
	boolean onFloorOrPlatform;
	
	Vector2 displacement = new Vector2();
	float velocityY;
	
	BloodSplatterParticles bloodSplatter;
	
	public Cat(BloodSplatterParticles particleManager) {
		position = new Vector2(100, 0);
		bounds = new Rectangle(position.x,position.y,width,height);
		initialiseAnimations();
		currentAnimation = sittingAnimation;
		bloodSplatter = particleManager;
	}

	public void update(float delta) {
		currentAnimationTime += delta;
		updateFloorCheckBounds();
		onFloorOrPlatform = currentlyOnFloorOrPlatform();
		manageInput(delta);
		updateVelocityY(delta);
		updateDisplacement();
		updateState();
		updateBloodSplatter();
		clampToWorldBounds();
		displacement.x = 0;
		displacement.y = 0;
		bounds.x = position.x;
		bounds.y = position.y;
	}
	
	public Vector2 getCatPosition() {
		return new Vector2(position).cpy().add(width / 2, height / 2);
	}

	public void draw(SpriteBatch batch) {
		TextureRegion cat = currentAnimation.getKeyFrame(currentAnimationTime);
		batch.draw(cat, facingRight?position.x+width:position.x, position.y,facingRight?-width:width,height);
	}

	private void manageInput(float delta) {

		if (Gdx.input.isKeyPressed(Keys.W)) {
			if(onFloorOrPlatform){
				velocityY = 700;
			}else{
				displacement.y += 100 * delta;
			}
		}
		
		if (Gdx.input.isKeyPressed(Keys.S)) {
			if(onFloorOrPlatform){
				displacement.y -= 100 * delta;
			}
		}

		if (Gdx.input.isKeyPressed(Keys.D)) {
			displacement.x += 400 * delta;
		} else if (Gdx.input.isKeyPressed(Keys.A)) {
			displacement.x -= 400 * delta;
		}
		
	}
	
	private void updateVelocityY(float delta) {
		if(onFloorOrPlatform && velocityY < 0){
			velocityY = 0;
		}else{
			velocityY -= delta * 1200;
		}
		if(!onFloorOrPlatform || velocityY > 0){
			displacement.y = velocityY * delta;
		}
	}
	
	private void updateDisplacement(){
		if(displacement.x > 0){
			facingRight = true;
		}else if(displacement.x < 0){
			facingRight = false;
		}
		position.x += displacement.x;
		position.y += displacement.y;
	}

	private void updateState(){
		if(!onFloorOrPlatform){
			changeState(CatState.Jumping);
		}else if(displacement.x != 0){
			changeState(CatState.Running);
		}else{
			changeState(CatState.Sitting);
		}
		
		if(previousState != currentState){
			currentAnimationTime = 0;
		}
		if (hasFood) {
			switch (currentState) {
			case Sitting:
				currentAnimation = sittingFoodAnimation;
				break;
			case Running:
				currentAnimation = runningFoodAnimation;
				break;
			case Jumping:
				currentAnimation = jumpingFoodAnimation;
				break;
			}
		} else {
			switch (currentState) {
			case Sitting:
				currentAnimation = sittingAnimation;
				break;
			case Running:
				currentAnimation = runningAnimation;
				break;
			case Jumping:
				currentAnimation = jumpingAnimation;
				break;
			}
		}
	}
	
	private void updateBloodSplatter(){
		if(hasFood){
			if(facingRight){
				bloodSplatter.setBloodLocation(position.x + width, position.y + height/2);
			}else{
				bloodSplatter.setBloodLocation(position.x , position.y + height/2);
			}
			bloodSplatter.addBloodSplatter();
		}
	}
	
	private void clampToWorldBounds(){
		position.x = MathUtils.clamp(position.x, World.bounds.x, World.bounds.width - width);
		position.y = MathUtils.clamp(position.y, World.bounds.y, World.bounds.height - height);
	}
	
	private boolean currentlyOnFloorOrPlatform() {
		if (position.y == 0 || Platforms.collidingWithPlatform(floorCheck)){
			return true;
		}
		return false;
	}

	private void changeState(CatState state){
		previousState = currentState;
		currentState = state;
	}

	private void initialiseAnimations() {
		sittingAnimation = new Animation(0.5f, AnimationTextures.catSittingArray);
		sittingAnimation.setPlayMode(PlayMode.LOOP);
		runningAnimation = new Animation(0.05f, AnimationTextures.catRunningArray);
		runningAnimation.setPlayMode(PlayMode.LOOP);
		jumpingAnimation = new Animation(0.4f, AnimationTextures.catJumpingArray);
		jumpingAnimation.setPlayMode(PlayMode.LOOP);
		
		sittingFoodAnimation = new Animation(0.5f, AnimationTextures.catSittingFoodArray);
		sittingFoodAnimation.setPlayMode(PlayMode.LOOP);
		runningFoodAnimation = new Animation(0.05f, AnimationTextures.catRunningFoodArray);
		runningFoodAnimation.setPlayMode(PlayMode.LOOP);
		jumpingFoodAnimation = new Animation(0.4f, AnimationTextures.catJumpingFoodArray);
		jumpingFoodAnimation.setPlayMode(PlayMode.LOOP);
	}
	
	private void updateFloorCheckBounds(){
		floorCheck.x = position.x + width * 0.35f;
		floorCheck.y = position.y;
		floorCheck.width = width * 0.3f;
		floorCheck.height = 2;
	}
	
	public void drawFloorCheck(ShapeRenderer shapeRenderer){
		shapeRenderer.begin(ShapeType.Line);
		shapeRenderer.rect(floorCheck.x, floorCheck.y, floorCheck.width, floorCheck.height);
		shapeRenderer.end();
	}
}
