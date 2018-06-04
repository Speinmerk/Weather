package ru.speinmerk.weather.fragment.CityList;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ru.speinmerk.weather.R;
import ru.speinmerk.weather.model.City;

public class CityListAdapter extends RecyclerView.Adapter<CityListAdapter.ViewHolder> {

    private ArrayList<City> cities = new ArrayList<>();
    private OnSelectedCityListener listener;

    CityListAdapter(OnSelectedCityListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_city_list, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(cities.get(position));
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    public void setData(List<City> cities) {
        this.cities.clear();
        this.cities.addAll(cities);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView;
        }

        void bind(City city) {
            textView.setText(city.name);
            textView.setOnClickListener(v -> listener.onSelectedCity(city));
        }
    }

    interface OnSelectedCityListener {
        void onSelectedCity(City city);
    }
}
