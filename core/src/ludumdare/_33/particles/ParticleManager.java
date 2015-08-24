package ludumdare._33.particles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;

public class ParticleManager {
	public ParticleEffect particleEffect;

	public ParticleManager() {
		particleEffect = new ParticleEffect();
		particleEffect.load(Gdx.files.internal("particles/fire-test"), Gdx.files.internal("particles"));
	}

}
