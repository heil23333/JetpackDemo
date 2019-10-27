package com.heil.jetpackdemo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.heil.jetpackdemo.ViewModel.MyViewModel;

public class MainFragment extends Fragment {

    private TextView input;
    private MyViewModel myViewModel;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        myViewModel = ViewModelProviders.of(getActivity()).get(MyViewModel.class);

        input = getView().findViewById(R.id.input);
        input.setText(myViewModel.input);
        System.out.println("hl-----myViewModel.input=" + myViewModel.input);

//        最简单的导航方式
//        getView().findViewById(R.id.to_viewmodel).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_viewModelFragment));
        getView().findViewById(R.id.to_viewmodel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.action_mainFragment_to_viewModelFragment);
            }
        });
    }
}
