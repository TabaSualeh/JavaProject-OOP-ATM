package ATM;

import java.util.HashMap;

public class Customer {
	HashMap<Integer,account_info> info = new HashMap<>();
	Customer(){
	    info.put(13939,new account_info("Uzair Mohiuddin",13939,1996,70000));
		info.put(13440,new account_info("Tanzeela Jabbar",13440,1999,40000));
		info.put(13436,new account_info("Muhammad Abdullah Khan",13436,2000,15000));
		info.put(13389, new account_info("Muhammad Taba Sualeh",13389,2001,30000));
	    info.put(14095,new account_info("Muskan Hasan",14095,2002,50000));
	}
	public HashMap getinfo() {
		return info;
	} 
}
