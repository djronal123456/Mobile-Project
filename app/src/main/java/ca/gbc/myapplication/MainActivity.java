package ca.gbc.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button add;
    AlertDialog dialog;
    LinearLayout layout;

    RestaurantList rest = new RestaurantList(1000);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = findViewById(R.id.add);
        layout = findViewById(R.id.container);

        buildDialog();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
    }

    private void buildDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.add_restaurant, null);

        final EditText name = view.findViewById(R.id.nameIn);
        final EditText address = view.findViewById(R.id.adressIn);
        final EditText phone = view.findViewById(R.id.phoneIn);
        final EditText description = view.findViewById(R.id.descriptionIn);
        final CheckBox isVegetarian = view.findViewById(R.id.tagVegetarian);
        final CheckBox isVegan = view.findViewById(R.id.tagVegan);
        final CheckBox isOrganic = view.findViewById(R.id.tagOrganic);
        final CheckBox isEuropean = view.findViewById(R.id.tagEuropean);
        final CheckBox isAsian = view.findViewById(R.id.tagAsian);
        final CheckBox isOther = view.findViewById(R.id.tagOther);



        builder.setView(view);
        builder.setTitle("Enter name")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String addName = name.getText().toString();
                        String addAddress = address.getText().toString();
                        String addPhone = phone.getText().toString();
                        String addDescription = description.getText().toString();
                        Boolean addVegetarian = isVegetarian.isChecked();
                        Boolean addVegan = isVegan.isChecked();
                        Boolean addOrganic = isOrganic.isChecked();
                        Boolean addEuropean = isEuropean.isChecked();
                        Boolean addAsian = isAsian.isChecked();
                        Boolean addOther = isOther.isChecked();
                        rest.addRestaurant(addName, addAddress, addPhone, addDescription, addVegetarian, addVegan, addOrganic, addEuropean, addAsian, addOther);
                        addCard(rest.findRestaurant(0).getName());
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        dialog = builder.create();
    }

    private void addCard(String name) {
        final View view = getLayoutInflater().inflate(R.layout.card, null);

        TextView nameView = view.findViewById(R.id.name);
        Button delete = view.findViewById(R.id.delete);

        nameView.setText(name);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.removeView(view);
            }
        });

        layout.addView(view);
    }
}
