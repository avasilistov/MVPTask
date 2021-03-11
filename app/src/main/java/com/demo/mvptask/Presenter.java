package com.demo.mvptask;

public class Presenter implements MainContract.Presenter, MainContract.Callback {
    private final MainContract.View view;
    private final Repository repository;

    public Presenter(MainContract.View view) {
        this.view = view;
        repository = new Repository(this);
    }

    @Override
    public void calculate() {
        setResultAddArray("");
        setResultAddLinked("");
        setResultAddCopy("");
        setResultRemoveArray("");
        setResultRemoveLinked("");
        setResultRemoveCopy("");
        setResultSearchArray("");
        setResultSearchLinked("");
        setResultSearchCopy("");
        repository.onStartExecutor();
        repository.calculateAddArray();
        repository.calculateAddLinked();
        repository.calculateAddCopy();
        repository.calculateRemoveArray();
        repository.calculateRemoveLinked();
        repository.calculateRemoveCopy();
        repository.calculateSearchArray();
        repository.calculateSearchLinked();
        repository.calculateSearchCopy();
        repository.onDestroy();

    }



    @Override
    public void setResultAddArray(String result) {
        view.setResultAddArray(result);
    }

    @Override
    public void setResultAddLinked(String result) {
        view.setResultAddLinked(result);
    }

    @Override
    public void setResultAddCopy(String result) {
        view.setResultAddCopy(result);
    }

    @Override
    public void setResultRemoveArray(String result) {
        view.setResultRemoveArray(result);
    }

    @Override
    public void setResultRemoveLinked(String result) {
        view.setResultRemoveLinked(result);
    }

    @Override
    public void setResultRemoveCopy(String result) {
        view.setResultRemoveCopy(result);
    }

    @Override
    public void setResultSearchArray(String result) {
        view.setResultSearchArray(result);
    }

    @Override
    public void setResultSearchLinked(String result) {
        view.setResultSearchLinked(result);
    }

    @Override
    public void setResultSearchCopy(String result) {
        view.setResultSearchCopy(result);
    }


}
