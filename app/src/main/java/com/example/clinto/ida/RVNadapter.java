package com.example.clinto.ida;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Clinto on 27-Sep-17.
 */

public class RVNadapter extends RecyclerView.Adapter<RVNadapter.SubClass> {
    private List<Newsn> newsList;
    Context context;
    public RVNadapter(Context context, ArrayList<Newsn> retlist) {
        this.context = context;
        this.newsList =retlist;
    }
    @Override
    public RVNadapter.SubClass onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutnotification, parent, false);
        return new RVNadapter.SubClass(view);
    }


    @Override
    public void onBindViewHolder(RVNadapter.SubClass holder, int position) {
        Newsn newsItem = newsList.get(position);
        String img_url = "http://iroidtech.com/wecare/uploads/unit_details/";


        /*holder.tvNewsTitle.setText(newsItem.getTitle());*/
     /*  holder.tvNewsDate.setText(newsItem.getPlace());*/
        /*holder.tvNewsContent.setText(newsItem.getPlace());*/


     /*   if (!TextUtils.isEmpty(newsItem.getImage())) {
            Picasso.with(context)
                    .load(img_url+newsItem.getImage())
                    .error(R.drawable.picprofile)
                    .into(holder.ivNewsImage);
        }*/



    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class SubClass extends RecyclerView.ViewHolder implements View.OnClickListener  {
        protected ImageView ivNewsImage;
        protected TextView tvNewsTitle, tvNewsContent, tvNewsDate;
        private OnItemClickListener onItemClickListener;
        public SubClass(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            /*this.ivNewsImage = (ImageView) itemView.findViewById(R.id.imv);*/
            /*this.tvNewsTitle = (TextView) itemView.findViewById(R.id.tv1);*/
            /*this.tvNewsContent = (TextView) itemView.findViewById(R.id.tv2);*/
           /* this.tvNewsDate = (TextView) itemView.findViewById(R.id.tv3);*/
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