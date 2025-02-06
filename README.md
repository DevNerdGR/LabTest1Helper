In Jetpack Compose, you can handle gestures using the `Modifier` API. Here are some common gesture handling scenarios:

1. Tap Gesture
To handle tap gestures, use the `clickable` modifier:

```
Text(
    text = "Tap me",
    modifier = Modifier.clickable(onClick = { /* Handle tap */ })
)
```

2. Long Press Gesture
To handle long press gestures, use the `longPressable` modifier:

```
Text(
    text = "Long press me",
    modifier = Modifier.longPressable(onLongPress = { /* Handle long press */ })
)
```

3. Drag Gesture
To handle drag gestures, use the `draggable` modifier:

```
Box(
    modifier = Modifier
        .size(50.dp)
        .draggable(
            state = rememberDraggableState { offset ->
                // Handle drag
            },
            orientation = Orientation.Horizontal
        )
)
```

4. Swipe Gesture
To handle swipe gestures, use the `swipeable` modifier:

```
Box(
    modifier = Modifier
        .size(50.dp)
        .swipeable(
            state = rememberSwipeableState(
                initialValue = 0
            ),
            anchors = mapOf(
                0f to 0,
                100f to 1
            ),
            thresholds = { _, _ -> FractionalThreshold(0.5f) },
            orientation = Orientation.Horizontal
        )
)
```

5. Custom Gestures
To handle custom gestures, use the `pointerInput` modifier:

```
Box(
    modifier = Modifier
        .size(50.dp)
        .pointerInput(Unit) {
            detectTapGestures(
                onTap = { offset ->
                    // Handle tap
                },
                onDoubleTap = { offset ->
                    // Handle double tap
                },
                onLongPress = { offset ->
                    // Handle long press
                }
            )
        }
)
```

These are some of the ways you can handle gestures in Jetpack Compose. You can combine these modifiers to create more complex gesture handling scenarios.