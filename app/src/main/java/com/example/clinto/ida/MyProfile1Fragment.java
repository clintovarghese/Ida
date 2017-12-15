package com.example.clinto.ida;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MyProfile1Fragment extends Fragment {
    private List<Person> persons;
    RecyclerView rv;
    EditText ed1,ed2,ed3;
    private HashMap<String, String> loginParms;
    Button bt;
    String idmem="56",name,email,phonenum;
    ServiceHandler serviceHandler222;
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

    public MyProfile1Fragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static MyProfile1Fragment newInstance() {
        MyProfile1Fragment fragment = new MyProfile1Fragment();
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
        mListener.changeTitle("My Profile");
        View view=inflater.inflate(R.layout.fragment_my_profile1, container, false);
        ed1=(EditText) view.findViewById(R.id.name);
        ed2=(EditText)view.findViewById(R.id.email);
        ed3=(EditText)view.findViewById(R.id.phonenum);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://iroidtech.com/ida/api/users/details/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IGetNewsEvents service = retrofit.create(IGetNewsEvents.class);
        Call<ArrayList<NewsItem>> call=service.getNewsItems();
        call.enqueue(new Callback<ArrayList<NewsItem>>() {
            @Override
            public void onResponse(Call<ArrayList<NewsItem>> call, Response<ArrayList<NewsItem>> response) {
                List<NewsItem> newsItems=response.body();
                for(int i=0;i<newsItems.size();i++){
                    if(i==42){
                        ed1.setText(newsItems.get(i).getFullname());
                        ed2.setText(newsItems.get(i).getEmail());
                        ed3.setText(newsItems.get(i).getPhoneno());
                    }
                }

            }

            @Override
            public void onFailure(Call<ArrayList<NewsItem>> call, Throwable t) {

            }
        });
        ImageView img = (ImageView) view.findViewById(R.id.imv);
        Context c = getActivity().getApplicationContext();
        Picasso.with(c)
                .load("https://www.google.co.in/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0ahUKEwiztuGc4cnVAhVKMI8KHZiaACoQjRwIBw&url=http%3A%2F%2Fwww.universalpestcontrol.com%2F&psig=AFQjCNH41qGDpBBq4ir_dOKIIJxA3X6RPA&ust=1502354526860070")
                .placeholder(R.drawable.picprofile)
                .error(R.drawable.picprofile)
                .into(img);
        serviceHandler222 =new ServiceHandler();
        bt=(Button)view.findViewById(R.id.postbutton);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = ed1.getText().toString();
                email = ed2.getText().toString();
                phonenum = ed3.getText().toString();
                if ((!email.equals(""))&&(!name.equals(""))&&(!phonenum.equals("")))
                {
                    loginParms = new HashMap<>();
                    idmem="56";
                    loginParms.put("id", idmem);
                    loginParms.put("fullname",name);
                    /*loginParms.put("address", address);
                    loginParms.put("location", location);*/
                    loginParms.put("phoneno", phonenum);
                   /* loginParms.put("phonehome", phonehome);*/
                    loginParms.put("email", email);
                   /* loginParms.put("clinicaddress", clinicadd);
                    loginParms.put("clinicphoneno", clinicphone);
                    loginParms.put("clinicwebsite", clinicweb);
                    loginParms.put("otherdetails", other);*/

                    new PostTask().execute("http://iroidtech.com/ida/api/users/details");

                }

            }
        });
       /* rv = view.findViewById(R.id.recv);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        initializeData();
        RVAdapter adapter = new RVAdapter(persons);
        rv.setAdapter(adapter);*/
       /* return view;*/
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
    private class PostTask extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... strings) {
            String response ="";
            try {
                response = serviceHandler222.performPostCall("http://iroidtech.com/ida/api/users/details", loginParms);

            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.d("LOG RES ###############", response);

            return response;
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject jsonObject = new JSONObject(s);
                String status = jsonObject.getString("result");
                if (status.equals("updated")) {
                    Toast.makeText(getContext(),"Updated Your Profile",Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(getContext(),"Already Updated Data",Toast.LENGTH_LONG).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
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
   /* public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/

}




