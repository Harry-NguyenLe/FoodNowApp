package vn.edu.csc.foodnowapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import model.Store;


public class OrderFragment extends Fragment {
    TextView tvAddress;
    Button btnCancel;
    StoreLactionActivity storeLactionActivity;

    public OrderFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order, container, false);
    }


    public static OrderFragment newInstance(Store store) {
        OrderFragment fragment = new OrderFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("Store", store);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvAddress = view.findViewById(R.id.tvAddress);
        btnCancel = view.findViewById(R.id.btnCancel);
        Bundle bundle = getArguments();
        Store store = (Store) bundle.getSerializable("Store");
        tvAddress.setText(store.getName() + " " + store.getAddress());

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 FragmentManager fragmentManager = getFragmentManager();
               if (fragmentManager.getBackStackEntryCount() != 0)
               {
                   fragmentManager.popBackStack();
               }

            }
        });

    }



}
