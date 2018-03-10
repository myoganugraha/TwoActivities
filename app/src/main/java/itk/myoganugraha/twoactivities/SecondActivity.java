package itk.myoganugraha.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "itk.myoganugraha.twoactivities.extra.REPLY";
    private TextView textView;
    private EditText mReply;
    private Button replyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        textView = (TextView) findViewById(R.id.text_message);
        textView.setText(message);

        mReply = (EditText) findViewById(R.id.editText_second);

        replyButton = (Button) findViewById(R.id.button_second);
        replyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                String reply = mReply.getText().toString();

                replyIntent.putExtra(EXTRA_REPLY, reply);
                setResult(RESULT_OK, replyIntent);
                finish();
            }
        });

    }
}
