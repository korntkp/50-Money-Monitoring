package io.github.shredktp.a50moneymonitoring.main;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import io.github.shredktp.a50moneymonitoring.R;

import static io.github.shredktp.a50moneymonitoring.R.id.contentFrame;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        ActionBar ab = getSupportActionBar();


        MainFragment mainFragment =
                (MainFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);

        if (mainFragment == null) {
            mainFragment = MainFragment.newInstance();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(contentFrame, mainFragment);
            transaction.commit();
        }

        new MainPresenter(mainFragment);
    }
}
