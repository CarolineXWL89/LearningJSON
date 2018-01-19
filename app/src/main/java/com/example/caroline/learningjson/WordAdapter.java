package com.example.caroline.learningjson;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by princ on 19/01/2018.
 */

//bridge the data in your List to the view
public class WordAdapter extends RecyclerView.Adapter<WordAdapter.MyViewHolder> {

    private Context context;
    private List<WordObject> words;

    public WordAdapter(Context context, List<WordObject> words) {
        this.context = context;
        this.words = words;
    }

    //creates the ViewHolder by inflating the layout and returning it
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.word_item, parent, false);


        return new MyViewHolder(itemView);
    }

    //Assigns the appropriate information from the word object to each widget in the layout
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //l: get the object at the position from the list
        WordObject wordObject = words.get(position);
        //set
        holder.titleText.setText(wordObject.getWord());
        holder.scoreText.setText(wordObject.getScore());

    }

    //Counts number in the list
    @Override
    public int getItemCount() {
        return words.size();
    }

    /*making an inner class b/c we want it to have access to vars in the outer class WordAdapter
        inside we wire the widgets for our layout + onClickListening and stuff
         */
    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView titleText, scoreText;


        //do the wiring in here
        public MyViewHolder(View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.wordTextView);
            scoreText = itemView.findViewById(R.id.scoreTextView);

            //set any listeners here if we had them
        }
    }
}
