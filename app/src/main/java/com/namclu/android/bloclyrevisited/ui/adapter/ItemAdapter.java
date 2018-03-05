package com.namclu.android.bloclyrevisited.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.namclu.android.bloclyrevisited.BloclyApplication;
import com.namclu.android.bloclyrevisited.R;
import com.namclu.android.bloclyrevisited.api.DataSource;
import com.namclu.android.bloclyrevisited.api.model.RssFeed;
import com.namclu.android.bloclyrevisited.api.model.RssItem;

/**
 * Created by namlu on 05-Mar-18.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemAdapterViewHolder> {

    @NonNull
    @Override
    public ItemAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rss_item, parent, false);
        return new ItemAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapterViewHolder holder, int position) {
        DataSource shareDataSource = BloclyApplication.getSharedDataSource();
        holder.update(shareDataSource.getFeeds().get(0), shareDataSource.getItems().get(position));
    }

    @Override
    public int getItemCount() {
        return BloclyApplication.getSharedDataSource().getItems().size();
    }

    class ItemAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView feed;
        TextView content;

        public ItemAdapterViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_rss_item_feed_title);
            feed = itemView.findViewById(R.id.tv_rss_item_feed_title);
            content = itemView.findViewById(R.id.tv_rss_item_content);
        }

        void update(RssFeed rssFeed, RssItem rssItem) {
            feed.setText(rssFeed.getTitle());
            title.setText(rssItem.getTitle());
            content.setText(rssItem.getDescription());
        }
    }
}
