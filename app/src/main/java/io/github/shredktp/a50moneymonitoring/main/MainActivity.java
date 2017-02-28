package io.github.shredktp.a50moneymonitoring.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import io.github.shredktp.a50moneymonitoring.R;
import io.github.shredktp.a50moneymonitoring.add_expense.AddExpenseActivity;
import io.github.shredktp.a50moneymonitoring.add_income.AddIncomeActivity;
import io.github.shredktp.a50moneymonitoring.data.Money;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MainContract.View {

    private Button btnAddIncome, btnAddExpense;
    private TextView tvDate, tvSummary;
    private TextView tvItem;

    private MainContract.Presenter mainPresenter;
//    private MainView mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupView();

        mainPresenter = new MainPresenter(this);
    }

    private void setupView() {
        btnAddIncome = (Button) findViewById(R.id.btn_add_income);
        btnAddExpense = (Button) findViewById(R.id.btn_add_expense);
        btnAddIncome.setOnClickListener(this);
        btnAddExpense.setOnClickListener(this);

        tvDate = (TextView) findViewById(R.id.tv_date);
        tvSummary = (TextView) findViewById(R.id.tv_summary);
        tvItem = (TextView) findViewById(R.id.tv_list_item);
    }

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
        Intent intent = new Intent(MainActivity.this, AddIncomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void showExpense() {
        Intent intent = new Intent(MainActivity.this, AddExpenseActivity.class);
        startActivity(intent);
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mainPresenter = presenter;
    }
}
