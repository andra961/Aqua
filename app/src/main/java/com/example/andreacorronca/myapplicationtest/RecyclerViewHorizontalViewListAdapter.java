package com.example.andreacorronca.myapplicationtest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewHorizontalViewListAdapter extends RecyclerView.Adapter<RecyclerViewHorizontalViewListAdapter.GamePreviewViewHolder>{
    private ArrayList<Game> games;
    //private List<Integer> imageIdList;
    Context context;

    public RecyclerViewHorizontalViewListAdapter(ArrayList<Game> games, Context context){
        this.games = games;
        //this.imageIdList = imageIdList;
        this.context = context;
    }

    @Override
    public GamePreviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View gamePreviweView = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_preview, parent, false);
        GamePreviewViewHolder gvh = new GamePreviewViewHolder(gamePreviweView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(GamePreviewViewHolder holder, final int position) {
        holder.imageView.setImageResource(games.get(position).getImgId());
        if (games.get(position).getDiscount() > 0){
            holder.sald.setVisibility(View.VISIBLE);
            holder.sald.setText("-" + new Integer (games.get(position).getDiscount()).toString() + "%");
        }
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*CharSequence msg = "E' l'intent il colpevole";
                Toast toast = Toast.makeText(context,msg,msg.length());
                toast.show();*/
                Intent intent = new Intent(context, GameInfo.class);
                intent.putExtra("_id", games.get(position).getId());
                intent.putExtra("activity",1);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    public class GamePreviewViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView sald;
        public GamePreviewViewHolder(View view) {
            super(view);
            imageView=view.findViewById(R.id.homePreviewImg);
            sald=view.findViewById(R.id.saldHome);
        }
    }
}