package com.example.farzanaakhtar.libraria;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View.OnClickListener;

import java.util.ArrayList;

import utils.arrays;

public class Engineering extends Fragment {

    LinearLayout body;
    ArrayList<TextView> toBeIssued = new ArrayList<>();

    int count = arrays.top;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.engineering, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FloatingActionButton fab = view.findViewById(R.id.engg_issue);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                for (TextView aBook: toBeIssued)
                {
                    arrays.push(aBook);
                }
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show(); // update this
            }
        });

        body = view.findViewById(R.id.engg_books);
        body.removeAllViews();

        for (String aBook: arrays.engg)
        {
            final TextView book = new TextView(getActivity());
            book.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            book.setTextColor(Color.rgb(0,0,0));
            book.setPadding(10, 10, 10, 10);
            book.setText(aBook);

            book.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (count < 9)
                    {
                        if (book.getCurrentTextColor() == Catalouge.defaultTextColor)
                        {
                            book.setTextColor(Catalouge.defaultBackColor);
                            book.setBackgroundColor(Catalouge.selectColor);
                            toBeIssued.add(book);
                            count++;
                        }
                        else
                        {
                            book.setTextColor(Catalouge.defaultTextColor);
                            book.setBackgroundColor(Catalouge.defaultBackColor);
                            count--;
                            toBeIssued.remove(book);
                        }
                    }
                    else Snackbar.make(view, "You can't issue more than 9 books\n\n", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
            body.addView(book);
        }
        TextView t = new TextView(getActivity());
        t.setText("\n\n\n");
        body.addView(t);
    }
}
