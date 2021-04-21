/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Random;

/**
 *
 * @author Hide
 */
public class Common {
    // chuyển từ kiểu float định dạnh tiền việt
      public static String formatNumber(float number) {
        if(number < 1000) {
            return String.valueOf(number);
        }
        try {
            NumberFormat formatter = new DecimalFormat("###,###");
            String resp = formatter.format(number);
            resp = resp.replaceAll(",", ".");
            return resp;
        } catch (Exception e) {
            return "";
        }
    }
      /**
       * chuyển từ chuỗi có định dạng tiền ex: 1.000.000 sang float -> 1000000
       * @param price
       * @return 
       */
  
      public static String fomatMonney(float price){
          Locale locale = new Locale("vi", "VN");
            Currency currency = Currency.getInstance("VND");
 
            DecimalFormatSymbols df = DecimalFormatSymbols.getInstance(locale);
            df.setCurrency(currency);
            NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
            numberFormat.setCurrency(currency);
              return numberFormat.format(price);
      }
      public static float convertToFloat(String number){
          float result = 0; 
          
          return Float.parseFloat(number.replaceAll("[.]", ""));
      }
    
     public static int runDom(){
         return new Random().nextInt(9999-1000)+1000;
     }
}
