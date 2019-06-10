package ramasatriafb.dicoding.myhealthdessert;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_REMARKS = "REMARKS";
    public static final String EXTRA_NAME = "NAME";
    public static final String EXTRA_IMAGE = "PHOTO";
    public static final String EXTRA_INGRADIANT = "INGRADIANT";
    public static final String EXTRA_PROCEDURES = "PROCEDURES";


    TextView titleDessert;
    TextView nutritionDessert;
    TextView ingrediantDessert;
    TextView proceduresDessert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        imgPhoto = findViewById(R.id.img_item_photo);
        titleDessert = findViewById(R.id.titleDessert);
        nutritionDessert = findViewById(R.id.nutrition);
        ingrediantDessert = findViewById(R.id.ingrediant);
        proceduresDessert = findViewById(R.id.procedures);
        String name = getIntent().getStringExtra(EXTRA_NAME);
        String remarks = getIntent().getStringExtra(EXTRA_REMARKS);
        String ingradiant = getIntent().getStringExtra(EXTRA_INGRADIANT);
        String procedures = getIntent().getStringExtra(EXTRA_PROCEDURES);
        //tvDataReceived.setText(text);
        String photo = getIntent().getStringExtra(EXTRA_IMAGE);

        new DownloadImageFromInternet((ImageView) findViewById(R.id.img_item_photo))
                .execute(photo);
        titleDessert.setText(name);
        nutritionDessert.setText(remarks);
        ingrediantDessert.setText(ingradiant);
        proceduresDessert.setText(procedures);



    }

    private class DownloadImageFromInternet extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;

        public DownloadImageFromInternet(ImageView imageView) {
            this.imageView = imageView;
            Toast.makeText(getApplicationContext(), "Data Sedang Dimuat ...", Toast.LENGTH_SHORT).show();
        }

        protected Bitmap doInBackground(String... urls) {
            String imageURL = urls[0];
            Bitmap bimage = null;
            try {
                InputStream in = new java.net.URL(imageURL).openStream();
                bimage = BitmapFactory.decodeStream(in);

            } catch (Exception e) {
                Log.e("Error Message", e.getMessage());
                e.printStackTrace();
            }
            return bimage;
        }

        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }
    }
}
