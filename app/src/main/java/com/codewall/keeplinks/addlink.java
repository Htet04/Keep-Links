package com.ktz.keeplinks;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ktz.keeplinks.database.DataBaseHelper;

import java.util.List;


public class addlink extends Fragment {
    EditText title;
Button add,view1;
List<Contacts > contacts;

    public addlink() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_addlink, container, false);
        title=view.findViewById(R.id.title);
DBHelper db=new DBHelper(getContext());
        add=view.findViewById(R.id.button);
        view1=view.findViewById(R.id.button2);
        add.setOnClickListener(v->{
          String str=title.getText().toString();
          Boolean check=db.saveDate(str);
          if(check==true){
              Toast.makeText(getContext(), "save", Toast.LENGTH_SHORT).show();
          }
      



        });
        view1.setOnClickListener(v->{
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame1,new categoryfragment()).commit();

        });



        return view;
    }

}