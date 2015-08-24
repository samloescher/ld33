package ludumdare._33.world;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import ludumdare._33.MainGame;
import ludumdare._33.particles.BloodSplatterParticles;
import ludumdare._33.world.cat.Cat;
import ludumdare._33.world.environment.buildings.Building;
import ludumdare._33.world.environment.buildings.Bungalow1;
import ludumdare._33.world.environment.buildings.Home;
import ludumdare._33.world.environment.hidables.Foliage;
import ludumdare._33.world.human.Human;
import ludumdare._33.world.human.Man;
import ludumdare._33.world.prey.Bird;
import ludumdare._33.world.prey.Chicken;
import ludumdare._33.world.prey.Mouse;

public class World {

	public Cat cat;
	public Bird bird;
	public Mouse mouse;
	public Chicken chicken;
	ArrayList<Human> humans = new ArrayList<Human>();
	ArrayList<Building> buildings = new ArrayList<Building>();
	ArrayList<Foliage> foliage = new ArrayList<Foliage>();

	public static Rectangle bounds = new Rectangle(0, 0, 800f * 10f, 480f * 3f);
	public float losePercent = 0f;

	BloodSplatterParticles bloodSplatterParticles;

	public World() {
		bloodSplatterParticles = new BloodSplatterParticles();
		cat = new Cat(bloodSplatterParticles);
		generateWorld();
	}

	private void generateWorld() {
		addBuildings();
		addFoliage();
		addHumans();
		addPrey();
	}

	private void addBuildings() {
		buildings.add(new Home(10));
		Building attemptedBuilding;
		for(int i = 0; i < 10; i++){
			attemptedBuilding = new Bungalow1(new Vector2(MathUtils.random(100, 1000),0));
		}
	}

	private void addFoliage() {
		for(int i = 0; i < 10; i++){
			
		}
	}

	private void addHumans() {
		humans.add(new Man(500, 1000));
	}

	private void addPrey() {
		bird = new Bird(10);
		mouse = new Mouse(10);
		chicken = new Chicken(100);
	}

	public void update(float delta) {
		cat.update(delta);
		updateHumans(delta);
		updatePrey(delta);
		bloodSplatterParticles.update(delta);
		bird.update(delta);
	}

	float loseTimer = 0f;

	private void updateHumans(float delta) {
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
			losePercent = loseTimer / 0.6f;
		}
	}

	private void updatePrey(float delta) {
		bird.update(delta);
		mouse.update(delta);
		chicken.update(delta);
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
		chicken.draw(batch);

		bloodSplatterParticles.drawBloodEffects(batch);
	}

	public void drawDebug(ShapeRenderer shapeRenderer) {
		cat.drawFloorCheck(shapeRenderer);
		for (Human h : humans) {
			h.drawDebug(shapeRenderer);
		}
	}

}
