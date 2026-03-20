package com.bold.core.presentation

interface Reducer<State: Reducer.ViewState, UserIntent: Reducer.ViewIntent, Effect: Reducer.ViewEffect> {

    interface ViewState
    interface ViewIntent
    interface ViewEffect

    fun reduce(previousState: State, intent: UserIntent): Pair<State, Effect?>
}