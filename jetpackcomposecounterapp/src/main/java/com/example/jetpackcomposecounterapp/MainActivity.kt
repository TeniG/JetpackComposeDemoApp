package com.example.jetpackcomposecounterapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpackcomposecounterapp.ui.theme.ComposeDemoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoAppTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // IncrementCounterButton()

                    /* 1: remember mutableIntStateOf */
//                    var count by remember {
//                        mutableIntStateOf(0)
//                    }

                    /* 2: rememberSaveable : to retain state even after rotation, language change.
                     But not useful for large data structures, instead use ViewModel.*/

//                    var count by rememberSaveable {
//                        mutableIntStateOf(0)
//                    }

                    /* 3: ViewModel */
                    val viewModel = viewModel<MainViewModel>()
                    val  count = viewModel.count
                    ButtonWithComposableStateless(count) {
                        viewModel.incrementCounter()
                    }
                }
            }

        }
    }
}

//Uni Directional flow : State goes from top to bottom and data goes from bottom to top
@Composable
fun ButtonWithComposableStateless(currentCounter : Int, updateCount: (Int) -> Unit) {
    val context = LocalContext.current

    Button(onClick = {
        updateCount(currentCounter)
        Toast.makeText(context, "Count : $currentCounter", Toast.LENGTH_SHORT).show()
    },
        contentPadding = PaddingValues(16.dp),
        border = BorderStroke(1.dp, color = Color.Black),
        colors = ButtonDefaults.textButtonColors(
            containerColor = Color.Cyan,
            contentColor = Color.Black
        )
    ) {
        Text ("Count : $currentCounter",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(5.dp)
        )
    }
}


@Composable
fun IncrementCounterButton() {
    val context = LocalContext.current
    var count by remember {
        mutableIntStateOf(0)
    }

    Button(onClick = {
        count += 1
        Toast.makeText(context, "Count : $count", Toast.LENGTH_SHORT).show()
    },
        contentPadding = PaddingValues(16.dp),
        border = BorderStroke(1.dp, color = Color.Black),
        colors = ButtonDefaults.textButtonColors(
            containerColor = Color.Cyan,
            contentColor = Color.Black
        )
    ) {
        Text ("Count : ${count}",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(5.dp)
        )
    }
}

