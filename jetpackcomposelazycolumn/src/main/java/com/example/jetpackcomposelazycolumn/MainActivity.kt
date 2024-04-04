package com.example.jetpackcomposelazycolumn

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposelazycolumn.domain.models.TvShow
import com.example.jetpackcomposelazycolumn.presentation.TvShowInfoActivity
import com.example.jetpackcomposelazycolumn.presentation.TvShowListScreen
import com.example.jetpackcomposelazycolumn.ui.theme.ComposeDemoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.secondaryContainer
                ) {
                    //Navigate to tvShowInfoActivity
                    TvShowListScreen(){
                        Toast.makeText(this, it.name,Toast.LENGTH_LONG).show()
                        navigateToTvShowInfoActivity(this,it)
                    }

                }
            }
        }
    }
}



fun navigateToTvShowInfoActivity(context: Context, tvShow: TvShow) {
    val intent = Intent(context, TvShowInfoActivity::class.java)
    intent.putExtra("tvShow", tvShow)
    context.startActivity(intent)
}