package com.example.a27100057_emotilog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.a27100057_emotilog.databinding.FragmentSecondBinding;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Iterator;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    private HashMap<String, Integer> emoticon_counts;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(v ->
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment)
        );

        MainActivity activity = (MainActivity) requireActivity();

        ListView listView = view.findViewById(R.id.emoticon_List);

        HashMap <String, Integer> emoticon_counts = new HashMap();

        ArrayList <Emotion> filtered_list = new ArrayList<>();
        LocalDate today = LocalDate.now();

        for (int i = 0; i < activity.dataList.size(); i++) {
            Emotion e = activity.dataList.get(i);
            if (e.getDate().equals(today)) {
                filtered_list.add(e);
            }
        }

        for (int i = 0; i < filtered_list.size(); i++) {
            Emotion e = filtered_list.get(i);
            if (!emoticon_counts.containsKey(e.getEmoticon())) {
                emoticon_counts.put(e.getEmoticon(), 1);
            }
            else {
                Integer additive = (Integer) emoticon_counts.get(e.getEmoticon());
                additive++;
                emoticon_counts.put(e.getEmoticon(), additive);
            }
        }

        TextView emoticon_counts_text = view.findViewById(R.id.emoticon_counts);
        StringBuilder builder = new StringBuilder();

        Iterator<String> iterator = emoticon_counts.keySet().iterator();

        while (iterator.hasNext()) {
            String emoticon = iterator.next();
            int count = emoticon_counts.get(emoticon);

            builder.append(emoticon)
                    .append(" : ")
                    .append(count)
                    .append("\n");
        }
        emoticon_counts_text.setText(builder.toString());

        ArrayAdapter<Emotion> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, filtered_list);
        listView.setAdapter(adapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}