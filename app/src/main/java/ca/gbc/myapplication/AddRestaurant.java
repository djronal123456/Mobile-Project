package ca.gbc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
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
        TextView displayingDescription = findViewById(R.id.textView10);
        TextView displayingTags = findViewById(R.id.textView12);
        btn  = findViewById(R.id.goTo);

        displayingName.setText(MainActivity.getName());
        displayingAddress.setText(MainActivity.getAddress());
        displayingPhone.setText(MainActivity.getPhone());
        displayingRating.setText(MainActivity.getRating());
        displayingDescription.setText(MainActivity.getDescription());
        displayingTags.setText(getTags());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:0,0?q=" +Uri.encode(MainActivity.getAddress())));
                startActivity(intent);
            }
        });

    }

    public static String getTags() {
        String tags = "";
        if (MainActivity.getVegetarian()) {
            tags += "Vegetarian, ";
        }
        if (MainActivity.getVegan()) {
            tags += "Vegan,";
        }
        if (MainActivity.getOrganic()) {
            tags += "Organic, ";
        }
        if (MainActivity.getEuropean()) {
            tags += "European, ";
        }
        if (MainActivity.getAsian()) {
            tags += "Asian, ";
        }
        if (MainActivity.getOther()) {
            tags += "Other";
        }
        return tags;
    }


}