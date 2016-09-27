package com.taberu.todolist;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by Taberu on 23/09/2016.
 */

public class NewItemFragment extends Fragment {
    private OnNewItemAddedListener onNewItemAddedListener;

    // A container activity que implementa este método interface:
    public interface OnNewItemAddedListener {
        void onNewItemAdded(String newItem);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            onNewItemAddedListener = (OnNewItemAddedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "deve implementar listener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.new_item_fragment, container, false);
        final EditText et1 = (EditText)view.findViewById(R.id.et1);
        et1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == event.ACTION_DOWN)
                    if (keyCode == event.KEYCODE_ENTER) {
                        String newItem = et1.getText().toString();
                        onNewItemAddedListener.onNewItemAdded(newItem);
                        et1.setText("");
                        return true;
                    }
                return false;
            }
        });
        return view;
    }
}
