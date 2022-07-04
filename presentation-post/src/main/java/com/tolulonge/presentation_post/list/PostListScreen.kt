package com.tolulonge.presentation_post.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tolulonge.presentation_cmn.navigation.NavRoutes
import com.tolulonge.presentation_cmn.navigation.PostInput
import com.tolulonge.presentation_cmn.navigation.UserInput
import com.tolulonge.presentation_cmn.state.CommonScreen
import com.tolulonge.presentation_cmn.state.UiState

@Composable
fun PostListScreen(
    viewModel: PostListViewModel,
    navController: NavController
) {
    viewModel.loadPosts()
    viewModel.postListFlow.collectAsState().value.let { state ->
        CommonScreen(state = state) {
            PostList(it, { postListItem ->
                viewModel.updateInteraction(it.interaction)
                navController.navigate(NavRoutes.Post.routeForPost(PostInput(postListItem.id)))
            }) { postListItem ->
                viewModel.updateInteraction(it.interaction)
                navController.navigate(NavRoutes.User.routeForUser(UserInput(postListItem.userId)))
            }
        }
    }
}



@Composable
fun PostList(
    postListModel: PostListModel,
    onRowClick: (PostListItemModel) -> Unit,
    onAuthorClick: (PostListItemModel) -> Unit,
) {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        item(postListModel.headerText) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = postListModel.headerText)
            }
        }
        items(postListModel.items) { item ->
            Column(modifier = Modifier
                .padding(16.dp)
                .clickable {
                    onRowClick(item)
                }) {
                ClickableText(text = AnnotatedString(text = item.authorName), onClick = {
                    onAuthorClick(item)
                })
                Text(text = item.title)
            }
        }
    }
}
