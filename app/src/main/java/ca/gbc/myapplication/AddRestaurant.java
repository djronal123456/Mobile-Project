package ca.gbc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class AddRestaurant extends AppCompatActivity {
    public static String name;
    public static String address;
    public static String phone;
    public static String rating;
    public static String description;
    public static Boolean vegetarian;
    public static Boolean vegan;
    public static Boolean organic;
    public static Boolean european;
    public static Boolean asian;
    public static Boolean other;
    public static Boolean trying = Boolean.FALSE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.display);
        super.onCreate(savedInstanceState);
        EditText displayingName = findViewById(R.id.textView);
        EditText displayingAddress = findViewById(R.id.textView2);
        EditText displayingPhone = findViewById(R.id.textView3);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) EditText displayingRating = findViewById(R.id.textView10);
        EditText displayingDescription = findViewById(R.id.textView4);
        TextView displayingTags = findViewById(R.id.textView12);
        Button locationBtn  = findViewById(R.id.goTo);
        Button saveBtn  = findViewById(R.id.save);
        Button btn = findViewById(R.id.share);

        displayingName.setText(MainActivity.getName());
        displayingAddress.setText(MainActivity.getAddress());
        displayingPhone.setText(MainActivity.getPhone());
        displayingRating.setText(MainActivity.getRating());
        displayingDescription.setText(MainActivity.getDescription());
        displayingTags.setText(getTags());

        setName(MainActivity.getName());
        setAddress(MainActivity.getAddress());
        setPhone(MainActivity.getPhone());
        setRating(MainActivity.getRating());
        setDescription(MainActivity.getDescription());
        setVegetarian(MainActivity.getVegetarian());
        setVegan(MainActivity.getVegan());
        setOrganic(MainActivity.getOrganic());
        setEuropean(MainActivity.getEuropean());
        setAsian(MainActivity.getAsian());
        setOther(MainActivity.getOther());

        locationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(Intent.ACTION_VIEW);
               intent.setData(Uri.parse("geo:0,0?q=" +Uri.encode(MainActivity.getAddress())));
              startActivity(intent);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_SUBJECT, ("Details of " + Uri.encode(MainActivity.getName())));
                email.putExtra(Intent.EXTRA_TEXT, ("Address: " + Uri.encode(MainActivity.getAddress()) + "\nPhone Number: " + Uri.encode(MainActivity.getPhone()) + "\nDescription: " + Uri.encode(MainActivity.getDescription()) + "\n This was sent using the Restaurant Guide App"));
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            setTry(Boolean.TRUE);
                setName(displayingName.getText().toString());
                setAddress(displayingAddress.getText().toString());
                setPhone(displayingPhone.getText().toString());
                setRating(displayingRating.getText().toString());
                setDescription(displayingDescription.getText().toString());
                setVegetarian(MainActivity.getVegetarian());
                setVegan(MainActivity.getVegan());
                setOrganic(MainActivity.getOrganic());
                setEuropean(MainActivity.getEuropean());
                setAsian(MainActivity.getAsian());
                setOther(MainActivity.getOther());
                change();
            }

        });


    }
    public void change(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
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
    public static Boolean getTry(){return trying;}
    public static void setTry(Boolean someTry){trying = someTry;}
    public static String getName(){return name;}
    public void setName(String someName){this.name = someName;}

    public static String getAddress(){return address;}
    public void setAddress(String someAddress){this.address = someAddress;}

    public static String getPhone(){return phone;}
    public void setPhone(String somePhone){this.phone = somePhone;}

    public static String getRating(){return rating;}
    public void setRating(String someRating){this.rating=someRating;}

    public static String getDescription(){return description;}
    public void setDescription(String someDescription){this.description=someDescription;}

    public static Boolean getVegetarian(){return vegetarian;}
    public void setVegetarian(Boolean someVegetarian){this.vegetarian=someVegetarian;}

    public static Boolean getVegan(){return vegan;}
    public void setVegan(Boolean someVegan){this.vegan=someVegan;}

    public static Boolean getOrganic(){return organic;}
    public void setOrganic(Boolean someOrganic){this.organic=someOrganic;}

    public static Boolean getEuropean(){return european;}
    public void setEuropean(Boolean someEuropean){this.european=someEuropean;}

    public static Boolean getAsian(){return asian;}
    public void setAsian(Boolean someAsian){this.asian=someAsian;}

    public static Boolean getOther(){return other;}
    public void setOther(Boolean someOther){this.other=someOther;}
}