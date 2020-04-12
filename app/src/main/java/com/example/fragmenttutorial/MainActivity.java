package com.example.fragmenttutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragmentContainer, new FragmentA());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


        Button removeTransactionBtn = findViewById(R.id.remove_transaction);
        removeTransactionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
                FragmentTransaction removeTransaction = getSupportFragmentManager().beginTransaction();
                if(fragment != null) {
                    removeTransaction.remove(fragment);
                    removeTransaction.commit();
                }
                removeTransaction.addToBackStack(null);
            }
        });

    }
}
