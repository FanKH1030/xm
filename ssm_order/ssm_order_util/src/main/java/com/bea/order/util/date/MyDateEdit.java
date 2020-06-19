package com.bea.order.util.date;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by fandi on 2020/5/16 0016.
 */
public class MyDateEdit  extends PropertyEditorSupport {
    private String patt;

    public MyDateEdit(String patt) {
        this.patt = patt;
    }

    @Override
    public void setAsText(String text)  {
        Date date = null;
        try {
            date = DateUtil.string2Date(text,patt);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.setValue(date);
    }
}
