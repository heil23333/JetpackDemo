package com.heil.jetpackdemo.ViewModel;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.heil.jetpackdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewModelFragment extends Fragment {

    private MyViewModel myViewModel;
    private Button button;
    private TextView textView;
    private EditText editText;

    public ViewModelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_model, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        myViewModel = ViewModelProviders.of(getActivity()).get(MyViewModel.class);
        button = getView().findViewById(R.id.add);
        textView = getView().findViewById(R.id.textView);
        editText = getView().findViewById(R.id.editText);

        editText.setText(myViewModel.input);
        textView.setText(String.valueOf(myViewModel.i));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.i ++;
                textView.setText(String.valueOf(myViewModel.i));
            }
        });
        getView().findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.input = editText.getText().toString();
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.action_viewModelFragment_to_mainFragment);
            }
        });
    }
}
