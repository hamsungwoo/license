package com.bellacorp.licenseapplication.job;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bellacorp.licenseapplication.databinding.ItemJobBinding;
import com.bellacorp.licenseapplication.job.model.JobItem;
import com.bellacorp.licenseapplication.util.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.JobViewHolder> {

    private ArrayList<JobItem> mItems = new ArrayList<>();
    private JobClickListener mListener;

    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemJobBinding binding = ItemJobBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new JobViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull JobViewHolder holder, int position) {
        holder.bind(position, mItems.get(position));
    }

    @Override
    public int getItemCount() {
        if (mItems == null) return 0;
        return mItems.size();
    }

    public interface JobClickListener {
        void onClick(int position, JobItem item);
    }

    class JobViewHolder extends RecyclerView.ViewHolder {
        ItemJobBinding binding;

        public JobViewHolder(@NonNull ItemJobBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }

        void bind(int position, JobItem item) {
            binding.setName(item.udeptmdoblignm);
            binding.setCallback(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                       mListener.onClick(position, item);
                }
            });
        }
    }

    public void setItems(List<JobItem> items) {
        this.mItems.addAll(items);
        List<JobItem> filtered = this.mItems.stream().filter(distinctByKey(JobItem::getUdeptmdobligcd)).collect(Collectors.toList());
        this.mItems.clear();
        this.mItems.addAll(filtered);
        notifyDataSetChanged();
    }

    public void setListener(JobClickListener listener) {
        this.mListener = listener;
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}
