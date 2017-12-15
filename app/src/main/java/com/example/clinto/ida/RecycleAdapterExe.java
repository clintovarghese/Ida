package com.example.clinto.ida;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Clinto on 26-Sep-17.
 */

public class RecycleAdapterExe extends RecyclerView.Adapter<RecycleAdapterExe.SubClass> {
    private List<Newsx> newsList;
    Context context;
    public RecycleAdapterExe(Context context, ArrayList<Newsx> retlist) {
        this.context = context;
        this.newsList =retlist;
    }
    @Override
    public RecycleAdapterExe.SubClass onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutexecutive, parent, false);
        SubClass viewholder= new SubClass(view);
        return viewholder;
    }


    @Override
    public void onBindViewHolder(SubClass holder, int position) {
        final Newsx newsItem = newsList.get(position);
        String img_url = "http://iroidtech.com/wecare/uploads/unit_details/";


        holder.tvNewsTitle.setText(newsItem.getFullname());
        holder.tvNewsDate.setText(newsItem.getAddress());
        /*holder.tvNewsContent.setText(newsItem.getPlace());*/


     /*   if (!TextUtils.isEmpty(newsItem.getImage())) {
            Picasso.with(context)
                    .load(img_url+newsItem.getImage())
                    .error(R.drawable.picprofile)
                    .into(holder.ivNewsImage);
        }*/
        holder.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View item, int position) {
                Intent i=new Intent(context,ScrollingActivity2.class);
                i.putExtra("fullname",newsItem.getFullname());
                i.putExtra("number",newsItem.getPhoneno());
                i.putExtra("home",newsItem.getPhonehome());
                i.putExtra("address",newsItem.getAddress());
                i.putExtra("email",newsItem.getEmail());
                i.putExtra("id",newsItem.getMemberId());
                context.startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class SubClass extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected ImageView ivNewsImage;
        protected TextView tvNewsTitle, tvNewsContent, tvNewsDate;
        private OnItemClickListener onItemClickListener;
        public SubClass(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            /*this.ivNewsImage = (ImageView) itemView.findViewById(R.id.imv);*/
            this.tvNewsTitle = (TextView) itemView.findViewById(R.id.tv1);
            /*this.tvNewsContent = (TextView) itemView.findViewById(R.id.tv2);*/
            this.tvNewsDate = (TextView) itemView.findViewById(R.id.tv2);
        }
        public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
            this.onItemClickListener = onItemClickListener;
        }

        @Override
        public void onClick(View view) {
            onItemClickListener.onItemClick(view, getAdapterPosition());
        }
    }


}
