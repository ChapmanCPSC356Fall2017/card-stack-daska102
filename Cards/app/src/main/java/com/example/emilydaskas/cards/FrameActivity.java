package com.example.emilydaskas.cards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.Stack;
import android.graphics.drawable.Drawable;
import android.graphics.Color;

public class FrameActivity extends AppCompatActivity {

    private TextView tv_upper;
    private TextView tv_lower;
    private ImageView iv_main;
    private ImageView iv_upper;
    private ImageView iv_lower;



    private Stack<CardDeck> cardDeckStack;

    private String[] cardNumberArray = new String[]{"2","3","4","5","6","7","8","9","10","J","Q","K","A"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        this.iv_lower = (ImageView) findViewById(R.id.iv_upper);
        this.iv_main = (ImageView) findViewById(R.id.iv_main);
        this.iv_upper = (ImageView) findViewById(R.id.iv_lower);
        this.tv_lower = (TextView) findViewById(R.id.tv_lower);
        this.tv_upper = (TextView) findViewById(R.id.tv_upper);



        this.cardDeckStack = new Stack<>();

        for (int i = 0; i < cardNumberArray.length; ++i)
        {
            this.cardDeckStack.push(new CardDeck(cardNumberArray[i], CardDeck.Suit.SPADE));
            this.cardDeckStack.push(new CardDeck(cardNumberArray[i], CardDeck.Suit.DIAMOND));
            this.cardDeckStack.push(new CardDeck(cardNumberArray[i], CardDeck.Suit.CLUB));
            this.cardDeckStack.push(new CardDeck(cardNumberArray[i], CardDeck.Suit.HEART));
        }

        Collections.shuffle(cardDeckStack);

        generateRandomCard();

    }

    public void generateRandomCard() {

        CardDeck card = cardDeckStack.pop();

        tv_upper.setText(card.getNumber());
        tv_lower.setText(card.getNumber());

        if (card.getSuit() == CardDeck.Suit.SPADE)
        {
            iv_lower.setImageResource(R.drawable.spade);
            iv_upper.setImageResource(R.drawable.spade);
            iv_main.setImageResource(R.drawable.spade);
            tv_lower.setTextColor(getResources().getColor(R.color.black));
            tv_upper.setTextColor(getResources().getColor(R.color.black));
        }
        else if (card.getSuit() == CardDeck.Suit.DIAMOND)
        {
            iv_lower.setImageResource(R.drawable.diamond);
            iv_upper.setImageResource(R.drawable.diamond);
            iv_main.setImageResource(R.drawable.diamond);
            tv_lower.setTextColor(getResources().getColor(R.color.red));
            tv_upper.setTextColor(getResources().getColor(R.color.red));
        }
        else if (card.getSuit() == CardDeck.Suit.HEART)
        {
            iv_lower.setImageResource(R.drawable.heart);
            iv_upper.setImageResource(R.drawable.heart);
            iv_main.setImageResource(R.drawable.heart);
            tv_lower.setTextColor(getResources().getColor(R.color.red));
            tv_upper.setTextColor(getResources().getColor(R.color.red));
        }
        else
        {

            iv_lower.setImageResource(R.drawable.club);
            iv_upper.setImageResource(R.drawable.club);
            iv_main.setImageResource(R.drawable.club);
            tv_lower.setTextColor(getResources().getColor(R.color.black));
            tv_upper.setTextColor(getResources().getColor(R.color.black));
        }

            /*
            else if (card.getSuit() == CardDeck.Suit.CLUB)
            {
                iv_lower.setImageResource(R.drawable.club);
                iv_upper.setImageResource(R.drawable.club);
                iv_main.setImageResource(R.drawable.club);
                //tv_lower.setTextColor();
                //tv_upper.setTextColor(Color.BLACK);
            }
            */
    }
    public void onCardClick(View view){

        if (cardDeckStack.isEmpty() == false) {
            generateRandomCard();
        }
        else
        {
            finish();
        }

    }



}
