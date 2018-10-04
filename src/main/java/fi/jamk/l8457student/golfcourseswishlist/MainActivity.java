package fi.jamk.l8457student.golfcourseswishlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // fields
    private RecyclerView mRecyclerView;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    // hard coded data
    public static ArrayList<Place> places = new Places().placeList();
    private GolfCourseWishListAdapter mAdapter;
    private boolean isListView = true;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredLayoutManager);
        mAdapter = new GolfCourseWishListAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        this.menu = menu;
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_toggle) {
            if (isListView) {
                item.setIcon(R.drawable.ic_accessibility_black_24dp);
                item.setTitle("Show as list");
                isListView = false;
                mStaggeredLayoutManager.setSpanCount(2);
            } else {
                item.setIcon(R.drawable.ic_airline_seat_recline_normal_black_24dp);
                item.setTitle("Show as grid");
                isListView = true;
                mStaggeredLayoutManager.setSpanCount(1);
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
