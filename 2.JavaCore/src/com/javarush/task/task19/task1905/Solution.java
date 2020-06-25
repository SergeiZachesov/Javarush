package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class DataAdapter implements RowItem {

        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String countries = null;
            for (Map.Entry<String, String> entry : Solution.countries.entrySet()) {
                if (this.customer.getCountryName() == entry.getValue()) {
                    countries = entry.getKey();
                }
            }
            return countries;
        }

        @Override
        public String getCompany() {
            return this.customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {

            Pattern pattern = Pattern.compile("[a-zA-z]+$");
            Matcher matcher = pattern.matcher(this.contact.getName());
            String contactFirstName = null;
            if (matcher.find()) {
                contactFirstName = matcher.group();
            }
            return contactFirstName;
        }

        @Override
        public String getContactLastName() {
            Pattern pattern = Pattern.compile("^([A-z]+)");
            Matcher matcher = pattern.matcher(this.contact.getName());
            String contactLastName = null;
            if (matcher.find()) {
                contactLastName = matcher.group();
            }
            return contactLastName;
        }

        @Override
        public String getDialString() {
            Pattern pattern = Pattern.compile("[0-9+]");
            Matcher matcher = pattern.matcher(this.contact.getPhoneNumber());
            String phoneNumber = "callto://";
            while (matcher.find()) {
                phoneNumber = phoneNumber + matcher.group();
            }
            return phoneNumber;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}