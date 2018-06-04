package ru.speinmerk.weather.fragment.CityList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ru.speinmerk.weather.R;
import ru.speinmerk.weather.fragment.AddCityFragment;
import ru.speinmerk.weather.fragment.CityWeatherFragment;
import ru.speinmerk.weather.model.City;

public class CityListFragment extends Fragment implements CityListContract.View, CityListAdapter.OnSelectedCityListener {
    public static final int RC_ADD_CITY = 145;

    private CityListContract.Presenter presenter;
    private CityListAdapter adapter;

    public static CityListFragment newInstance() {
        return new CityListFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_city_list, container, false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new CityListAdapter(this);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        CityListModel model = new CityListModel();
        presenter = new CityListPresenter(model);
        presenter.attachView(this);
        presenter.viewIsReady();
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.city_list_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_city:
                presenter.onAddCity();
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onSelectedCity(City city) {
        presenter.onSelectedCity(city);
    }

    @Override
    public void showCities(ArrayList<City> cities) {
        adapter.setData(cities);
    }

    @Override
    public void showAddCityFragment() {
        FragmentManager fm = getFragmentManager();
        if (fm != null) {
            fm.beginTransaction()
                    .replace(R.id.container, AddCityFragment.newInstance(this, RC_ADD_CITY))
                    .addToBackStack(null)
                    .commit();
        }
    }

    @Override
    public void showCityWeatherFragment(City city) {
        FragmentManager fm = getFragmentManager();
        if (fm != null) {
            fm.beginTransaction()
                    .replace(R.id.container, CityWeatherFragment.newInstance(city))
                    .addToBackStack(null)
                    .commit();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_OK || data == null) {
            return;
        }
        switch (requestCode) {
            case RC_ADD_CITY:
                presenter.onResultAddCityFragment(data);
        }
    }
}
