package com.example.clinto.ida;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Clinto on 26-Sep-17.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.SubClass> {
    private List<NewsItem> newsList;
    Context context;
    public RecycleAdapter(Context context, List<NewsItem> retlist) {
        this.context = context;
        this.newsList =retlist;
    }
    @Override
    public RecycleAdapter.SubClass onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout, parent, false);
        SubClass viewholder= new SubClass(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(RecycleAdapter.SubClass holder, int position) {
        final NewsItem newsItem = newsList.get(position);
       /* String img_url = "http://iroidtech.com/wecare/uploads/unit_details/";*/


        holder.tvNewsTitle.setText(newsItem.getFullname());
        holder.tvNewsDate.setText(newsItem.getAddress());
        holder.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View item, int position) {
                Intent iii=new Intent(context,ScrollingActivity.class);
                iii.putExtra("fullname",newsItem.getFullname());
                iii.putExtra("number",newsItem.getPhoneno());
                iii.putExtra("home",newsItem.getPhonehome());
                iii.putExtra("address",newsItem.getAddress());
                iii.putExtra("email",newsItem.getEmail());
                iii.putExtra("id",newsItem.getMemberId());
                context.startActivity(iii);

            }
        });
       /* holder.tvNewsContent.setText(newsItem.getEmail());*/


      /*  if (!TextUtils.isEmpty(newsItem.getImage())) {
        Picasso.with(context)
        .load(img_url+newsItem.getImage())
        .error(R.drawable.picprofile)
        .into(holder.ivNewsImage);
        }
*/


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
       /* this.ivNewsImage = (ImageView) itemView.findViewById(R.id.imv);*/
            this.tvNewsTitle = (TextView) itemView.findViewById(R.id.tv1);
      /*  this.tvNewsContent = (TextView) itemView.findViewById(R.id.tv2);*/
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
