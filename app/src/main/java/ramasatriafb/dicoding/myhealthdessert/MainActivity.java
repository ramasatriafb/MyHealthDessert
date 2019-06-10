package ramasatriafb.dicoding.myhealthdessert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<Dessert> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list.addAll(DessertData.getListData());
        showRecyclerList();
    }

    private void showSelectedPresident(Dessert dessert){
//        Toast.makeText(this, "Kamu memilih "+dessert.getName(), Toast.LENGTH_SHORT).show();
        Intent moveWithDataIntent = new Intent(MainActivity.this, DetailActivity.class);
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_NAME,dessert.getName());
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_REMARKS, dessert.getRemarks());
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_IMAGE, dessert.getPhoto());
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_INGRADIANT, dessert.getIngrediant());
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_PROCEDURES, dessert.getProcedures());
        startActivity(moveWithDataIntent);
    }

    private void showRecyclerList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListDessertAdapter listDessertAdapter = new ListDessertAdapter(this);
        listDessertAdapter.setListDessert(list);
        rvCategory.setAdapter(listDessertAdapter);
        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedPresident(list.get(position));
            }
        });
    }
}
