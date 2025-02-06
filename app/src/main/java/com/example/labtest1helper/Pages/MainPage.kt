package com.example.labtest1helper.Pages

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.widget.DatePicker
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.labtest1helper.R

class MainPage {
    companion object {
        @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
        @Composable
        fun page() {
            var text by remember {mutableStateOf("Click a button")}

            val ic = WindowCompat.getInsetsController((LocalView.current.context as Activity).window, LocalView.current)
            ic.apply {
                hide(WindowInsetsCompat.Type.systemBars())
                systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
            Scaffold(
                topBar = { //HEADER
                    BottomAppBar(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(70.dp),
                    ) {
                        Box(
                            modifier = Modifier.height(10.dp)
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.lambda_calculus_logo), //TODO: CHANGE APPROPRIATE LOGO
                                contentDescription = "Icon",
                                modifier = Modifier.fillMaxHeight()
                            )
                            Text(
                                text = stringResource(R.string.app_name), //TODO: CHANGE APP NAME
                                textAlign = TextAlign.Right,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                },


                bottomBar = { //BOTTOM BAR
                    BottomAppBar(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(70.dp),
                    ) {
                        Row( //BUTTON BAR
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Button( //ACTION BUTTONS
                                onClick = {}
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.baseline_home_24),
                                    contentDescription = "Home"
                                )
                            }
                        }
                    }
                }
            ) { innerPadding ->
                Column( //CONTENT
                    modifier = Modifier
                        .padding(innerPadding),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = text
                    )
                    Image(
                        painter = painterResource(R.drawable.lambda_calculus_logo),
                        contentDescription = "Logo"
                    )
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            DatePickerModalInput(
                                onDateSelected = {date ->
                                    text = date
                                },
                                onDismiss = {}
                            ) { }
                        }
                    ) {
                        Text("Date picker")
                    }
                }
            }
        }


        //DATE PICKER
        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        fun DatePickerModalInput(
            onDateSelected: (Long?) -> Unit,
            onDismiss: () -> Unit
        ) {
            val datePickerState = rememberDatePickerState(initialDisplayMode = DisplayMode.Input)

            DatePickerDialog(
                onDismissRequest = onDismiss,
                confirmButton = {
                    TextButton(onClick = {
                        onDateSelected(datePickerState.selectedDateMillis)
                        onDismiss()
                    }) {
                        Text("OK")
                    }
                },
                dismissButton = {
                    TextButton(onClick = onDismiss) {
                        Text("Cancel")
                    }
                }
            ) {
                DatePicker(state = datePickerState)
            }
        }
    }
}
