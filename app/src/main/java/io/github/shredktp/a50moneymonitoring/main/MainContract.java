package io.github.shredktp.a50moneymonitoring.main;

import java.util.List;

import io.github.shredktp.a50moneymonitoring.BasePresenter;
import io.github.shredktp.a50moneymonitoring.BaseView;
import io.github.shredktp.a50moneymonitoring.data.Money;

/**
 * Created by Korshreddern on 27-Feb-17.
 */

public interface MainContract {
    interface View extends BaseView<Presenter>{
        void showDate();

        void showItem(List<Money> moneys);
        void showNoItem();

        void showSummary();

        void showIncome();
        void showExpense();
    }

    interface Presenter extends BasePresenter {
        void getDate();

        void loadItem(List<Money> moneyToShow);

        void calculateSummary();

        void addIncome();
        void addExpense();

        void loadData();
    }
}
