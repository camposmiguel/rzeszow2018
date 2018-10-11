package com.miguelcr.a04_fragmentlist;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class RestaurantFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private RestaurantInteractionListener mListener;
    private List<Restaurant> restaurantList;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RestaurantFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static RestaurantFragment newInstance(int columnCount) {
        RestaurantFragment fragment = new RestaurantFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurant_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            restaurantList = new ArrayList<>();
            restaurantList.add(new Restaurant(
                    "Goiko Grill",
                    5,
                    "Avda. República Argentina, 15 Sevilla",
                    "https://www.goikogrill.com/wp-content/uploads/2017/01/GOIKO_GRILL_WEB-2.jpg"
                    )
            );
            restaurantList.add(new Restaurant(
                            "Bar Esperanza Triana",
                            4,
                            "C/ San Jacinto, 4",
                            "https://4.bp.blogspot.com/-LKqHkbvgV8Q/V7sSK61_7fI/AAAAAAAAFDM/kzPl1Zsq_FQY4nOBJLpM7CWl5UhdbONYQCLcB/s1600/e1.jpg"
                    )
            );

            recyclerView.setAdapter(new MyRestaurantRecyclerViewAdapter(restaurantList, mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof RestaurantInteractionListener) {
            mListener = (RestaurantInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement RestaurantInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
