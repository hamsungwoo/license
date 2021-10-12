package com.bellacorp.licenseapplication.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bellacorp.licenseapplication.databinding.ItemResultNameBinding;
import com.bellacorp.licenseapplication.main.model.LicenseItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LicenseAdapter extends RecyclerView.Adapter<LicenseAdapter.LicenseViewHolder> {

    private ArrayList<LicenseItem> mItems = new ArrayList<>();
    private LicenseClickListener mListener;

    public interface LicenseClickListener {
        void onClick(int position, LicenseItem item);
    }

    @NonNull
    @Override
    public LicenseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemResultNameBinding binding = ItemResultNameBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new LicenseViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull LicenseViewHolder holder, int position) {
        holder.bind(position, mItems.get(position));
    }

    @Override
    public int getItemCount() {
        if (mItems == null) return 0;
        return mItems.size();
    }

    class LicenseViewHolder extends RecyclerView.ViewHolder {
        ItemResultNameBinding binding;

        public LicenseViewHolder(@NonNull ItemResultNameBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }

        void bind(int position, LicenseItem item) {
            binding.setName(item.jmfldnm);
            binding.setCallback(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onClick(position, item);
                }
            });
        }
    }

    public void setItems(List<LicenseItem> items) {
        this.mItems.clear();
        this.mItems.addAll(items);
        notifyDataSetChanged();
    }

    public void setSearchItems(String text) {
        if (text != null) {
            List<LicenseItem> filtered = mItems.stream().filter(licenseItem -> licenseItem.mdobligfldnm.contains(text))
                    .collect(Collectors.toList());

//            List<LicenseItem> filteredJob = mItems.stream().filter(item -> item.obligfldnm.contains(text))
//                    .collect(Collectors.toList());

            mItems.clear();
//            mItems.addAll(filteredJob);
            mItems.addAll(filtered);
            notifyDataSetChanged();
        }
    }

    public void setListener(LicenseClickListener listener) {
        this.mListener = listener;
    }
}
