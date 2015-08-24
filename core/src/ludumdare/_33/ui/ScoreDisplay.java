package ludumdare._33.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ludumdare._33.Player;
import ludumdare._33.screens.AbstractScreen;

public class ScoreDisplay {

	int score;
	Player player;
	
	public ScoreDisplay(Player player) {
	}
	
	public void update(int playerScore) {
		score = playerScore;
	}

	public void draw(SpriteBatch batch) {
		AbstractScreen.font.draw(batch, "SCORE: "+ score, 340, 440);
	}

}
