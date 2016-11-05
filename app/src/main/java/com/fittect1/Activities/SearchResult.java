package com.fittect1.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.Movie;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.fittect1.R;
import com.fittect1.ResultItem;
import com.fittect1.ResultItemAdapter;
import com.fittect1.model.User;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by prasang on 21/6/16.
 */
public class SearchResult extends Activity implements AdapterView.OnItemSelectedListener{

    Spinner filterSpinner;
    private RecyclerView recyclerView;
    private ResultItemAdapter adapter;
    private List<ResultItem> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();

        setFilterSpinner();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_resultItems);
        itemList = new ArrayList<>();
        adapter = new ResultItemAdapter(this, itemList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);

        prepareAlbums();

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                ResultItem resultItem = itemList.get(position);

                // Right now I'm just adding a toast to display select item,
                // Further, later we can open an activity (just like Airbnb) to display data of that gym/sports center
                Toast.makeText(getApplicationContext(), resultItem.getName() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }


    void init() {
        setContentView(R.layout.activity_search_results);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        filterSpinner = (Spinner)findViewById(R.id.search_filter_spinner);
    }


    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private SearchResult.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final SearchResult.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }


    private void prepareAlbums() {

        //we can add as many gym's images here.
        int[] covers = new int[]{
                R.drawable.dummy_image,
                R.drawable.dummy_image2,
                R.drawable.dummy_image,
                R.drawable.dummy_image2};

        ResultItem a = new ResultItem("Gold's Gym", "Gym | Aerobics | Yoga | Zomba", "402, 4th fl, Royal Avenue", "8k - 10k", covers[0]);
        itemList.add(a);

        a = new ResultItem("Silver Gym", "Gym | Yoga | Swimming", "12D, New Palasia, Near Nafees", "12k - 14k", covers[1]);
        itemList.add(a);

        a = new ResultItem("Calvin's Gym", "Gym | Squash | Yoga | Zomba", "AM II 79, Super Corridor", "6k - 8k", covers[2]);
        itemList.add(a);

        a = new ResultItem("Hobbes Gym", "Aerobics | Yoga | Zomba", "23A, Block B, Aerodrum Rd.", "10k - 12k", covers[3]);
        itemList.add(a);

        adapter.notifyDataSetChanged();
    }

    void setFilterSpinner() {
        // For top filter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.filter_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filterSpinner.setAdapter(adapter);
        filterSpinner.setOnItemSelectedListener(this);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        if (position == 1) {
            Toast.makeText(SearchResult.this, "Filter " + position + " selected!", Toast.LENGTH_SHORT).show();
        }
        else if (position == 2) {
            Toast.makeText(SearchResult.this, "Filter " + position + " selected!", Toast.LENGTH_SHORT).show();
        }
        else if (position == 3) {
            Toast.makeText(SearchResult.this, "Filter " + position + " selected!", Toast.LENGTH_SHORT).show();
        }
    }
    public void onNothingSelected(AdapterView<?> arg0) {}
}
