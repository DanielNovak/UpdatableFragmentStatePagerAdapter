package eu.inloop.pager.sample;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final TestPagerAdapter adapter = new TestPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        findViewById(R.id.btn_shuffle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.toggleState();
            }
        });
    }

    public static class TestPagerAdapter extends FragmentStatePagerAdapter {
        private boolean mState = true;

        public TestPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public int getCount() {
            return 3;
        }

        private void toggleState() {
            mState = !mState;
            notifyDataSetChanged();
        }

        @Override
        public int getItemPosition(Object object) {
            String label = ((PageFragment) object).getLabel();
            if (label.equals("A")) {
                return 0;
            } else if (label.equals("B")) {
                return mState ? 1 : 2;
            } else {
                return mState ? 2 : 1;
            }
        }

        @Override
        public Fragment getItem(int position) {
            String label;
            switch (position) {
                case 0:
                    label = "A";
                    break;
                case 1:
                    label = mState ? "B" : "C";
                    break;
                default:
                    label = mState ? "C" : "B";
                    break;
            }

            return PageFragment.newInstance(label);
        }
    }
}
