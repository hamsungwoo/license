package com.bellacorp.licenseapplication.job;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableArrayList;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bellacorp.licenseapplication.R;
import com.bellacorp.licenseapplication.job.model.JobItem;

public class JobBindings {
    @BindingAdapter(value = {"job_list", "job_click_listener"})
    public static void setRecyclerView(RecyclerView view, ObservableArrayList<JobItem> items, JobAdapter.JobClickListener listener) {
        JobAdapter adapter = null;

        if (view.getAdapter() == null) {
            adapter = new JobAdapter();
        } else {
            adapter = (JobAdapter) view.getAdapter();
        }

        adapter.setListener(listener);
        adapter.setItems(items);

        view.setAdapter(adapter);
        view.setLayoutManager(new GridLayoutManager(view.getContext(), 3));
        if (view.getItemDecorationCount() == 0) {
            DividerItemDecoration decor = new DividerItemDecoration(view.getContext(), LinearLayoutManager.VERTICAL);
            decor.setDrawable(view.getContext().getDrawable(R.drawable.shape_divider));
            view.addItemDecoration(decor);
        }
    }

    @BindingAdapter("next_items")
    public static void setRecyclerViewItems(RecyclerView view, ObservableArrayList<JobItem> items) {
        JobAdapter adapter = (JobAdapter) view.getAdapter();
        adapter.setItems(items);
    }
}
