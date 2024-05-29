package csc475.hello.warhammerbattletracker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class DiceRollActivity extends AppCompatActivity {

    private TextView diceResultTextView;
    private Button rollDiceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roll);

        diceResultTextView = findViewById(R.id.text_dice_result);
        rollDiceButton = findViewById(R.id.button_roll_dice);

        rollDiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });
    }

    private void rollDice() {
        Random random = new Random();
        int diceRollResult = random.nextInt(6) + 1;
        diceResultTextView.setText(getString(R.string.dice_result, diceRollResult));
        diceResultTextView.setVisibility(View.VISIBLE);
    }
}
