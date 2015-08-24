package ludumdare._33.world;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import ludumdare._33.MainGame;
import ludumdare._33.Player;
import ludumdare._33.particles.BloodSplatterParticles;
import ludumdare._33.screens.GameScreen;
import ludumdare._33.world.cat.Cat;
import ludumdare._33.world.environment.buildings.Building;
import ludumdare._33.world.environment.buildings.Bungalow1;
import ludumdare._33.world.environment.buildings.Bungalow2;
import ludumdare._33.world.environment.buildings.Church;
import ludumdare._33.world.environment.buildings.Home;
import ludumdare._33.world.environment.buildings.Marketplace;
import ludumdare._33.world.environment.hidables.Foliage;
import ludumdare._33.world.environment.hidables.HedgeGreen;
import ludumdare._33.world.environment.hidables.SmallBushDarkGreen;
import ludumdare._33.world.environment.hidables.SmallBushFruitGreen;
import ludumdare._33.world.environment.hidables.SmallBushGreen;
import ludumdare._33.world.human.Female;
import ludumdare._33.world.human.Human;
import ludumdare._33.world.human.Male;
import ludumdare._33.world.prey.Bird;
import ludumdare._33.world.prey.Chicken;
import ludumdare._33.world.prey.Mouse;
import ludumdare._33.world.prey.Prey;

public class World {

	Player player;

	public Cat cat;
	Home home;
	ArrayList<Human> humans = new ArrayList<Human>();
	ArrayList<Building> buildings = new ArrayList<Building>();
	ArrayList<Foliage> foliage = new ArrayList<Foliage>();
	ArrayList<Prey> preys = new ArrayList<Prey>();

	public static Rectangle bounds = new Rectangle(0, 0, 800f * 10f, 480f * 3f);
	public float losePercent = 0f;

	float preyCaughtX;
	float preyCaughtY;

	BloodSplatterParticles bloodSplatterParticles;

	public World(Player player) {
		this.player = player;
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
		home = new Home(10);
		buildings.add(home);
		buildings.add(new Church(new Vector2(700, 0)));
		buildings.add(new Bungalow1(new Vector2(1500, 0)));
		buildings.add(new Marketplace(new Vector2(2200, 0)));
		buildings.add(new Bungalow2(new Vector2(2800, 0)));
		buildings.add(new Church(new Vector2(3200, 0)));
		buildings.add(new Marketplace(new Vector2(4200, 0)));
		buildings.add(new Bungalow2(new Vector2(4800, 0)));
		buildings.add(new Bungalow1(new Vector2(5400, 0)));
		buildings.add(new Marketplace(new Vector2(5800, 0)));
		buildings.add(new Church(new Vector2(6400, 0)));
		buildings.add(new Bungalow1(new Vector2(7200, 0)));
	}

	private void addFoliage() {
		foliage.add(new HedgeGreen(new Vector2(22, 0)));
		foliage.add(new SmallBushGreen(new Vector2(500, 0)));
		foliage.add(new SmallBushFruitGreen(new Vector2(900, 0)));
		foliage.add(new SmallBushDarkGreen(new Vector2(1400, 0)));
		foliage.add(new SmallBushFruitGreen(new Vector2(1800, 0)));
		foliage.add(new HedgeGreen(new Vector2(2400, 0)));
		foliage.add(new SmallBushFruitGreen(new Vector2(2700, 0)));
		foliage.add(new SmallBushGreen(new Vector2(3100, 0)));
		foliage.add(new SmallBushFruitGreen(new Vector2(3500, 0)));
		foliage.add(new HedgeGreen(new Vector2(3800, 0)));
		foliage.add(new SmallBushDarkGreen(new Vector2(4100, 0)));
		foliage.add(new HedgeGreen(new Vector2(4300, 0)));
		foliage.add(new SmallBushGreen(new Vector2(4700, 0)));
		foliage.add(new SmallBushFruitGreen(new Vector2(5000, 0)));
		foliage.add(new SmallBushDarkGreen(new Vector2(5350, 0)));
		foliage.add(new SmallBushFruitGreen(new Vector2(5800, 0)));
		foliage.add(new HedgeGreen(new Vector2(6300, 0)));
		foliage.add(new SmallBushFruitGreen(new Vector2(6500, 0)));
		foliage.add(new SmallBushGreen(new Vector2(6800, 0)));
		foliage.add(new SmallBushFruitGreen(new Vector2(7100, 0)));
		foliage.add(new HedgeGreen(new Vector2(7300, 0)));
		foliage.add(new SmallBushFruitGreen(new Vector2(7500, 0)));
	}

	private void addHumans() {
		humans.add(new Male(500, 1000));
		humans.add(new Female(1200, 1700));
		humans.add(new Male(2000, 2700));
		humans.add(new Female(3000, 3500));
		humans.add(new Male(3800, 4500));
		humans.add(new Female(4500, 5000));
		humans.add(new Male(5000, 5700));
		humans.add(new Male(5800, 6200));
		humans.add(new Female(6500, 6900));
		humans.add(new Male(7200, 7800));
	}

	private void addPrey() {
		preys.add(new Bird(10, 400, 400));
		preys.add(new Bird(250, 800, 450));
		preys.add(new Bird(400, 600, 400));
		preys.add(new Bird(700, 900, 440));
		preys.add(new Bird(1000, 1400, 400));
		preys.add(new Bird(1270, 1900, 400));
		preys.add(new Bird(2000, 2900, 400));
		preys.add(new Bird(2600, 4500, 450));
		preys.add(new Bird(5000, 7000, 400));
		preys.add(new Bird(6500, 7500, 450));
		preys.add(new Bird(7000, 8000, 440));

		preys.add(new Chicken(400, 800));
		preys.add(new Chicken(1200, 2000));
		preys.add(new Chicken(2100, 2800));
		preys.add(new Chicken(3200, 4000));
		preys.add(new Chicken(4400, 5000));
		preys.add(new Chicken(5200, 6000));
		preys.add(new Chicken(6100, 6800));
		preys.add(new Chicken(7100, 7800));

		preys.add(new Mouse(700, 1200));
		preys.add(new Mouse(1500, 2000));
		preys.add(new Mouse(2300, 3500));
		preys.add(new Mouse(3000, 4000));
		preys.add(new Mouse(4500, 5300));
		preys.add(new Mouse(5600, 6200));
		preys.add(new Mouse(6800, 7200));
		preys.add(new Mouse(7300, 7700));
	}

	public void update(float delta) {

		int newPreyStartLocationX = (int) preyCaughtX + MathUtils.random(400, 1000);
		if (newPreyStartLocationX > 7800 ) {
			newPreyStartLocationX = MathUtils.random(400, 1000);
		}
		int newPreyEndLocationX = (int) preyCaughtX + MathUtils.random(1500, 2000);
		if (newPreyEndLocationX < 7800 ) {
			newPreyEndLocationX = MathUtils.random(1500, 2000);
		}

		cat.update(delta);
		updateHumans(delta);
		updatePrey(delta);
		attemptToEatPrey();
		if (isCatHome()) {
			if (cat.hasFood) {
				cat.hasFood = false;
				player.score += player.currentCatchValue;
				GameScreen.soundEffects.playPointsSound();

				// Add prey back in after returning home.
				if (player.currentCatchValue == 50) {
					preys.add(new Bird(newPreyStartLocationX, newPreyEndLocationX, (int) preyCaughtY));
				} else if (player.currentCatchValue == 20) {
					preys.add(new Chicken(newPreyStartLocationX, newPreyEndLocationX));
				} else {
					preys.add(new Mouse(newPreyStartLocationX, newPreyEndLocationX));
				}
			}
		}
		bloodSplatterParticles.update(delta);
	}

	float loseTimer = 0f;

	private void updateHumans(float delta) {
		boolean visible = false;
		for (Human h : humans) {
			h.update(delta);
			if (!catIsBehindBush()) {
				if (h.canSeeCat(cat) && cat.hasFood) {
					visible = true;
				}
			}
		}
		if (visible == true) {
			loseTimer += delta;
			if (loseTimer > 0.4f) {
				int score = player.score;
				player.score = 0;
				GameScreen.soundEffects.playMeowSound();
				MainGame.instance.endGame(score);
			}
		} else {
			loseTimer -= 0.25f * delta;
			if (loseTimer < 0) {
				loseTimer = 0;
			}
		}
		losePercent = loseTimer / 0.4f;
	}

	private void updatePrey(float delta) {
		for (Prey p : preys) {
			p.update(delta);
		}
	}

	void attemptToEatPrey() {
		if (cat.hasFood) {
			return;
		}
		for (Prey p : preys) {
			if (p.bounds.overlaps(cat.bounds)) {
				// Get location of where prey is killed
				preyCaughtX = p.bounds.x;
				preyCaughtY = p.bounds.y;
				player.currentCatchValue = p.value;
				player.score += p.value / 2;
				preys.remove(p);
				cat.hasFood = true;
				return;
			}
		}
		return;
	}

	boolean isCatHome() {
		return home.doorBounds.overlaps(cat.bounds);
	}

	boolean catIsBehindBush() {
		for (Foliage f : foliage) {
			if (f.bounds.overlaps(cat.bounds)) {
				return true;
			}
		}
		return false;
	}

	public void draw(SpriteBatch batch) {

		for (Building b : buildings) {
			b.draw(batch);
		}

		cat.draw(batch);
		bloodSplatterParticles.drawBloodEffects(batch);

		for (Foliage f : foliage) {
			f.draw(batch);
		}

		for (Human h : humans) {
			h.draw(batch);
		}

		for (Prey p : preys) {
			p.draw(batch);
		}
	}

	public void drawDebug(ShapeRenderer shapeRenderer) {
		cat.drawFloorCheck(shapeRenderer);
		for (Human h : humans) {
			h.drawDebug(shapeRenderer);
		}
	}

}
