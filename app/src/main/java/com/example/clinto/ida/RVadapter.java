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

public class RVadapter extends RecyclerView.Adapter<RVadapter.SubClass> {
    private List<News> newsList;
    Context context;
    public RVadapter(Context context, ArrayList<News> retlist) {
        this.context = context;
        this.newsList =retlist;
    }
    @Override
    public RVadapter.SubClass onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutnewsandevents, parent, false);
        return new SubClass(view);
    }

    @Override
    public void onBindViewHolder(RVadapter.SubClass holder, int position) {
        final News newsItem = newsList.get(position);
       /* String img_url = "http://iroidtech.com/wecare/uploads/unit_details/";*/


        holder.tvNewsTitle.setText(newsItem.getTitle());
        /*holder.tvNewsDate.setText(newsItem.getPlace());*/
        holder.tvNewsContent.setText(newsItem.getDetails());


        /*if (!TextUtils.isEmpty(newsItem.getMediaImg())) {
            Picasso.with(context)
                    .load(img_url+newsItem.getMediaImg())
                    .error(R.drawable.picprofile)
                    .into(holder.ivNewsImage);
        }
*/
        holder.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View item, int position) {
                Intent ii=new Intent(context,ScrollingActivity3.class);
                ii.putExtra("head",newsItem.getTitle());
                ii.putExtra("des",newsItem.getDetails());
                context.startActivity(ii);
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
            this.ivNewsImage = (ImageView) itemView.findViewById(R.id.imv);
            this.tvNewsTitle = (TextView) itemView.findViewById(R.id.tv1);
            this.tvNewsContent = (TextView) itemView.findViewById(R.id.tv2);
            /*this.tvNewsDate = (TextView) itemView.findViewById(R.id.tv3);*/
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
