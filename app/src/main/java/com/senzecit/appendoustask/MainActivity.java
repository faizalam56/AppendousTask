package com.senzecit.appendoustask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.senzecit.appendoustask.asymmetricgridview.AsymmetricItem;
import com.senzecit.appendoustask.asymmetricgridview.AsymmetricRecyclerView;
import com.senzecit.appendoustask.asymmetricgridview.AsymmetricRecyclerViewAdapter;
import com.senzecit.appendoustask.asymmetricgridview.Utils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final DemoUtils demoUtils = new DemoUtils();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AsymmetricRecyclerView recyclerView = (AsymmetricRecyclerView) findViewById(R.id.recyclerView);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(demoUtils.moarItems(50));
        recyclerView.setRequestedColumnCount(3);
        recyclerView.setDebugging(true);
        recyclerView.setRequestedHorizontalSpacing(Utils.dpToPx(this, 3));
        recyclerView.addItemDecoration(
                new SpacesItemDecoration(getResources().getDimensionPixelSize(R.dimen.recycler_padding)));

        recyclerView.setAdapter(new AsymmetricRecyclerViewAdapter<>(this, recyclerView, adapter));


    }
}
