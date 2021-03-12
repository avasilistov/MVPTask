package com.demo.mvptask;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository implements MainContract.Repository {
    private final MainContract.Presenter callback;
    private ExecutorService executor;

    public Repository(MainContract.Presenter callback) {
        this.callback = callback;
    }


    // Get addMid operation time
    private String getAddTime(List<Byte> list) {
        Long start = System.currentTimeMillis();
        list.add(Math.round(list.size() / 2), (byte) 1);
        Long end = System.currentTimeMillis() - start;
        String result = end + " ms";
        Log.i("getTime", list.getClass().toString() + " " + result);
        return result;
    }

    // Get removeMid operation time
    private String getRemoveTime(List<Byte> list) {
        Long start = System.currentTimeMillis();
        list.remove(Math.round(list.size() / 2));
        Long end = System.currentTimeMillis() - start;
        String result = end + " ms";
        Log.i("getTime", list.getClass().toString() + " remove " + result);
        return result;
    }

    // Get search operation time
    private String getSearchTime(List<Byte> list) {

        Long start = System.currentTimeMillis();
        list.indexOf(10);
        Long end = System.currentTimeMillis() - start;
        String result = end + " ms";
        return result;
    }

    // Make the required list
    private List<Byte> makeList(int listKind) {
        List<Byte> list;
        int size = 10000000;
        switch (listKind) {
            case 0:
                list = new ArrayList<>(Collections.nCopies(size, (byte) 1));
                break;
            case 1:
                list = new LinkedList<>(Collections.nCopies(size, (byte) 1));
                break;
            case 2:
                list = new CopyOnWriteArrayList<>(Collections.nCopies(size, (byte) 1));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + listKind);
        }
        list.set(Math.round(size / 2), (byte) 10);
        return list;
    }

    @Override
    public void calculate() {
        executor = Executors.newFixedThreadPool(4);
        for (int operationKind = 0; operationKind < 3; operationKind++) {
            for (int listKind = 0; listKind < 3; listKind++) {
                executor.execute(new Calculator(operationKind, listKind));
            }

        }
        executor.shutdown();
    }

    public class Calculator implements Runnable {
        private Integer operationKind;
        private Integer listKind;

        public Calculator(Integer operationKind, Integer listKind) {
            this.operationKind = operationKind;
            this.listKind = listKind;
        }

        public void run() {
            List<Byte> list = makeList(listKind);
            String time = makeOperation(operationKind, list);
            String flag = "" + operationKind + listKind;
            callback.setResult(time, flag);
        }
    }

    private String makeOperation(Integer operationKind, List<Byte> list) {
        switch (operationKind) {
            case 0:
                return getAddTime(list);
            case 1:
                return getRemoveTime(list);
            case 2:
                return getSearchTime(list);
            default:
                return "";
        }
    }

}
