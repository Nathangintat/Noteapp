package com.example.noteapp.feature_note.presentasion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.noteapp.feature_note.presentasion.add_edit_notes_screen.AddEditNoteScreen
import com.example.noteapp.feature_note.presentasion.notes_screen.NoteScreen
import com.example.noteapp.feature_note.presentasion.util.Screen
import com.example.noteapp.ui.theme.NoteappTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteappTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController,
                        startDestination = Screen.NoteScreen.route
                    ) {
                        composable(route = Screen.NoteScreen.route) {
                            NoteScreen(navController = navController)
                        }
                        composable(
                            route = Screen.AddEditNoteScreen.route +
                                    "?noteId={noteId}&noteColor={noteColor}",
                            arguments = listOf(
                                navArgument(
                                    name = "noteId"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                                navArgument(
                                    name = "noteColor"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                            )
                        ) {
                            val color = it.arguments?.getInt("noteColor") ?: -1
                            AddEditNoteScreen(
                                navController = navController,
                                noteColor = color
                            )
                        }
                    }
                }
            }
        }
    }
}