package com.example.dogapp.ui.screens.home

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import kotlin.math.roundToInt

@Composable
fun HomeScreen(
    homeModel: HomeViewModel
) {
    val homeState = homeModel.state
    val context = LocalContext.current

     Surface(modifier = Modifier.fillMaxSize(),
         color = Color.White){
         LazyColumn(state = rememberLazyListState(),
             modifier = Modifier.fillMaxSize()){
//             itemsIndexed(items = homeModel.state.dogBreed,
//                 key = { _: Int, item : DogBreed ->
//                     item.hashCode()
//                 }
//             ){_: Int,item: HomeViewModel ->
//                 ListItemView(context = context, model = item, onDelete = {
//                     list.remove()
//                 })
//             }
         }
     }
}






@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ListItemView(context: Context, model: HomeViewModel, onDelete: () -> Unit) {

    val swipeableState = rememberSwipeableState(initialValue = 0)
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .swipeable(
                state = swipeableState,
                anchors = mapOf(
                    0f to 0, -dipToPx(context, 100f) to 1, dipToPx(context, 100f) to 2
                ),
                thresholds = { _, _ -> FractionalThreshold(0.3f) },
                orientation = Orientation.Horizontal
            )
            .background(Color.LightGray)
    )

    IconButton(
        onClick = {}, modifier = Modifier
            .padding(start = 30.dp)
            .size(40.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Delete,
            contentDescription = null,
            tint = Color.Red,
            modifier = Modifier.size(40.dp)
        )
    }

    Box(modifier = Modifier
        .offset {
            IntOffset(swipeableState.offset.value.roundToInt(), 0)
        }
        .fillMaxWidth()
        .wrapContentHeight()
        .background(Color.Gray)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentHeight()
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = ImageRequest.Builder(context)
                            .data("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSg-3382ZgdUhzsOz0VYE8KVNtX_HTwTxRSps08Nli1&s")
                            .size(Size.ORIGINAL).build(), filterQuality = FilterQuality.Low
                    ),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentHeight()
                )
                if (2 > 0) {
                    Icon(
                        Icons.Filled.Favorite,
                        null,
                        tint = Color.Yellow,
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .padding(16.dp)
                    )
                    Spacer(modifier = Modifier.padding(vertical = 16.dp))
                    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                        Text(
                            text = "title",
                            fontSize = 18.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "title dos",
                            fontSize = 18.sp,
                            color = Color.Gray,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.padding(vertical = 16.dp))
                }
            }
        }
    }
}

private fun dipToPx(context: Context, dipVal: Float): Float {
    return dipVal * context.resources.displayMetrics.density
}



