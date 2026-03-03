package com.example.crocusoft_project1.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.crocusoft_project1.R
import com.example.crocusoft_project1.core.DTextStyle
import com.example.crocusoft_project1.core.DsTheme
import com.example.crocusoft_project1.domain.entities.PostEntity
import com.example.crocusoft_project1.presentation.home.HomeContract

@Composable
fun PostDetail(
    post: PostEntity,
    postIntent: (HomeContract.Intent) -> Unit
) {

    val context = LocalContext.current


    val pagerState = rememberPagerState { post.contents.size }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = DsTheme.dimens.dp2)

        ) {

            Row(
                horizontalArrangement = Arrangement.spacedBy(DsTheme.dimens.dp2),
                verticalAlignment = Alignment.CenterVertically,

                ) {

                ProfileAvatar(
                    imgUri = post.userUri,
                    size = DsTheme.dimens.dp8,
                    padding = 0.dp
                )

                Column(
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = post.username,
                        style = DTextStyle.t14Bold
                    )

                    Text(
                        text = post.location,
                        style = DTextStyle.t12
                    )
                }
            }

            DIconButton(R.drawable.more) { postIntent(HomeContract.Intent.OnToggleMore) }

        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(
                    minWidth = DsTheme.dimens.postMinWidth,
                )
                .widthIn(DsTheme.dimens.postMaxWidth)
                .heightIn(max = DsTheme.dimens.postMaxHeight),
        ) {
            HorizontalPager(
                state = pagerState,
                key = { post.contents[it] }
            ) { page ->
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = ImageRequest.Builder(context)
                        .data(post.contents[page])
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }


            if(post.contents.size>1){
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(DsTheme.dimens.dp3)
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(DsTheme.dimens.dp3))

                            .background(colorResource(R.color.contentBlack).copy(alpha = 0.6f))
                            .padding(DsTheme.dimens.dp2),

                        ) {

                        Text(
                            text = "${pagerState.currentPage + 1}/${post.contents.size}",
                            style = DTextStyle.t12White,
                        )
                    }
                }
            }


        }




        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                DIconButton(R.drawable.like) {
                    postIntent(HomeContract.Intent.OnLikePost(post))

                }
                DIconButton(R.drawable.comment) {
                    postIntent(HomeContract.Intent.OnComment)

                }
                DIconButton(R.drawable.messanger) {
                    postIntent(HomeContract.Intent.OnShare(post))

                }
            }

            DIconButton(R.drawable.save) { postIntent(HomeContract.Intent.OnSave(post)) }
        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = DsTheme.dimens.dp2),
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(fontWeight = FontWeight.Bold)
                ) {
                    append(post.username)
                }
                append(" ")
                append(post.description)
            },
            style = DsTheme.textStyle.t12
        )

        Spacer(modifier = Modifier.height(height = DsTheme.dimens.dp2))

        Text(
            modifier = Modifier.padding(DsTheme.dimens.dp2),
            text = post.date,
            style = DsTheme.textStyle.t12Gray,

            )


    }

}


