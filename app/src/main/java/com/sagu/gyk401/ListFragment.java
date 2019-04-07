package com.sagu.gyk401;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ListFragment extends Fragment {



    public String mParam1;
    public String mParam2;


    


    private OnFragmentInteractionListener mListener;

    private ListView listView;
    private ArrayList<Diet> dietList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);

        Toast.makeText(getActivity(), mParam1 +" + " + mParam2 , Toast.LENGTH_SHORT).show();

        listView = view.findViewById(R.id.listview);

        dietList = new ArrayList<>();

        dietList.add(new Diet(R.drawable.menu_3,"Yumurta,peynir,zeytin","5000C"));
        dietList.add(new Diet(R.drawable.menu_1,"Mevsim yeşillikleri salata","2000C"));
        dietList.add(new Diet(R.drawable.menu_2,"Badem,fındık,ceviz","4000C"));
        dietList.add(new Diet(R.drawable.menu_4,"Kivi,çilek,muz","1000C"));

        ListAdapter adapter = new ListAdapter(dietList,getActivity().getApplicationContext());
        listView.setAdapter(adapter);




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mListener.onFragmentInteraction(dietList.get(position));
            }
        });

        return view;
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Diet diet);
    }
}
