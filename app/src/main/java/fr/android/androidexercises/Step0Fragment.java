package fr.android.androidexercises;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Step0Fragment extends Fragment {

    private static final String step0 = "This is step 0";

    private TextView textView;
    private OnNextStep0Listener listener;
    private String dataBack = "";

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnNextStep0Listener) {
            listener = (OnNextStep0Listener) context;
        } else {
            throw new RuntimeException("Trompé de listener bobby !");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_step0, container, false);
        textView = view.findViewById(R.id.textView);

        Button nextButton = view.findViewById(R.id.nextButton);
        final EditText editText = view.findViewById(R.id.editText);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataBack = listener.onNext(editText.getText().toString());
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView.setText(step0 + "   retour : " + dataBack);
    }

    public interface OnNextStep0Listener {
        String onNext(String data);
    }
}
