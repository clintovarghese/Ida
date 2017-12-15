package com.example.clinto.ida;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class ImageFragment extends Fragment {

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

    public ImageFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ImageFragment newInstance() {
        ImageFragment fragment = new ImageFragment();
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
        View view= inflater.inflate(R.layout.fragment_image, container, false);
        mListener.changeTitle("Gallery");
        ImageView img = (ImageView) view.findViewById(R.id.im1);
        ImageView img1 = (ImageView) view.findViewById(R.id.im2);
        ImageView img2 = (ImageView) view.findViewById(R.id.im3);
        ImageView img3 = (ImageView) view.findViewById(R.id.im4);
        ImageView img4 = (ImageView) view.findViewById(R.id.im5);
        ImageView img5= (ImageView) view.findViewById(R.id.im6);
        Context c = getActivity().getApplicationContext();
        Picasso.with(c).load("http://stanlemmens.nl/wp/wp-content/uploads/2014/07/bill-gates-wealthiest-person.jpg")
                .placeholder(R.drawable.picprofile)
                .error(R.drawable.picprofile)
                .into(img);
        Picasso.with(c).load("https://static01.nyt.com/images/2017/01/12/well/move/adam-bryant-headshot/adam-bryant-headshot-square320-v2.jpg")
                .placeholder(R.drawable.picprofile)
                .error(R.drawable.picprofile)
                .into(img1);
        Picasso.with(c).load("https://cdn.pixabay.com/photo/2015/08/25/10/40/ben-knapen-906550_960_720.jpg")
                .placeholder(R.drawable.picprofile)
                .error(R.drawable.picprofile)
                .into(img2);
        Picasso.with(c).load("http://blog.homerealestate.com/wp-content/uploads/2010/04/Person.Ashley.jpg")
                .placeholder(R.drawable.picprofile)
                .error(R.drawable.picprofile)
                .into(img3);
        Picasso.with(c).load("http://therapidian.org/sites/default/files/article_images/jamesperson.jpg")
                .placeholder(R.drawable.picprofile)
                .error(R.drawable.picprofile)
                .into(img4);
        Picasso.with(c).load("http://bhaboise.com/wp-content/uploads/2013/04/Person-Melanie-2012-07-4x6-1.jpg")
                .placeholder(R.drawable.picprofile)
                .error(R.drawable.picprofile)
                .into(img5);
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
