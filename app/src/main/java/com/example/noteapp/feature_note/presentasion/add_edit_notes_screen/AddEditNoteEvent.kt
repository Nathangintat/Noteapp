package com.example.noteapp.feature_note.presentasion.add_edit_notes_screen

import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.graphics.Color

sealed class AddEditNoteEvent{
    data class EnteredTitle(val value: String): AddEditNoteEvent()
    data class ChangeTitleFocus(val FocusState: FocusState):AddEditNoteEvent()
    data class EnteredContent(val value: String): AddEditNoteEvent()
    data class ChangeContentFocus(val FocusState: FocusState):AddEditNoteEvent()
    data class ChangeColor(val Color: Int): AddEditNoteEvent()
    object SaveNote: AddEditNoteEvent()
}
