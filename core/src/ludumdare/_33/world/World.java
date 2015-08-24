package ludumdare._33.world;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

import ludumdare._33.MainGame;
import ludumdare._33.particles.ParticleManager;
import ludumdare._33.world.cat.Cat;
import ludumdare._33.world.environment.buildings.Building;
import ludumdare._33.world.environment.buildings.Home;
import ludumdare._33.world.environment.hidables.Foliage;
import ludumdare._33.world.human.Human;
import ludumdare._33.world.prey.Bird;
import ludumdare._33.world.prey.Mouse;

public class World {

	public Cat cat;
	public Bird bird;
	public Mouse mouse;
	ArrayList<Human> humans = new ArrayList<Human>();
	ArrayList<Building> buildings = new ArrayList<Building>();
	ArrayList<Foliage> foliage = new ArrayList<Foliage>();

	public static Rectangle bounds = new Rectangle(0, 0, 800f * 10f, 480f * 3f);
	public float losePercent = 0f;
	
	ParticleManager particleManager;

	public World() {
		cat = new Cat();
		particleManager = new ParticleManager();
		
		generateWorld();
	}
	
	void generateWorld(){
		addBuildings();
		addFoliage();
		addHumans();
		addPrey();
	}
	
	void addBuildings(){
		buildings.add(new Home(10));
		
		
	}
	
	void addFoliage(){
		
	}
	
	void addHumans(){
		humans.add(new Human(0));
	}
	
	void addPrey(){
		bird = new Bird(10);
		mouse = new Mouse(10);
	}

	
	public void update(float delta) {
		cat.update(delta);
		updateDetection(delta);
		
		bird.update(delta);
	}
	
	float loseTimer = 0f;
	public void updateDetection(float delta) {
		for (Human h : humans) {
			h.update(delta);
			if (h.canSeeCat(cat) && cat.hasFood) {
				loseTimer += delta;
				if (loseTimer > 0.6f) {
					MainGame.instance.endGame();
				}
			} else {
				loseTimer -= 0.25f * delta;
				if (loseTimer < 0) {
					loseTimer = 0;
				}
			}
			losePercent = loseTimer/0.6f;
		}
		bird.update(delta);
		mouse.update(delta);
	}

	public void draw(SpriteBatch batch) {

		for (Building b : buildings) {
			b.draw(batch);
		}

		cat.draw(batch);

		for (Foliage f : foliage) {
			f.draw(batch);
		}
		
		for (Human h : humans) {
			h.draw(batch);
		}
		
		bird.draw(batch);
		mouse.draw(batch);
		
		particleManager.setBloodLocation(400, 280);
		particleManager.drawBloodEffects(batch);
	}

	public void drawDebug(ShapeRenderer shapeRenderer) {
		cat.drawFloorCheck(shapeRenderer);
		for (Human h : humans) {
			h.drawDebug(shapeRenderer);
		}
	}

}
