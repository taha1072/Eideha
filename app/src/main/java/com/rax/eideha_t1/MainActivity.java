package com.rax.eideha_t1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String DATABASE_NAME="database_Eideha.db";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            CreateTable_Eideha();
            CreateTable_Jadval_Meyar();
            CreateTable_Zaribe_Meyar();
            CreateTable_Olavite_Eideha();
            Afzodane_Meyarhai_Avalie();
            Toast.makeText(getApplicationContext(), "دیتا بیس با موفقیت ایجاد گردید", Toast.LENGTH_SHORT).show();
            finish();
        }catch(Exception e){
            Toast.makeText(getApplicationContext(), "خطا در ساخت دیتا بیس", Toast.LENGTH_SHORT).show();
        }    }
    //==============================
    private void CreateTable_Eideha()
    {
        //تابع ساخت یک دیتا بیس
        try{
            SQLiteDatabase mydb=openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE,null);
            mydb.execSQL("CREATE TABLE IF  NOT EXISTS Table_Eideha(  shomare_Eide integer NOT NULL PRIMARY KEY, M1  text, M2  text, M3  text, M4  text, M5  text, M6  text, M7  text, M8  text, M9  text, M10  text, M11  text, M12  text, M13  text, M14  text, M15  text, M16  text, M17  text, M18  text, M19  text, M20  text );");
            mydb.close();
        }catch(Exception e){
            	Toast.makeText(getApplicationContext(), "Error in creating Teams table", Toast.LENGTH_SHORT).show();
        }

    }
    //==============================
    private void CreateTable_Zaribe_Meyar()
    {
        //تابع ساخت یک دیتا بیس
        try{
            SQLiteDatabase mydb=openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE,null);
            mydb.execSQL("CREATE TABLE IF  NOT EXISTS Table_Zaribe_Meyar(  shomare_Eide integer NOT NULL PRIMARY KEY, M1  float(50), M2  float(50), M3  float(50), M4  float(50), M5  float(50), M6  float(50), M7  float(50), M8  float(50), M9  float(50), M10  float(50), M11  float(50), M12  float(50), M13  float(50), M14  float(50), M15  float(50), M16  float(50), M17  float(50), M18  float(50), M19  float(50), M20  float(50) );");
            mydb.close();
        }catch(Exception e){
            Toast.makeText(getApplicationContext(), "Error in creating Teams table", Toast.LENGTH_SHORT).show();
        }

    }
    //==============================
    private void CreateTable_Olavite_Eideha()
    {
        //تابع ساخت یک دیتا بیس
        try{
            SQLiteDatabase mydb=openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE,null);
            mydb.execSQL("CREATE TABLE IF  NOT EXISTS Table_Olaviate_Eideha(  shomare_Eide integer NOT NULL PRIMARY KEY, Emtiaz  float(50), Vaziat_Faal text , Vaziat_Tavaggof text, Vaziat_Movaffagiat text, Vaziat_Ejra text, Vaziat_Vagozari text );");
            mydb.close();
        }catch(Exception e){
            Toast.makeText(getApplicationContext(), "Error in creating Teams table", Toast.LENGTH_SHORT).show();
        }

    }
    //==============================
    private void CreateTable_Jadval_Meyar()
    {
        //تابع ساخت یک دیتا بیس
        try{
            SQLiteDatabase mydb=openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE,null);
            mydb.execSQL("CREATE TABLE IF  NOT EXISTS Table_Jadval_Meyar(  Id_Meyar integer NOT NULL PRIMARY KEY, Meyar  text );");
            mydb.close();
        }catch(Exception e){
            Toast.makeText(getApplicationContext(), "Error in creating Teams table", Toast.LENGTH_SHORT).show();
        }

    }
    //==============================
    //====================================
    private void Afzodane_Meyarhai_Avalie()
    {
        //      تابع گرفتن نام تیم و اضافه کردن آن به جدول تیمها
        try{
            SQLiteDatabase mydb = openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE,null);
                //		ذخیره تیم جدید
            mydb.execSQL("INSERT INTO Table_Jadval_Meyar (Id_Meyar,Meyar) VALUES ('1','توضیح ایده')");
            mydb.execSQL("INSERT INTO Table_Jadval_Meyar (Id_Meyar,Meyar) VALUES ('2','موضوع ایده')");
            mydb.execSQL("INSERT INTO Table_Jadval_Meyar (Id_Meyar,Meyar) VALUES ('3','قشر درگیر')");
            mydb.execSQL("INSERT INTO Table_Jadval_Meyar (Id_Meyar,Meyar) VALUES ('4','درصد احتمال شکست')");
            mydb.execSQL("INSERT INTO Table_Jadval_Meyar (Id_Meyar,Meyar) VALUES ('5','نفرات مورد نیاز ساخت')");
            mydb.execSQL("INSERT INTO Table_Jadval_Meyar (Id_Meyar,Meyar) VALUES ('6','درصد اهمیت برای خودم')");
            mydb.execSQL("INSERT INTO Table_Jadval_Meyar (Id_Meyar,Meyar) VALUES ('7','درصد اهمیت برای قشر درگیر')");
            mydb.execSQL("INSERT INTO Table_Jadval_Meyar (Id_Meyar,Meyar) VALUES ('8','درصد زمان لازم برای اجرای اولیه')");
            mydb.execSQL("INSERT INTO Table_Jadval_Meyar (Id_Meyar,Meyar) VALUES ('9','درصد هزینه لازم برای اجرای اولیه')");
            mydb.execSQL("INSERT INTO Table_Jadval_Meyar (Id_Meyar,Meyar) VALUES ('10','درصد کمبود بوجه')");
            mydb.execSQL("INSERT INTO Table_Jadval_Meyar (Id_Meyar,Meyar) VALUES ('11','درصد سودمندی برای خودم')");
            mydb.execSQL("INSERT INTO Table_Jadval_Meyar (Id_Meyar,Meyar) VALUES ('12','درصد سودمندی برای خانواده')");
            mydb.execSQL("INSERT INTO Table_Jadval_Meyar (Id_Meyar,Meyar) VALUES ('13','درصد سودمندی برای تمام آشنایان')");
            mydb.execSQL("INSERT INTO Table_Jadval_Meyar (Id_Meyar,Meyar) VALUES ('14','درصد سودمندی برای همشهریان')");
            mydb.execSQL("INSERT INTO Table_Jadval_Meyar (Id_Meyar,Meyar) VALUES ('15','درصد سودمندی برای کشور')");
            mydb.execSQL("INSERT INTO Table_Jadval_Meyar (Id_Meyar,Meyar) VALUES ('16','درصد سودمندی برای تمام انسانها')");
            mydb.execSQL("INSERT INTO Table_Jadval_Meyar (Id_Meyar,Meyar) VALUES ('17','درصد میزان یونیک بودن')");
            mydb.execSQL("INSERT INTO Table_Jadval_Meyar (Id_Meyar,Meyar) VALUES ('18','درصد اهمیت مخفی بودن تا اجرا')");
            mydb.execSQL("INSERT INTO Table_Jadval_Meyar (Id_Meyar,Meyar) VALUES ('19','درصد میزان نیاز به سرمایه گذاری خارجی')");
            mydb.execSQL("INSERT INTO Table_Jadval_Meyar (Id_Meyar,Meyar) VALUES ('20','درصد میزان مشکلات دریافت مجوز')");

            //		Toast.makeText(getBaseContext(),teamName+" با موفقیت اضافه شد ", Toast.LENGTH_SHORT).show();

            mydb.close();
        }catch(Exception e){
            Toast.makeText(getApplicationContext(), "Error in atttotable function", Toast.LENGTH_LONG).show();
        }
    }

}
