package jp.ac.asojuku.st.anbayasiroulette;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ActivityMain extends AppCompatActivity implements View.OnClickListener{
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.cardList);

        Button button = (Button) this.findViewById(R.id.button2);
        button.setOnClickListener(this);


        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llManager = new LinearLayoutManager(this);
        //縦スクロール
        llManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llManager);

        ArrayList<AnbayasiData> anbayasi = new ArrayList<AnbayasiData>();
        for(int i = 0; i < MyData.commentArray.length; i++) {
            anbayasi.add(new AnbayasiData(
                    MyData.numArray[i],
                    MyData.additionArray[i],
                    MyData.commentArray[i]
            ));
        }

        RecyclerView.Adapter adapter = new AnbayasiAdapter(anbayasi, this);
        recyclerView.setAdapter(adapter);
        recyclerView.smoothScrollToPosition(anbayasi.size() - 1);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(ActivityMain.this, ActivityMail.class);
        startActivity(intent);
    }

}
