package uz.pdp.fragmentjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import uz.pdp.fragmentjava.fragments.FirstFragment;
import uz.pdp.fragmentjava.fragments.SecondFragment;
import uz.pdp.fragmentjava.model.User;

public class MainActivity extends AppCompatActivity implements FirstFragment.FirstListener, SecondFragment.SecondListener {
    FirstFragment firstFragment;
    SecondFragment secondFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_first, firstFragment)
                .commit();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_second, secondFragment)
                .commit();
    }

    @Override
    public void onFirstSend(User s) {
        secondFragment.updateFirstText(s);
    }

    @Override
    public void onSecondSend(User s) {
        firstFragment.updateFirstText(s);
    }
}