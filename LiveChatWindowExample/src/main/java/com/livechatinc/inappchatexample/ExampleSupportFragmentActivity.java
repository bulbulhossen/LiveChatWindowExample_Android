package com.livechatinc.inappchatexample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.livechatinc.inappchat.ChatWindowSupportFragment;

public class ExampleSupportFragmentActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_example);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout, new MapFragment(), "map_fragment")
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_example, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.chat_with_us) {
            if (getSupportFragmentManager().findFragmentByTag("chat_fragment") == null) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_layout, ChatWindowSupportFragment.newInstance("7325621", "0", "client", "client@example.com"), "chat_fragment")
                        .addToBackStack("chat_fragment")
                        .commit();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static class MapFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return layoutInflater.inflate(R.layout.activity_example, container, false);
        }
    }
}
