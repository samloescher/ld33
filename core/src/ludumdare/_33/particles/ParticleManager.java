package ludumdare._33.particles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ParticleManager {
	public ParticleEffect particleEffect;

	public ParticleManager() {
		particleEffect = new ParticleEffect();
		particleEffect.load(Gdx.files.internal("particles/blood/blood.p"), Gdx.files.internal("particles/blood"));
	}
	
	public void setBloodLocation(float x, float y) {
		particleEffect.setPosition(x, y);
	}

	public void drawBloodEffects(SpriteBatch batch) {
		particleEffect.draw(batch, Gdx.graphics.getDeltaTime());
		particleEffect.start();
	}
}
