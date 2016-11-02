package jp.ac.asojuku.st.anbayasiroulette;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by satakenaoto on 2016/11/02.
 */
public class ActivityMail  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);
        Button btn = (Button) this.findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityMail.this, Sendmail.class);

                intent = getIntent();
                Bundle bundle = intent.getExtras();
                    String janru = bundle.getString("ジャンル");
                    String num = bundle.getString("数");


                intent = new Intent(ActivityMail.this, Sendmail.class);


                num = String.valueOf(num);
                bundle = new Bundle();
                bundle.putString("ジャンル",janru);
                bundle.putString("数",num);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }
}
