package com.example.a27100057_emotilog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.a27100057_emotilog.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;


    private Button happy_button;

    private Button sad_button;

    private Button gratefule_button;

    private Button angry_button;

    private Button excited_button;

    private Button disgusted_button;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(v ->
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment)
        );

        Button happy_button = view.findViewById(R.id.happy_button);
        Button sad_button = view.findViewById(R.id.sad_button);
        Button grateful_button = view.findViewById(R.id.grateful_button);
        Button angry_button = view.findViewById(R.id.angry_button);
        Button excited_button = view.findViewById(R.id.excited_button);
        Button disgusted_button = view.findViewById(R.id.disgusted_button);

        happy_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view)
            {
                ADDEMOTICON(view, "Happy");
            }
        });

        sad_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view)
            {
                ADDEMOTICON(view, "Sad");
            }
        });

        grateful_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view)
            {
                ADDEMOTICON(view, "Grateful");
            }
        });

        angry_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view)
            {
                ADDEMOTICON(view, "Angry");
            }
        });

        excited_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view)
            {
                ADDEMOTICON(view, "Excited");
            }
        });

        disgusted_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view)
            {
                ADDEMOTICON(view, "Disgusted");
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    private void ADDEMOTICON(View view, String Emoticon)
    {
        Emotion new_emoticon = new Emotion(Emoticon);

        MainActivity activity = (MainActivity) requireActivity();

        activity.dataList.add(new_emoticon);
//        activity.emoticonAdaptor.notifyDataSetChanged();
    }
}