package com.bellacorp.licenseapplication.main;


import androidx.appcompat.widget.SearchView;
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableArrayList;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bellacorp.licenseapplication.R;
import com.bellacorp.licenseapplication.main.model.LicenseItem;
import com.bellacorp.licenseapplication.util.Logger;

public class MainBindings {
    @BindingAdapter(value = {"search_listener", "close_listener"})
    public static void setSearchListener(SearchView view, SearchView.OnQueryTextListener listener, SearchView.OnCloseListener closeListener) {
        view.setOnQueryTextListener(listener);
        view.setOnCloseListener(closeListener);
    }

    @BindingAdapter(value = {"license_list", "item_click_listener"})
    public static void setRecyclerView(RecyclerView view, ObservableArrayList<LicenseItem> items, LicenseAdapter.LicenseClickListener listener) {
        LicenseAdapter adapter = null;

        if (view.getAdapter() == null) {
            adapter = new LicenseAdapter();
        } else {
            adapter = (LicenseAdapter) view.getAdapter();
        }

        adapter.setListener(listener);
        adapter.setItems(items);

        view.setAdapter(adapter);
        view.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));
        if (view.getItemDecorationCount() == 0) {
            DividerItemDecoration decor = new DividerItemDecoration(view.getContext(), LinearLayoutManager.VERTICAL);
            decor.setDrawable(view.getContext().getDrawable(R.drawable.shape_divider));
            view.addItemDecoration(decor);
        }
    }

    @BindingAdapter("search_text")
    public static void setSearchText(RecyclerView view, String text) {
        try {
            LicenseAdapter adapter = (LicenseAdapter) view.getAdapter();
            adapter.setSearchItems(text);
        } catch (NullPointerException e) {
            Logger.e("it does not have adapter");
        }
    }
}
