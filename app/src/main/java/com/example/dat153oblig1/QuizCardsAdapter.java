package com.example.dat153oblig1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuizCardsAdapter extends RecyclerView.Adapter<QuizCardsAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView cardImageView;
        public TextView textAlt1;
        public TextView textAlt2;
        public TextView textAlt3;

        public ViewHolder(View itemView) {
            super(itemView);

            cardImageView = (ImageView) itemView.findViewById(R.id.cardImageView);
            textAlt1 = (TextView) itemView.findViewById(R.id.textAlt1);
            textAlt2 = (TextView) itemView.findViewById(R.id.textAlt2);
            textAlt3 = (TextView) itemView.findViewById(R.id.textAlt3);
        }
    }

    private List<QuizCard> cards;

    public QuizCardsAdapter(List<QuizCard> cards) {
        this.cards = cards;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View cardView = inflater.inflate(R.layout.card_view, parent, false);

        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        QuizCard card = cards.get(position);
        holder.cardImageView.setImageURI(card.getImageLinkUri());
        holder.textAlt1.setText(card.getCorrectAns());
        holder.textAlt2.setText(card.getWrongAns1());
        holder.textAlt3.setText(card.getWrongAns2());
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public List<QuizCard> getData() {
        return this.cards;
    }


}
