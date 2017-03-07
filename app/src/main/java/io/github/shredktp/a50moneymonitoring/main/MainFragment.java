package io.github.shredktp.a50moneymonitoring.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import io.github.shredktp.a50moneymonitoring.R;
import io.github.shredktp.a50moneymonitoring.add_expense.AddExpenseActivity;
import io.github.shredktp.a50moneymonitoring.add_income.AddIncomeActivity;
import io.github.shredktp.a50moneymonitoring.data.Money;

public class MainFragment extends Fragment implements MainContract.View, View.OnClickListener {
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//    private String mParam1;
//    private String mParam2;

    private Button btnAddIncome, btnAddExpense;
    private TextView tvDate, tvSummary;
    private TextView tvItem;

//    private OnFragmentInteractionListener mListener;
    private MainContract.Presenter mainPresenter;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
//        MainFragment fragment = new MainFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return new MainFragment();
    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @Override
    public void onResume() {
        super.onResume();
        mainPresenter.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        setupView(root);

        return root;
    }

    private void setupView(View root) {
        btnAddIncome = (Button) root.findViewById(R.id.btn_add_income);
        btnAddExpense = (Button) root.findViewById(R.id.btn_add_expense);
        btnAddIncome.setOnClickListener(this);
        btnAddExpense.setOnClickListener(this);

        tvDate = (TextView) root.findViewById(R.id.tv_date);
        tvSummary = (TextView) root.findViewById(R.id.tv_summary);
        tvItem = (TextView) root.findViewById(R.id.tv_list_item);
    }

//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

    @Override
    public void showDate() {

    }

    @Override
    public void showItem(List<Money> moneys) {

    }

    @Override
    public void showNoItem() {

    }

    @Override
    public void showSummary() {

    }

    @Override
    public void showIncome() {
        Intent intent = new Intent(getContext(), AddIncomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void showExpense() {
        Intent intent = new Intent(getContext(), AddExpenseActivity.class);
        startActivity(intent);
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mainPresenter = presenter;
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
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_income: {
                mainPresenter.addIncome();
                break;
            }
            case R.id.btn_add_expense: {
                mainPresenter.addExpense();
                break;
            }
        }
    }
}
