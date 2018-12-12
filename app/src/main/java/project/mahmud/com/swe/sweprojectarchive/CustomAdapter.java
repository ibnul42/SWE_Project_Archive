package project.mahmud.com.swe.sweprojectarchive;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>
{

    private Context context;
    private List<Model>models;
    private LayoutInflater inflater;

    public CustomAdapter(Context context, List<Model>model)
    {
        this.context = context;
        this.models = model;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.value_model,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Model model = models.get(i);
        viewHolder.setListener();
        viewHolder.setData(model,i);
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        TextView txtText1,txtText2,txtText3;
        private CardView cardView;


        private ViewHolder(View view)
        {
            super(view);
            txtText1 = view.findViewById(R.id.text1);
            txtText2 = view.findViewById(R.id.text2);
            txtText3 = view.findViewById(R.id.text3);
            cardView = view.findViewById(R.id.cardLayout);
        }

        private void setData(Model model,int pos)
        {
            txtText1.setText(model.getText1());
            txtText2.setText(model.getText2());
            txtText3.setText(model.getText3());
        }

        private void setListener()
        {
            cardView.setOnClickListener(CustomAdapter.ViewHolder.this);
        }

        @Override
        public void onClick(View v) {
            switch(v.getId())
            {
                case R.id.cardLayout:
                    Intent intent=new Intent(context,Submit.class);
                    context.startActivity(intent);
                    break;
            }
        }
    }
}
