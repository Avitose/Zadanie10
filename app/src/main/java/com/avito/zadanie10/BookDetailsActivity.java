package com.avito.zadanie10;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class BookDetailsActivity extends AppCompatActivity {
    public static final String EXTRA_TITLE = "DETAILS_TITLE";
    public static final String EXTRA_AUTHOR = "BOOK_DETAILS_AUTHOR";
    public static final String EXTRA_COVER = "BOOK_COVER";
    private TextView titleTextView;
    private TextView authorTextView;
    private ImageView cover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        titleTextView = findViewById(R.id.book_title);
        authorTextView = findViewById(R.id.book_author);
        cover = findViewById(R.id.img_cover);

        Intent starter = getIntent();
        titleTextView.setText(starter.getStringExtra(EXTRA_TITLE));
        authorTextView.setText(starter.getStringExtra(EXTRA_AUTHOR));
        String coverId = starter.getStringExtra(EXTRA_COVER);
        if (coverId != null) {
            Picasso.with(this)
                    .load(MainActivity.IMAGE_URL_BASE + coverId + "-L.jpg")
                    .placeholder(R.drawable.ic_book)
                    .into(cover);
        } else
            cover.setImageResource(R.drawable.ic_book);
    }
}
