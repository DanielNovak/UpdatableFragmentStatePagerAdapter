package eu.inloop.support.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import eu.inloop.support.sample.adapter.IncorrectFragmentAdapter;

public class IncorrectMainActivity extends AppCompatActivity {

    private IncorrectFragmentAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        mSectionsPagerAdapter = new IncorrectFragmentAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        ((Button)findViewById(R.id.test_start_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSectionsPagerAdapter.toggleState();
            }
        });

        ((Button)findViewById(R.id.switch_tests_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IncorrectMainActivity.this, FixedMainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                IncorrectMainActivity.this.startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

}