package com.ccormor392.retrofit.mainScreen.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.ccormor392.retrofit.mainScreen.ui.model.User


@Composable
fun UserList(users: List<User>) {
    LazyColumn {
        items(users) { user ->
            Text(user.login)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserScreen(viewModel: UserViewModel) {
    val users by viewModel.users.observeAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Lista de Usuarios") },
                actions = {
                    Button(onClick = { viewModel.loadUsers() }) {
                        Text(text = "Buscar")
                    }
                }
            )
        },
        content = {
            Column(Modifier.fillMaxSize()) {
                if (users != null) {
                    UserList(users!!)
                } else {
                    CircularProgressIndicator()
                }
            }
        }
    )
}


