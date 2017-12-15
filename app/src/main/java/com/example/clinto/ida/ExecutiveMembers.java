package com.example.clinto.ida;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ExecutiveMembers extends Fragment {
    RecyclerView rv_retrofit;
    private RecycleAdapterExe adapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static String param2;
    private static String param1;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ExecutiveMembers() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ExecutiveMembers newInstance() {
        ExecutiveMembers fragment = new ExecutiveMembers();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mListener.changeTitle("Executive Members");
        View view = inflater.inflate(R.layout.layoutmembercard, container, false);
        rv_retrofit = (RecyclerView) view.findViewById(R.id.rv_retrofit);
        rv_retrofit.setLayoutManager(new LinearLayoutManager(getContext()));
        IGetExecutive apiService =
                MyApplication.getClient().create(IGetExecutive.class);

        Call<ArrayList<Newsx>> call = apiService.getNewsx();
        call.enqueue(new Callback<ArrayList<Newsx>>() {
            @Override
            public void onResponse(Call<ArrayList<Newsx>> call, Response<ArrayList<Newsx>> response) {
                Log.d("SIZE>>",32+" "+response.body().size());
                adapter = new RecycleAdapterExe(getContext(), response.body());
                rv_retrofit.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Newsx>> call, Throwable t) {

            }
        });
        return view;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

}
