package haruurara.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class RoundStartActivity extends AppCompatActivity {

    Globals globals;
    TextView mTimerText;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_start);
        globals = (Globals)this.getApplication();

        int BrainTime = globals.time * globals.CountAliveUser();
        mTimerText = (TextView) findViewById(R.id.timer_text);
        mTimerText.setText(String.valueOf(BrainTime) + ":00");

        Log.d("木村",Integer.toString(globals.CountAliveUser()));
        mListView = (ListView) findViewById(R.id.list_view);
        CustomAdapter arrayAdapter = new CustomAdapter(this, R.layout.picture_list, globals.users);
        mListView.setAdapter(arrayAdapter);

        Button round_start_button = (Button) findViewById(R.id.round_start_button);
        round_start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("haruurara.android", "haruurara.android.BrainStormActivity");
                startActivity(intent);
                RoundStartActivity.this.finish();
            }
        });
    }

}


