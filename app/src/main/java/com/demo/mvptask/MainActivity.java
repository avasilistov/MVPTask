package com.demo.mvptask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainContract.View, MainContract.Callback {
    private final MainContract.Presenter presenter = new Presenter(this);
    private TextView txtArrayAddMid, txtLinkedAddMid, txtCopyAddMid, txtArrayRemoveMid, txtLinkedRemoveMid, txtCopyRemoveMid, txtArraySearch, txtLinkedSearch, txtCopySearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtArrayAddMid = findViewById(R.id.add_mid_result_array);
        txtLinkedAddMid = findViewById(R.id.add_mid_result_linked);
        txtCopyAddMid = findViewById(R.id.add_mid_result_copy);
        txtArrayRemoveMid = findViewById(R.id.remove_mid_result_array);
        txtLinkedRemoveMid = findViewById(R.id.remove_mid_result_linked);
        txtCopyRemoveMid = findViewById(R.id.remove_mid_result_copy);
        txtArraySearch = findViewById(R.id.search_result_array);
        txtLinkedSearch = findViewById(R.id.search_result_linked);
        txtCopySearch = findViewById(R.id.search_result_copy);
        Button button = findViewById(R.id.calculate);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button.setOnClickListener(v -> presenter.calculate());


    }

    @Override
    public void setResult(String result, String flag) {
        runOnUiThread(() -> {
            switch (flag) {
                case "00":
                    txtArrayAddMid.setText(result);
                    break;

                case "01":
                    txtLinkedAddMid.setText(result);
                    break;

                case "02":
                    txtCopyAddMid.setText(result);
                    break;

                case "10":
                    txtArrayRemoveMid.setText(result);
                    break;

                case "11":
                    txtLinkedRemoveMid.setText(result);
                    break;

                case "12":
                    txtCopyRemoveMid.setText(result);
                    break;

                case "20":
                    txtArraySearch.setText(result);
                    break;

                case "21":
                    txtLinkedSearch.setText(result);
                    break;

                case "22":
                    txtCopySearch.setText(result);
                    break;
            }
        });
    }


    @Override
    protected void onDestroy() {
        //Delete the link to the MainActivity
        presenter.onDestroy();
        super.onDestroy();
    }
}