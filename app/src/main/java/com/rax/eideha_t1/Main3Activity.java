package com.rax.eideha_t1;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
    String DATABASE_NAME = "database_Eideha.db";
    //===========================================
    String[][] Eideh_Andaze;
    int tedadEideh;
    Button btnSabt,btnCancel;
    ListView list;
    CustomAdapterEideha1 adapter;
    public  Main3Activity CustomListView = null;
    public ArrayList<ListModel> CustomListViewValuesArr = new ArrayList<ListModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        //======================================
        //==============================================
        CustomListView = this;

        /******** Take some data in Arraylist ( CustomListViewValuesArr ) ***********/
        setTitle("لیست جام های قابل انتخاب ");
        Eideh_Andaze= EidehVAndaze(DATABASE_NAME);

        tedadEideh=Eideh_Andaze.length;

        setListData( Eideh_Andaze,tedadEideh);

        Resources res =getResources();
        list=(ListView)findViewById(R.id.listView_Eideha);

        /**************** Create Custom Adapter *********/
        adapter=new CustomAdapterEideha1(CustomListView, CustomListViewValuesArr,res);
        list.setAdapter(adapter);
        Log.d("","aaaaa   2");


    }
    //============================================
    private String[][] EidehVAndaze(String data_base) {


        SQLiteDatabase mydb = openOrCreateDatabase(data_base, Context.MODE_PRIVATE,null);
        Cursor allrows  = mydb.rawQuery("SELECT Table_Olaviate_Eideha.shomare_Eide,Table_Olaviate_Eideha.Emtiaz,Table_Eideha.M1 FROM Table_Olaviate_Eideha INNER JOIN Table_Eideha ON Table_Olaviate_Eideha.shomare_Eide = Table_Eideha.shomare_Eide ORDER BY Table_Olaviate_Eideha.Emtiaz DESC ", null);

        int count=allrows.getCount();
        String[][] outp=new  String[count][3];
        try{
            int i = 0;

            if (count==0) {
                Toast.makeText(getBaseContext()," موردی برای نمایش وجود ندارد", Toast.LENGTH_SHORT).show();
                //		چک کردن وارد نکردن یک تیم به صورت تکراری
            } else {
                if (allrows.moveToFirst()) {
                    do {
                        outp[i][0] = allrows.getString(0);
                        outp[i][1] = allrows.getString(1);
                        outp[i][2] = allrows.getString(2);

                        i++;
                    }
                    while (allrows.moveToNext());
                }
            }
            mydb.close();
        }catch(Exception e){
            Toast.makeText(getApplicationContext(), "موردی برای نمایش موجود نیست", Toast.LENGTH_SHORT).show();
        }
        return outp;
    }
    //============================================

    //============================================
    public void setListData(String[][] Eide_Andazein,Integer tedadEidein)    {
        CustomListViewValuesArr.clear();

        for (int i = 0; i < tedadEidein; i++) {

            final ListModel sched = new ListModel();

            /******* Firstly take data in model object ******/

            sched.setRadif(""+(i+1));
            sched.setEideh(Eide_Andazein[i][0]);
            Log.d("","zzzz      0:"+Eide_Andazein[i][0]);

            sched.setMizan(Eide_Andazein[i][1]);
            sched.setMeyar(Eide_Andazein[i][2]);

            /******** Take Model Object in ArrayList **********/

            CustomListViewValuesArr.add(sched);
        }
    }
    //============================================
    public void onItemClick(int mPosition)    {
        ListModel tempValues = (ListModel) CustomListViewValuesArr.get(mPosition);
        String Eideh1=tempValues.getEideh();
        //                      ارسال اطلاعات به اکتویوی بعد
        //-----------------------------------------------------------
        Intent i = new Intent(getApplicationContext(), Main2Activity.class);
        String[] send_Data = {Eideh1};
        i.putExtra("key_send", send_Data);
        Log.d("","zzzz      1"+Eideh1);
        startActivity(i);



        //===========================

    }

    //============================================
}
