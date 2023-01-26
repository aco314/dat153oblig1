package com.example.dat153oblig1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Comparator;

public class DatabaseActivity extends AppCompatActivity implements AddCardDialogFragment.AddCardDialogListener {

    ApplicationData appData;
    ArrayList<QuizCard> cards;
    String sortedBy;

    RecyclerView rView;
    FloatingActionButton databaseAddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        appData = ((ApplicationData) getApplicationContext());
        cards = appData.getCards();
        sortedBy = "added";

        databaseAddButton = (FloatingActionButton) findViewById(R.id.databaseAddButton);
        databaseAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddCardDialogFragment dialogFragment = new AddCardDialogFragment();
                dialogFragment.show(getSupportFragmentManager(), "dialogB");
            }
        });

        // Add divider line between RecyclerView items
        rView = (RecyclerView) findViewById(R.id.cardsView);
        rView.addItemDecoration(new DividerItemDecoration(getApplicationContext(),
                DividerItemDecoration.VERTICAL));

        updateRView();
        rView.setLayoutManager(new LinearLayoutManager(this));

        // Make the RecyclerView items swipeable
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(rView);
    }

    // "Add" button pressed in the "Add new card"-dialog
    @Override
    public void onDialogPositiveClick(QuizCard newCard) {
        appData.addCard(newCard);
        updateRView();
        Snackbar.make(rView, "Item Added!", Snackbar.LENGTH_LONG).show();
    }

    // Function to add the "Sort" button to the action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Function to sort the RecyclerView from button input
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.sortByAdded:
                sortedBy = "added";
                updateRView();
                return true;
            case R.id.sortByAlpha:
                sortedBy = "alpha";
                updateRView();
                return true;
            case R.id.sortByReverse:
                sortedBy = "reverse";
                updateRView();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Function to refresh the RecyclerView content, with the same sorting as in previous refresh
    private void updateRView() {
        QuizCardsAdapter adapter;
        switch (sortedBy) {
            case "added":  // Added order
                cards = appData.getCards();
                break;
            case "alpha":  // Sorted A-Z order
                // Cloning list instead of using reference. Otherwise the original list will be changed
                cards = new ArrayList<QuizCard>(appData.getCards());
                cards.sort(Comparator.comparing(QuizCard::getCorrectAns));
                break;
            case "reverse":  // Reversed Z-A order
                cards = new ArrayList<QuizCard>(appData.getCards());
                cards.sort(Comparator.comparing(QuizCard::getCorrectAns).reversed());
                break;
        }
        adapter = new QuizCardsAdapter(cards);
        rView.setAdapter(adapter);
    }

    // For swiping a RecyclerView item
    ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        // Delete card after swiping it to left
        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            Snackbar.make(rView, "Item Deleted!", Snackbar.LENGTH_LONG).show();
            QuizCard deleted = cards.get(viewHolder.getAdapterPosition());
            appData.getCards().remove(deleted);
            updateRView();
        }

        // Delete the card after swiping it 70% left of screen
        @Override
        public float getSwipeThreshold(@NonNull RecyclerView.ViewHolder viewHolder) {
            return 0.7f;
        }

        // Make the background color red of the View that is being swiped
        @Override
        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

            View itemView = viewHolder.itemView;
            int itemHeight = itemView.getHeight();

            boolean isCancelled = dX == 0 && !isCurrentlyActive;

            if (isCancelled) {
                Paint  mClearPaint = new Paint();
                mClearPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                c.drawRect(itemView.getRight() + dX, (float) itemView.getTop(), (float) itemView.getRight(), (float) itemView.getBottom(), mClearPaint);
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
                return;
            }

            ColorDrawable mBackground = new ColorDrawable(Color.RED);
            mBackground.setBounds(itemView.getRight() + (int) dX, itemView.getTop(), itemView.getRight(), itemView.getBottom());
            mBackground.draw(c);

            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

        }
    };

}