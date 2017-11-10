package fr.android.androidexercises;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Step1Fragment extends Fragment {
    private static final String step1 = "This is step 1";

    private TextView textView;
    private Step0Fragment.OnNextStep0Listener listener;
    private String data = "";

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Step0Fragment.OnNextStep0Listener) {
            listener = (Step0Fragment.OnNextStep0Listener) context;
        } else {
            throw new RuntimeException("Trompé de listener bobby !");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_step1, container, false);
        textView = view.findViewById(R.id.step1TextView);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView.setText(step1 + "  data : " + data);
    }
}
