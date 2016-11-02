package jp.ac.asojuku.st.anbayasiroulette;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by satakenaoto on 2016/10/07.
 */

public  class AnbayasiAdapter extends RecyclerView.Adapter<AnbayasiViewHolder> {
    private ArrayList<AnbayasiData> rouletteDateSet;
    private Activity activity;

    public AnbayasiAdapter(ArrayList<AnbayasiData> roulette, Activity activity) {
        this.activity = activity;
        this.rouletteDateSet = roulette;
    }


    @Override
    public AnbayasiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cords_layout, parent, false);

        return new AnbayasiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AnbayasiViewHolder holder, final int listPosition) {

         holder.textViewNumber.setText("今日のおかずは"+rouletteDateSet.get(listPosition).getNumber()+"品");
         holder.textViewComment.setText(rouletteDateSet.get(listPosition).getComment());
         holder.base.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(activity, ActivityMail.class);

                String janru = rouletteDateSet.get(listPosition).getComment();
                int sinasu = rouletteDateSet.get(listPosition).getNumber();
                String num = String.valueOf(sinasu);
                Bundle bundle = new Bundle();
                bundle.putString("ジャンル",janru);
                bundle.putString("数",num);
                intent.putExtras(bundle);

                activity.startActivity(intent);
            }
         });
    }

    @Override
    public int getItemCount() {
        return rouletteDateSet.size();
    }
}