package ca.gbc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class AddRestaurant extends AppCompatActivity {
    private Button btn;
    private TextView name,address,phone;
    ArrayList<String> resList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.display);
        super.onCreate(savedInstanceState);
        TextView displayingName = findViewById(R.id.textView);
        TextView displayingAddress = findViewById(R.id.textView2);
        TextView displayingPhone = findViewById(R.id.textView3);
        TextView displayingRating = findViewById(R.id.textView4);
        displayingName.setText(MainActivity.getName());
        displayingAddress.setText(MainActivity.getAddress());
        displayingPhone.setText(MainActivity.getPhone());
        displayingRating.setText(MainActivity.getRating());

    }


}