package com.example.a27100057_emotilog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.a27100057_emotilog.databinding.FragmentThirdBinding;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class ThirdFragment extends Fragment {

    private FragmentThirdBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentThirdBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonThird.setOnClickListener(v ->
                NavHostFragment.findNavController(ThirdFragment.this)
                        .navigate(R.id.action_ThirdFragment_to_SecondFragment)
        );

        // Mappings for emojis
        HashMap<String, String> emoticonEmoji = new HashMap<>();
        emoticonEmoji.put("Happy", "😊");
        emoticonEmoji.put("Sad", "😢");
        emoticonEmoji.put("Grateful", "🙏");
        emoticonEmoji.put("Angry", "😠");
        emoticonEmoji.put("Excited", "🤩");
        emoticonEmoji.put("Disgusted", "🤢");


        MainActivity activity = (MainActivity) requireActivity();

        HashMap<String, Integer> emoticon_counts = new HashMap<>();
        ArrayList<Emotion> filtered_list = new ArrayList<>();
        LocalDate today = LocalDate.now();

        for (int i = 0; i < activity.dataList.size(); i++)
        {
            Emotion e = activity.dataList.get(i);
            if (e.getDate().equals(today))
            {
                filtered_list.add(e);
            }
        }

        // Counts
        for (int i = 0; i < filtered_list.size(); i++)
        {
            Emotion e = filtered_list.get(i);

            if (!emoticon_counts.containsKey(e.getEmoticon()))
            {
                emoticon_counts.put(e.getEmoticon(), 1);
            }
            else
            {
                int count = emoticon_counts.get(e.getEmoticon());
                count++;
                emoticon_counts.put(e.getEmoticon(), count);
            }
        }


        StringBuilder builder = new StringBuilder();

        for (String emoticon : emoticon_counts.keySet())
        {

            int count = emoticon_counts.get(emoticon);

            String emoji = emoticonEmoji.get(emoticon);
            if (emoji == null)
            {
                emoji = "";   // safety fallback
            }

            builder.append(String.format("%-2s %-10s %3d\n", emoji, emoticon, count));
        }
        binding.emoticonCounts.setText(builder.toString());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
