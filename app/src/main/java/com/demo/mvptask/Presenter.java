package com.demo.mvptask;

public class Presenter implements MainContract.Presenter, MainContract.Callback {
    private MainContract.View view;
    private final Repository repository;

    public Presenter(MainContract.View view) {
        this.view = view;
        repository = new Repository(this);
    }

    @Override
    public void calculate() {
        clearTxtCells();
        repository.calculate();
    }

    // Clear textView's result cells before calculating
    private void clearTxtCells() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                setResult("", "" + i + j);
            }

        }
    }

    @Override
    public void setResult(String result, String flag) {
        view.setResult(result, flag);
    }


    @Override
    public void onDestroy() {
        view = null;
    }
}
