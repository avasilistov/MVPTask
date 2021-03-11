package com.demo.mvptask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainContract.View, MainContract.Callback {
    private final MainContract.Presenter presenter = new Presenter(this);
    private TextView addResArr, addResLink, addResCopy, remResArr, remResLink, remResCopy, searchResArr, searchResLink, searchResCopy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addResArr = findViewById(R.id.add_mid_result_array);
        addResLink = findViewById(R.id.add_mid_result_linked);
        addResCopy = findViewById(R.id.add_mid_result_copy);
        remResArr = findViewById(R.id.remove_mid_result_array);
        remResLink = findViewById(R.id.remove_mid_result_linked);
        remResCopy = findViewById(R.id.remove_mid_result_copy);
        searchResArr = findViewById(R.id.search_result_array);
        searchResLink = findViewById(R.id.search_result_linked);
        searchResCopy = findViewById(R.id.search_result_copy);
        Button button = findViewById(R.id.calculate);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button.setOnClickListener(v -> presenter.calculate());


    }

    @Override
    public void setResultAddArray(String result) {
        runOnUiThread(() -> addResArr.setText(result));
    }

    @Override
    public void setResultAddLinked(String result) {
        runOnUiThread(() -> addResLink.setText(result));
    }

    @Override
    public void setResultAddCopy(String result) {
        runOnUiThread(() -> addResCopy.setText(result));
    }

    @Override
    public void setResultRemoveArray(String result) {
        runOnUiThread(() -> remResArr.setText(result));
    }

    @Override
    public void setResultRemoveLinked(String result) {
        runOnUiThread(() -> remResLink.setText(result));
    }

    @Override
    public void setResultRemoveCopy(String result) {
        runOnUiThread(() -> remResCopy.setText(result));
    }

    @Override
    public void setResultSearchArray(String result) {
        runOnUiThread(() -> searchResArr.setText(result));
    }

    @Override
    public void setResultSearchLinked(String result) {
        runOnUiThread(() -> searchResLink.setText(result));
    }

    @Override
    public void setResultSearchCopy(String result) {
        runOnUiThread(() -> searchResCopy.setText(result));
    }
}