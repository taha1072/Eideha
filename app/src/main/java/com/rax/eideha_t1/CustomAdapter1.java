package com.rax.eideha_t1;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/********* Adapter class extends with BaseAdapter and implements with OnClickListener ************/
public class CustomAdapter1 extends BaseAdapter   implements OnClickListener {

	/*********** Declare Used Variables *********/
    private Activity activity;
    private ArrayList data;
    private static LayoutInflater inflater=null;
    public Resources res;
    ListModel tempValues=null;
    int i=0;

    /*************  CustomAdapter Constructor *****************/
    public CustomAdapter1(Activity a, ArrayList d, Resources resLocal) {
    	
    	/********** Take passed values **********/
        activity = a;
        data=d;
        res = resLocal;
        
        /***********  Layout inflator to call external xml layout () **********************/
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
    }

    /******** What is the size of Passed Arraylist Size ************/
    public int getCount() {
    	
    	if(data.size()<=0)
    		return 1;
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }
    
    /********* Create a holder to contain inflated xml file elements ***********/
    public static class ViewHolder{

        public TextView textradif;
        public TextView textmeyar;
        public TextView texttarifmeyar;
        public TextView textzarib;
    }

    /*********** Depends upon data size called for each row , Create each ListView row ***********/
    public View getView(int position, View convertView, ViewGroup parent) {
    	
        View vi=convertView;
        ViewHolder holder;
        
        if(convertView==null){ 
        	
        	/********** Inflate tabitem.xml file for each row ( Defined below ) ************/
            vi = inflater.inflate(R.layout.tab_sabt_eide, null);
            
            /******** View Holder Object to contain tabitem.xml file elements ************/
            holder=new ViewHolder();
            holder.textradif=(TextView)vi.findViewById(R.id.textView_radif);
            holder.textmeyar=(TextView)vi.findViewById(R.id.textView_meyar);
            holder.texttarifmeyar=(TextView)vi.findViewById(R.id.textView_Megdar);
            holder.textzarib=(TextView)vi.findViewById(R.id.textView_Zarib);
           /************  Set holder with LayoutInflater ************/
            vi.setTag(holder);
        }
        else  
            holder=(ViewHolder)vi.getTag();
        
        if(data.size()<=0)
        {
        	holder.textmeyar.setText("No Data");
            
        }
        else
        {
        	/***** Get each Model object from Arraylist ********/
	        tempValues=null;
	        tempValues = (ListModel) data.get(position);
	        
	        /************  Set Model values in Holder elements ***********/
	         holder.textradif.setText(tempValues.getRadif());
            holder.textmeyar.setText(tempValues.getMeyar());
            holder.texttarifmeyar.setText(tempValues.getTarifmeyar());
            holder.textzarib.setText(tempValues.getMizan());
	         /******** Set Item Click Listner for LayoutInflater for each row ***********/
	         vi.setOnClickListener(new OnItemClickListener(position));
        }
        return vi;
    }
    
    @Override
    public void onClick(View v) {
            Log.v("CustomAdapter", "=====Row button clicked");
    }
    
    /********* Called when Item click in ListView ************/
    private class OnItemClickListener  implements OnClickListener{           
        private int mPosition;
        
        OnItemClickListener(int position){
        	 mPosition = position;
        }
        
        @Override
        public void onClick(View arg0) {
            Main2Activity sct = (Main2Activity) activity;
        	sct.onItemClick(mPosition);
        }               
    }   
}