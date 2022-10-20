package com.example.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.paging.RickMortyPaginSource
import com.example.pagingcourse.api.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RickMortyViewModel @Inject constructor(private val apiService: ApiService):ViewModel(){

    val listData = Pager(PagingConfig(pageSize = 1)){
       RickMortyPaginSource(apiService)
    }.flow.cachedIn(viewModelScope)
}