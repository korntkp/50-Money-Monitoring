package io.github.shredktp.a50moneymonitoring.main;

import java.util.ArrayList;
import java.util.List;

import io.github.shredktp.a50moneymonitoring.data.Money;

/**
 * Created by Korshreddern on 27-Feb-17.
 */

public class MainPresenter implements MainContract.Presenter {

    // TODO: 28-Feb-17 Repo
    private MainContract.View mainView;

    public MainPresenter(MainContract.View mainView) {
        this.mainView = mainView;
        mainView.setPresenter(this);
    }

    @Override
    public void getDate() {
        mainView.showDate();
    }

    @Override
    public void loadItem(List<Money> moneyToShow) {
        mainView.showItem(moneyToShow);
    }

    @Override
    public void calculateSummary() {

    }

    @Override
    public void addIncome() {
        mainView.showIncome();
    }

    @Override
    public void addExpense() {
        mainView.showExpense();
    }

    @Override
    public void start() {
        loadData();
    }

    @Override
    public void loadData() {
        List<Money> moneyToShow = new ArrayList<Money>();
        // TODO: 28-Feb-17 Repo.get xxx

        loadItem(moneyToShow);
        calculateSummary();
    }
}
