package com.blaxsoftware.androidtests;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author fpalonso
 */
public class GreetingActivity extends Activity implements View.OnClickListener {

    private EditText mUserNameEditText;
    private TextView mGreetingView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);
        mUserNameEditText = (EditText) findViewById(R.id.username);
        mGreetingView = (TextView) findViewById(R.id.greeting);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.greet:
                mGreetingView.setText("Hey " + mUserNameEditText.getText().toString()
                        + ", what's up");
                break;
        }
    }
}
