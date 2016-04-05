package com.livechatinc.inappchatexample;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.livechatinc.inappchat.ChatWindowFragment;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ExampleFragmentActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_example);

        if (savedInstanceState == null) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout, new MapFragment(), "map_fragment")
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_fragment_example, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.chat_with_us) {
            if (getFragmentManager().findFragmentByTag("chat_fragment") == null) {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_layout, ChatWindowFragment.newInstance("7325621", "0", "client", "client@example.com"), "chat_fragment")
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
