package ru.speinmerk.weather.fragment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import ru.speinmerk.weather.R;
import ru.speinmerk.weather.model.City;

public class AddCityFragment extends Fragment {

    public static AddCityFragment newInstance(Fragment parent, int requestCode) {
        AddCityFragment fragment = new AddCityFragment();
        fragment.setTargetFragment(parent, requestCode);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_city, container, false);
        TextInputLayout tilCity = view.findViewById(R.id.til_name_city);
        EditText etCity = view.findViewById(R.id.name_city);
        view.findViewById(R.id.add_city).setOnClickListener(v -> {
            String cityName = etCity.getText().toString();
            if (cityName.isEmpty()) {
                tilCity.setError(getString(R.string.enter_city));
                return;
            }
            Fragment fragment = getTargetFragment();
            if (fragment != null) {
                Intent intent = new Intent();
                intent.putExtra(City.KEY_PARCELABLE, new City(cityName));
                fragment.onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, intent);
                getActivity().onBackPressed();
            }
        });
        return view;
    }

}
