package csc475.hello.warhammerbattletracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.fragment.app.Fragment;

import java.util.List;

public class BuildArmyFragment extends Fragment {

    private EditText modelNameEditText, modelTypeEditText;
    private Button addModelButton;
    private ListView armyListView;
    private ArmyModelDAO armyModelDAO;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_build_army, container, false);

        modelNameEditText = rootView.findViewById(R.id.edit_text_model_name);
        modelTypeEditText = rootView.findViewById(R.id.edit_text_model_type);
        addModelButton = rootView.findViewById(R.id.button_add_model);
        armyListView = rootView.findViewById(R.id.list_view_army);

        armyModelDAO = new ArmyModelDAO(getActivity());

        addModelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String modelName = modelNameEditText.getText().toString();
                String modelType = modelTypeEditText.getText().toString();
                if (!modelName.isEmpty() && !modelType.isEmpty()) {
                    ArmyModel newModel = new ArmyModel(0, modelName, modelType);
                    armyModelDAO.addModel(newModel);
                    updateArmyList();
                }
            }
        });

        updateArmyList();

        return rootView;
    }

    private void updateArmyList() {
        List<ArmyModel> armyModels = armyModelDAO.getAllModels();
        ArmyListAdapter adapter = new ArmyListAdapter(getActivity(), armyModels);
        armyListView.setAdapter(adapter);
    }
}
