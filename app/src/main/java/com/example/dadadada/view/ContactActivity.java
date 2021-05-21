package com.example.dadadada.view;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dadadada.R;
import com.example.dadadada.adapter.CAdapter;
import com.example.dadadada.adapter.SAdapter;
import com.example.dadadada.common.ConstactEntity;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity {
    private List<ConstactEntity> list = new ArrayList<>();
    private List<String> str = new ArrayList<>();
    private EditText edSou;
    private RecyclerView ree1;
    private RecyclerView ree2;
    private ImageView imageFanhui;
    private TextView titleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        initView();
        titleText.setText("联系人");
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            requestPermissions(new String[]{
                    Manifest.permission.WRITE_CONTACTS, Manifest.permission.READ_CONTACTS
            }, 100);
        } else {
            huoqulianxiren();
        }

        youlie();

        imageFanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void youlie() {
        for(char i='A';i<='Z';i++){
            str.add(i+"");
        }
        SAdapter sAdapter = new SAdapter(R.layout.item_xyz, str);
        ree2.setAdapter(sAdapter);

        ree2.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            huoqulianxiren();
        }
    }

    private void huoqulianxiren(){
        Log.i("www", "huoqulianxiren: 咚咚咚");
        ContentResolver contentResolver = getContentResolver();
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String[] strings = {ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME};

        Cursor cursor = contentResolver.query(uri, strings, null, null, null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String phone = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));


            ConstactEntity constactEntity = new ConstactEntity();
            constactEntity.setName(name);
            constactEntity.setPhonenumber(phone);
            list.add(constactEntity);
            Log.i("www", "huoqulianxiren: " + list.size());
            CAdapter cAdapter = new CAdapter(R.layout.item_c, list);
            ree1.setAdapter(cAdapter);
            ree1.setLayoutManager(new LinearLayoutManager(this));
        }
    }

    private void initView() {
        edSou = (EditText) findViewById(R.id.ed_sou);
        ree1 = (RecyclerView) findViewById(R.id.ree1);
        ree2 = (RecyclerView) findViewById(R.id.ree2);
        imageFanhui = (ImageView) findViewById(R.id.image_fanhui);
        titleText = (TextView) findViewById(R.id.title_text);
    }
}