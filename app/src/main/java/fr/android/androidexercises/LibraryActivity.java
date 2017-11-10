package fr.android.androidexercises;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class LibraryActivity extends AppCompatActivity implements Step0Fragment.OnNextStep0Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerFrameLayout, new Step0Fragment(), Step0Fragment.class.getSimpleName())
                .commit();
    }

    @Override
    public String onNext(String data) {
        Step1Fragment fragment = new Step1Fragment();
        fragment.setData(data);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerFrameLayout, fragment, Step1Fragment.class.getSimpleName())
                .addToBackStack(Step1Fragment.class.getSimpleName())
                .commit();

        return fragment.getData().toUpperCase();
    }

}
