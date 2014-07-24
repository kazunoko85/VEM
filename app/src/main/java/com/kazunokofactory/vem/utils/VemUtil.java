package com.kazunokofactory.vem.utils;

import android.view.View;
import android.widget.TextView;

import com.kazunokofactory.vem.annotation.VemTextView;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by kazunoko on 2014/07/24.
 */
public class VemUtil {

    public VemUtil() {
    }

    private Object entity;

    private View view;

    private Class rid;

    public void mappingView(Object entity, View view, Class rid) {
        if (entity == null) return;
        if (view == null) return;
        if (rid == null) return;
        mappingTextView(entity, view, rid);

    }

    private void mappingTextView(Object entity, View view, Class rid) {
        Class clazz = entity.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);

                setTextToTextView(getTextView(field, view, rid), String.valueOf(field.get(entity)));

                field.setAccessible(false);
            } catch (Exception e) { // nice catch!
            }
        }
    }


    private void setTextToTextView(TextView text, String value) {
        if (text == null || value == null) return;
        text.setText(value);
    }

    private TextView getTextView(Field field, View view, Class rid) throws NoSuchFieldException, IllegalAccessException {

        if(field == null || view == null || rid == null) return null;
        Annotation annotation = field.getAnnotation(VemTextView.class);
        if (annotation == null) return null;

        //アノテーションの設定値を取得
        String s = ((VemTextView) annotation).value();

        //アノテーションの設定値なし = フィールド名をもとにTextViewを取得する
        if ("".equals(s)) s = field.getName();

        //対象のTextView取得
        return (TextView) view.findViewById((((Integer) rid.getField(s).get(null))).intValue());
    }
}

