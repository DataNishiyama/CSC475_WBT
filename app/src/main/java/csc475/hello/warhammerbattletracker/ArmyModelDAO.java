package csc475.hello.warhammerbattletracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class ArmyModelDAO {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    public ArmyModelDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long addModel(ArmyModel model) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NAME, model.getName());
        values.put(DatabaseHelper.COLUMN_TYPE, model.getType());
        return db.insert(DatabaseHelper.TABLE_MODELS, null, values);
    }

    public int updateModel(ArmyModel model) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NAME, model.getName());
        values.put(DatabaseHelper.COLUMN_TYPE, model.getType());
        return db.update(DatabaseHelper.TABLE_MODELS, values, DatabaseHelper.COLUMN_ID + " = ?", new String[] { String.valueOf(model.getId()) });
    }

    public void deleteModel(int modelId) {
        db.delete(DatabaseHelper.TABLE_MODELS, DatabaseHelper.COLUMN_ID + " = ?", new String[] { String.valueOf(modelId) });
    }

    public List<ArmyModel> getAllModels() {
        List<ArmyModel> models = new ArrayList<>();
        Cursor cursor = db.query(DatabaseHelper.TABLE_MODELS, null, null, null, null, null, null);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    int id = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ID));
                    String name = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_NAME));
                    String type = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_TYPE));
                    models.add(new ArmyModel(id, name, type));
                } while (cursor.moveToNext());
            }
            cursor.close();
        }

        return models;
    }
}
