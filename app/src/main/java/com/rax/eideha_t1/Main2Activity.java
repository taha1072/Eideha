package com.rax.eideha_t1;

        import android.app.Dialog;
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


public class Main2Activity extends AppCompatActivity {
    String DATABASE_NAME = "database_Eideha.db";
    //===========================================
    String[][] Meyar_Andaze;
    String [] Meyar,Zarib_Meyar;
    int tedadMeyar;
     int sho=1001;

    Button btnSabt,btnCancel;
    ListView list;
    CustomAdapter1 adapterJamha;
    //===============================================
    public String shoInputForEdit="";
    public  String[] my_Data= new String [1];
    //================================================
    public  Main2Activity CustomListView = null;
    public ArrayList<ListModel> CustomListViewValuesArr = new ArrayList<ListModel>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //======================================
        //--------------------------------------------------
        //                 دریافت اطلاعات از اکتویتی قبل
        //--------------------------------------------------
        Bundle extras = getIntent().getExtras();
        Log.d("","zzzz      2");
        if (extras != null) {
            Log.d("","zzzz      3");

            String[] recive_Data = extras.getStringArray("key_send");
            my_Data = recive_Data;
            shoInputForEdit = recive_Data[0];
            Log.d("","zzzz      5"+shoInputForEdit);
            sho=Integer.parseInt(shoInputForEdit);

        }
        else
        {
            shoInputForEdit=AkarinShomareEide(DATABASE_NAME);
            sho=Integer.parseInt(shoInputForEdit)+1;

        }
            //----------------------------------------------------------------------

            //==============================================
        CustomListView = this;

        /******** Take some data in Arraylist ( CustomListViewValuesArr ) ***********/
        setTitle("لیست جام های قابل انتخاب ");
        Meyar_Andaze= MeyarVAndaze(DATABASE_NAME);


        tedadMeyar=Meyar_Andaze.length;
        Log.d("","zzzz      6"+sho);

        Meyar=Meyar(DATABASE_NAME,sho,tedadMeyar);

        Zarib_Meyar=ZaribMeyarVAndaze(DATABASE_NAME,sho,tedadMeyar);

        setListData( Meyar_Andaze,Meyar,Zarib_Meyar,tedadMeyar);

        Resources res =getResources();
        list=(ListView)findViewById(R.id.listView_Sabt_Eideh);

        /**************** Create Custom Adapter *********/
        adapterJamha=new CustomAdapter1(CustomListView, CustomListViewValuesArr,res);
        list.setAdapter(adapterJamha);
        Log.d("","aaaaa   2");
        btnSabt=(Button) findViewById(R.id.button_Sabt);
        btnSabt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            SaveEide(Meyar,Zarib_Meyar,tedadMeyar,sho);
            }
        });



    }
    //=======================================
    private String[][] MeyarVAndaze(String data_base) {


        SQLiteDatabase mydb = openOrCreateDatabase(data_base, Context.MODE_PRIVATE,null);
        Cursor allrows  = mydb.rawQuery("SELECT * FROM Table_Jadval_Meyar ", null);
        int count=allrows.getCount();
        String[][] outp=new  String[count][2];
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
                        Log.d("","aaaaa   7:"+outp[i][0]+outp[i][1]);

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
    //===========================================
    private String[] Meyar(String data_base,Integer shoEide,Integer tedadMeyar) {


        SQLiteDatabase mydb = openOrCreateDatabase(data_base, Context.MODE_PRIVATE,null);
        Cursor allrows  = mydb.rawQuery("SELECT * FROM Table_Eideha Where shomare_Eide="+shoEide+"", null);
        String[] outp=new  String[tedadMeyar+1];
        outp[0]=shoEide+"";
        try{
            int i = 0;

            if (tedadMeyar==0) {
                Toast.makeText(getBaseContext()," موردی برای نمایش وجود ندارد", Toast.LENGTH_SHORT).show();
                //		چک کردن وارد نکردن یک تیم به صورت تکراری
            } else {
                if (allrows.moveToFirst()) {
                    do {
                        for (i=1;i<tedadMeyar+1;i++)
                        {
                            outp[i] = allrows.getString(i);
                        }
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
    //===========================================
    private String[] ZaribMeyarVAndaze(String data_base,Integer shoEide,Integer tedadMeyar) {


        SQLiteDatabase mydb = openOrCreateDatabase(data_base, Context.MODE_PRIVATE,null);
        Cursor allrows  = mydb.rawQuery("SELECT * FROM Table_Zaribe_Meyar Where shomare_Eide="+shoEide, null);
        String[] outp=new  String[tedadMeyar+1];
        outp[0]=shoEide+"";
        try{
            int i = 0;

            if (tedadMeyar==0) {
                Toast.makeText(getBaseContext()," موردی برای نمایش وجود ندارد", Toast.LENGTH_SHORT).show();
                //		چک کردن وارد نکردن یک تیم به صورت تکراری
            } else {
                if (allrows.moveToFirst()) {
                    do {
                        for (i=1;i<tedadMeyar+1;i++)
                        {
                            outp[i] = allrows.getString(i);
                        }
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
    //=======================================
    public void setListData(String[][] Meyar_Andazein,String [] Meyarin,String [] Zarib_Meyarin,Integer tedadMeyarin)    {
        CustomListViewValuesArr.clear();

        for (int i = 0; i < tedadMeyarin; i++) {

            final ListModel sched = new ListModel();

            /******* Firstly take data in model object ******/

            sched.setRadif(Meyar_Andazein[i][0]);
            sched.setMeyar(Meyar_Andazein[i][1]);
            sched.setTarifmeyar(Meyarin[i+1]);
            sched.setMizan(Zarib_Meyarin[i+1]);

            /******** Take Model Object in ArrayList **********/

            CustomListViewValuesArr.add(sched);
        }


    }
    //=========================================
    public void onItemClick(int mPosition)    {
        ListModel tempValues = (ListModel) CustomListViewValuesArr.get(mPosition);
        String radif1=tempValues.getRadif();
        String meyar1=tempValues.getMeyar();
        //===========================
        dialogprosess(radif1,meyar1,mPosition);

    }
    //=============================
    public void dialogprosess(String radifin, String meyarin, final Integer position){
        //-------------------ایجاد دیالوگ شو برای خروج----------------------------
        final Dialog dialog12 = new Dialog(Main2Activity.this);
        dialog12.setContentView(R.layout.activity_dialog_each_meyar);
        //-------------------------------------------
        dialog12.setTitle("ایده شماره 1111");
        // set the custom dialog components - text, image and button
        TextView shMe=(TextView) dialog12.findViewById(R.id.textView10);
        shMe.setText(radifin);
        TextView Me=(TextView) dialog12.findViewById(R.id.textView3);
        Me.setText(meyarin);


        Button dialogCancle = (Button) dialog12.findViewById(R.id.button_Ca);
        // if button is clicked, close the custom dialog
        dialogCancle.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog12.dismiss();
            }
        });


        Button dialogsabt = (Button) dialog12.findViewById(R.id.button_Sa);
        // if button is clicked, close the custom dialog
        dialogsabt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edMeyar=(EditText) dialog12.findViewById(R.id.editText4);
                EditText edZaMeyar=(EditText) dialog12.findViewById(R.id.editText5);
                Meyar [position+1]=edMeyar.getText().toString();
                Zarib_Meyar [position+1]=edZaMeyar.getText().toString();
                setListData( Meyar_Andaze,Meyar,Zarib_Meyar,tedadMeyar);
           //     Resources res =getResources();

            //    adapterJamha=new CustomAdapter1(CustomListView, CustomListViewValuesArr,res);
                list.setAdapter(adapterJamha);

                dialog12.dismiss();
            }
        });
        dialog12.show();

    }
    //===============================
    //=================================
    public void SaveEide(String [] Meyarin,String [] Zarib_Meyarin,Integer tedadMeyarin,Integer shE){

        try{
            Log.d("","aaaaa   t:");

            SQLiteDatabase mydb = openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE,null);
            //================================================
            Cursor allrows= mydb.rawQuery("select * from Table_Eideha where shomare_Eide="+shE+"",null);
            int count=allrows.getCount();
            if (count!=0) {
                for (int i=1;i<tedadMeyarin;i++) {
                    if (Meyarin[i]==null||Meyarin[i]=="null")
                    {
                        Meyarin[i]="";
                    }
                    mydb.execSQL("UPDATE Table_Eideha SET M"+i+"='"+Meyarin[i]+"' where shomare_Eide="+shE);
                }

            } else {

                mydb.execSQL("INSERT INTO Table_Eideha (shomare_Eide) VALUES ('" + shE + "')");
                for (int i=1;i<tedadMeyarin;i++) {
                    if (Meyarin[i]==null||Meyarin[i]=="null")
                    {
                        Meyarin[i]="";
                    }
                    mydb.execSQL("UPDATE Table_Eideha SET M"+i+"='"+Meyarin[i]+"' where shomare_Eide="+shE);
                }
            }
            //==============================================
            Cursor allrows2= mydb.rawQuery("select * from Table_Zaribe_Meyar where shomare_Eide="+shE+"",null);
            int count2=allrows2.getCount();
            if (count2!=0) {
                for (int i=1;i<tedadMeyarin;i++) {
                    if (Zarib_Meyarin[i]==null||Zarib_Meyarin[i]=="null")
                    {
                        Zarib_Meyarin[i]="";
                    }
                    mydb.execSQL("UPDATE Table_Zaribe_Meyar SET M"+i+"='"+Zarib_Meyarin[i]+"' where shomare_Eide="+shE);
                }

            } else {

                mydb.execSQL("INSERT INTO Table_Zaribe_Meyar (shomare_Eide) VALUES ('" + shE + "')");
                for (int i=1;i<tedadMeyarin+1;i++) {
                    if (Zarib_Meyarin[i]==null||Zarib_Meyarin[i]=="null")
                    {
                        Zarib_Meyarin[i]="";
                    }
                    mydb.execSQL("UPDATE Table_Zaribe_Meyar SET M"+i+"='"+Zarib_Meyarin[i]+"' where shomare_Eide="+shE);
                }

            }
            //==============================================
            float sum=0;

            for (int i=1;i<tedadMeyarin;i++)
            {
                Log.d(" ", "ddddd    in    :" + Zarib_Meyarin[i]);

                if (Zarib_Meyarin[i]==null||Zarib_Meyarin[i]=="null"||Zarib_Meyarin[i]==""||Zarib_Meyarin[i].equalsIgnoreCase(""))
                {

                }
                else {
                    Log.d(" ", "ddddd    qa    3:" + Zarib_Meyarin[i]);

                    sum = sum + Float.parseFloat(Zarib_Meyarin[i]);
                    Log.d(" ", "ddddd    q:" + sum);
                }
            }
            Cursor allrows3= mydb.rawQuery("select * from Table_Olaviate_Eideha where shomare_Eide="+shE+"",null);
            int count3=allrows3.getCount();
            if (count3!=0) {

                mydb.execSQL("UPDATE Table_Olaviate_Eideha SET Emtiaz='"+sum+"' where shomare_Eide="+shE);

            } else {
                mydb.execSQL("INSERT INTO Table_Olaviate_Eideha (shomare_Eide) VALUES ('" + shE + "')");
                mydb.execSQL("UPDATE Table_Olaviate_Eideha SET Emtiaz='"+sum+"' where shomare_Eide="+shE);
            }
            mydb.close();
               Toast.makeText(getApplicationContext(), "ایده با موفقیت ثبت گردید", Toast.LENGTH_LONG).show();
                finish();
        }catch(Exception e){
               Toast.makeText(getApplicationContext(), "Error in MegdardehiAvvalehJadvalBazi function", Toast.LENGTH_LONG).show();
       }

    }
    //===================================
    private String AkarinShomareEide(String data_base) {

        String out="1000";
        SQLiteDatabase mydb = openOrCreateDatabase(data_base, Context.MODE_PRIVATE,null);
        Cursor allrows  = mydb.rawQuery("SELECT MAX(shomare_Eide) FROM Table_Eideha ", null);
        int count=allrows.getCount();

        Log.d("","ddddd   7:"+out);

        try{
            int i = 0;
            Log.d("","ddddd   8:"+count);

            if (count==0) {
                Toast.makeText(getBaseContext()," موردی برای نمایش وجود ندارد", Toast.LENGTH_SHORT).show();
                //		چک کردن وارد نکردن یک تیم به صورت تکراری
            } else {
                if (allrows.moveToFirst()) {
                    do {

                        out = allrows.getString(0);
                        Log.d("", "ddddd   9:" + out);

                    }
                    while (allrows.moveToNext());
                }
            }
            mydb.close();
        }catch(Exception e){
            Toast.makeText(getApplicationContext(), "موردی برای نمایش موجود نیست", Toast.LENGTH_SHORT).show();
        }
        if (out==null)
        {
            out="1000";
        }
        Log.d("", "ddddd   10 :" + out);

        return out;
    }


    //==============================
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.jam_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_back_jam:
                finish();
                onBackPressed();
                break;

        }
        return true;
    }


}
