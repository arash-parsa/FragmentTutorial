package com.example.fragmenttutorial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FragmentA extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return (inflater.inflate(R.layout.fragment_a,container,false));
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button doneBtn = view.findViewById(R.id.gotoFragmentB);
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  EditText editText = view.findViewById(R.id.et_a);
                /*String data = editText.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString(FragmentB.EXTRA_KET_DATA,data);

                FragmentB fragmentB = new FragmentB();
                fragmentB.setArguments(bundle);
                */




                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer,FragmentB.newInstance(
                        editText.getText().toString()
                ));
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack(null);
            }
        });
    }
}
