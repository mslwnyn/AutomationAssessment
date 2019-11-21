package za.co.ilab.tshimx.utils;

import java.util.Random;

/**
 *
 * @author Tshimologo
 */
public class PhoneNumberGenerator {
    
    public static String phoneNumber="";
  
    public static String getPhoneNumber(){
      
        int num1 =0;
        int num2, num3; //3 numbers in area code
        int set2, set3; //sequence 2 and 3 of the phone number
        
        Random generator = new Random();
        num2 = getRandomNumberInRange(6,8); 
        num3 = getRandomNumberInRange(1,7);
        set2 = getRandomNumberInRange(100,999);
        set3 = getRandomNumberInRange(1000,9999);
        return ""+num1+"" + num2 + "" + num3 +  " " + set2 + " " + set3 ;
    }
  
    private static int getRandomNumberInRange(int min, int max) {

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}


    

