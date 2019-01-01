package com.example.hothaingoc.chemicallight;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class ChemicalElement extends AppCompatActivity {

    RecyclerView recyclerView;
    EditText editText_search;
    Button button_search;

    //database
    final String DATABASE_NAME = "ntg.sqlite";
    SQLiteDatabase sqLiteDatabase;
    ArrayList<data_Element> arrayList;
    adapter_Element dataA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemical_element);

        initView();
        findDataSearch();

        //menu fillter
        registerForContextMenu(button_search);
    }

    private void findDataSearch() {
        editText_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s == null){
                    readData("",1,0, 2);
                }
                else{
                    readData(s.toString(),1,0,2);
                }
            }
        });
    }

    private void readData(String s, int _metal , int _nometal,int _rareGas){
        sqLiteDatabase = Database.initDatabase(this,DATABASE_NAME);
        String countQuery = "SELECT  * FROM  NGUYENTO WHERE "
                +"( NAME_NT " +" like '%"+s+"%'"
                + "OR CK" + " like '%"+s+"%'"
                + "OR GP" +" like '"+s+"')";
        Cursor cursor = sqLiteDatabase.rawQuery(countQuery,null);
        arrayList.clear();

        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            int id_ele = cursor.getInt(0);
            String name_ele = cursor.getString(1);
            String symbol_ele = cursor.getString(2);
            String ato_ele = cursor.getString(4);
            String group_ele = cursor.getString(5);
            String cycle_ele = cursor.getString(6);
            String oxi_ele = cursor.getString(7);

            //type img
            int typeElement = cursor.getInt(3);

            if (typeElement == _metal) {
                arrayList.add(new data_Element(id_ele, R.drawable.img_a, name_ele, symbol_ele, ato_ele, group_ele, cycle_ele, oxi_ele));
            }
            else if (typeElement == _nometal){
                arrayList.add(new data_Element(id_ele, R.drawable.img_b, name_ele, symbol_ele, ato_ele, group_ele, cycle_ele, oxi_ele));
            }
        }
        dataA.notifyDataSetChanged();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context,menu);
        menu.setHeaderTitle("FILLTER");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.KL:
            {
                //FillMetal();
                readData("",1,-1, -1);
                break;
            }

            case R.id.PK:
            {
                //FillNonmetals();
                readData("",-1,0, -1);
                break;
            }

            case R.id.KH:
            {
                break;
            }
        }
        return super.onContextItemSelected(item);
    }

    private void initView() {

        editText_search = (EditText) findViewById(R.id.edt_search);
        button_search = (Button) findViewById(R.id.btn_search);

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true); //toi uu data ko bi anh huong boi adapter
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator( new DefaultItemAnimator());

        arrayList = new ArrayList<>();
        dataA = new adapter_Element(arrayList,this);
        recyclerView.setAdapter(dataA);
    }
}
