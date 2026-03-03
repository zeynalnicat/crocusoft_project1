package com.example.crocusoft_project1.presentation.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.crocusoft_project1.R
import com.example.crocusoft_project1.core.DsTheme
import com.example.crocusoft_project1.core.Strings
import com.example.crocusoft_project1.domain.entities.StoryEntity
import com.example.crocusoft_project1.core.theme.White


@Composable
fun StoryItem(
    story: StoryEntity,
    modifier: Modifier = Modifier,
    onStoryClick: () -> Unit = {},
) {

    val context = LocalContext.current

    Column(
        verticalArrangement = Arrangement.spacedBy(DsTheme.dimens.dp1),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .size(DsTheme.dimens.storySize)
                .clip(CircleShape)
                .border(
                    border = BorderStroke(
                        DsTheme.dimens.dp02,
                        brush = Brush.linearGradient(
                            colors = if (!story.isLive) listOf(
                                colorResource(id = R.color.yellow),
                                colorResource(id = R.color.red),
                                colorResource(id = R.color.purple),

                                )
                            else listOf(
                                colorResource(id = R.color.red02),
                                colorResource(id = R.color.pink),
                                colorResource(id = R.color.purple02),
                            )
                        ),

                        ),
                    shape = CircleShape

                )
                .padding(DsTheme.dimens.dp03)
                .clip(CircleShape)
                .clickable(
                    onClick = onStoryClick
                )
        ) {

            ProfileAvatar(
                imgUri = story.imgUri,
                size = DsTheme.dimens.storyImg,
                padding = DsTheme.dimens.dp03
            )


            if (story.isLive) {
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .offset(y = DsTheme.dimens.dp1)
                        .zIndex(10f)
                        .clip(RoundedCornerShape(DsTheme.dimens.dp03))
                        .background(color = White)
                        .padding(DsTheme.dimens.dp02)
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .background(
                                brush = Brush.linearGradient(
                                    colors = listOf(
                                        colorResource(id = R.color.yellow),
                                        colorResource(id = R.color.red),
                                        colorResource(id = R.color.purple),

                                        )
                                )
                            )
                            .clip(RoundedCornerShape(DsTheme.dimens.dp03))
                            .height(16.dp)
                            .width(26.dp)

                    ) {
                        Text(
                            text = stringResource(
                                Strings.live,

                                ),
                            style = DsTheme.textStyle.t8White
                        )
                    }
                }
            }


        }

        Text(
            text = story.name,
            style = DsTheme.textStyle.t12
        )

    }


}


@Preview
@Composable
fun StoryItemPreview() {
    val story = StoryEntity(
        imgUri = "https://fastly.picsum.photos/id/2/200/300.jpg",
        name = "Alice",
        isLive = false

    )

    StoryItem(
        story = story
    )
}