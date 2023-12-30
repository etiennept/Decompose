package com.arkivanov.decompose.extensions.compose.jetbrains

import androidx.activity.OnBackPressedDispatcherOwner
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.platform.LocalSavedStateRegistryOwner
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelStoreOwner
import androidx.savedstate.SavedStateRegistryOwner
import com.arkivanov.decompose.DefaultComponentContext
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import com.arkivanov.decompose.ExperimentalDecomposeApi

@ExperimentalDecomposeApi
@Composable
fun rememberDefaultComponentContext(lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
                            savedStateRegistryOwner: SavedStateRegistryOwner = LocalSavedStateRegistryOwner.current,
                            onBackPressedDispatcherOwner: OnBackPressedDispatcherOwner? = LocalOnBackPressedDispatcherOwner.current,
                            viewModelStoreOwner: ViewModelStoreOwner? = LocalViewModelStoreOwner.current    )  = remember {  DefaultComponentContext(
    lifecycleOwner.lifecycle,
    savedStateRegistryOwner.savedStateRegistry ,
    viewModelStoreOwner?.viewModelStore ,
    onBackPressedDispatcherOwner?.onBackPressedDispatcher ) }
