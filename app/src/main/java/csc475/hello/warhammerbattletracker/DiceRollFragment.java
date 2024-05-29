package csc475.hello.warhammerbattletracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import java.util.Random;

public class DiceRollFragment extends Fragment {

    private TextView diceResultTextView;
    private Button rollDiceButton;

    public DiceRollFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_dice_roll, container, false);

        diceResultTextView = rootView.findViewById(R.id.text_dice_result);
        rollDiceButton = rootView.findViewById(R.id.button_roll_dice);

        rollDiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });

        return rootView;
    }

    private void rollDice() {
        Random random = new Random();
        int diceRollResult = random.nextInt(6) + 1;
        diceResultTextView.setText(getString(R.string.dice_result, diceRollResult));
        diceResultTextView.setVisibility(View.VISIBLE);
    }
}
