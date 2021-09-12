package com.example.weatherapplication.ui.current;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.weatherapplication.R;
import com.example.weatherapplication.databinding.FragmentCurrentBinding;
import com.example.weatherapplication.models.CurrentWeatherResponse;
import com.example.weatherapplication.utils.WeatherUtils;
import com.squareup.picasso.Picasso;

public class CurrentFragment extends Fragment {

    private CurrentViewModel currentViewModel;
    private FragmentCurrentBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        currentViewModel =
                new ViewModelProvider(this).get(CurrentViewModel.class);

        binding = FragmentCurrentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        String api_key = getString(R.string.appid);
        String currentWeatherEndUrl = String.format("weather?lat=%f&lon=%f&appid=%s",35.0,139.0,api_key);
        currentViewModel.getCurrentWeatherResponseData(currentWeatherEndUrl).observe(getViewLifecycleOwner(), new
                Observer<CurrentWeatherResponse>() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onChanged(CurrentWeatherResponse currentWeatherResponse) {
                        binding.textCity.setText(currentWeatherResponse.getName());
                        binding.textCurrentDate.setText(WeatherUtils.getFormattedDate(currentWeatherResponse.getDt()));
                        Picasso.get().load(WeatherUtils.getImageUrl(currentWeatherResponse.getWeather().get(0).getIcon())).into(binding.currentIcon);
                    }
                });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}