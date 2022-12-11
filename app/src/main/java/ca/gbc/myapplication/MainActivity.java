package ca.gbc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private TextView name,address,phone;
    ArrayList<String> resList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.submit);
        name = findViewById(R.id.nameIn);
        address = findViewById(R.id.adressIn);
        phone = findViewById(R.id.phoneIn);

        btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view){
        String item = (String) name.getText() + (String) address.getText() + (String) phone.getText();
        resList.add(item);
        }
        });
    }

}
