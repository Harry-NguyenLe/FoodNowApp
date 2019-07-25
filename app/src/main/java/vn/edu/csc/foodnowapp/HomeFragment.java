package vn.edu.csc.foodnowapp;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import adapter.StoreAdapter;
import model.Store;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    ListView lvHome;
    ArrayList<Store> list;
    StoreAdapter adapter;
    StoreLactionActivity storeLactionActivity;
    TabLayout tabLayout;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lvHome = view.findViewById(R.id.lvHome);
        tabLayout = view.findViewById(R.id.tabLayout);
        list = new ArrayList<>();
        list.add(new Store(R.drawable.ic_circlek, "Circle K", "40 Hung Vuong"));
        list.add(new Store(R.drawable.ic_milk_tea, "Milk Tea", "38 Nguyen Van Cu"));
        list.add(new Store(R.drawable.ic_highland, "Highland ", "938 Nguyen Cong Tru"));
        list.add(new Store(R.drawable.ic_ministop, "MiniStop ", "45 Bui Huu Nghia"));
        list.add(new Store(R.drawable.ic_seveneleven, "7Eleven", "94 Phan Dang Luu"));
        list.add(new Store(R.drawable.ic_vinmart, "Vinmart", "78 Hai Ba Trung"));


        adapter = new StoreAdapter(getContext(), R.layout.home_row, list);
        lvHome.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        displayOrder();
    }

    private void displayOrder() {

        lvHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               storeLactionActivity.getStoreForFragment(list.get(position));
            }
        });

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof StoreLactionActivity) {
            storeLactionActivity = (StoreLactionActivity) context;
        }
    }
}
