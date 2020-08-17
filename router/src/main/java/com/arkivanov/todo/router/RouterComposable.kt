package com.arkivanov.todo.router

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.runtime.Composable
import androidx.compose.runtime.onDispose
import androidx.compose.runtime.remember
import androidx.compose.runtime.state
import androidx.lifecycle.Lifecycle

@Composable
fun <C> Router(
    params: () -> RouterParams<C>,
    resolve: Router<C>.(configuration: C, Lifecycle) -> ComposableComponent
) {
    val stack = state<BackStack<C>> { BackStack() }

    val router =
        remember {
            val routerParams = params()
            val router = RouterImpl(stack, routerParams.stateKeeper, routerParams.onBackPressedDispatcher, resolve)
            router.push(routerParams.initialConfiguration)
            router
        }

    onDispose(router::dispose)

    router.content()
}

class RouterParams<C>(
    val initialConfiguration: C,
    val stateKeeper: RouterStateKeeper<C>? = null,
    val onBackPressedDispatcher: OnBackPressedDispatcher? = null,
)
