package com.example.fitarmorapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fitarmorapp.models.Products
import com.example.fitarmorapp.network.Callback
import com.example.fitarmorapp.network.FirestoreService
import java.lang.Exception

class OrderViewModel: ViewModel() {
    val firestoreService = FirestoreService()
    val listProducts: MutableLiveData<List<Products>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refrest(){
        getProductsFromFirebase()
    }

    private fun getProductsFromFirebase() {
        firestoreService.getProducts(object : Callback<List<Products>> {

            override fun onFailed(exception: Exception) {
                processFinished()
            }

            override fun onSuccess(result: List<Products>?) {
                listProducts.postValue(result)
                processFinished()
            }

        })
    }

    fun processFinished() {
        isLoading.value = true
    }
}