package jp.ac.asojuku.st.anbayasiroulette;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Sendmail extends AppCompatActivity implements View.OnClickListener,View.OnLongClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendmail);
        Button btnsend = (Button) this.findViewById(R.id.button);
        btnsend.setOnClickListener(this);
        btnsend.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v){
        EditText edit01 = (EditText)findViewById(R.id.editText);
        String title = edit01.getText().toString();
        Resources res = getResources();
        Uri uri = Uri.parse("mailto:" + res.getString(R.string.haha).toString());
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);

        intent = getIntent();
        Bundle bundle = intent.getExtras();
        String janru = bundle.getString("ジャンル");
        String num = bundle.getString("数");

        intent = new Intent(Intent.ACTION_SENDTO, uri);

        intent.putExtra(Intent.EXTRA_SUBJECT, title);
        intent.putExtra(Intent.EXTRA_TEXT, "今日の料理のジャンルは" + janru + "\n品数は" + num + "品");
        startActivity(intent);
    }

    @Override
    public boolean onLongClick(View v) {
        EditText edit01 = (EditText)findViewById(R.id.editText);
        String title = edit01.getText().toString();
        Resources res = getResources();
        Uri uri = Uri.parse("mailto:" + res.getString(R.string.omake).toString());
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);

        intent = getIntent();
        Bundle bundle = intent.getExtras();
        String janru = bundle.getString("ジャンル");
        String num = bundle.getString("数");

        intent = new Intent(Intent.ACTION_SENDTO, uri);

        intent.putExtra(Intent.EXTRA_SUBJECT, title);
        intent.putExtra(Intent.EXTRA_TEXT, "今日の料理のジャンルは" + janru + "\n品数は" + num + "デザートもお願い♫");
        startActivity(intent);
        return true;
    }
}
