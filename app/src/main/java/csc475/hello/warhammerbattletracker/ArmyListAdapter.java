package csc475.hello.warhammerbattletracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ArmyListAdapter extends BaseAdapter {

    private Context context;
    private List<ArmyModel> armyModels;

    public ArmyListAdapter(Context context, List<ArmyModel> armyModels) {
        this.context = context;
        this.armyModels = armyModels;
    }

    @Override
    public int getCount() {
        return armyModels.size();
    }

    @Override
    public Object getItem(int position) {
        return armyModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return armyModels.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_army_model, parent, false);
        }

        ArmyModel model = armyModels.get(position);

        TextView modelNameTextView = convertView.findViewById(R.id.text_model_name);
        TextView modelTypeTextView = convertView.findViewById(R.id.text_model_type);

        modelNameTextView.setText(model.getName());
        modelTypeTextView.setText(model.getType());

        return convertView;
    }
}
