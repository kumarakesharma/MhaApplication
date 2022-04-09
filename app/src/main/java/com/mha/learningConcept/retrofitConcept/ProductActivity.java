package com.mha.learningConcept.retrofitConcept;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.mha.learningConcept.R;
import com.mha.learningConcept.databinding.ActivityProductBinding;
import com.mha.learningConcept.retrofitConcept.response.CartProductQuantity;
import com.mha.learningConcept.retrofitConcept.response.CartsResponse;
import com.mha.learningConcept.retrofitConcept.response.ProductResponse;
import com.mha.learningConcept.util.Utility;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductActivity extends AppCompatActivity {
    private ActivityProductBinding binding;
    private MyRecyclerviewAdapter myRecyclerviewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FakeStoreEndPoints serviceCall = RetrofitInstance.getInstance(FakeStoreEndPoints.class);
        Call<List<ProductResponse>> callProductResponse = serviceCall.getProductResponse();
        callProductResponse.enqueue(new Callback<List<ProductResponse>>() {
            @Override
            public void onResponse(Call<List<ProductResponse>> call, Response<List<ProductResponse>> response) {
                List<ProductResponse> list = response.body();
                myRecyclerviewAdapter = new MyRecyclerviewAdapter(ProductActivity.this, list);
                binding.recyclerView.setAdapter(myRecyclerviewAdapter);
                myRecyclerviewAdapter.notifyDataSetChanged();

                binding.progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<ProductResponse>> call, Throwable t) {
                Utility.showShortToast(ProductActivity.this, t.getMessage());
                binding.progressBar.setVisibility(View.GONE);
            }
        });

//        FakeStoreEndPoints serviceCall = RetrofitInstance.getInstance(FakeStoreEndPoints.class);
//        Call<List<CartsResponse>> call = serviceCall.getCarts();
//        call.enqueue(new Callback<List<CartsResponse>>() {
//            @Override
//            public void onResponse(Call<List<CartsResponse>> call, Response<List<CartsResponse>> response) {
//                Log.d("Data", ""+response.code());
//            }
//
//            @Override
//            public void onFailure(Call<List<CartsResponse>> call, Throwable t) {
//                Utility.showShortToast(ProductActivity.this, t.getMessage());
//            }
//        });
    }
}