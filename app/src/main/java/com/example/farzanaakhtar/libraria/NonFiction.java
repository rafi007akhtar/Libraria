package com.example.farzanaakhtar.libraria;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import utils.arrays;

public class NonFiction extends Fragment{

    LinearLayout body;
    TextView Book[];
    int count = arrays.top;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.non_fiction, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        body = view.findViewById(R.id.nonF);
        body.removeAllViews();

        Book = new TextView[arrays.non_fiction.length];
        int i = 0;

        for (String aBook: arrays.non_fiction)
        {
            final TextView book = new TextView(getActivity());
            book.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            book.setTextColor(Color.rgb(0,0,0));
            book.setPadding(10, 10, 10, 10);
            book.setText(aBook);

            book.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (count < 9)
                    {
                        if (book.getCurrentTextColor() == Catalouge.defaultTextColor)
                        {
                            book.setTextColor(Catalouge.defaultBackColor);
                            book.setBackgroundColor(Catalouge.selectColor);
                            count++;
                        }
                        else
                        {
                            book.setTextColor(Catalouge.defaultTextColor);
                            book.setBackgroundColor(Catalouge.defaultBackColor);
                            count--;
                        }
                    }
                }
            });
            body.addView(book);

            Book[i++] = book;
        }
        TextView t = new TextView(getActivity());
        t.setText("\n\n\n");
        body.addView(t);
    }
}
