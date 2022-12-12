package ca.gbc.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    Button add;
    AlertDialog dialog;
    LinearLayout layout;
    public static String name;
    public static String address;
    public static String phone;
    public static String rating;
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
        //final EditText rating = view.findViewById(R.id.rating);

        builder.setView(view);
        builder.setTitle("Enter name")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        addCard(name.getText().toString(),address.getText().toString(),phone.getText().toString());

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        dialog = builder.create();
    }

    private void addCard(String name, String address,String phone) {
        final View view = getLayoutInflater().inflate(R.layout.card, null);

        TextView nameView = view.findViewById(R.id.name);
        Button delete = view.findViewById(R.id.delete);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button viewDetails = view.findViewById(R.id.view);

        nameView.setText(name);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.removeView(view);
            }
        });
        viewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setName(name);
                setAddress(address);
                setPhone(phone);
                setRating(rating);
                changePage();
            }
        });

        layout.addView(view);
    }
    public void changePage(){
        Intent i = new Intent(this, AddRestaurant.class);
        startActivity(i);
    }
    public static String getName(){return name;}
    public void setName(String someName){this.name = someName;}

    public static String getAddress(){return address;}
    public void setAddress(String someAddress){this.address = someAddress;}

    public static String getPhone(){return phone;}
    public void setPhone(String somePhone){this.phone = somePhone;}

    public static String getRating(){return rating;}
    public void setRating(String someRating){this.rating=someRating;}
}

