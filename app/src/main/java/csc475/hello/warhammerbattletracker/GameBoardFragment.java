package csc475.hello.warhammerbattletracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import java.util.List;

public class GameBoardFragment extends Fragment {

    private GridLayout gameBoardLayout;
    private ArmyModelDAO armyModelDAO;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_game_board, container, false);

        gameBoardLayout = rootView.findViewById(R.id.game_board_layout);
        armyModelDAO = new ArmyModelDAO(getActivity());

        populateGameBoard();

        return rootView;
    }

    private void populateGameBoard() {
        List<ArmyModel> armyModels = armyModelDAO.getAllModels();
        for (ArmyModel model : armyModels) {
            TextView modelTextView = new TextView(getActivity());
            modelTextView.setText(model.getName());
            gameBoardLayout.addView(modelTextView);
        }
    }
}
