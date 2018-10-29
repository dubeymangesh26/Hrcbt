package hrcbetaversion.com.hrcbt.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import hrcbetaversion.com.hrcbt.R;
import hrcbetaversion.com.hrcbt.Response.DiagonsticResponse;

public class DatadisplyAdapter extends RecyclerView.Adapter<DatadisplyAdapter.ProgrammingViewHolder> {
    List<DiagonsticResponse.ResponseBean> data;
    Context context;

    public DatadisplyAdapter(Context datadisplay, List<DiagonsticResponse.ResponseBean> response) {
        this.data = response;
        this.context = context;

    }


    @Override
    public ProgrammingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_layout, parent, false);
        return new ProgrammingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProgrammingViewHolder programmingViewHolder, int position) {
        programmingViewHolder.textTitle.setText(data.get(position).getCenterName());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ProgrammingViewHolder extends RecyclerView.ViewHolder{
        TextView textTitle;

        public ProgrammingViewHolder(View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);


        }
    }
}
