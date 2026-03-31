package com.checkengineoff.core.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.checkengineoff.core.presentation.Reducer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

open class BaseViewModel<State: Reducer.ViewState, UserIntent: Reducer.ViewIntent, Effect: Reducer.ViewEffect>(
    val initialState: State,
    private val reducer: Reducer<State, UserIntent, Effect>
) : ViewModel() {
    private val _state: MutableStateFlow<State> = MutableStateFlow(initialState)

    val state: StateFlow<State> by lazy {
        _state.onStart {
            viewModelScope.launch {
                withContext(Dispatchers.IO) {
                    initialDataLoad()
                }
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.Companion.WhileSubscribed(5000L),
            initialValue = initialState
        )
    }

    private val _event: MutableSharedFlow<UserIntent> = MutableSharedFlow()
    val event: SharedFlow<UserIntent>
        get() = _event.asSharedFlow()

    private val _effects = Channel<Effect>(capacity = Channel.Factory.CONFLATED)
    val effect = _effects.receiveAsFlow()

    open suspend fun initialDataLoad() {}

    fun sendEffect(effect: Effect) {
        _effects.trySend(effect)
    }

    fun sendEvent(event: UserIntent) {
        val (newState, effect) = reducer.reduce(_state.value, event)
        _state.tryEmit(newState)
        effect?.let {
            sendEffect(it)
        }
    }
}