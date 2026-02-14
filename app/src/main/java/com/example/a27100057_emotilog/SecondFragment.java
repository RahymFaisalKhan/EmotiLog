package com.example.a27100057_emotilog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.a27100057_emotilog.databinding.FragmentSecondBinding;

import java.time.LocalDate;
import java.util.ArrayList;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(v ->
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment)
        );

        // Go to Summary (ThirdFragment)
        binding.buttonNext.setOnClickListener(v ->
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_ThirdFragment)
        );

        MainActivity activity = (MainActivity) requireActivity();

        ArrayList<Emotion> filtered_list = new ArrayList<>();
        LocalDate today = LocalDate.now();

        // Filter
        for (int i = 0; i < activity.dataList.size(); i++)
        {
            Emotion e = activity.dataList.get(i);
            if (e.getDate().equals(today))
            {
                filtered_list.add(e);
            }
        }

        // Display
        ArrayAdapter<Emotion> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, filtered_list);

        binding.emoticonList.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

