package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Customer, Contact {

        private IncomeData data;

        IncomeDataAdapter(IncomeData incomeData) {
            this.data = incomeData;
        }

        public String getCompanyName() {
            return this.data.getCompany();
        }

        @Override
        public String getCountryName() {
            String countries = Solution.countries.get(this.data.getCountryCode());
            return countries;
        }

        @Override
        public String getName() {
            String name = this.data.getContactLastName() + ", " + this.data.getContactFirstName();
            return name;
        }

        @Override
        public String getPhoneNumber() {
            //Pattern pattern = Pattern.compile("^([\\d]{0,3})([\\d]{3})([\\d]{2})([\\d]{2})$");
            //Matcher matcher = pattern.matcher(String.valueOf(this.data.getPhoneNumber()));
            //String number = null;
            //if (matcher.find()) {
            //    number = String.format("%+d%s%03d%s%s%s%s%s%s", this.data.getCountryPhoneCode(), "(", Integer.parseInt(matcher.group(1)), ")", matcher.group(2), "-", matcher.group(3), "-", matcher.group(4));
            //}
            //return number;

            String s = String.format("%010d", data.getPhoneNumber());
            return "+" + data.getCountryPhoneCode() + "(" + s.substring(0, 3) + ")" + s.substring(3,6) + "-" + s.substring(6,8) + "-" + s.substring(8,10);
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}