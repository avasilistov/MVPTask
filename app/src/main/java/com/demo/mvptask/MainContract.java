package com.demo.mvptask;

public interface MainContract {

    interface Callback {

    }

    interface View {
        void setResult(String result, String flag);


    }

    interface Presenter {
        void calculate();

        void setResult(String result, String flag);

        public void onDestroy();
    }

    interface Repository {

        void calculate();
    }
}
