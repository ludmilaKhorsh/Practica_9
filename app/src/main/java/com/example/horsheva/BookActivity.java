package com.example.horsheva;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import java.util.UUID;

public class BookActivity extends AppCompatActivity {
    public static final String EXTRA_BOOK_ID = "ru.rsue.android.bookdepository.book_id";

    public static Intent newIntent(Context packageContext, UUID bookId) {
        Intent intent = new Intent(packageContext, BookActivity.class);
        intent.putExtra(EXTRA_BOOK_ID, bookId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        FragmentManager fm = getSupportFragmentManager();
        BookFragment fragment = (BookFragment) fm.findFragmentById(R.id.fragmentContainer);

        if (fragment == null) {
            UUID bookId = (UUID) getIntent().getSerializableExtra(EXTRA_BOOK_ID);
            fragment = BookFragment.newInstance(bookId);
            fm.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit();
        }
    }
}