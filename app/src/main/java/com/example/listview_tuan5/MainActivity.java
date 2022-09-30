package com.example.listview_tuan5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    ArrayList<com.example.listview_tuan5.Items> items = new ArrayList<>();
    com.example.listview_tuan5.Adapter adapter;
    Boolean kt=false;
    int j=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.petShopLV);
        items.add(new com.example.listview_tuan5.Items("Mèo Na uy","Thông tin mèo Na Uy", "2",R.drawable.nauy)) ;
        items.add(new com.example.listview_tuan5.Items("Husky","Thông tin Husky", "3",R.drawable.husky)) ;
        items.add(new com.example.listview_tuan5.Items("Mèo Ba Tư","Thông tin mèo Ba Tư", "2",R.drawable.butu)) ;
        items.add(new com.example.listview_tuan5.Items("Chó mặt xệ","Thông tin chó mặt xệ", "3",R.drawable.matxe)) ;
        items.add(new com.example.listview_tuan5.Items("Mèo Sphynx","Thông tin mèo Sphynx", "2",R.drawable.sphynx)) ;


        adapter = new com.example.listview_tuan5.Adapter(MainActivity.this,items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(MainActivity.this,Detail.class);
//                intent.putExtra("dulieu",items.get(i).getTen());
//                if (kt!=true)
//                    startActivity(intent);
//                kt=false;
                Xacnhanxoa(i);

            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                kt=true;
                Xacnhanxoa(i);
                return false;
            }
        });
    }
    public void Xacnhanxoa(final int pos){
        AlertDialog.Builder alertDiaLog = new AlertDialog.Builder(MainActivity.this);
        alertDiaLog.setTitle("Xóa món");
        alertDiaLog.setIcon(R.mipmap.ic_launcher);
        alertDiaLog.setMessage("Bạn có chắc chắn muốn xóa món này?");
        alertDiaLog.setPositiveButton("Co", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                items.remove(pos);
                adapter.notifyDataSetChanged();
            }
        });
        alertDiaLog.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDiaLog.show();

    }
}