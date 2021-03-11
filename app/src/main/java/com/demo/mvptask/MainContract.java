package com.demo.mvptask;

public interface MainContract {

    interface Callback {

    }

    interface View {
        void setResultAddArray(String result);

        void setResultAddLinked(String result);

        void setResultAddCopy(String result);

        void setResultRemoveArray(String result);

        void setResultRemoveLinked(String result);

        void setResultRemoveCopy(String result);

        void setResultSearchArray(String result);

        void setResultSearchLinked(String result);

        void setResultSearchCopy(String result);

    }

    interface Presenter {
        void calculate();

        void setResultAddArray(String result);

        void setResultAddLinked(String result);

        void setResultAddCopy(String result);

        void setResultRemoveArray(String result);

        void setResultRemoveLinked(String result);

        void setResultRemoveCopy(String result);

        void setResultSearchArray(String result);

        void setResultSearchLinked(String result);

        void setResultSearchCopy(String result);



    }

    interface Repository {

        void calculateAddArray();

        void calculateAddLinked();

        void calculateAddCopy();

        void calculateRemoveArray();

        void calculateRemoveLinked();

        void calculateRemoveCopy();

        void calculateSearchArray();

        void calculateSearchLinked();

        void calculateSearchCopy();

        void onStartExecutor();

        void onDestroy();
    }
}
