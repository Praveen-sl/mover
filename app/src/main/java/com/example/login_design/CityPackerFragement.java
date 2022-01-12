package com.example.login_design;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CityPackerFragement#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CityPackerFragement extends Fragment  {
    TextView text6,text7,text8,text9,text10,text11,text12,text13,text14,text15,text16,text17;
    ImageView image7,image8,image9;
    Button btn3;
    EditText ed2,ed3,ed4;
    View view;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CityPackerFragement() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CityPackerFragement.
     */
    // TODO: Rename and change types and number of parameters
    public static CityPackerFragement newInstance(String param1, String param2) {
        CityPackerFragement fragment = new CityPackerFragement();
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
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_city_packer_fragement, container, false);


        text6 = (TextView) view.findViewById(R.id.text6);
        text7 = (TextView) view.findViewById(R.id.text7);
        text8 = (TextView) view.findViewById(R.id.text8);
        text9 = (TextView) view.findViewById(R.id.text9);
        text10 = (TextView) view.findViewById(R.id.text10);
        text11 = (TextView) view.findViewById(R.id.text11);
        text12 = (TextView) view.findViewById(R.id.text12);
        text13 = (TextView) view.findViewById(R.id.text13);
        text14 = (TextView) view.findViewById(R.id.text14);
        text15 = (TextView) view.findViewById(R.id.text15);
        text16 = (TextView) view.findViewById(R.id.text16);
        text17 = (TextView) view.findViewById(R.id.text17);

        btn3 = (Button) view.findViewById(R.id.btn3);

        image7 = (ImageView) view.findViewById(R.id.image7);
        image8 = (ImageView) view.findViewById(R.id.image8);
        image9 = (ImageView) view.findViewById(R.id.image9);

        ed2 = (EditText) view.findViewById(R.id.ed2);
        ed3 = (EditText) view.findViewById(R.id.ed3);
        ed4 = (EditText) view.findViewById(R.id.ed4);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String City = ed2.getText().toString();
                String From = ed3.getText().toString();
                String To = ed4.getText().toString();
                if (TextUtils.isEmpty(City) || TextUtils.isEmpty(From) || TextUtils.isEmpty(To)) {
                    Toast.makeText(getActivity(), "please fill the All Requirements", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent i = new Intent(getActivity(), Customer_Details.class);
                    startActivity(i);
                }
            }
        });

        return view;
    }
}
