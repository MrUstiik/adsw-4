package com;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EMailList extends AbstractListDecorator<String>{
    private final String eMailPattern = "\\S+@\\w+\\.[a-z]{2,}";
    private Pattern pattern = Pattern.compile(eMailPattern);
    private Matcher matcher;

    public EMailList(List<String> list) {
        super(list);
    }

    @Override
    public boolean add(String eMail) {
        matcher = pattern.matcher(eMail);
        try {
            if (matcher.matches()) {
                list.add(eMail);
                return true;
            }
            return false;
        }finally {
            matcher = null;
        }
    }

    public static void main(String[] args) {
        EMailList list = new EMailList(new ArrayList<String>());
        System.out.println(list.add("mr.ustiik@gmail.com"));
        System.out.println(list.add("as@sa"));
        System.out.println(list);
    }
}
