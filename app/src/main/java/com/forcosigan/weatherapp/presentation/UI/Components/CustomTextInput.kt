package com.forcosigan.weatherapp.presentation.UI.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.forcosigan.weatherapp.presentation.Theme.defaultSubColor
import com.forcosigan.weatherapp.presentation.Theme.inputBackgroundColor
import kotlin.text.ifEmpty

@Composable
fun CustomTextInput(
    textValue: String,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    valueChange: (field: String) -> Unit,
    minLines: Int = 1,
    placeholderAlignment: Alignment = Alignment.CenterStart,
    cornerRadius: Dp = 10.dp,
    enabled: Boolean = true,
    rightIcon: ImageVector? = null
) {
    BasicTextField(
        value = textValue,
        enabled = enabled,
        minLines = minLines,
        textStyle = TextStyle.Default.copy(
            fontSize = 18.sp,
            color = MaterialTheme.colors.onBackground
        ),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
        onValueChange = {
            valueChange(it.ifEmpty { "" })
        },
        modifier = modifier
            .fillMaxWidth(),
        decorationBox = { innerTextField ->
            Column(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier
                        .clip(RoundedCornerShape(cornerRadius))
                        .background(inputBackgroundColor)

                        .padding(horizontal = 20.dp, vertical = 10.dp)
                ) {
                    Box(
                        contentAlignment = placeholderAlignment,
                        modifier = Modifier.weight(1.0f)
                    ) {
                        if (textValue.isEmpty()) {
                            Text(text = placeholder, color = defaultSubColor, fontSize = 16.sp)
                        }
                        innerTextField()
                    }

                    if (rightIcon != null) {
                        Icon(
                            imageVector = rightIcon,
                            contentDescription = "Search",
                            tint = defaultSubColor

                        )
                    }
                }
            }
        }
    )

}