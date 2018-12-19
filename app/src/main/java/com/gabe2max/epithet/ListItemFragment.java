package com.gabe2max.epithet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gabe2max.epithet.adapters.BatchItem;
import com.gabe2max.epithet.adapters.BatchListAdapter;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListItemFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListItemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListItemFragment extends ListFragment {
    private List<BatchItem> list;

    public ListItemFragment() {
        super();
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public ListItemFragment(List<BatchItem> list) {
        super();
        this.list = list;
    }

    public static ListItemFragment newInstance() {
        ListItemFragment fragment = new ListItemFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        BatchListAdapter adapter = new BatchListAdapter(getActivity(), list);
        setListAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_item, container, false);
    }

    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
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
        void onFragmentInteraction(Uri uri);
    }
}
