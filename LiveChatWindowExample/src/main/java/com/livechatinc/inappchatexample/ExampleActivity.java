package com.livechatinc.inappchatexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.livechatinc.inappchat.ChatWindowActivity;

public class ExampleActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

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
            Intent intent = new Intent(this, ChatWindowActivity.class);
            intent.putExtra(ChatWindowActivity.KEY_GROUP_ID, "0");
            intent.putExtra(ChatWindowActivity.KEY_LICENCE_NUMBER, "7325621");
            intent.putExtra(ChatWindowActivity.KEY_VISITOR_NAME, "Client");
            intent.putExtra(ChatWindowActivity.KEY_VISITOR_EMAIL, "client@example.com");
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
