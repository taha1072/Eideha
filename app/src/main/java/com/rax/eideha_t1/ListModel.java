package com.rax.eideha_t1;


public class ListModel {

	private  String radif;
	private  String meyar;
	private  String tarifmeyar;
	private  String mizan;
	//===================
	private  String eideh;


	/*********** Set Methods ******************/


	public void setRadif(String radif )
	{
		this.radif =radif ;
	}
	public void setMeyar(String meyar)
	{
		this.meyar = meyar;
	}
	public void setTarifmeyar(String tarifmeyar)
	{
		this.tarifmeyar = tarifmeyar;
	}
	public void setMizan(String mizan)
	{
		this.mizan = mizan;
	}
//============================================
public void setEideh(String eideh)
{
	this.eideh = eideh;
}


	//=====================================
	//				Jamha

	//========================================

	/*********** Get Methods ****************/


	public String getRadif()
	{
		return this.radif  ;
	}
	public String getMeyar()
	{
		return this.meyar ;
	}
	public String getTarifmeyar()
	{
		return this.tarifmeyar ;
	}
	public String getMizan()
	{
		return this.mizan ;
	}
	public String getEideh()
	{
		return this.eideh ;
	}

	//=====================================
	//				Jamha

	//========================================
}
