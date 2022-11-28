package com.codewall.keeplinks.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.codewall.keeplinks.R;
import com.codewall.keeplinks.database.DataBaseHelper;
import com.codewall.keeplinks.ui.fragment.CategoryFragment;

public class MyDialog extends AppCompatDialogFragment {
    @NonNull
    EditText title;
   public String str;
   DataBaseHelper db;
    @Override

    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
      super.onCreateDialog(savedInstanceState);
       AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater=getActivity().getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.dialog_layout,null);
        builder.setTitle("name category");
        builder.setView(view);
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String str = title.getText().toString();
db=new DataBaseHelper(getContext());
                Toast.makeText(getContext(), "c;ocl", Toast.LENGTH_SHORT).show();
                long status = db.addLink(str, null, null, null, null);
                if (status != -1) {
                    Toast.makeText(getContext(), "success", Toast.LENGTH_SHORT).show();


                }
            }
        });
        title=view.findViewById(R.id.editText1);
return builder.create();
    }

public void insert(String string){
        this.str=string;
}
public void getString(String str){
        this.str=str;
}




//
}
