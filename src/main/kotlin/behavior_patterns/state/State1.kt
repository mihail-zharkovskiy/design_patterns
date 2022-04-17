package behavior_patterns.state

class SoundState {

    private var currentSoundState: State = State.Vibration

    fun setSoundState(state: State) {
        currentSoundState = state
    }

    fun enableSoundState() {
        currentSoundState.enable(this)
    }

    fun disableSoundState() {
        currentSoundState.disable(this)
    }

    sealed class State {
        abstract fun enable(state: SoundState)
        abstract fun disable(state: SoundState)

        object Vibration : State() {
            override fun enable(state: SoundState) = println("состояние Vibration включено")
            override fun disable(staet: SoundState) = println("состояние Vibration отключено")
        }

        object SoundOff : State() {
            override fun enable(state: SoundState) = println("состояние Silent включено")
            override fun disable(staet: SoundState) = println("состояние Silent отключено")
        }

        object SoundOn : State() {
            override fun enable(state: SoundState) = println("состояние Sound включено")
            override fun disable(staet: SoundState) = println("состояние Sound отключено")
        }
    }
}

fun main() {
    val state = SoundState().also { it.setSoundState(SoundState.State.SoundOff) }
    state.enableSoundState()
    state.disableSoundState()
}