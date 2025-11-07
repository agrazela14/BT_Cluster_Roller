package com.example.bt_cluster_roller

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

/**
 * The main UI screen for the Cluster Roller app, built with Jetpack Compose.
 */
@Composable
fun ClusterScreen(vm: ClusterViewModel = viewModel()) {
    val resultText by vm.resultText.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()), // Make column scrollable
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text("Cluster Roller", style = MaterialTheme.typography.headlineMedium)

        // --- Inputs ---

        // Arc Selection Dropdown
        DropdownInput(
            label = "Hitting Arc",
            optionsMap = vm.arcOptions,
            selectedKey = vm.selectedArc.value,
            onSelectionChange = { vm.selectedArc.value = it }
        )

        // Shot Count Dropdown
        DropdownInput(
            label = "Shot Count",
            // Convert Int keys to String keys for the display map
            optionsMap = vm.shotCountOptions.associate { it.toString() to it.toString() },
            selectedKey = vm.selectedShotCount.value.toString(),
            onSelectionChange = { vm.selectedShotCount.value = it.toInt() }
        )

        // Text Inputs
        NumberTextField(
            label = "Damage per Shot",
            value = vm.damagePerShot.value,
            onValueChange = { vm.damagePerShot.value = it }
        )

        NumberTextField(
            label = "Grouping Size",
            value = vm.groupingSize.value,
            onValueChange = { vm.groupingSize.value = it }
        )

        NumberTextField(
            label = "Cluster Modifier",
            value = vm.clusterModifier.value,
            onValueChange = { vm.clusterModifier.value = it }
        )

        // --- Actions ---
        Button(
            onClick = { vm.calculateClusters() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Roll Clusters")
        }

        // --- Results ---
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

        Text("Results", style = MaterialTheme.typography.titleMedium)

        OutlinedTextField(
            value = resultText,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 150.dp)
        )
    }
}

/**
 * A reusable Composable for a labeled text field that only accepts numbers.
 */
@Composable
fun NumberTextField(label: String, value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = { newValue ->
            // Allow only digits or empty string
            if (newValue.isEmpty() || newValue.matches(Regex("^-?[0-9]*$"))) {
                onValueChange(newValue)
            }
        },
        label = { Text(label) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )
}

/**
 * A reusable Composable for a dropdown menu (ExposedDropdownMenuBox).
 * @param optionsMap A Map where the key is the value to be stored (e.g., "F")
 * and the value is the text to be displayed (e.g., "Front/Rear").
 * @param selectedKey The currently selected key.
 * @param onSelectionChange Lambda called when a new key is selected.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> DropdownInput(
    label: String,
    optionsMap: Map<T, String>,
    selectedKey: T,
    onSelectionChange: (T) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val selectedDisplayValue = optionsMap[selectedKey] ?: "Select"

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = selectedDisplayValue,
            onValueChange = {},
            readOnly = true,
            label = { Text(label) },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            optionsMap.forEach { (key, displayValue) ->
                DropdownMenuItem(
                    text = { Text(displayValue) },
                    onClick = {
                        onSelectionChange(key)
                        expanded = false
                    }
                )
            }
        }
    }
}