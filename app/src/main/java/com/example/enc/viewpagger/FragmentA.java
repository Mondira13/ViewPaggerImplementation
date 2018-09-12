package com.example.enc.viewpagger;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentA extends BaseFragment {

    private static final String ARG_PARAM1 = "param1";

    private String title;

    private OnFragmentInteractionListener mListener; // interface reference variable

    public FragmentA() {
        // Required empty public constructor
    }

    public static FragmentA newInstance(String title) {
        FragmentA fragment = new FragmentA();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_PARAM1);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final EditText editText = view.findViewById(R.id.editText);
        final EditText noEditText = view.findViewById(R.id.noEditText);
        final EditText fragNameEditText = view.findViewById(R.id.fragNameeditText);
        Button submitButton = view.findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int number = Integer.parseInt(noEditText.getText().toString());
                final String value = editText.getText().toString().trim();
                if(value.isEmpty() || value== null) {
                    Toast.makeText(getActivity(),"Please enter value",Toast.LENGTH_SHORT).show();
                }else {
                    mListener.onFragmentInteraction(number,value);
                }
            }
        });


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnFragmentInteractionListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(" Error..!!! Please try again");
        }
    }

    @Override
    public void displayReceivedData(int number, String message) {

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


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(int number, String message);
    }
}
