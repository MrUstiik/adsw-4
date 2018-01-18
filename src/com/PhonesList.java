package com;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhonesList extends AbstractListDecorator<String>{
    private final String eMailPattern = "\\+380\\d{9}";
    private Pattern pattern = Pattern.compile(eMailPattern);
    private Matcher matcher;

    public PhonesList(List<String> list) {
        super(list);
    }

    @Override
    public boolean add(String phoneNumber) {
        matcher = pattern.matcher(phoneNumber);
        try{
            if (matcher.matches()) {
                list.add(phoneNumber);
                return true;
            }
            return false;
        }finally{
           matcher = null;
        }
    }

    public static void main(String[] args) {
        PhonesList phonesList = new PhonesList(new ArrayList<String>());
        System.out.println(phonesList.add("+380663150283"));
        System.out.println(phonesList.add("4445525"));
        System.out.println(phonesList);
    }
}
