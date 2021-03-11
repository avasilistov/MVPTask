package com.demo.mvptask;

import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository implements MainContract.Repository {
    private final MainContract.Presenter callback;
    private ExecutorService executor = Executors.newFixedThreadPool(5);

    public Repository(MainContract.Presenter callback) {
        this.callback = callback;
    }


    private String getAddTime(List<Integer> list) {
        Long start = System.currentTimeMillis();
        list.add(Math.round(list.size() / 2), 1);
        Long end = System.currentTimeMillis() - start;
        String result = end + " ms";
        Log.i("getTime", list.getClass().toString() + " " + result);
        return result;
    }

    private String getRemTime(List<Integer> list) {
        Long start = System.currentTimeMillis();
        list.remove(Math.round(list.size() / 2));
        Long end = System.currentTimeMillis() - start;
        String result = end + " ms";
        Log.i("getTime", list.getClass().toString() + " remove " + result);
        return result;
    }

    private String getSearchTime(List<Integer> list) {

        Long start = System.currentTimeMillis();
        list.indexOf(1);
        Long end = System.currentTimeMillis() - start;
        String result = end + " ms";
        Log.i("getTime", list.getClass().toString() + " remove " + result);
        return result;
    }

    private List<Integer> makeList(int num) {
        List<Integer> list;

        switch (num) {
            case 1:
                list = new ArrayList<>();
                break;
            case 2:
                list = new LinkedList<>();
                break;
            case 3:
                list = new ArrayList<>();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + num);
        }

//        Random random = new Random();

        int size = 10000000;
        for (int i = 0; i < size; i++) {

            if (i == Math.round(size / 2)) {
                list.add(1);
            } else list.add(0);


        }
        if (num == 3) {
            list = new CopyOnWriteArrayList<>(list);
        }
        Log.i("getTime", list.getClass().toString() + " created ");
        return list;
    }


    @Override
    public void calculateAddArray() {
        executor.execute(() -> {
            callback.setResultAddArray(getAddTime(makeList(1)));
        });

    }


    @Override
    public void calculateAddLinked() {
        executor.execute(() -> {
            callback.setResultAddLinked(getAddTime(makeList(2)));
        });

    }

    @Override
    public void calculateAddCopy() {
        executor.execute(() -> {
            callback.setResultAddCopy(getAddTime(makeList(3)));
        });

    }

    @Override
    public void calculateRemoveArray() {
        executor.execute(() -> {
            callback.setResultRemoveArray(getRemTime(makeList(1)));
        });

    }

    @Override
    public void calculateRemoveLinked() {
        executor.execute(() -> {
            callback.setResultRemoveLinked(getRemTime(makeList(2)));
        });

    }

    @Override
    public void calculateRemoveCopy() {
        executor.execute(() -> {
            callback.setResultRemoveCopy(getRemTime(makeList(3)));
        });

    }

    @Override
    public void calculateSearchArray() {
        executor.execute(() -> {
            callback.setResultSearchArray(getSearchTime(makeList(1)));
        });

    }

    @Override
    public void calculateSearchLinked() {
        executor.execute(() -> {
            callback.setResultSearchLinked(getSearchTime(makeList(2)));
        });

    }

    @Override
    public void calculateSearchCopy() {
        executor.execute(this::run);

    }

    @Override
    public void onDestroy() {
        executor.shutdown();
    }

    private void run() {
        callback.setResultSearchCopy(getSearchTime(makeList(3)));
    }
}
